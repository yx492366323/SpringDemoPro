layui.use(['table', 'layer', 'util'], function () {
    var table = layui.table
        , layer = layui.layer
        , util = layui.util;

    table.render({
        elem: '#test'
        , cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
        , cols: [[
            { field: 'id', title: 'ID', sort: true},
            { field: 'name', title: '名称', sort: true, edit: 'text'},
            { field: 'filename', title: '文件名', sort: true},
            { field: 'time', title: '视频时长', sort: true},
            { field: 'path', title: '路径', sort: true},
            { field: 'username', title: '用户名', sort: true},
            { field: 'uploadtime', title: '上传时间', sort: true},
            {
                field: "",
                title: "操作",
                width: 180,
                templet: '#btn'
            }
        ]]
        , even: true
        , page: true //是否显示分页
        , limit: 10 //每页默认显示的数量
    });
    var reload = function () {
        // 此处调用查询接口
        $.ajax({
            type: "GET",
            url: "findvideo",
            success: function (res) {
                var data = res;
                // 获取到 data
                table.reload('test', {
                    data: data
                }, true)
            }
        });
    }
    reload();
    //监听单元格编辑
    table.on('edit(test)', function (obj) {
        var value = obj.value //得到修改后的值
            , data = obj.data //得到所在行所有键值
            , field = obj.field; //得到字段
        layer.msg('[用户名: ' + data.userName + '] ' + field + ' 字段更改值为：' + util.escape(value));
        console.log(obj);
        $.ajax({
            type: "POST",
            url: "modvideo",
            data: {
                _csrf: $('#csrf').val(),
                Field: field,
                Value: value,
                Id: data.id,
            },
            success: function (res) {
                reload();
                console.log(res);
            }
        });
    });
    search = function () {
        var searchCondition = $('#searchCondition').val();
        var searchType = $("#searchType option:selected").val();
        $.ajax({
            url: "findvideo",
            data: {
                Value: searchCondition,
                Field: searchType
            },
            success: function (res) {
                var data = res;
                // 获取到 data
                table.reload('test', {
                    data: data
                }, true)
            }
        });
    }
    btnAct = function (type, obj) {
        var id = obj.parentNode.parentNode.parentNode.getElementsByClassName("laytable-cell-1-0-0")[0].innerHTML;
        var name = obj.parentNode.parentNode.parentNode.getElementsByClassName("laytable-cell-1-0-1")[0].innerHTML;
        if (type == 'del') {
            layer.confirm('确认删除该用户', function (index) {
                $.ajax({
                    type: "POST",
                    url: "delvideo",
                    data: {
                        _csrf: $('#csrf').val(),
                        Id: id
                    },
                    success: function (res) {
                        // 调用删除接口
                        reload();
                        layer.close(index);
                    }
                });
            });
        }
        else if(type == 'download'){
            window.open("../Public/download?name="+name);
        }
        else if(type == 'play'){
            var path = "../Public/download?name="+name;
            var video = '<div id="video" style="display: block;"><!--视频模块--><video class="video_window" src='+path+' autoplay="" controls="" height="1280px" width="720px"></video><!--视频关闭按钮--><img src="Image/video_off.png" id="video_off" alt="video_off" width="60px"></div>';
            document.getElementById("video").outerHTML = video;
        }
    }
});
