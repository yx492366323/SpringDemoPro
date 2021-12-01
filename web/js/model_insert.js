insmodel = function () {
    var PaperModel = $("#PaperModel").val();
    var ColorModel = $("#ColorModel").val();
    var UnitPrice = $("#UnitPrice").val();
    $.ajax({
        type: "POST",
        url: "/AdminPrint/insModel",
        data: {
            _csrf: $('#csrf').val(),
            PaperModel: PaperModel,
            ColorModel: ColorModel,
            UnitPrice: UnitPrice
        },
        success: function (res) {
            if(res){
                layer.msg("添加成功");
            }
            else{
                layer.msg("添加失败");
            }
        }
    });
}