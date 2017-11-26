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
<title>Chi Tiết Sản Phẩm</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/font-awesome.min.css" rel="stylesheet">
<link href="css/prettyPhoto.css" rel="stylesheet">
<link href="css/price-range.css" rel="stylesheet">
<link href="css/animate.css" rel="stylesheet">
<link href="css/main.css" rel="stylesheet">
<link href="css/slider/main.css" rel="stylesheet">
<link href="css/responsive.css" rel="stylesheet">
<script src="js/jquery-1.11.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<style type="text/css">
.colorpromotion {
	background: navajowhite;
}
.activeColor{
	outline: 2px solid #000;
}
</style>
</head>
<body>
	<jsp:include page="tieuDe.jsp" />
	<div class="container">
		<div class="row">
			

			<div class="col-sm-12">
				<div class="product-details">
					<!--product-details-->
					<div class="col-sm-5">
						<div class="view-product">
							<div id="bigPic">
								<bean:define id="pro" name="danhSachProductForm" property="product" />
							<logic:iterate id="productDetail" name="danhSachProductForm" property="listProductDetail">
								<img id='image<bean:write name="productDetail" property="productDetailId" />' src="images/product/<bean:write name="productDetail" property="image" />" height="300px" />
								<img src="images/product/<bean:write name="productDetail" property="image2" />" height="300px" />
								<img src="images/product/<bean:write name="productDetail" property="image3" />" height="300px" />
							</logic:iterate>
							</div>
						</div>
						<div id="similar-product" class="carousel slide"
							data-ride="carousel">

							<!-- Wrapper for slides -->
							<div class="carousel-inner">
								<div class="item active">
									<ul id="thumbs">
									<% int i = 1; %>
									<logic:iterate id="productDetail" name="danhSachProductForm" property="listProductDetail">
										<li class='active' rel='<%= i %>'>
											<img src="images/product/<bean:write name="productDetail" property="image" />" alt="" />
										</li>
										<li rel='<%= i+1 %>'>
											<img src="images/product/<bean:write name="productDetail" property="image2" />" alt="" />
										</li>
										<li rel='<%= i+2 %>'>
											<img src="images/product/<bean:write name="productDetail" property="image3" />" alt="" />
										</li>
										<% i+=3; %>
									</logic:iterate>
									</ul>
								</div>
							</div>
						</div>

					</div>
					<div class="col-sm-7">

						<!--/product-information-->
						<div class="product-information">
							<p class="newarrival">

							</p>
							<h2 id="name">
								<bean:write name="pro" property="productName" />
							</h2>
							<p>
								Mã Sản Phẩm: <bean:write name="pro" property="productId" />
							</p>
							<img src="images/product-details/rating.png" alt="" />
							<p>
								Giá: <span id="price" class="formatPrice"><bean:write name="pro" property="price" />
									 </span>
							</p>
							<p>
								<span> Số lượng: 
								<input type="button" onclick="cong()" value="+">
								<input type="text" value="1" id="quantity" /> 
								<input type="button" onclick="tru()" value="-" />
								</span>
							</p>
							<p>
								<b>Loại giày: </b>
								<bean:define id="itemCategory" name="danhSachProductForm" property="category"></bean:define>
								<bean:write name="itemCategory" property="categoryName" />
							</p>
<!-- 							<p> -->
						<form id="formAddToCart">
								<b>Màu: </b>
								<ul>
									<logic:iterate name="danhSachProductForm" property="listProductDetail" id="productDetail">
										<li class="color" style="width: auto; position: relative; float: left; margin-left: 5px;">
											<p style="z-index: 1; color: black; text-align: center; line-height: 40px; padding: 0 5px; background-color: #ddd; margin: 0;"><bean:write name="productDetail" property="color" /></p>
