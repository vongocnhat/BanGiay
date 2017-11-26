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
<title>Thông tin tài khoản</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/font-awesome.min.css" rel="stylesheet">
<link href="css/prettyPhoto.css" rel="stylesheet">
<link href="css/price-range.css" rel="stylesheet">
<link href="css/animate.css" rel="stylesheet">
<link href="css/main.css" rel="stylesheet">
<link href="css/responsive.css" rel="stylesheet">
<body>
	<!-- Header -->
	<jsp:include page="tieuDe.jsp" />
	<!-- /Header -->

	<section id="form"><!--form-->
	<div class="container">
		<div class="row">
		<html:form action="/doiMatKhau" method="post" style="margin-left: 400px;">
			<div class="row form-group">
				<label class="col-lg-2">Mật khẩu cũ:</label>
				<div class="col-lg-3">
					<input type="password" name="password" placeholder="Mật khẩu cũ" required/> 
				</div>
			</div>
			<div class="row form-group">
				<label class="col-lg-2">Mật khẩu mới:</label>
				<div class="col-lg-3">
					<input type="password" name="passwordNew" placeholder="Mật khẩu mới" id="pwd" required/> 
				</div>
			</div>
			<div class="row form-group">
				<label class="col-lg-2">Xác nhận mật khẩu:</label>
				<div class="col-lg-3">
					<input type="password" placeholder="Xác nhận mật khẩu" id="pwd2" required/>
				</div>
			</div>
			<logic:notEmpty name="updatePasswordPersonForm" property="submit">
			<div class="row form-group">
				<div class="col-lg-3 col-lg-offset-2">
					<p style="color: red;"><bean:write name="updatePasswordPersonForm" property="thongBao" />
					</p>
				</div>
			</div>
			</logic:notEmpty>
			<div class="row form-group">
				<div class="col-lg-3 col-lg-offset-2">
					<html:submit styleClass="btn btn-primary">Đổi mật khẩu</html:submit>
					<html:hidden  property="submit" value="submit"/>
					<a href="thong-tin-tai-khoan.do" class="btn btn-primary" >Hủy</a>
				</div>
			</div>
		</html:form>
		</div>
	</div>
	</section>
	<!--/form-->


	<!-- Footer -->
	<script src="js/jquery-1.11.2.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="admin_assets/myjsandcss/js/myjquery.form_validation.js"></script>
	<jsp:include page="cuoiTrang.jsp" />
	<!--/Footer-->
</body>
</html>