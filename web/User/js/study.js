layui.use(['table', 'layer', 'util'], function () {
    var table = layui.table
        , layer = layui.layer
        , util = layui.util;

    table.render({
        elem: '#test'
        , cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
        , cols: [[
            { field: 'name', title: '名称', sort: true},
            { field: 'time', title: '视频时长', sort: true},
            { field: 'username', title: '上传者用户名', sort: true},
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
            data: {
                State: false
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
    reload();
    search = function () {
        var searchType = $("#searchType option:selected").val();
        var state = searchType=="true"?true:false;
        $.ajax({
            url: "findvideo",
            data: {
                State: state
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
        name = obj.parentNode.parentNode.parentNode.getElementsByClassName("laytable-cell-1-0-0")[0].innerHTML;
        if(type == 'download'){
            window.open("../Public/download?name="+name);
        }
        else if(type == 'play'){
            var path = "../Public/download?name="+name;
            var video = '<div id="video" style="display: block;"><!--视频模块--><video id="thevideo" class="video_window" src='+path+' autoplay="" controls="" height="720px" width="1280px"></video><!--视频关闭按钮--><img src="../Public/Img/video_off.png" id="video_off" alt="video_off" width="60px"></div>';
            document.getElementById("no_video").outerHTML = video;
            var video_off_button = document.getElementById("video_off");
            video_off_button.onclick = function(){
                document.getElementById("video").outerHTML = '<div id ="no_video"></div>';
            }
            thevideo.addEventListener("ended",function(){
                OK();
            })
        }
    }
    var OK = function () {
        $.ajax({
            type: "POST",
            url: "okvideo",
            data: {
                _csrf: $('#csrf').val(),
                Name: name
            },
            success: function (res) {
                var data = res;
                // 获取到 data
                table.reload('test', {
                    data: data
                }, true)
                window.top.location.reload();
            }
        });
    }
});
