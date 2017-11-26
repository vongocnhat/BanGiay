<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/struts.jsp"%>
<%@page import="common.StringProcess"%>
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
				<html:link href="quanly/person/capnhat.do?btnUpdate=addView" styleClass="btn btn-primary">Thêm Người Dùng</html:link>
				<div class="panel panel-default">
					<div class="panel-heading">
						<i class="fa fa-table"></i>
						<h5>Danh Sách Người Dùng</h5>
					</div>
					<div class="panel-body">
						<bean:define id="type" name="personForm" property="type"></bean:define>
						<html:select property="personForm" name="type" styleId="type"
							value="${type}" styleClass="form-control">
							<html:option value="0">Khách Hàng</html:option>
							<html:option value="1">Admin</html:option>
						</html:select>				
						<table class="table table-striped">
							<thead>
								<tr>
									<th>Tài Khoản</th>
									<th>Họ Và Tên</th>
									<th>Giới Tính</th>
									<th>Ngày Sinh</th>
									<th>Địa Chỉ</th>
									<th>Điện Thoại</th>
									<th>Email</th>
									<th>Trạng Thái</th>
									<th>Ngày Tạo</th>
									<th>Sửa</th>
									<th>Xóa</th>
								</tr>
							</thead>
							<tbody>
								<logic:iterate name="personForm" property="listPerson" id="person">
									<tr class="gradeX">
										<td><bean:write name="person" property="userName" /></td>
										<td><bean:write name="person" property="fullName" /></td>
										<td><bean:write name="person" property="gender" /></td>
										<td><bean:write name="person" property="birthday" /></td>
										<td><bean:write name="person" property="address" /></td>
										<td><bean:write name="person" property="phone" /></td>
										<td><bean:write name="person" property="email" /></td>
										<td>
											<logic:equal name="person" property="status" value="true">
												Mở
											</logic:equal>
											<logic:equal name="person" property="status" value="false">
												Khóa
											</logic:equal>
										</td>
										<td><bean:write name="person" property="createdday" /></td>
										<bean:define id="userName" name="person" property="userName"></bean:define>
										<td><html:link
												action="quanly/person/capnhat?userName=${userName}&btnUpdate=updateView"
												styleClass="btn btn-info">Sửa</html:link></td>
										<td><html:link action="quanly/person/capnhat?userName=${userName}&btnUpdate=delete"
												styleClass="btn btn-danger" styleId="btnDelete">Xóa</html:link></td>
									</tr>
								</logic:iterate>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<jsp:include page="/quanly/layout/bottom.jsp"></jsp:include>
<script>
	var type = document.getElementById("type");
	var url;
	type.onchange = function() {
		url = "quanly/person/danhsach.do?type=" + type.value;
		window.location = url;
	}
	$("#btnDelete").click(function(){
		var userName = $(this).parent().siblings("td:first").text();
		return confirm("Bạn Muốn Xóa Tài Khoản "+userName+" ?");
	});
</script>
<script type="text/javascript">

</script>
</body>
</html>