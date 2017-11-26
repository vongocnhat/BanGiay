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

<!-- 	<section id="form">form -->
<!-- 	<div class="container"> -->
<!-- 		<div class="row"> -->
		<center>
		<img src="images/iconhdd.png" alt="">
		<br>
		<br>
		<bean:define id="person" name="personForm" property="person"></bean:define>
		<table class="table table-striped" style="width: 0;">
            <thead>
            <tr>
                <th>Tên đăng nhập:</th>
                <th><bean:write name="person" property="userName" /></th>
                <th>
                	<html:link action="#">
                		<span></span>
                	</html:link>
                </th>
            </tr>
            <tr>
                <th>Họ và tên:</th>
                <th><bean:write name="person" property="fullName" /></th>
                <th>
                	<html:link action="#">
                		<span class="glyphicon glyphicon-edit"></span>
                	</html:link>
                </th>
            </tr>
            <tr>
                <th>Giới tính:</th>
                <th><bean:write name="person" property="gender" /></th>
                <th>
                	<html:link action="#">
                		<span class="glyphicon glyphicon-edit"></span>
                	</html:link>
                </th>
            </tr>
            <tr>
                <th>Ngày sinh:</th>
                <th><bean:write name="person" property="birthday" /></th>
                <th>
                	<html:link action="#">
                		<span class="glyphicon glyphicon-edit"></span>
                	</html:link>
                </th>
            </tr>
            <tr>
                <th>Địa chỉ:</th>
                <th><bean:write name="person" property="address" /></th>
                <th>
                	<html:link action="#">
                		<span class="glyphicon glyphicon-edit"></span>
                	</html:link>
                </th>
            </tr>
            <tr>
                <th>Số điện thoại:</th>
                <th><bean:write name="person" property="phone" /></th>
                <th>
                	<html:link action="#">
                		<span class="glyphicon glyphicon-edit"></span>
                	</html:link>
                </th>
            </tr>
            <tr>
                <th>Email:</th>
                <th><bean:write name="person" property="email" /></th>
                <th>
                	<html:link action="#">
                		<span class="glyphicon glyphicon-edit"></span>
                	</html:link>
                </th>
            </tr>
            <tr>
                <th>Ngày lập tài khoản:</th>
                <th><bean:write name="person" property="createdday" /></th>
                <th>
                	<html:link action="#">
                		<span class="glyphicon glyphicon-edit"></span>
                	</html:link>
                </th>
            </tr>
            <tr>
            	<th>
                	<html:link action="/doiMatKhau.jsp">
                		<span class="glyphicon glyphicon-edit"> Đổi mật khẩu</span>
                	</html:link>
                </th>
            </tr>
            </thead>
        </table>
        </center>
<!-- 		</div> -->
<!-- 	</div> -->
<!-- 	</section> -->
	<!--/form-->


	<!-- Footer -->
	<script src="js/jquery-1.11.2.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="admin_assets/myjsandcss/js/myjquery.form_validation.js"></script>
	<jsp:include page="cuoiTrang.jsp" />
	<!--/Footer-->
</body>
</html>