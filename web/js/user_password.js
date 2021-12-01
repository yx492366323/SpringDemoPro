changepassword = function () {
    var ID = $('#ID').val();
    var NewPassword = $("#NewPassword").val();
    $.ajax({
        type: "POST",
        url: "/ManageUser/modUser",
        data: {
            _csrf: $('#csrf').val(),
            Id: ID,
            Field: "Password",
            Value: NewPassword
        },
        success: function (res) {
            layer.msg(res);
        }
    });
}