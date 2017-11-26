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
					<html:link href="quanly/productdetail/capnhat.do?btnUpdate=addView"
						styleClass="btn btn-primary">Thêm chi tiết Sản Phẩm</html:link>
					<div class="panel panel-default">
						<div class="panel-heading">
							<i class="fa fa-table"></i>
							<h5>Chi Tiết Sản Phẩm</h5>
						</div>
						<div class="panel-body">
							<table class="table table-striped">
								<thead>
									<tr>
										<th>Tên Sản Phẩm</th>
										<th>Mã Chi Tiết Sản Phẩm</th>
										<th>Hình Ảnh</th>
										<th>Hình Ảnh2</th>
										<th>Hình Ảnh 3</th>
										<th>Màu</th>
										<th>Sửa</th>
										<th>Xóa</th>
									</tr>
								</thead>
								<tbody>
									<logic:iterate id="productDetail" name="productDetailForm" property="listProductDetail">
										<tr>
											<bean:define id="productId" name="productDetail" property="productId"></bean:define>
											<td><bean:write name="productDetail" property="productName"/></td>
											<td><bean:write name="productDetail" property="productDetailId"/></td>
											<td>
												<img alt="" src='images/product/<bean:write name="productDetail" property="image"/>'
													style=" width: 50px;height: 50px;"/>
											</td>
											<td>
												<img alt="" src='images/product/<bean:write name="productDetail" property="image2"/>'
													style=" width: 50px;height: 50px;"/>
											</td>
											<td>
												<img alt="" src='images/product/<bean:write name="productDetail" property="image3"/>'
													style=" width: 50px;height: 50px;"/>
											</td>	
											<td><bean:write name="productDetail" property="color"/></td>
											<td><a href="/BanGiay/quanly/productdetail/capnhat.do?productId=${productId}" class="btn btn-info">Sửa</a></td>
											
											<td><a href="/BanGiay/quanly/productdetail/xoa.do?productId=${productId}" class="btn btn-danger">Xóa</a></td>
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