<input type="radio" class="productDetailId" name="productDetailId" value='<bean:write name="productDetail" property="productDetailId"/>' style="opacity: 0; position: absolute; top: 0; right: 0; bottom: 0; left: 0; width: 100%; height: 40px; margin: 0; cursor: pointer;" required />
										</li>
									</logic:iterate>
								</ul>
<!-- 							</p> -->
							<p style="clear: both;">
								<b>Nhãn hiệu: </b>
								<bean:write name="itemCategory" property="categoryParent" />
							</p>
							<p>
								<b>Size: </b>
								<logic:iterate id="productDetail" name="danhSachProductForm" property="listProductDetail">
			  						<select id='productDetailId<bean:write name="productDetail" property="productDetailId" />' name="size" class="size" style="display: none">
				  						<option value="">Chọn Size</option>
				  						<logic:iterate id="productDetailSQ" name="productDetail" property="listProductDetailSQ">
				  							<option value='<bean:write name="productDetailSQ" property="productDetailSQId" />'><bean:write name="productDetailSQ" property="size" /></option>
				  						</logic:iterate>
				  					</select>
			  					</logic:iterate>
							</p>
							<p>
								<span>
									<button type="submit" name="submit" class="btn btn-fefault cart">
										<i class="fa fa-shopping-cart"></i> Thêm vào giỏ hàng
									</button>
								</span>
								
							</p>
							
						</form>
						<logic:notEmpty name="danhSachProductForm" property="userName">
								<span>
									<bean:define id="proId" name="pro" property="productId" />
									<form action="yeu-thich-san-pham.do" method="get" class="formYeuThichSanPham">
										<input type="hidden" name="userName" value="<bean:write name="danhSachProductForm" property="userName" />" />
										<input type="hidden" name="productId" value="${proId}" />
									<button type="submit" class="btn btn-danger">
										<i class="glyphicon glyphicon-heart"></i> Yêu thích
									</button>
									</form>
								</span>
						</logic:notEmpty>
							<a href=""><img src="images/product-details/share.png"
								class="share img-responsive" alt="" /></a>
						</div>
						<!--/product-information-->
					</div>
				</div>
				<!--/product-details-->
				<div class="category-tab shop-details-tab">
					<!--category-tab-->
					<div class="col-sm-12">
						<ul class="nav nav-tabs">
							<li><a href="#details" data-toggle="tab">Thông
									Tin</a></li>
							<li class="active"><a href="#companyprofile" data-toggle="tab" aria-expanded="true">Sản phẩm
									cùng loại</a></li>
							<li><a href="#tag" data-toggle="tab">Thông tin khuyến
									mãi</a></li>
						</ul>
					</div>
					<div class="tab-content">
						<div class="tab-pane fade active in" id="details">
							<bean:write name="pro" property="description" />
						</div>

						<div class="tab-pane fade active in" id="companyprofile">
