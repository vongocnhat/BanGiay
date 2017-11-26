<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
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
<title>Tìm Kiếm Sản Phẩm</title>
</head>
<body>
<!-- Header -->
<jsp:include page="tieuDe.jsp"/>
<!-- /Header -->
<!-- 	<div class="row" style="padding-bottom: 10px; margin-left: 0px;"> -->
<!-- 		<div class="toolbox col-sm-12"> -->
<!-- 			Sắp Xếp: <a href="" class="priceSort" title="Giá Tăng Dần">Giá <i class="fa fa-arrow-up" aria-hidden="true" title="Giá Tăng Dần"></i></a> -->
<!-- 		</div> -->
<!-- 	</div> -->
	<section>
		<div class="container">
			<div class="row">
				<div class="col-sm-12">
					<div class="features_items"><!--features_items-->
						<h2 class="title text-center"><bean:write name='danhSachProductForm' property="stringSearch"/> </h2>
							<logic:iterate id="proSearch" name="danhSachProductForm" property="listProduct">
								<bean:define id="productId" name="proSearch" property="productId"></bean:define>
								<bean:define id="categoryId" name="proSearch" property="categoryId"></bean:define>
								<html:link action="/chi-tiet-san-pham?productId=${productId}&categoryId=${categoryId}">
								<div id ="cacSanPham">
								<div class="col-sm-3">
									<div class="product-image-wrapper">
										<div class="single-products">
											<div class="productinfo text-center">
												<img src='images/product/<bean:write name="proSearch" property="image"/>'/>
												<h2 class="formatPrice"><bean:write name="proSearch" property="price"/> </h2>
												<p>
												<span class="glyphicon glyphicon-eye-open"></span>
												<bean:write name="proSearch" property="numberViewed" />
												</p>
												<p><bean:write name="proSearch" property="productName"/></p>
												<html:link action="/chi-tiet-san-pham?productId=${productId}&categoryId=${categoryId}" styleClass="btn btn-default add-to-cart">
												<i class="fa fa-shopping-cart"></i>Xem Chi Tiết
												</html:link>
<!-- 												dungnvdelai -->
												<logic:equal name="danhSachProductForm" property="submit" value="submitYeuThich">
													<form action="xoa-danh-sach-yeu-thich.do" method="get" class="formXoaDanhSachYeuThich">
														<input type="hidden" name="productId" value="${productId}" />
														<html:submit styleClass="btn btn-xs btn-danger" style="float: right"> Xóa</html:submit>
													</form>
												</logic:equal>
<!-- 												dungnv end -->
											</div>
										</div>
									</div>
								</div>
							</div>
							</html:link>
						</logic:iterate>
					</div><!--features_items-->
					
				</div>
			</div>
		</div>
	</section>
	<!-- Footer -->
	<jsp:include page="cuoiTrang.jsp"/>
	<!--/Footer-->
	
	<script type="text/javascript">
// 	dungnv delai
	$(".formXoaDanhSachYeuThich").submit(function(e) {
		e.preventDefault();
			var productId = $(this).find(
					"input[name='productId']").val();
			var url = "xoa-danh-sach-yeu-thich.do?"
					+ "productId=" + productId ;
			$.ajax({
				url : url
			})
			location.reload();
		});
		//ket thuc 
	</script>
	<script>
		function ajaxHTML(url, vitri) {
		    $.ajax({
		      url: url,  
		      success: function(data) {
		    	  console.log(url);
		         $(vitri).html(data);
		      }
		   });
		}
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
				url = "ajaxProduct.do?column=price&sortType=DESC";
				ajaxHTML(url, vitri);
			}
			else
			{	
				$(this).attr("title", "Giá Tăng Dần");
				$(this).find("i").removeClass("fa-arrow-down");
				$(this).find("i").addClass("fa-arrow-up");
				url = "ajaxProduct.do?column=price&sortType=ASC";
				ajaxHTML(url, vitri);
			}
				
		});
	</script>
</body>
</html>