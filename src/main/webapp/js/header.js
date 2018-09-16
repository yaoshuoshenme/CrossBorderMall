document.writeln("<div id=\'top\'>");
document.writeln("    <div id=\'topdiv\'>");
document.writeln("            <span>");
document.writeln("                <a href=\'index.jsp\' class=\'a_top\' target=\'_blank\'>锋米之家</a>");
document.writeln("                <li>|</li>");
document.writeln("                <a class=\'a_top\'>锋米之家移动版</a>");
document.writeln("                <li>|</li>");
document.writeln("                <a class=\'a_top\'>问题反馈</a>");
document.writeln("            </span>");
document.writeln("        <span style=\'float:right\'>");
document.writeln("            <span id=\'sp1\'>");
document.writeln("                    <a href=\'login.html\' class=\'a_top\'>登录</a>");
document.writeln("                    <li>|</li>");
document.writeln("                    <a href=\'register.jsp\' class=\'a_top\'>注册</a>");
document.writeln("            </span>");
document.writeln("       			 <span id=\'sp2\'>");
document.writeln("                    <a href=\'addresslist.do\' class=\'a_top\' id=\'au1\'></a>");
document.writeln("                    <li>|</li>");
document.writeln("                    <a href=\'api/v1/userloginout.do' class=\'a_top\'>注销</a>");
document.writeln("                    <li>|</li>");
document.writeln("                    <a href=\'getOrderList.do\' class=\'a_top\'>我的订单</a>");
document.writeln("             </span>");
document.writeln("                <li>|</li>");
document.writeln("                <a href=\'\' class=\'a_top\'>消息通知</a>");
document.writeln("                <a href=\'querycartitem.do\' id=\'shorpcar\'>购物车</a>");
document.writeln("            </span>");
document.writeln("    </div>");
document.writeln("</div>");
document.writeln("<div id=\'second\'>");
document.writeln("    <a href=\'\' class=\'seimg\' style=\' margin-top:23px;\'><img id=\'logo\' src=\'image/logo_top.png\' width=\'55\' height=\'54\'/></a>");
document.writeln("    <a href=\'\' class=\'seimg\' style=\' margin-top:17px;\'><img id=\'gif\' src=\'image/yyymix.gif\' width=\'180\' height=\'66\' /></a>");
document.writeln("    <p id=\'goodsType\'>");
document.writeln("        <!-- 根据ajax 回调函数 填写数据 到此id中 -->");
document.writeln("    </p>");
document.writeln("    <form class=\'form-inline pull-right\' style=\'margin-top: 40px;margin-right: 10px;\'>");
document.writeln("");
document.writeln("        <div class=\'form-group\'>");
document.writeln("            <input type=\'text\' class=\'form-control\' style=\'width: 400px\'  placeholder=\'搜索一下好东西...\'>");
document.writeln("        </div>");
document.writeln("        <button type=\'submit\' class=\'btn btn-warning\'><span class=\'glyphicon glyphicon-search\'></span>&nbsp;&nbsp;搜索</button>");
document.writeln("    </form>");
document.writeln("</div>");
init();
function init() {
    $.ajax({
        url:'goodstypelist.do?gtlevel=1',
        method:'get',
        success:function(datas){
            var list = datas.data;

            for(var t in list){
                var a = "<a href='goodsbytid.do?tid="+list[t].gtid+"'>"+list[t].gtname+'</a>';
                $('#goodsType').append(a);
            }
        }
    });
    $.get("api/v1/userlogincheck.do",null,function (obj) {
        if(obj.code==0){
            //登录成功
            $("#sp1").css("display","none");
            $("#sp2").css("display","block");
            $("#au1").html(obj.data.uname);
        }else{
            //未登录
            $("#sp2").css("display","none");
            $("#sp1").css("display","block");
        }
    })

}