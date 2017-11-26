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
					<html:link href="quanly/category/capnhat.do?btnUpdate=addView"
						styleClass="btn btn-primary">Thêm Danh Mục</html:link>
					<div class="panel panel-default">
						<div class="panel-heading">
							<i class="fa fa-table"></i>
							<h5>Danh Sách Danh Mục Sản Phẩm</h5>
						</div>
						<div class="panel-body">
							<table class="table table-striped">
								<thead>
									<tr>
										<th>Mã Danh Mục</th>
										<th>Tên Danh Mục Cha</th>
										<th>Tên Danh Mục</th>
										<th>Sửa</th>
										<th>Xóa</th>
										
									</tr>
								</thead>
								<tbody>
									<logic:iterate name="categoryForm" property="listCategory"
										id="category">
										<tr class="gradeX">
											<td><bean:write name="category" property="categoryId" /></td>
											<td><bean:write name="category" property="categoryParent" /></td>
											<td><bean:write name="category" property="categoryName" /></td>

											<bean:define id="categoryId" name="category" property="categoryId"></bean:define>
											<td><html:link
													action="quanly/category/capnhat?categoryId=${categoryId}&btnUpdate=updateView"
													styleClass="btn btn-info">Sửa</html:link></td>
											<td><html:link
													action="quanly/category/capnhat?categoryId=${categoryId}&btnUpdate=delete"
													styleClass="btn btn-danger btnDelete" >Xóa</html:link>
													<input type="hidden" value="${categoryId}" id='categoryId'/>
											</td>
											
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
 	<script type="text/javascript">
			var categoryId = document.getElementById("categoryId");
			var url;
			categoryId.onchange = function() {
				url = "quanly/category/danhsach.do?categoryId=" +categoryId.value;
				window.location = url;
			}
			$(".btnDelete").click(function(){
				var category = $(this).parent().siblings("td:first").text();
				return confirm("Bạn Muốn Xóa Danh Mục: "+ category +" Này Không ?");
			});
 	</script>
</body>
</html>