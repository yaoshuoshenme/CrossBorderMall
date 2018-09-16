<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="css/login2.css">
<link rel="stylesheet" href="css/bootstrap.min.css" />
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<title>个人中心-收货地址页面</title>
<script type="text/javascript">
	function deleteAddr(id){
		var res = confirm("是否删除");
		if(res==true){
			window.location.href="deleteaddress.do?aid="+id;
		}
	}
	function defaultAddr(aid,uid){
		var res = confirm("是否设为默认");
		if(res==true){
			window.location.href="defaultaddress.do?aid="+aid+"&&uid="+uid;
			
		}
	}

</script>

<script type="text/javascript">

	    //省市联动
		function changePro(obj) {
			var pid = obj.value;
			$("#scity").html("<option value=\"-1\">--请选择市--</option>");
			$("#scountry").html("<option value=\"-1\">--请选择县--</option>");

			if(pid > 0){
                $.get("querycity.do","id="+pid,function (data) {
                    $.each(data, function(i, city){

                        var $option = $("<option value="+city.id+">"+city.name+"</opton>")
						$("#scity").append($option);
                    });

                })
			}
        }

        //市 县联动
		function changeCity(obj){
            $("#scountry").html("<option value=\"-1\">--请选择县--</option>");
		    var cityid = obj.value;

		    if(cityid > 0){
		        $.get("querycountry.do","id="+cityid,function (data) {
                    $.each(data, function(i, country){
                        var $option = $("<option value="+country.id+">"+country.name+"</opton>")
                    	$("#scountry").append($option);
                    });
                })
			}
		}

</script>

</head>
<body>
<script type="text/javascript" src="js/header.js"></script>

<!--网站中间内容开始-->
<div id="dingdanxiangqing_body">
    <div id="dingdanxiangqing_body_big">
        <div id="big_left">
           	   <p style="font-size:18px;margin-top: 15px">订单中心</p>
               <a id="big_left_a" href="dingdanxiangqing.html">我的订单</a><br/>
               <a id="big_left_a" href="">意外保</a><br/>
               <a id="big_left_a" href="">团购订单</a><br/>
               <a id="big_left_a" href="">评价晒单</a><br/>
               <p style="font-size:18px">个人中心</p>
               <a id="big_left_a" href="self_info.html">我的个人中心</a><br/>
               <a id="big_left_a" href="">消息通知</a><br/>
               <a id="big_left_a" href="">优惠券</a><br/>
               <a id="big_left_a" href="">收货地址</a><br/>
        </div>
     <div id="big_right" style="height: 500px;overflow: scroll;">
     
         <div style="margin:0 20px;">
	         <h3>收货地址</h3>
	         <hr>
	         <table class="table table-striped table-hover table-bordered">
				<tr>
					<th>序号</th><th>收件人</th>
					<th>手机号</th><th>地址</th>
					<th>操作</th>
				</tr>
				<c:forEach var="address" items="${addList}" varStatus="i" >
					<tr>
						<Td>${i.count}</Td>
						<td>${address.aname}</td>
						<td>${address.aphone}</td>
						<td>${address.pname}${address.cityname}${address.countryname}${address.adetail}</td>
						<td>
							<button onclick="deleteAddr(${address.aid})" class="btn btn-danger btn-sm">删除</button>&nbsp;&nbsp;
							<button class="btn btn-default btn-sm" data-toggle="modal" data-target="#myModal${address.aid}">修改</button>&nbsp;&nbsp;
							<!-- 弹出模态框 -->
							
							<div class="modal fade" tabindex="-1" role="dialog" id="myModal${address.aid}">
							  <div class="modal-dialog" role="document">
							    <div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal">
											<span>&times;</span>
										</button>
										<h4 class="modal-title">修改地址</h4>
									</div>

									<%--修改地址--%>
							<form action="userAddress?flag=update" method="post" class="form-horizontal">
										<div class="motal-body">
											<div class="form-group">
												<label class="col-sm-2 control-label">收件人</label>
												<div class="col-sm-10">
													<input type="hidden" name="aid" value="${address.aid}">
													<input type="hidden" name="aord" value="${address.aord}">
													<input type="text" name="aname" class="form-control" value="${address.aname}">
												</div>
											</div>
											<div class="form-group">
												<label class="col-sm-2 control-label">电话</label>
												<div class="col-sm-10">
													<input type="text" name="aphone" class="form-control" value="${address.aphone}">
												</div>
											</div>
											<div class="form-group">
												<label class="col-sm-2 control-label">收件人</label>
												<div class="col-sm-10">
													<input type="text" name="adetail" class="form-control" value="${address.adetail}">
												</div>
											</div>
										</div>
										<div class="motal-footer">
											<button type="submit" class="btn btn-primary">修改</button>
										</div>
									</form>
								</div>
							</div>
							</div>
							
							<button onclick="defaultAddr(${address.aid},${user.uid})" class="btn btn-primary btn-sm">设为默认</button>
							<c:if test="${address.aord==1}">
								<span class="badge" style="background-color:red;">默认</span>
							</c:if>
							<c:if test="${address.aord==0}">
								<span class="badge">普通</span>
							</c:if>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<br>
		<div class="container" style="width:960px;">

			<%--添加收货地址--%>
			<form action="addaddress.do" method="post" class="form-horizontal">
				<div class="form-group">
				    <label class="col-sm-2 form-label">收件人</label>
				    <div class="col-sm-3">
				      <input type="text" class="form-control" name="aname"/>
				    </div>
				</div>
		  		<div class="form-group">
				    <label class="col-sm-2 form-label">手机号</label>
				    <div class="col-sm-3">
				      <input type="text" class="form-control" name="aphone"/>
				    </div>
				</div>
				<div class="form-group">
					<div class="form-group">
						<label class="col-sm-2 form-label">省市县</label>
						<div class="col-sm-3">
							<select name="pid" class="form-control" onchange="changePro(this)">
								<option value="-1">--请选择省份--</option>
								<c:forEach items="${province}" var="p">
									<option value="${p.id}">${p.name}</option>
								</c:forEach>
							</select>
						</div>
						<div class="col-sm-3">
							<select name="cityid" class="form-control" id="scity" onchange="changeCity(this)">
								<option value="-1">--请选择市--</option>
							</select>
						</div>
						<div class="col-sm-3">
							<select name="countryid" class="form-control"  id="scountry">
								<option value="-1">--请选择县--</option>
							</select>
						</div>
					</div>
				<div class="form-group">
					<label class="form-label">详细地址</label>
					<textarea rows="3" class="form-control" name="adetail" ></textarea>
				</div>
				<div class="form-group col-md-12">
					<input type="submit" id="btn_submit" class="btn btn-primary" value="添加地址">
				</div>
				<input type="hidden" value="${user.uid}" name="uid">
			</form>
	      </div>
       </div>
    </div>
</div>
	
<!-- 底部 -->
<script type="text/javascript" src="js/footer.js"></script>

</body>
</html>