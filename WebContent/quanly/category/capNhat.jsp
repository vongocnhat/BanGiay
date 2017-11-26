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
							<h5>Danh Mục Sản Phẩm</h5>
						</div>
						<div class="panel-body">
							<html:form action="quanly/category/capnhat" method="post"
								styleClass="form-horizontal">
							<logic:notEqual name="categoryForm" property="categoryId" value="0">
								<div class="control-group">
									<label class="control-label required">Mã Danh Mục Sản Phẩm: </label>
									<div class="controls">
										<html:text property="categoryId" styleClass="form-control" readonly="true"></html:text>
									</div>
								</div>
							</logic:notEqual>
							<div class="control-group">
									<label class="control-label required">Tên Danh Mục Cha: </label>
									<div class="controls">
										<html:text property="categoryParent" styleClass="form-control" />
									</div>
								</div>
								<div class="control-group">
									<label class="control-label required">Tên Danh Mục: </label>
									<div class="controls">
										<html:text property="categoryName" styleClass="form-control" />
									</div>
								</div>
								
								<div class="form-actions">
									<html:submit value="Lưu" styleClass="btn btn-primary btn-large"></html:submit>
									
									<logic:equal name="categoryForm" property="categoryId" value="0">
										<html:hidden property="btnUpdate" value="add" />
									</logic:equal>
									<logic:notEqual name="categoryForm" property="categoryId" value="0">
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

</body>
</html>