<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/font-awesome.min.css" rel="stylesheet">
<link href="css/prettyPhoto.css" rel="stylesheet">
<link href="css/price-range.css" rel="stylesheet">
<link href="css/animate.css" rel="stylesheet">
<link href="css/main.css" rel="stylesheet">
<link href="css/responsive.css" rel="stylesheet">
<script src="js/jquery-1.11.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<title>Trang Chủ</title>
</head>
<body>
	<!-- Header -->
	<jsp:include page="tieuDe.jsp" />
	<!-- /Header -->

	<!--slider-->
	<jsp:include page="slideAnh.jsp" />
	<!--/slider-->
	<section>
	<div class="container">
		<div class="row">
			<div class="col-sm-3">
				<div class="left-sidebar">
					<h2>Danh Mục Công Ty</h2>
					<!--category-productsr-->
					<div class="panel-group category-products" id="accordian">
						<logic:iterate id="cat" name="danhSachProductForm"
							property="listCategory">
						<logic:notEmpty name="cat" property="categoryParent">
				
							<div class="panel panel-default" style="border-color: #b34747;">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a href='?categoryId=<bean:write name="cat" property="categoryId"/>' style="display: block;" ><bean:write name="cat" property="categoryParent" /></a>
									</h4>
								</div>
							</div>
					
						</logic:notEmpty>
						</logic:iterate>
					</div>
					<!--/category-products-->

				</div>
			</div>

			<div class="col-sm-9 padding-right">
				<div class="features_items">
					<!--features_items-->
					<h2 class="title text-center">Sản phẩm xem nhiều</h2>
					<% int i = 0; %>
					<logic:iterate id="prov" name="danhSachProductForm"
						property="listProductNumberViewed">
						<%
							if (i % 4 == 0)
									out.print("<div class='col-sm-12'>");
						%>
						<div class="col-sm-3">
							<bean:define id="productId" name="prov" property="productId" />
							<bean:define id="categoryId" name="prov" property="categoryId" />
							<html:link
								action="/chi-tiet-san-pham?productId=${productId}&categoryId=${categoryId}">
								<div class="product-image-wrapper">
									<div class="single-products">
										<div class="productinfo text-center">
											<img
												src='images/product/<bean:write name="prov" property="image"/>'
												alt="" />
											<h2 class="formatPrice">
												<bean:write name="prov" property="price" />
												
											</h2>

											<p>
												<span class="glyphicon glyphicon-eye-open"></span>
												<bean:write name="prov" property="numberViewed" />
											</p>
											<p>
												<bean:write name="prov" property="productName" />
											</p>
											<html:link
												action="/chi-tiet-san-pham?productId=${productId}&categoryId=${categoryId}"
												styleClass="btn btn-default add-to-cart">
												<i class="fa fa-shopping-cart"></i>Xem Chi Tiết</html:link>
										</div>
									</div>
								</div>
							</html:link>
							<%
								if ((i + 1) % 4 == 0)
										out.print("</div>");
								i++;
							%>
						</div>
					</logic:iterate>
				</div>
				<!--features_items-->
			</div>
			<div class="col-sm-9 pull-right padding-right">
				<div class="features_items">
					<!--features_items-->
					<h2 class="title text-center">Sản phẩm mua nhiều</h2>
					<% i = 0; %>
					<logic:iterate id="pros" name="danhSachProductForm"
						property="listProductNumberSeller">
						<%
							if (i % 4 == 0)
									out.print("<div class='col-sm-12'>");
						%>
						<div class="col-sm-3">
							<bean:define id="productId" name="pros" property="productId" />
							<bean:define id="categoryId" name="pros" property="categoryId" />
							<html:link
								action="/chi-tiet-san-pham?productId=${productId}&categoryId=${categoryId}">
								<div class="product-image-wrapper">
									<div class="single-products">
										<div class="productinfo text-center">
											<img
												src='images/product/<bean:write name="pros" property="image"/>'
												alt="" />
											<h2 class="formatPrice">
												<bean:write name="pros" property="price" />
												
											</h2>

											<p>
												<span class="glyphicon glyphicon-eye-open"></span>
												<bean:write name="pros" property="numberViewed" />
											</p>
											<p>
												<bean:write name="pros" property="productName" />
											</p>
											<html:link
												action="/chi-tiet-san-pham?productId=${productId}&categoryId=${categoryId}"
												styleClass="btn btn-default add-to-cart">
												<i class="fa fa-shopping-cart"></i>Xem Chi Tiết</html:link>
										</div>
									</div>
								</div>
							</html:link>
							<%
								if ((i + 1) % 4 == 0)
										out.print("</div>");
								i++;
							%>
						</div>
					</logic:iterate>
				</div>
				<!--features_items-->
			</div>
			<div class="col-sm-9 pull-right padding-right">
				<div class="features_items">
					<!--features_items-->
					<h2 class="title text-center">Các sản phẩm</h2>
					<div class="row" style="padding-bottom: 10px; margin-left: 0px;">
						<div class="toolbox col-sm-12">
