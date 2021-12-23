layui.use(['element', 'layer', 'util'], function(){
    var element = layui.element
        ,layer = layui.layer
        ,util = layui.util
        ,$ = layui.$;

    //头部事件
    util.event('lay-header-event', {
        //左侧菜单事件
        menuLeft: function(othis){
            layer.msg('展开左侧菜单的操作', {icon: 0});
        }
    });

});

function Change_iframe(num){
    var ifream_all = document.getElementsByClassName("iframe_div_all");
    var i=0;
    for (i=0;i<ifream_all.length;i++){

        ifream_all[i].style.display="none";
    }
    document.getElementById("iframe_"+num).style.display="";
    Reload_iframe();
}

function Reload_iframe(){
    var ifream_all = document.getElementsByClassName("iframe_div_all");
    var i=0;
    for (i=0;i<ifream_all.length;i++){
        if(ifream_all[i].style.display==""){
            herf=document.getElementsByClassName('iframe_one')[i].contentWindow.location.href.split("/").pop();
            document.getElementsByClassName('iframe_one')[i].contentWindow.location.href=herf;
        }
    }
}
