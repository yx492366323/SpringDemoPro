layui.use(['table', 'layer', 'util'], function () {
    var table = layui.table
        , layer = layui.layer
        , util = layui.util;

    table.render({
        elem: '#test'
        , cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
        , cols: [[
            { field: 'id', title: 'ID', sort: true},
            { field: 'userName', title: 'UserName', sort: true, edit: 'text' },
            { field: 'trueName', title: 'TrueName', sort: true},
            { field: 'idcardNumber', title: 'IDCardNumber', sort: true},
            { field: 'sex', title: 'IsMale', sort: true},
            { field: 'birthDay', title: 'BirthDay', sort: true},
            { field: 'email', title: 'Email', sort: true},
            { field: 'phoneNumber', title: 'PhoneNumber', sort: true, edit: 'text' },
            { field: 'buildingNumber', title: 'BuildingNumber', sort: true, edit: 'text' },
            { field: 'securityQuestion', title: 'SecurityQuestion', sort: true, edit: 'text' },
            { field: 'securityAnswer', title: 'SecurityAnswer', sort: true, edit: 'text' }
        ]]
        , even: true
        , page: false //是否显示分页
    });
    var reload = function () {
        // 此处调用查询接口
        $.ajax({
            type: "GET",
            url: "/UserPrint/getUser",
            success: function (res) {
                var data = res.data;
                console.log(data);
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
        console.log(obj);
        $.ajax({
            type: "POST",
            url: "/UserPrint/modUser",
            data: {
                _csrf: $('#csrf').val(),
                Field: field,
                Value: value,
                Id: data.id,
            },
            success: function (res) {
                if(res){
                    layer.msg("修改成功！");
                }
                else{
                    layer.msg("修改失败！");
                }
                reload();
            }
        });
    });
});