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
            { field: 'id', title: 'ID', sort: true ,width: 90},
            { field: 'userName', title: 'UserName', sort: true ,width: 140},
            { field: 'phoneNumber', title: 'PhoneNumber', sort: true ,width: 140},
            { field: 'fileName', title: 'FileName', sort: true },
            { field: 'pageNum', title: 'PageNum', sort: true ,width: 120},
            { field: 'paperModel', title: 'PaperModel', sort: true ,width: 140},
            { field: 'colorModel', title: 'ColorModel', sort: true ,width: 130},
            { field: 'unitPrice', title: 'UnitPrice', sort: true ,width: 120},
            { field: 'num', title: 'Num', sort: true ,width: 90},
            { field: 'allPageNum', title: 'AllPageNum', sort: true ,width: 140},
            { field: 'money', title: 'Money', sort: true ,width: 90},
            { field: 'printData', title: 'PrintData', sort: true ,width: 140},
            { field: 'state', title: 'State', sort: true ,width: 80},
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
            url: "/AdminPrint/getPrintAll",
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
        var Id=$("#input_Id").val()
        var UserName=$("#input_UserName").val()
        var PhoneNumber=$("#input_Phone").val()
        var FileName=$("#input_FileName").val()
        var Money1=$("#input_Money1").val()
        var Money2=$("#input_Money2").val()
        var PrintData1=$("#input_Date1").val()
        var PrintData2=$("#input_Date2").val()
        var State=$("#State_select option:selected").val()
        $.ajax({
            type: "GET",
            url: "/AdminPrint/getPrintAll",
            data: {
                Id,
                UserName,
                PhoneNumber,
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
                table.reload('test', {
                    data: data
                }, true)
            }
        });
    }

    btnAct = function (type, obj) {
        var id = obj.parentNode.parentNode.parentNode.getElementsByClassName("laytable-cell-1-0-0")[0].innerHTML
        if (type == 'Print') {
            var state = obj.parentNode.parentNode.parentNode.getElementsByClassName("laytable-cell-1-0-12")[0].innerHTML
            if(state==0){
                layer.confirm('该订单未付款，请等待对方付款！如确认打印请点击确认！', function (index) {
                    $.ajax({
                        type: "POST",
                        url: "/AdminPrint/printFinish",
                        data: {
                            _csrf: $('#csrf').val(),
                            Id: id
                        },
                        success: function (res) {
                            reload();
                            layer.close(index);
                        }
                    });
                });
            }
            else if(state==1){
                $.ajax({
                    type: "POST",
                    url: "/AdminPrint/printFinish",
                    data: {
                        _csrf: $('#csrf').val(),
                        Id: id
                    },
                    success: function (res) {
                        reload();
                        layer.close(index);
                    }
                });
            }
            else if(state==2){
                layer.confirm('该订单已经打印过了，如确认打印请点击确认！', function (index) {
                    $.ajax({
                        type: "POST",
                        url: "/AdminPrint/printFinish",
                        data: {
                            _csrf: $('#csrf').val(),
                            Id: id
                        },
                        success: function (res) {
                            reload();
                            layer.close(index);
                        }
                    });
                });
            }
        }
    }
});