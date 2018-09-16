<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" type="text/css" href="css/login2.css">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="js/jquery.min.js"></script>
<title>商品列表页</title>

</head>
<script type="application/javascript" src="js/header.js"></script>
<body>
<div class="panel panel-default" style="margin: 0 auto;width: 95%;">
	<div class="panel-heading">
	    <h3 class="panel-title"><span class="glyphicon glyphicon-th-list"></span>&nbsp;&nbsp;商品列表</h3>
	</div>
	<div class="panel-body">
	   	   <!--列表开始-->
	    <div class="row" style="margin: 0 auto;">
	    	<c:forEach items="${glist}" var="g" varStatus="i">
		    	<div class="col-sm-3">
				    <div class="thumbnail">
				      <img src="/17fmpics/${g.gpic}" width="180" height="180"  alt="小米6" />
				      <div class="caption">
				        <h4>商品名称<a href="${pageContext.request.contextPath}/goodsbyid.do?gid=${g.gid}">${g.gname}</a></h4>
				        <p>热销指数
				        	<c:forEach begin="1" end="${g.gstar}">
				        		<img src="image/star_red.gif" alt="gstar"/>
				        	</c:forEach>
				        </p>
				         <p>上架日期:${g.gpubdate}</p>
			             <p style="color:orange">价格:${g.gprice.intValue()/100.00}元</p>
				      </div>
				    </div>
				  </div>
	    	</c:forEach>
			  
		</div>
   	</div>
</div>
      <!-- 底部 -->
<script type="application/javascript" src="js/footer.js"></script>
</body>
</html>