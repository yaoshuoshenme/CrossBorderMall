<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="css/login2.css">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<script type="text/javascript" src="js/jquery.min.js"></script>
<title>商品详情页</title>

</head>
<body>
<script type="application/javascript" src="js/header.js"></script>

  
    	<div style="margin: 0 auto;width: 90%;">
	   <ol class="breadcrumb">
		  <li><a href="#">小米商城</a></li>
		  <li><a href="#">手机</a></li>
		  <li class="active"><a href="getGoodsListByTypeId?typeid=${goods.gtid}">${goods.gtname}</a></li>
	   </ol>
   </div>
   
	<div class="container">
		<div class="row">
		  <div class="col-xs-6 col-md-6">
		    <a href="#" class="thumbnail">
		      <img src="/17fmpics/${goods.gpic}"  width="560" height="560"  alt="${goods.gname}" />
		    </a>
		  </div>
		  <div class="col-xs-6 col-md-6">
		   	<div class="panel panel-default" style="height: 560px">
			  <div class="panel-heading">商品详情</div>
			  <div class="panel-body">
			    <h3>产品名称:<small>${goods.gname}</small></h3>
			    <div style="margin-left: 10px;">
				    
				   <p>市场价格:&nbsp;&nbsp;&nbsp;<span class="text-danger" style="font-size: 15px;">${goods.gprice.intValue()/100.00}元</span>&nbsp;&nbsp;&nbsp;</p>
				    <p>上市时间:&nbsp;&nbsp;&nbsp;${goods.gpubdate}</p>
				     <p>热销指数:&nbsp;&nbsp;&nbsp;
						<c:forEach begin="1" end="${goods.gstar}">
				        		<img src="image/star_red.gif" alt="gstar"/>
				        	</c:forEach>
					</p>
				    <p>详细介绍:</p>
				    <p>&nbsp;&nbsp;${goods.ginfo }</p>
				    <a href="${pageContext.request.contextPath}/addCart.do?gid=${goods.gid}" class="btn btn-warning">加入购物车&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon-shopping-cart"></span></a>&nbsp;&nbsp;&nbsp;
				    <button class="btn btn-danger">直接购买</button>
			    </div>
			  </div>
			</div>
		  </div>
		</div>
	</div>
   <!-- 底部 -->
	<script type="application/javascript" src="js/footer.js"></script>



</body>
</html>