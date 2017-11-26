<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/struts.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/quanly/layout/head.jsp"></jsp:include>
</head>
<body>
<jsp:include page="/quanly/layout/top.jsp"></jsp:include>
<div id="page-wrapper">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">
						<i class="fa fa-align-justify"></i>
						<h5>Cập Nhật Admin</h5>
					</div>
					<div class="panel-body">
						<html:form action="quanly/person/capnhat" method="post"
							styleClass="form-horizontal">
							<div class="control-group">
								<label class="control-label required">Họ Và Tên: </label>
								<div class="controls">
									<html:text property="fullName" styleClass="form-control" ></html:text>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label required">Giới Tính: </label>
								<div class="controls">
									<html:select property="gender" styleClass="form-control">
										<html:option value="Nam">Nam</html:option>
										<html:option value="Nữ">Nữ</html:option>
										<html:option value="Khác">Khác</html:option>
									</html:select>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label required">Ngày Sinh: </label>
								<div class="controls">
									<input type="date" name="birthday" class="form-control"
										value='<bean:write name="personForm" property="birthday" />' max="9999-12-31" required />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label required">Địa Chỉ: </label>
								<div class="controls">
									<html:text property="address" styleClass="form-control" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label required">Điện Thoại: </label>
								<div class="controls">
									<input type="number" name="phone" class="form-control no-spin"
										value='<bean:write name="personForm" property="phone"/>' />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label required">Email: </label>
								<div class="controls">
									<input type="email" name="email" class="form-control" required
										value='<bean:write name="personForm" property="email"/>' />
								</div>
							</div>
							<div class="control-group">
								<h2>Thông tin đăng nhập</h2>
							</div>
							<div class="control-group">
								<label class="control-label required">Tài Khoản: </label>
								<div class="controls">
									<html:text property="userName" styleClass="form-control" styleId="userName"></html:text>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label required">Mật Khẩu: </label>
								<div class="controls">
									<html:password property="password" styleClass="form-control"
										styleId="pwd" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label required">Xác Nhận Mật
									Khẩu: </label>
								<div class="controls">
									<input type="password" name="confirmPassword"
										class="form-control" id="pwd2" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label required">Loại Tài Khoản: </label>
								<div class="controls">
									<html:select property="type" styleClass="form-control">
										<html:option value="0">Người Dùng</html:option>
										<html:option value="1">Admin</html:option>
									</html:select>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label required">Trạng Thái: </label>
								<div class="controls">
									<html:checkbox property="status" styleClass="form-control"></html:checkbox>
								</div>
							</div>
							<div class="form-actions">
								<html:submit value="Lưu" styleClass="btn btn-primary btn-large"></html:submit>
								<logic:empty name="personForm" property="userName">
									<html:hidden property="btnUpdate" value="add" />
								</logic:empty>
								<logic:notEmpty name="personForm" property="userName">
									<html:hidden property="btnUpdate" value="edit" />
								</logic:notEmpty>
								<button class="btn btn-danger" onclick="history.go(-1);">Quay
									lại</button>
							</div>
						</html:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<jsp:include page="/quanly/layout/bottom.jsp"></jsp:include>
<script>
$("input").attr("required", true);
$("input[type='checkbox']").attr("required", false);
	if($("#userName").val() != "")
	{
		$("#userName").attr("readonly", true);
 		var pdw = $("#pwd");
 		var pdw2 = $("#pwd2");
 		pdw.attr("placeholder", "Nhập để đổi mật khẩu");
 		pdw.attr("required", false);
 		pdw2.attr("required", false);
	}
	else
	$("#pwd").
		$("input[type='checkbox']").attr("checked", "checked");
	
</script>
</body>
</html>