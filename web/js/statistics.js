layui.use(['table', 'layer', 'util'], function () {
    var table = layui.table
        , layer = layui.layer
        , util = layui.util;

    table.render({
        elem: '#test'
        , cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
        , cols: [[
            { field: 'date', title: 'Date', sort: true},
            { field: 'paperNum', title: 'PaperNum', sort: true},
            { field: 'income', title: 'Income', sort: true},
            { field: 'newUserNum', title: 'NewUserNum', sort: true},
        ]]
        , even: true
        , page: true //是否显示分页
        , limit: 10 //每页默认显示的数量
    });
    var reload = function () {
        // 此处调用查询接口
        $.ajax({
            type: "GET",
            url: "/AdminPrint/getStatistics",
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
    search = function () {
        var searchCondition = $('#searchCondition').val();
        var searchType = $("#searchType option:selected").val();
        $.ajax({
            url: "/AdminPrint/getStatistics",
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