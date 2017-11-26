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
				<html:link href="quanly/promotion/danhSach.do?btnUpdate=addView" styleClass="btn btn-primary">Thêm Khuyến Mãi</html:link>
				<div class="panel panel-default">
					<div class="panel-heading">
						<i class="fa fa-table"></i>
						<h5>Danh Sách Khuyến mãi</h5>
					</div>
					<div class="panel-body">
						<table class="table table-striped">
							<thead>
								<tr>
									<th>ID</th>
									<th>Mã Sản Phẩm</th>
									<th>Phụ Kiện Khuyến mãi</th>
									<th>% Khuyến Mãi</th>
									<th>Thời Gian Bắt Đầu</th>
									<th>Thời Gian Kết Thúc</th>
									<th>Sửa</th>
									<th>Xóa</th>
								</tr>
							</thead>
							<tbody>
								<logic:iterate name="promotionForm" property="listPromotion" id="promotion">
									<tr class="gradeX">
										<td><bean:write name="promotion" property="promotionId" /></td>
										<td><bean:write name="promotion" property="productId" /></td>
										<td><bean:write name="promotion" property="accessoriesId" /></td>
										<td><bean:write name="promotion" property="discount" /></td>
										<td><bean:write name="promotion" property="mfgDate" /></td>
										<td><bean:write name="promotion" property="expDate" /></td>
										<bean:define id="promotionId" name="promotion" property="promotionId"></bean:define>
										<td><html:link
												action="quanly/promotion/danhsach?promotionId=${promotionId}&btnUpdate=updateView"
												styleClass="btn btn-info">Sửa</html:link></td>
										<td><html:link action="quanly/promotion/danhsach?promotionId=${promotionId}&btnUpdate=delete"
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