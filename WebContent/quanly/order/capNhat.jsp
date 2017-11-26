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
							<h5>Đơn Hàng </h5>
						</div>
						<div class="panel-body">
							<html:form action="quanly/order/capnhat" method="post"
								styleClass="form-horizontal">
							<logic:notEqual name="orderForm" property="orderId" value="0">
								<div class="control-group">
									<label class="control-label required">Mã Đơn Hàng </label>
									<div class="controls">
										<html:text property="orderId" styleClass="form-control" readonly="true"></html:text>
									</div>
								</div>
							</logic:notEqual>
							<div class="control-group">
									<label class="control-label required">Username </label>
									<div class="controls">
										<html:text property="userName" styleClass="form-control" />
									</div>
								</div>
								<div class="control-group">
									<label class="control-label required">Họ Tên </label>
									<div class="controls">
										<html:text property="fullName" styleClass="form-control" />
									</div>
								</div>
								<div class="control-group">
									<label class="control-label required">Email </label>
									<div class="controls">
										<html:text property="email" styleClass="form-control" />
									</div>
								</div>
								<div class="control-group">
									<label class="control-label required">Số ĐT</label>
									<div class="controls">
										<html:text property="phone" styleClass="form-control" />
									</div>
								</div>
								<div class="control-group">
									<label class="control-label required">Địa Chỉ </label>
									<div class="controls">
										<html:text property="address" styleClass="form-control" />
									</div>
								</div>
							<div class="control-group">
									<label class="control-label required">Thanh Toán </label>
									<div class="controls">
										<html:text property="method" styleClass="form-control" />
									</div>
								</div>
								<div class="control-group">
									<label class="control-label required">Số Lượng </label>
									<div class="controls">
										<html:text property="totalQuantity" styleClass="form-control" />
									</div>
								</div>
								<div class="control-group">
									<label class="control-label required">Tổng tiền </label>
									<div class="controls">
										<html:text property="totalPrice" styleClass="form-control" />
									</div>
								</div>
								<div class="control-group">
								<label class="control-label required">Thanh Toán: </label>
								<div class="controls">
									<html:checkbox property="status" styleClass="form-control"></html:checkbox>
								</div>
								</div>
								<div class="control-group">
								<label class="control-label required">Xác Nhận: </label>
								<div class="controls">
									<html:checkbox property="confirm" styleClass="form-control"></html:checkbox>
								</div>
								</div>
								<div class="control-group">
								<label class="control-label required">Ngày Tạo </label>
								<div class="controls">
									<input type="date" name="createdday" class="form-control"
										value='<bean:write name="orderForm" property="createdday" />' max="9999-12-31" required />
								</div>
							</div>
								<div class="form-actions">
									<html:submit value="Lưu" styleClass="btn btn-primary btn-large"></html:submit>
									
									<logic:equal name="orderForm" property="orderId" value="0">
										<html:hidden property="btnUpdate" value="add" />
									</logic:equal>
									<logic:notEqual name="orderForm" property="orderId" value="0">
										<html:hidden property="btnUpdate" value="edit" />
									</logic:notEqual>
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
		$("input").attr("readonly", true);
		$('input[type="checkbox"]').attr("readonly", false);
	</script>
</body>
</html>