<!-- 							liên quan -->
							<div class="col-sm-12">
							<logic:iterate id="listPro" property="listProduct" name="danhSachProductForm">
							
								<div class="col-sm-3">
								<bean:define id="productId" name="listPro" property="productId" />
								<bean:define id="categoryId" name="listPro" property="categoryId" />
								<html:link action="/chi-tiet-san-pham?productId=${productId}&categoryId=${categoryId}">
									<div class="product-image-wrapper">
										<div class="single-products">
											<div class="productinfo text-center">
												<img alt=""
													src="images/product/<bean:write name="listPro" property="image"/>">
												<h2 class="formatPrice">
													<bean:write name="listPro" property="price" />
													
												</h2>
												<p>
													<a href="#"> <bean:write name="listPro"	property="productName" />
													</a>
												</p>
												<p>
													<span class="glyphicon glyphicon-eye-open"></span>
													<bean:write name="listPro" property="numberViewed" />
												</p>
												<html:link action="/chi-tiet-san-pham?productId=${productId}&categoryId=${categoryId}" styleId="btnAddToCartMore" styleClass="btn btn-default add-to-cart">
													<i class="fa fa-shopping-cart"></i>Thêm vào giỏ hàng
												</html:link>
											</div>
										</div>
									</div>
								</html:link>
								</div>
							</logic:iterate>
							</div>
						</div>

						<div class="tab-pane fade" id="tag">
						
							<logic:iterate id="promotion" name="danhSachProductForm" property="listPromotion">
								<ul>
									<li class="colorpromotion"><b>Giảm giá: </b> <bean:write
											name="promotion" property="discount" /> %</li>
									<li class="colorpromotion"><b>Thời gian: </b>Từ <bean:write
											name="promotion" property="mfgDate" /> Đến </b> <bean:write name="promotion"
											property="expDate" /></li>
									<logic:iterate id="accessories" name="promotion" property="listAccessories">
										<li class="colorpromotion"><b>------Phụ kiện------</b></li>
										<li class="colorpromotion"><b>Tên phụ kiện: </b> <bean:write
												name="accessories" property="accessoriesName" /></li>
										<li class="colorpromotion formatPrice"><b>Giá phụ kiện: </b> <bean:write
												name="accessories" property="price" /> </li>
										<li class="colorpromotion"><b>Size phụ kiện: </b> <bean:write
												name="accessories" property="size" /></li>
										<li class="colorpromotion"><b>Số Lượng phụ kiện: </b> <bean:write
												name="accessories" property="quantity" /></li>
										<li class="colorpromotion"><b>Hình ảnh phụ kiện: </b> <bean:write
												name="accessories" property="image" /></li>
										<li class="colorpromotion"><b>Màu phụ kiện: </b> <bean:write
												name="accessories" property="color" /></li>
										<li class="colorpromotion"><b>Mô tả phụ kiện: </b> <bean:write
												name="accessories" property="description" /></li>
									</logic:iterate>
								</ul>
							</logic:iterate>		
						</div>
					</div>
				</div>
				<!--/category-tab-->

				<div class="recommended_items">
					<!--recommended_items-->
					<h2 class="title text-center">Đánh giá sản phẩm</h2>
					<div class="col-md-12">


						<section class="comment-list">
						<div class="panel-body">
						<logic:notEmpty name="danhSachProductForm" property="userName">
							<bean:define id="uname" name="danhSachProductForm" property="userName"></bean:define>
							<article class="row">
							<div class="col-md-2 col-sm-2 hidden-xs"></div>
							<div class="col-md-10 col-sm-10">
								<div class="panel panel-default arrow left">
									<div class="panel-body">
										<header class="text-left">
										<div class="comment-user">
											<i class="fa fa-user"></i> <bean:write name="danhSachProductForm" property="userName" />
										</div>
										<p class="text-right">
										<form action="binh-luan-san-pham.do" method="get"
											class="formBinhLuan">
											<input type="hidden" name="commentIdParent" value="NULL" />
											<input type="hidden" name="levelCmt" value="1" /> <input
												type="hidden" name="productId" value="${proId}" /> <input
												type="hidden" name="userName" value="${uname}" />
											<textarea name="contentConmment" id="message"
												required="required" class="form-control" rows="3"
												placeholder="Nội dung bình luận..."></textarea>
											<html:submit styleClass="btn btn-primary"
												styleId="btnBinhLuan" style="float: right"> Bình luận</html:submit>
											
										</form>
										</p>
									</div>
								</div>
							</div>
							</article>
							</logic:notEmpty>


							<logic:iterate id="listCmt" property="listCommentProduct"
								name="danhSachProductForm">
								<logic:equal name="listCmt" property="levelCmt" value="1">

									<!-- First Comment -->
									<article class="row">
									<div class="col-md-2 col-sm-2 hidden-xs"></div>
									<div class="col-md-10 col-sm-10">
										<div class="panel panel-default arrow left">
											<div class="panel-body">
												<header class="text-left">
												<div class="comment-user">
													
													<logic:notEmpty name="danhSachProductForm" property="userName">
	<!-- 											Xoa binh luan -->
														<bean:define id="uname1" name="danhSachProductForm" property="userName"></bean:define>
														<logic:equal name="listCmt" property="userName" value="${uname}">
														<form action="xoa-binh-luan-san-pham.do" method="get" class="formXoaBinhLuan">
															<input type="hidden" name="commentId" value="<bean:write name="listCmt" property="commentId" />" />
															<html:submit styleClass="btn btn-xs btn-danger" styleId="btnXoaBinhLuan" 
															style="float: right"> Xóa</html:submit>
														</form>
	<!-- 											Ket thuc xoa binh luan -->
														<button Class="btn btn-xs btn-warning btnSuaBinhLuan"  style="float: right; margin-right:10px"> Sửa</button>
														</logic:equal>
														<button Class="btn btn-xs btn-warning btnTraLoi" style="float: right; margin-right:10px"> Trả lời</button>
													</logic:notEmpty>	
													<i class="fa fa-user"></i> <bean:write name="listCmt" property="userName" />
												</div>
												<time class="comment-date" datetime="16-12-2014 01:05">
												<i class="fa fa-clock-o"></i> <bean:write name="listCmt"
													property="createdDay" /></time> </header>
												<div class="comment-post">
													<p><bean:write name="listCmt" property="contentConmment" /></p>
												</div>
												
												<p class="text-right">
