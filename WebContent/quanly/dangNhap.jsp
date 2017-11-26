<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/struts.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>SB Admin 2 - Bootstrap Admin Theme</title>
    <base href="/BanGiay/">
    <!-- Bootstrap Core CSS -->
    <link href="admin_assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="admin_assets/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="admin_assets/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="admin_assets/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Đăng Nhập</h3>
                    </div>
                    <div class="panel-body">
                       <!--  @if(session('notify'))
                        <div class="alert alert-danger">
                            {{ session('notify') }}
                        </div>
                        @endif-->
                        <html:form action="/quanly" method="post" styleClass="form-horizontal">
                            <fieldset>
                                <div class="form-group">
                                    <label>Tài Khoản:</label>
                                    <html:text property="userName" styleClass="form-control"></html:text>
                                </div>
                                <div class="form-group">
                                	<label>Mật Khẩu</label>
                                    <html:password property="password" styleClass="form-control"></html:password>
                                </div>
                                <p style="color: red"><bean:write name="personForm" property="thongBao" /></p>
                                <div class="checkbox">
                                    <label>
                                        <input name="remember" type="checkbox" value="Remember Me">Remember Me
                                    </label>
                                </div>
                                <!-- Change this to a button or input when using this as a form -->
                                <html:submit value="Đăng Nhập" styleClass="btn btn-lg btn-success btn-block"></html:submit>
                            </fieldset>
                        </html:form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- jQuery -->
    <script src="admin_assets/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="admin_assets/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="admin_assets/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="admin_assets/dist/js/sb-admin-2.js"></script>
    <script>
    	$("input").attr("required", true);
    	$("input[type='checkbox']").attr("required", false);
    </script>
</body>
</html>