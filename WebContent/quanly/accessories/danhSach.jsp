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
				<html:link href="quanly/accessories/danhsach.do?btnUpdate=addView" styleClass="btn btn-primary">Thêm Phụ Kiện</html:link>
				<div class="panel panel-default">
					<div class="panel-heading">
						<i class="fa fa-table"></i>
						<h5>Danh Sách Phụ Kiện</h5>
					</div>
					<div class="panel-body">			
						<table class="table table-striped">
							<thead>
								<tr>
									<th>Id</th>
									<th>Tên Phụ Kiện</th>
									<th>Giá</th>
									<th>Size</th>
									<th>Số Lượng</th>
									<th>Hình Ảnh</th>
									<th>Màu Sắc</th>
									<th>Mô Tả</th>
									<th>Sửa</th>
									<th>Xóa</th>
								</tr>
							</thead>
							<tbody>
								<logic:iterate name="accessoriesForm" property="listAccessories" id="accessories">
									<tr class="gradeX">
										<td><bean:write name="accessories" property="accessoriesId" /></td>
										<td><bean:write name="accessories" property="accessoriesName" /></td>
										<td><bean:write name="accessories" property="price" /></td>
										<td><bean:write name="accessories" property="size" /></td>
										<td><bean:write name="accessories" property="quantity" /></td>
										<td><bean:write name="accessories" property="image" /></td>
										<td><bean:write name="accessories" property="color" /></td>
										<td><bean:write name="accessories" property="description" /></td>
										<bean:define id="accessoriesId" name="accessories" property="accessoriesId"></bean:define>
										<td><html:link
												action="quanly/accessories/danhsach?accessoriesId=${accessoriesId}&btnUpdate=updateView"
												styleClass="btn btn-info">Sửa</html:link></td>
										<td><html:link action="quanly/accessories/danhsach?accessoriesId=${accessoriesId}&btnUpdate=delete"
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
</body>
</html>