<!-- 												Binh luan san pham -->
												<form action="binh-luan-san-pham.do" method="get"
													class="formBinhLuan hideFormBinhLuan">
													<input type="hidden" name="commentIdParent"
														value="<bean:write name="listCmt" property="commentId" />" />
													<input type="hidden" name="levelCmt" value="2" /> <input
														type="hidden" name="productId"
														value="<bean:write name="listCmt" property="productId" />" />
													<logic:notEmpty name="danhSachProductForm" property="userName">
														<bean:define id="uname1" name="danhSachProductForm" property="userName"></bean:define>
														<input type="hidden" name="userName" value="${uname1}" />
													</logic:notEmpty>
													<textarea name="contentConmment" id="message"
														required="required" class="form-control message" rows="2"
														placeholder="Nội dung bình luận..."></textarea>
													<html:submit styleClass="btn btn-sm btn-primary" style="float: right"> Trả lời</html:submit>
													<html:hidden property="submit" value="submit" />
												</form>
<!-- 												Ket thuc ghi binh luan -->
<!-- 												Sua binh luan -->
												<form action="sua-binh-luan-san-pham.do" method="get"
													class="formSuaBinhLuan hideFormSuaBinhLuan">
													<input type="hidden" name="commentId" value="<bean:write name="listCmt" property="commentId" />" />
													<textarea name="contentConmment" id="message"
														required="required" class="form-control message" rows="2" ></textarea>
													<html:submit styleClass="btn btn-sm btn-primary" style="float: right"> Lưu</html:submit>
												</form>
