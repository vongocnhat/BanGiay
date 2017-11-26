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
					<html:link href="quanly/product/capnhat.do?btnUpdate=addView"
						styleClass="btn btn-primary">Thêm Sản Phẩm</html:link>
					<div class="panel panel-default">
						<div class="panel-heading">
							<i class="fa fa-table"></i>
							<h5>Danh Sách Sản Phẩm</h5>
						</div>
						<div class="panel-body">
							<table class="table table-striped">
								<thead>
									<tr>
										<th>Mã Sản Phẩm</th>
										<th>Tên Danh Mục</th>
										<th>Tên Sản Phẩm</th>
										<th>Lượt Xem</th>
										<th>Lượt Mua</th>
										<th>Giá</th>
										<th>Mô Tả</th>
										<th>Sửa</th>
										<th>Xóa</th>
										<th>Thêm chi tiết</th>
									</tr>
								</thead>
								<tbody>
									<logic:iterate name="productForm" property="listProduct"
										id="product">
										<tr class="gradeX">
											<td><bean:write name="product" property="productId" /></td>
											<td><bean:write name="product" property="categoryId" /></td>
											<td><bean:write name="product" property="productName" /></td>
											<td><bean:write name="product" property="numberViewed" /></td>
											<td><bean:write name="product" property="numberSeller" /></td>
											<td><bean:write name="product" property="price" /></td>
											<td><bean:write name="product" property="description" /></td>
											<bean:define id="productId" name="product" property="productId"></bean:define>
											<td><html:link
													action="quanly/product/capnhat?productId=${productId}&btnUpdate=updateView"
													styleClass="btn btn-info">Sửa</html:link></td>
											<td><html:link
													action="quanly/product/capnhat?productId=${productId}&btnUpdate=delete"
													styleClass="btn btn-danger" styleId="btnDelete">Xóa</html:link></td>
											<td><html:link
													action="quanly/productdetail/them?productId=${productId}"
													styleClass="btn btn-danger" styleId="btnDelete">Thêm chi tiết</html:link></td>
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