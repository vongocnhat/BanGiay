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
<%-- 					<html:link href="quanly/order/capnhat.do?btnUpdate=addView" --%>
<%-- 						styleClass="btn btn-primary">Thêm Đơn Hàng</html:link> --%>
					<div class="panel panel-default">
						<div class="panel-heading">
							<i class="fa fa-table"></i>
							<h5>Danh Sách Đơn Hàng</h5>
						</div>
						<div class="panel-body">
							<table class="table table-striped">
								<thead>
									<tr>
										<th>Mã Đơn Hàng</th>
										<th>User Name</th>
										<th>Họ Tên</th>
										<th>Email</th>
										<th>Số ĐT</th>
										<th>Địa Chỉ</th>
										<th>Thanh Toán</th>
										<th>Số Lượng</th>
										<th>Tổng Tiền</th>
										<th>Thanh Toán</th>
										<th>Xác Nhận</th>
										<th>Ngày Tạo</th>
<!-- 										<th></th> -->
										<th></th>
										<th></th>
									</tr>
								</thead>
								<tbody>
									<logic:iterate name="orderForm" property="listOrder" id="order">
										<tr class="gradeX">
											<bean:define id="orderId" name="order" property="orderId"></bean:define>
											<td><bean:write name="order" property="orderId" /></td>
											<td><bean:write name="order" property="userName" /></td>
											<td><bean:write name="order" property="fullName" /></td>
											<td><bean:write name="order" property="email" /></td>
											<td><bean:write name="order" property="phone" /></td>
											<td><bean:write name="order" property="address" /></td>
											<td><bean:write name="order" property="method" /></td>
											<td><bean:write name="order" property="totalQuantity" /></td>
											<td><bean:write name="order" property="totalPrice" /></td>
											<td>
												<logic:equal name="order" property="status" value="true">
													Rồi
												</logic:equal>
												<logic:equal name="order" property="status" value="false">
													<p style="color: red;">Chưa
												</logic:equal>
											</td>
											<td>
												<logic:equal name="order" property="confirm" value="true">
													Rồi
												</logic:equal>
												<logic:equal name="order" property="confirm" value="false">
													<p style="color: red;">Chưa
												</logic:equal>
											</td>
											<td><bean:write name="order" property="createdday" /></td>
<%-- 											<td><html:link --%>
<%-- 													action="quanly/productdetail/them?productId=${productId}" --%>
<%-- 													styleClass="btn btn-danger" styleId="btnDelete">Xem chi tiết</html:link></td>						 --%>
											<td><html:link action="quanly/order/capnhat?orderId=${orderId}&btnUpdate=updateView" 
													styleClass="btn btn-info">Duyệt</html:link></td>
											<td><html:link action="quanly/order/capnhat?orderId=${orderId}&btnUpdate=delete"
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