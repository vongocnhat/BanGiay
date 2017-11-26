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
				<div class="panel panel-default">
					<div class="panel-heading">
						<i class="fa fa-table"></i>
						<h5>Danh Sách Phản Hồi</h5>
					</div>
					<div class="panel-body">
						<table class="table table-striped">
							<thead>
								<tr>
									<th>Id</th>
									<th>Nội Dung</th>
									<th>Người Phản Hồi</th>
									<th>Email</th>
									<th>Ngày Phản Hồi</th>
									<th>Sửa</th>
									<th>Xóa</th>
								</tr>
							</thead>
							<tbody>
								<logic:iterate name="feedBackForm" property="listFeedBack" id="feedBack">
									<tr class="gradeX">
										<td><bean:write name="feedBack" property="feedBackId" /></td>
										<td><bean:write name="feedBack" property="contentFeedBack" /></td>
										<td><bean:write name="feedBack" property="name" /></td>
										<td><bean:write name="feedBack" property="email" /></td>
										<td><bean:write name="feedBack" property="createdday" /></td>
										<bean:define id="feedBackId" name="feedBack" property="feedBackId"></bean:define>
										<td><html:link
												action="quanly/feedback/danhsach.do"
												styleClass="btn btn-info">Sửa</html:link></td>
										<td><html:link action="quanly/feedback/danhsach.do"
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

</script>
</body>
</html>