<!-- 												ket thuc Sua binh luan -->
												</p>
												
											</div>
										</div>
									</div>
									</article>

								</logic:equal>
								<!-- 				Lop thu 2 -->
								<logic:equal name="listCmt" property="levelCmt" value="2">
									<!-- Second Comment Reply -->
									<article class="row">
									<div
										class="col-md-2 col-sm-2 col-md-offset-1 col-sm-offset-0 hidden-xs">
									</div>
									<div class="col-md-9 col-sm-9">
										<div class="panel panel-default arrow left">
											<div class="panel-heading right" style="padding : 0px 15px">Trả lời</div>
											<div class="panel-body">
												<header class="text-left">
												<div class="comment-user">

													<logic:notEmpty name="danhSachProductForm" property="userName">
	<!-- 											Xoa binh luan -->
														<bean:define id="uname1" name="danhSachProductForm" property="userName"></bean:define>
														<logic:equal name="listCmt" property="userName" value="${uname1}">
														<form action="xoa-binh-luan-san-pham.do" method="get" class="formXoaBinhLuan">
															<input type="hidden" name="commentId" value="<bean:write name="listCmt" property="commentId" />" />
															<html:submit styleClass="btn btn-xs btn-danger" styleId="btnXoaBinhLuan" 
															style="float: right"> Xóa</html:submit>
														</form>
	<!-- 											Ket thuc xoa binh luan -->
														<button Class="btn btn-xs btn-warning btnSuaBinhLuan"  style="float: right; margin-right:10px"> Sửa</button>
														</logic:equal>
														<button Class="btn btn-xs btn-warning btnTraLoi" style="float: right; margin-right:10px"> Trả lời</button>
													</logic:notEmpty>	
													<i class="fa fa-user"></i> <bean:write name="listCmt" property="userName" />
												</div>
												<time class="comment-date" datetime="16-12-2014 01:05">
												<i class="fa fa-clock-o"></i> <bean:write name="listCmt"
													property="createdDay" /></time> </header>
												<div class="comment-post">
													<p><bean:write name="listCmt" property="contentConmment" />
</p>
												</div>
												<p class="text-right">
												<form action="binh-luan-san-pham.do" method="get"
													class="formBinhLuan hideFormBinhLuan">
													<input type="hidden" name="commentIdParent"
														value="<bean:write name="listCmt" property="commentId" />" />
													<input type="hidden" name="levelCmt" value="3" /> <input
														type="hidden" name="productId"
														value="<bean:write name="listCmt" property="productId" />" />
													<logic:notEmpty name="danhSachProductForm" property="userName">
														<bean:define id="uname1" name="danhSachProductForm" property="userName"></bean:define>
														<input type="hidden" name="userName" value="${uname1}" />
													</logic:notEmpty>
													<textarea name="contentConmment" id="message"
														required="required" class="form-control message" rows="2"
														placeholder="Nội dung bình luận..."></textarea>
													<html:submit styleClass="btn btn-sm btn-primary" style="float: right"> Trả lời</html:submit>
													<html:hidden property="submit" value="submit" />
												</form>
<!-- 												Ket thuc ghi binh luan -->
<!-- 												Sua binh luan -->
												<form action="sua-binh-luan-san-pham.do" method="get"
													class="formSuaBinhLuan hideFormSuaBinhLuan">
													<input type="hidden" name="commentId" value="<bean:write name="listCmt" property="commentId" />" />
													<textarea name="contentConmment" id="message"
														required="required" class="form-control message" rows="2" ></textarea>
													<html:submit styleClass="btn btn-sm btn-primary" style="float: right"> Lưu</html:submit>
												</form>
<!-- 												ket thuc Sua binh luan -->
												</p>
											</div>
										</div>
									</div>
									</article>
								</logic:equal>
								<!-- 				lop thu 3 -->
								<logic:equal name="listCmt" property="levelCmt" value="3">
									<!-- Third Comment Reply -->
									<article class="row">
									<div
										class="col-md-2 col-sm-2 col-md-offset-3 col-sm-offset-0 hidden-xs">
									</div>
									<div class="col-md-7 col-sm-7">
										<div class="panel panel-default arrow left">
											<div class="panel-heading right" style="padding : 0px 15px">Trả lời</div>
											<div class="panel-body">
												<header class="text-left">
												<div class="comment-user">

													<logic:notEmpty name="danhSachProductForm" property="userName">
	<!-- 											Xoa binh luan -->
														<bean:define id="uname1" name="danhSachProductForm" property="userName"></bean:define>
														<logic:equal name="listCmt" property="userName" value="${uname1}">
														<form action="xoa-binh-luan-san-pham.do" method="get" class="formXoaBinhLuan">
															<input type="hidden" name="commentId" value="<bean:write name="listCmt" property="commentId" />" />
															<html:submit styleClass="btn btn-xs btn-danger" styleId="btnXoaBinhLuan" 
															style="float: right"> Xóa</html:submit>
														</form>
	<!-- 											Ket thuc xoa binh luan -->
														<button Class="btn btn-xs btn-warning btnSuaBinhLuan"  style="float: right; margin-right:10px"> Sửa</button>
														</logic:equal>
													</logic:notEmpty>	
													<i class="fa fa-user"></i> <bean:write name="listCmt" property="userName" />
												</div>
												<time class="comment-date" datetime="16-12-2014 01:05">
												<i class="fa fa-clock-o"></i> <bean:write name="listCmt"
													property="createdDay" /></time> </header>
												<div class="comment-post">
													<p><bean:write name="listCmt" property="contentConmment" /></p>
												</div>
												<p class="text-right">
