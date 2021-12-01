layui.use(['table', 'layer', 'util'], function () {
    var table = layui.table
        , layer = layui.layer
        , util = layui.util;

    table.render({
        elem: '#test'
        , cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
        , cols: [[
            { field: 'id', title: 'ID', sort: true },
            { field: 'paperModel', title: 'PaperModel', sort: true, edit: 'text' },
            { field: 'colorModel', title: 'ColorModel', sort: true, edit: 'text' },
            { field: 'unitPrice', title: 'UnitPrice', sort: true, edit: 'text' },
        ]]
        , even: true
        , page: true //是否显示分页
        , limit: 10 //每页默认显示的数量
    });
    var reload = function () {
        // 此处调用查询接口
        $.ajax({
            type: "GET",
            url: "/AdminPrint/getModelAll",
            success: function (res) {
                var data = res.data;
                console.log(data.data);
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
        layer.msg('[ID: ' + data.id + '] ' + field + ' 字段更改值为：' + util.escape(value));
        console.log(obj);
        $.ajax({
            type: "POST",
            url: "/AdminPrint/modModel",
            data: {
                _csrf: $('#csrf').val(),
                Field: field,
                Value: value,
                Id: data.id,
            },
            success: function (res) {
                reload();
                console.log("OK");
            }
        });
    });
    search = function () {
        var searchCondition = $('#searchCondition').val();
        var searchType = $("#searchType option:selected").val();
        $.ajax({
            type:"GET",
            url: "/AdminPrint/getModelAll",
            data: {
                Value: searchCondition,
                Field: searchType
            },
            success: function (res) {
                var data = res.data;
                // 获取到 data
                table.reload('test', {
                    data: data
                }, true)
            }
        });
    }
});