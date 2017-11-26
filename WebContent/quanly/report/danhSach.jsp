<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/struts.jsp"%>
<%@page import="common.StringProcess"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/quanly/layout/head.jsp"></jsp:include>
<link rel="stylesheet" type="text/css"
	href="admin_assets/calendar/css/datepicker.min.css">
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
							<h5>Thống Kê</h5>
						</div>
						<div class="panel-body">
							<html:form action="quanly/report/danhsach" method="post"
								styleClass="form-horizontal" styleId="formAjaxReport">
								<div class="control-group">
									<label class="control-label required">Từ Ngày: </label>
									<div class="controls">
										<input type="date" name="from" class="form-control no-spin"
											max="9999-12-31" required value='<bean:write name="reportForm" property="from"/>' />
									</div>
								</div>
								<div class="control-group">
									<label class="control-label required">Đến Ngày: </label>
									<div class="controls">
										<input type="date" name="to" class="form-control no-spin"
											max="9999-12-31" required value='<bean:write name="reportForm" property="to"/>' />
									</div>
								</div>
								<div class="control-group">
									<label class="control-label required">Gộp Nhóm Theo: </label>
									<div class="controls">
										<html:select property="groupBy" styleClass="form-control" value='<bean:write name="reportForm" property="groupBy"/>'>
											<html:option value="month">Tháng</html:option>
											<html:option value="year">Năm</html:option>
										</html:select>
									</div>
								</div>
								<div class="control-group">
									<label class="control-label required">Kết Quả: </label>
									<div class="controls">
										<html:submit value="Xem"
											styleClass="btn btn-primary btn-large btnSubmit"></html:submit>
									</div>
								</div>

							</html:form>
							<table class="table table-striped">
								<thead>
									<tr>
										<th>Năm</th>
										<th>Tháng</th>
										<th>Số Lượng Bán</th>
										<th>Số Tiền Bán</th>
									</tr>
								</thead>
								<tbody id="ajaxReport">
									<logic:iterate name="reportForm" property="listReport"
										id="report">
										<tr class="gradeX">
											<td><bean:write name="report" property="year" /></td>
											<td><bean:write name="report" property="month" /></td>
											<td><bean:write name="report" property="totalQuantity" /></td>
											<td class="formatPrice"><bean:write name="report" property="totalPrice" />
												</td>
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
	<script type="text/javascript"
		src="admin_assets/calendar/js/datepicker.min.js"></script>
	<script type="text/javascript"
		src="admin_assets/calendar/js/datepicker.en.js"></script>
	<script>
		$(document).ready(function() {
			$('input[type="date"]').datepicker({
				language : 'en',
				dateFormat : 'yyyy-mm-dd',
				todayButton : new Date(),
				clearButton : true,
				autoClose : true,
			});
			if ($("#ajaxReport").html().search("gradeX") == -1)
				$("#ajaxReport").html('<tr><td colspan="4"><h3 class="required">Không Có Sản Phẩm Nào Được Bán Trong Ngày Này</td></tr></h3>');
			formatPriceAll("#ajaxReport");
		});
	</script>
</body>
</html>