<!-- 												Sua binh luan -->
												<form action="sua-binh-luan-san-pham.do" method="get"
													class="formSuaBinhLuan hideFormSuaBinhLuan">
													<input type="hidden" name="commentId" value="<bean:write name="listCmt" property="commentId" />" />
													<textarea name="contentConmment" id="message"
														required="required" class="form-control message" rows="2" ></textarea>
													<html:submit styleClass="btn btn-sm btn-primary" style="float: right"> Lưu</html:submit>
												</form>
<!-- 												ket thuc Sua binh luan -->
												</p>
											</div>
										</div>
									</div>
									</article>

								</logic:equal>
							</logic:iterate>
						</section>
					</div>


				</div>
				<!--/recommended_items-->
			</div>
		</div>
	</div>
	</section>
	<jsp:include page="cuoiTrang.jsp" />
	<script type="text/javascript">
		var i = 1;
		function cong() {

			document.getElementById('quantity').value = ++i;
		}
		function tru() {
			if (document.getElementById('quantity').value > 1) {
				document.getElementById('quantity').value = i--;
			}
		}
	</script>
	<script type="text/javascript">
	var currentImage;
    var currentIndex = -1;
    var interval;
    function showImage(index){
        if(index < $('#bigPic img').length){
        	var indexImage = $('#bigPic img')[index]
            if(currentImage){   
            	if(currentImage != indexImage ){
                    $(currentImage).css('z-index',2);
                    clearTimeout(myTimer);
                    $(currentImage).fadeOut(250, function() {
					    $(this).css({'display':'none','z-index':1,'height':300})
					});
                }
            }
            $(indexImage).css({'display':'block', 'opacity':1,'height':300});
            currentImage = indexImage;
            currentIndex = index;
            $('#thumbs li').removeClass('active');
            $($('#thumbs li')[index]).addClass('active');
        }
    }
    
    function showNext(){
        var len = $('#bigPic img').length;
        var next = currentIndex < (len-1) ? currentIndex + 1 : 0;
        showImage(next);
    }
    
    var myTimer;
    
    $(document).ready(function() {
		showNext(); //loads first image
        $('#thumbs li').bind('click',function(e){
        	var count = $(this).attr('rel');
        	showImage(parseInt(count)-1);
        });
	});
    //convert /uxxxx cách dùng "string".toUnicode();
    String.prototype.toUnicode = function(){
        var result = "";
        for(var i = 0; i < this.length; i++){
            // Assumption: all characters are < 0xffff
            result += "\\u" + ("000" + this[i].charCodeAt(0).toString(16)).substr(-4);
        }
        return result;
    };
  	//btnAddToCart click
  	$("#formAddToCart").submit(function(e){
  		e.preventDefault();
  		var name = $("#name").text();
		var color = $(".activeColor").find("p").text();
		//lấy size
		var productDetailId = $(".activeColor").find(".productDetailId").val();
  		var size = $("#productDetailId"+productDetailId+" option:selected").text();
  		var image = $("#image"+productDetailId).attr("src");
  		var price = unFormatPrice($("#price").text());
  		var quantity = $("#quantity").val();
  		//lấy productDetailSQId
  		var productDetailSQId = $(".size").val();
  		var url = "cap-nhat-gio-hang.do?productName="+name+"&size="+size+"&color="+color+"&image="+image+"&price="+price+"&quantity="+quantity+"&productDetailId="+productDetailId+"&productDetailSQId="+productDetailSQId+"&type=add";
  		$.ajax({
  	        url: url,
  	    });
  		alert("Thêm Hàng Vào Giỏ Thành Công");
  	});
  	//radioColor
  	$(".productDetailId").click(function(){
  		$(".color").removeClass("activeColor");
  		$(this).parent().addClass("activeColor");
  		var productDetailId = $(this).val();
//   		$(".size").css({"z-index":"-1"});
  		$(".size").hide();
  		$(".size").attr("required", false);
//   		$("#productDetailId"+productDetailId).css({"z-index":"0"});
		$("#productDetailId"+productDetailId).show();
  		$("#productDetailId"+productDetailId).attr("required", true);
  		$()
  	});
  	
  	//binh luan dung
  	$(".formBinhLuan").submit(function(e) {
			e.preventDefault();
			var commentIdParent = $(this).find(
					"input[name='commentIdParent']").val();
			var levelCmt = $(this).find(
					"input[name='levelCmt']").val();
			var productId = $(this).find(
					"input[name='productId']").val();
			var userName = $(this).find(
					"input[name='userName']").val();
			var contentConmment = $(this).find(
					"textarea[name='contentConmment']").val();
			var url = "binh-luan-san-pham.do?"
					+ "commentIdParent=" + commentIdParent
					+ "&levelCmt=" + levelCmt + "&productId="
					+ productId + "&userName=" + userName
					+ "&contentConmment=" + contentConmment;
			$.ajax({
				url : url
			});							
			location.reload();
		});
		$(".formSuaBinhLuan").submit(function(e) {
			e.preventDefault();
			var commentId = $(this).find(
					"input[name='commentId']").val();
			var contentConmment = $(this).find(
					"textarea[name='contentConmment']").val();
			var url = "sua-binh-luan-san-pham.do?"
					+ "commentId=" + commentId
					+ "&contentConmment=" + contentConmment;
			$.ajax({
				url : url
			});							
			location.reload();
		});
		$(".formXoaBinhLuan").submit(function(e) {
			e.preventDefault();
			var commentId = $(this).find(
					"input[name='commentId']").val();
			var url = "xoa-binh-luan-san-pham.do?"
					+ "commentId=" + commentId ;
			$.ajax({
				url : url
			})
			location.reload();
		});
		$(".hideFormBinhLuan").hide();
		$(".hideFormSuaBinhLuan").hide();
		$(".btnSuaBinhLuan").click(function(){
			$(this).parent().parent().siblings(".hideFormSuaBinhLuan").show();
			$(".hideFormBinhLuan").hide();
			var message = $(this).parent().parent().siblings(".comment-post").find("p").text();
			$(this).parent().parent().siblings(".formSuaBinhLuan").find(".message").text(message);
		});
		$(".btnTraLoi").click(function(){
			$(".hideFormSuaBinhLuan").hide();
			$(this).parent().parent().siblings(".hideFormBinhLuan").show();
		});
		$(".formYeuThichSanPham").submit(function(e) {
			e.preventDefault();
			var userName = $(this).find(
					"input[name='userName']").val();
			var productId = $(this).find(
					"input[name='productId']").val();
			var url = "yeu-thich-san-pham.do?"
					+ "userName=" + userName
					+ "&productId=" + productId;
			$.ajax({
				url : url
			})
			$(".formYeuThichSanPham").hide();
		});
		//ket thuc binh luan dung
	</script>
</body>
</html>