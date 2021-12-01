layui.use(['table', 'layer', 'util', 'laydate'], function () {
    var table = layui.table
        , layer = layui.layer
        , util = layui.util
        , laydate = layui.laydate;

    laydate.render({
        elem: '#input_Date1,#input_Date2'
    });

    table.render({
        elem: '#test'
        , cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
        , cols: [[
            {field: 'id', title: 'ID', sort: true},
            {field: 'paperModel', title: 'PaperModel', sort: true},
            {field: 'colorModel', title: 'ColorModel', sort: true},
            {field: 'unitPrice', title: 'UnitPrice', sort: true},
        ]]
        , even: true
        , page: true //是否显示分页
        , limit: 10 //每页默认显示的数量
    });

    table.render({
        elem: '#test2'
        , cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
        , cols: [[
            {field: 'id', title: 'ID', sort: true, width: 90},
            {field: 'fileName', title: 'FileName', sort: true},
            {field: 'pageNum', title: 'PageNum', sort: true, width: 120},
            {field: 'modelID', title: 'ModelID', sort: true, width: 140, edit: 'text'},
            {field: 'num', title: 'Num', sort: true, width: 90, edit: 'text'},
            {field: 'allPageNum', title: 'AllPageNum', sort: true, width: 140},
            {field: 'money', title: 'Money', sort: true, width: 90},
            {field: 'printData', title: 'PrintData', sort: true, width: 140},
            {field: 'state', title: 'State', sort: true, width: 80},
            {
                field: "",
                title: "操作",
                width: 65,
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
            url: "/UserPrint/getPrintAll",
            success: function (res) {
                var data = res.data;
                console.log(data.data);
                // 获取到 data
                table.reload('test2', {
                    data: data
                }, true)
            }
        });
    }
    reload();

    var reload1 = function () {
        // 此处调用查询接口
        $.ajax({
            type: "GET",
            url: "/UserPrint/getModelAll",
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
    reload1();
    //监听单元格编辑
    table.on('edit(test2)', function (obj) {
        var value = obj.value //得到修改后的值
            , data = obj.data //得到所在行所有键值
            , field = obj.field; //得到字段
        console.log(obj);
        $.ajax({
            type: "POST",
            url: "/UserPrint/modPrint",
            data: {
                _csrf: $('#csrf').val(),
                Field: field,
                Value: value,
                Id: data.id,
            },
            success: function (res) {
                if(res){
                    layer.msg("修改成功！"+'[ID: ' + data.id + '] ' + field + ' 字段更改值为：' + util.escape(value));
                }
                reload();
                console.log("OK");
            }
        });
    });
    search = function () {
        var searchCondition = $('#searchCondition').val();
        var searchType = $("#searchType option:selected").val();
        $.ajax({
            type: "GET",
            url: "/UserPrint/getModelAll",
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
    search1 = function () {
        var Id = $("#input_Id").val()
        var FileName = $("#input_FileName").val()
        var Money1 = $("#input_Money1").val()
        var Money2 = $("#input_Money2").val()
        var PrintData1 = $("#input_Date1").val()
        var PrintData2 = $("#input_Date2").val()
        var State = $("#State_select option:selected").val()
        $.ajax({
            type: "GET",
            url: "/UserPrint/getPrintAll",
            data: {
                Id,
                FileName,
                Money1,
                Money2,
                PrintData1,
                PrintData2,
                State
            },
            success: function (res) {
                var data = res.data;
                // 获取到 data
                table.reload('test2', {
                    data: data
                }, true)
            }
        });
    }
    btnAct = function (type, obj) {
        var id = obj.parentNode.parentNode.parentNode.getElementsByClassName("laytable-cell-2-0-0")[0].innerHTML
        if (type == 'Pay') {
            var state = obj.parentNode.parentNode.parentNode.getElementsByClassName("laytable-cell-2-0-8")[0].innerHTML
            if (state == 0) {
                $.ajax({
                    type: "POST",
                    url: "/UserPrint/printPay",
                    data: {
                        _csrf: $('#csrf').val(),
                        Id: id
                    },
                    success: function (res) {
                        if(res){
                            layer.msg("支付成功");
                        }
                        reload();
                    }
                });
                layer.msg("支付成功");

            } else if (state == 1) {
                layer.confirm('该订单已付款，请不要重复付款', function (index) {
                    layer.msg("该订单已付款，已拒绝交易！");
                })
            } else if (state == 2) {
                layer.confirm('该订单已经打印过了，如再次点击确认！', function (index) {
                    $.ajax({
                        type: "POST",
                        url: "/UserPrint/printPay",
                        data: {
                            _csrf: $('#csrf').val(),
                            Id: id
                        },
                        success: function (res) {
                            if(res){
                                layer.msg("支付成功");
                            }
                            reload();
                            layer.close(index);
                        }
                    });
                });
            }
        }
    }

});