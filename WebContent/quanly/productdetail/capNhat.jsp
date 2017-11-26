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
							<h5>Cập Nhật Chi Tiết Sản Phẩm</h5>
						</div>
						<div class="panel-body">
							<html:form action="quanly/productdetail/capnhat" method="post" styleClass="form-horizontal">
								<div class="control-group">
									<label class="control-label required">Mã Chi Tiết Sản Phẩm: </label>
									<div class="controls">
										<html:text property="productDetailId" styleClass="form-control" readonly="true"></html:text>
									</div>
								</div>
								<div class="control-group">
									<label class="control-label required">Mã Sản Phẩm: </label>
									<div class="controls">
										<html:text property="productId" styleClass="form-control" readonly="true" />
									</div>
								</div>
								<div class="control-group">
									<label class="control-label required">Ảnh: </label>
									<div class="controls">
										<html:file property="image" styleClass="form-control" accept="image/*" />
									</div>
								</div>
								<div class="control-group">
									<label class="control-label required">Ảnh 2: </label>
									<div class="controls">
										<html:file property="image2" styleClass="form-control" accept="image/*" />
									</div>
								</div>
								<div class="control-group">
									<label class="control-label required">Ảnh 3: </label>
									<div class="controls">
										<html:file property="image3" styleClass="form-control" accept="image/*" />
									</div>
								</div>
								<div class="control-group">
									<label class="control-label required">Màu: </label>
									<div class="controls">
										<html:text property="color" styleClass="form-control" />
									</div>
								</div>

								<div class="form-actions">
									<html:submit value="Lưu" styleClass="btn btn-primary btn-large"></html:submit>
									<html:hidden property="btnUpdate" value="btnUpdate" />
									<button class="btn btn-danger" onclick="history.go(-1);">Quay lại</button>
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