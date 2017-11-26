<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Đăng Nhập || Đăng Ký</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/font-awesome.min.css" rel="stylesheet">
<link href="css/prettyPhoto.css" rel="stylesheet">
<link href="css/price-range.css" rel="stylesheet">
<link href="css/animate.css" rel="stylesheet">
<link href="css/main.css" rel="stylesheet">
<link href="css/responsive.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="admin_assets/calendar/css/datepicker.min.css">
<style>
.no-spin::-webkit-calendar-picker-indicator, .no-spin::-webkit-outer-spin-button, .no-spin::-webkit-inner-spin-button {
    -webkit-appearance: none;
    display:none;
</style>
<body>
	<!-- Header -->
	<jsp:include page="tieuDe.jsp" />
	<!-- /Header -->

	<section id="form"><!--form-->
	<div class="container">
		<div class="row">
			<div class="col-sm-4 col-sm-offset-1">
				<div class="login-form">
					<!--login form-->
					<h2>Đăng nhập với tài khoản của bạn</h2>
					<html:form action="dang-nhap-dang-ky.do" method="post">
						<input type="text" name="userName" placeholder="Tên đăng nhập" />
						<input type="password" name="password" placeholder="Mật khẩu" />
						<logic:notEmpty name="personForm" property="submit">
							<logic:equal name="personForm" property="submit" value="submitDangNhap">
								<p style="color: red;"><bean:write name="personForm" property="thongBao" />
							</logic:equal>
						</logic:notEmpty>
						<html:submit styleClass="btn btn-primary">Đăng nhập</html:submit>
						<html:hidden property="submit" value="submitDangNhap" />
					</html:form>
				</div>
				<!--/login form-->
			</div>
			<div class="col-sm-1">
				<h2 class="or">Hoặc</h2>
			</div>
			<div class="col-sm-4">
				<div class="login-form">
					<!--sign up form-->
					<h2>Đăng ký tài khoản mới</h2>
					<form action="dang-nhap-dang-ky.do" method="post">
						<input type="text" name="userName" placeholder="Tên đăng nhập" required/>
						<input type="text" name="fullName" placeholder="Tên đầy đủ" required/>
						<div style="float: left;">
							<span> <input type="radio" value="Nam" name="gender" checked="checked">
								<label style="font-weight: normal">Nam</label>
							</span>
						</div>
						<div style="float: left;">
							<span> <input type="radio" value="Nữ" name="gender">
								<label style="font-weight: normal">Nữ</label>
							</span>
						</div>
						<span> <input type="radio" value="Khác" name="gender">
							<label style="font-weight: normal">Khác</label>
						</span>
						<input type="date" name="birthday" placeholder="Ngày Sinh" max="9999-12-31" required class="no-spin"/>
						<input type="text" name="address" placeholder="Địa chỉ" required/>
						<input type="text" name="phone" id="phone" placeholder="Số điện thoại" required/> 
						<input type="email" name="email" placeholder="Email" required/> 
						<input type="password" name="password" placeholder="Mật khẩu" id="pwd" required/> 
						<input type="password" placeholder="Xác nhận mật khẩu" id="pwd2" required/>
						<logic:notEmpty name="personForm" property="submit">
							<logic:equal name="personForm" property="submit" value="submitDangKy">
								<p style="color: red;"><bean:write name="personForm" property="thongBao" />
							</logic:equal>
						</logic:notEmpty>
						<html:submit styleClass="btn btn-primary btnSubmit">Đăng Ký</html:submit>
						<html:hidden property="submit" value="submitDangKy" />
					</form>
				</div>
				<!--/sign up form-->
			</div>
		</div>
	</div>
	</section>
	<!--/form-->


	<!-- Footer -->
	<script src="js/jquery-1.11.2.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="admin_assets/myjsandcss/js/myjquery.form_validation.js"></script>
	<jsp:include page="cuoiTrang.jsp" />
	<script>
	$(".btnSubmit").click(function(){
		var phone=document.getElementById('phone');
		var arrPhone = phone.value.split("");
		for(var i = 0 ; i < arrPhone.length ; i++)
		{
			if(!(arrPhone[i].charCodeAt() >= 48 && arrPhone[i].charCodeAt() <= 57))
			{
				return phone.setCustomValidity("Chỉ Được Nhập Số");
			}
		}
		phone.setCustomValidity("");
	});
	</script>
	 <script type="text/javascript" src="admin_assets/calendar/js/datepicker.min.js" ></script>
	 <script type="text/javascript" src="admin_assets/calendar/js/datepicker.en.js" ></script>
	 <script>
	       $(document).ready(function(){
	           $('input[type="date"]').datepicker({
	               language: 'en',
	               dateFormat: 'yyyy-mm-dd',
	               todayButton: new Date(),
	               clearButton: true,
	               autoClose: true,
	           });
	       });
	   </script>
	<!--/Footer-->
</body>
</html>