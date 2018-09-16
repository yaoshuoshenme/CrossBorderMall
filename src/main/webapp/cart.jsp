<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link rel="stylesheet" type="text/css" href="css/login2.css">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<script type="text/javascript" src="js/jquery.min.js"></script>
<title>购物车</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript">
	function pNum(ciid,p,no){
		var nums = $("#num_count"+no).val();
		$.ajax({
			url:"updatecount.do?ciid="+ciid+"&count=1",
			method:"get",
			success:function(){
			    nums++;
                $("#num_count"+no).val(nums)
                var price = p*nums/100.00;
                $("#pri_count"+no).text(price.toFixed(2))


                var total = Number($("#price_sum").text()) + p/100.00;

                $("#price_sum").text(total.toFixed(2))
			},
			error:function(){
				alert("服务器异常");
			}
		})
	}
	function mNum(ciid,p,no){
		var num = -1; //数量
		var nums = $("#num_count"+no).val();
		if(Number(nums)<=1){
			if(confirm("确认要删除吗?")){
				$.post("deleteCartitem.do",{ciid:ciid})
				window.location.href="querycartitem.do"
			}
				return;

		}
		$.ajax({
			url:"updatecount.do?ciid="+ciid+"&count=-1",
			method:"get",
			success:function(){
			    nums--;
                $("#num_count"+no).val(nums)
				var price = p*nums/100.00;
				$("#pri_count"+no).text(price.toFixed(2))

                var total = Number($("#price_sum").text())- p/100.00;
                $("#price_sum").text(total.toFixed(2))
			},
			error:function(){
				alert("服务器异常");
			}
		})

	}
	function clearCart(){
		if(confirm("确认要删除吗")){
			location.href="clearcart.do";
		}
	}


</script>
<script type="text/javascript">
    $(function () {
        $("#ckall").click(function() {
            if (this.checked){
                $("input.ck:checkbox").each(function(){
                    $(this).attr("checked", true);
                });
            } else {
                $("input.ck:checkbox").each(function() {
                    $(this).attr("checked", false);
                });
            }
        });


        $("#btn_submit").click(function () {
            //获取被选中的商品ciid（购物车详情）
            var ciids = "";
            $("input.ck").each(function () {
                if($(this).prop("checked")){
                 ciids = ciids + $(this).attr("id") + ",";
                 alert(ciids)
				}
            })
            //处理数据
            if(ciids.length > 0){
                ciids = ciids.substring(0,ciids.length-1)
				alert(ciids)
               //发起ajax传递数据//通过后台查询跳转
               $.post("selectByCiids.do","ciids="+ciids,function (data) {
				   if(data.code == 0){
				       window.location.href="order.jsp";
				   }else{
				       alert(data.code)
				       alert("生成失败")
				   }
               })
            }else{
                alert("没有选择商品")
            }

        })

    })

</script>
</head>


<body style="background-color:#f5f5f5">
<script type="application/javascript" src="js/header.js"></script>

<div class="container" style="background-color: white;">
	<div class="row" style="margin-left: 40px">
		<h3>我的购物车<small>温馨提示：产品是否购买成功，以最终下单为准哦，请尽快结算</small></h3>
	</div>
	<div class="row" style="margin-top: 40px;">
		<div class="col-md-10 col-md-offset-1">
			<table class="table table-bordered table-striped table-hover">
 				<tr>
					<th><input type="radio" id="ckall" ></th>
					<th>序号</th>
 					<th>商品名称</th>
					<th>图片</th>
 					<th>价格</th>
 					<th>数量</th>
 					<th>小计</th>
 					<th>操作</th>
 				</tr>
 				<c:set value="0" var="sum"></c:set>
 				<c:forEach items="${carts}" var="c" varStatus="i">

	 				<tr>
						<th><input type="radio" id="${c.ciid}" class="ck" ></th>
	 					<th>${i.count}</th>
	 					<th>${c.goods.gname}</th>
						<th><img src="/17fm/+${c.goods.gpic}" ></th>
	 					<th>${c.goods.gprice.intValue()/100.00}</th>
	 					<th width="100px">
		 					<div class="input-group">
		 						<span class="input-group-btn">
		 							<button class="btn btn-default" type="button" onclick="mNum(${c.ciid},${c.goods.gprice},${i.count})">-</button>
		 						</span>
		 						<input type="text" class="form-control" id="num_count${i.count}" value="${c.count}" readonly="readonly" style="width:40px">
		 						<span class="input-group-btn">
		 							<button class="btn btn-default" type="button" onclick="pNum(${c.ciid},${c.goods.gprice},${i.count})">+</button>
		 						</span>
	 						</div>
	 					</th>
	 					<th id="pri_count${i.count}">¥&nbsp;${(c.goods.gprice.intValue()/100.00)*c.count}</th>
	 					<th>
	 						<button type="button" class="btn btn-default" onclick="clearCart(${c.ciid})">删除</button>
	 					</th>
	 				</tr>
	 				<c:set var="sum" value="${sum+(c.goods.gprice.intValue()/100.00)*c.count}"></c:set>
 				</c:forEach>
			</table>
		</div>
	</div>
	<hr>
	<div class="row">
		<div class="pull-right" style="margin-right: 40px;">

			<div style="margin-bottom: 20px;">
				商品金额总计：<span id="total" class="text-danger">￥&nbsp;&nbsp;<b id="price_sum" >${sum}</b></span>
			</div>
			<br><br>
	            <div>
	            	<a id="removeAllProduct" href="javascript:clearCart(0)" class="btn btn-default btn-lg">清空购物车</a>
	            	&nbsp;&nbsp;
	            	<a href="selectall.do" class="btn  btn-danger btn-lg">添加收货地址</a>
					<input type="button" id="btn_submit" value="生成订单"  class="btn  btn-danger btn-lg" />
	            </div>



		</div>
	</div>
</div>
	
    
<!-- 底部 -->
<script type="application/javascript" src="js/footer.js"></script>


</body>
</html>