<!-- 							Số lượng sản phẩm: -->
<!-- 							<select id="numpage"> -->
<!-- 								<option>16</option> -->
<!-- 								<option>48</option> -->
<!-- 								<option>All</option> -->
<!-- 							</select>  -->
							Sắp Xếp: <a href="" class="priceSort" title="Giá Tăng Dần">Giá <i class="fa fa-arrow-up" aria-hidden="true" title="Giá Tăng Dần"></i></a>
						</div>
					</div>
					<% i = 0; %>
					<div id="cacSanPham">
					<logic:iterate id="pro" name="danhSachProductForm"
						property="listProduct">
						<%
							if (i % 4 == 0)
									out.print("<div class='col-sm-12'>");
						%>
						<div class="col-sm-3">
							<bean:define id="productId" name="pro" property="productId" />
							<bean:define id="categoryId" name="pro" property="categoryId" />
							<html:link
								action="/chi-tiet-san-pham?productId=${productId}&categoryId=${categoryId}">
								<div class="product-image-wrapper">
									<div class="single-products">
										<div class="productinfo text-center">
											<img
												src='images/product/<bean:write name="pro" property="image"/>'
												alt="" />
											<h2 class="formatPrice">
												<bean:write name="pro" property="price" />
												
											</h2>

											<p>
												<span class="glyphicon glyphicon-eye-open"></span>
												<bean:write name="pro" property="numberViewed" />
											</p>
											<p>
												<bean:write name="pro" property="productName" />
											</p>
											<html:link
												action="/chi-tiet-san-pham?productId=${productId}&categoryId=${categoryId}"
												styleClass="btn btn-default add-to-cart">
												<i class="fa fa-shopping-cart"></i>Xem Chi Tiết</html:link>
										</div>
									</div>
								</div>
							</html:link>
							<%
								if ((i + 1) % 4 == 0)
										out.print("</div>");
								i++;
							%>
						</div>
					</logic:iterate>
					</div>
				</div>
			</div>

		</div>
	</div>
	</section>
	<!-- Footer -->
	<jsp:include page="cuoiTrang.jsp" />
	<!--/Footer-->
	<script type="text/javascript">
	    <%String s = (String) request.getAttribute("order");%>
		    	$("[name='orderProduct']").val('<%=s%>');
	</script>
	<script>
		var vitriajaxhientai;
		function ajaxHTML(url, vitri) {
		    $.ajax({
		      url: url,  
		      success: function(data) {
		         $(vitri).html(data);
		      }
		   });
		    vitriajaxhientai = vitri;
		}
		$( document ).ajaxComplete(function() {
			formatPriceAll(vitriajaxhientai);
		});
		
		$(".priceSort").click(function(e){
			e.preventDefault();
			var sortType = $(this).attr("title").indexOf("Tăng Dần");
			var url;
			var vitri = $("#cacSanPham");
			if(sortType > 0)
			{
				$(this).attr("title", "Giá Giảm Dần");
				$(this).find("i").removeClass("fa-arrow-up");
				$(this).find("i").addClass("fa-arrow-down");
				url = "ajaxProduct.do?column=Price&sortType=DESC";
				ajaxHTML(url, vitri);
			}
			else
			{	
				$(this).attr("title", "Giá Tăng Dần");
				$(this).find("i").removeClass("fa-arrow-down");
				$(this).find("i").addClass("fa-arrow-up");
				url = "ajaxProduct.do?column=Price&sortType=ASC";
				ajaxHTML(url, vitri);
			}
				
		});
	</script>
</body>
</html>