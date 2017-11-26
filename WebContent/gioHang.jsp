<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/struts.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Giỏ Hàng Của Bạn</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/prettyPhoto.css" rel="stylesheet">
    <link href="css/price-range.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
	<link href="css/main.css" rel="stylesheet">
	<link href="css/responsive.css" rel="stylesheet">
<script src="js/jquery-1.11.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<body>
<!-- Header -->
<jsp:include page="tieuDe.jsp"/>
<!-- /Header -->

	<section id="cart_items">
		<div class="container">
			<div class="breadcrumbs">
				<ol class="breadcrumb">
			
				</ol>
			</div><!--/breadcrums-->

			
			<div class="review-payment">
				<h2>Giỏ Hàng Của Bạn</h2>
			</div>
		<logic:empty name="cartForm" property="listCart">
			<h2 style="color: green;">Chưa có hàng</h2>
		</logic:empty>
		<logic:notEmpty name="cartForm" property="listCart">
			<div class="table-responsive cart_info">
				<table class="table table-condensed">
					<thead>
						<tr class="cart_menu">
							<th>STT</th>
							<td>Tên Hàng</td>
							<td>Kích Cỡ</td>
							<td>Màu</td>
							<td>Ảnh</td>
							<td>Đơn Giá</td>
							<td>Số Lượng</td>
							<td>Tổng Tiền</td>
							<td>Xóa</td>
						</tr>
					</thead>
					<tbody>
					 <% int i = 0; %>
					<logic:iterate name="cartForm" property="listCart" id="cart">
						<% i++; %>
						<tr>
							<td class="STT"><%= i %></td>
							<td class="productName">
								<p><bean:write name="cart" property="productName" /></p>
							</td>
							<td class="size">
								<p><bean:write name="cart" property="size" /></p>
							</td>
							<td class="color">
								<p><bean:write name="cart" property="color" /></p>
							</td>
							<td>
								<img src='<bean:write name="cart" property="image" />' height="50px" style="padding:2px; box-sizing: border-box; background-color: #75b176;" />
							</td>
							<td>
								<p class="price formatPrice" style="display: inline;"><bean:write name="cart" property="price" /></p> 
							</td>
							<td class="cart_quantity">
								<div class="cart_quantity_button">
									<input type="number" value='<bean:write name="cart" property="quantity" />' class="cart_quantity_input quantity" style="width: 82px;" min="1" max="2147483648">
								</div>
							</td>
							<td class="cart_total totalPrice formatPrice">
								<p class="cart_total_price"><bean:write name="cart" property="totalPrice" /></p>
							</td>
							<td class="cart_delete" style="margin-top: 5px;">
								<a class="cart_quantity_delete" href=""><i class="fa fa-times"></i></a>
							</td>
						</tr>
					</logic:iterate>
					</tbody>
				</table>
			</div>
			<div class="payment-options">
				<form action="dat-hang.do" class="table table-condensed total-result" method="post">
					<div style="font-size: 20px; font-weight: bold;">
						Tổng Số Lượng:
						<span id="totalQuantity" style="border: 0;"></span>
					</div>
					<div style="font-size: 20px; font-weight: bold;">
						Tổng Tiền Phải Trả:
						<span id="totalPricePay" style="border: 0; text-align: right;"></span>
					</div>
				
					<span>
						<html:submit styleClass="btn btn-success">Thanh Toán</html:submit>
					</span>
				</form>
			</div>
			</logic:notEmpty>
		</div>
	</section> <!--/#cart_items-->
<!-- thanh toan ngan luong -->
<!-- <a target="_blank" href="https://www.nganluong.vn/button_payment.php?receiver=volam22714611@gmail.com&product_name=DH001&price=2000&return_url=http://localhost:8080/BanGiay/gio-hang.do&comments=Ghi chú về đơn hàng"><img src="https://www.nganluong.vn/css/newhome/img/button/pay-sm.png"border="0" /></a> -->
<!-- thanh toan ngan luong -->
		<!-- Footer -->
	<jsp:include page="cuoiTrang.jsp"/>
<!-- 	<script type="text/javascript" src="js/cart.js"></script> -->
<script>

// function b64DecodeUnicode(str) {
//     return decodeURIComponent(Array.prototype.map.call(atob(str), function(c) {
//         return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
//     }).join(''));
// }
//tao view lan dau
updateView();
//end tao view lan dau
$(".cart_quantity_delete").click(function(e){
	e.preventDefault();
	$(this).parent().parent().remove();
	updateView();
	//update STT
	$(".STT").each(function(index){
		$(this).text(index+1);
	});
	var url = "cap-nhat-gio-hang.do?STT="+$(this).parent().siblings("td:first").text()+"&type=delete";
	updateCart(url);
});
function updateCart(url) {
	$.ajax({
        url: url,
    });
}
$(".quantity").change(function() {
	var STT = $(this).parent().parent().siblings("td:first").text();
	var price = parseInt(unFormatPrice($(this).parent().parent().siblings().find(".price").text()));
	var quantity = parseInt($(this).val());
	var url = "cap-nhat-gio-hang.do?STT="+STT+"&quantity="+quantity+"&type=update";
	var indexTotalPrice = $(this).parent().parent().siblings(".totalPrice");
	
	updateView(quantity, price, indexTotalPrice);
	updateCart(url);
});
function updateView(quantity, price, indexTotalPrice) {
	var totalQuantity = 0;
	var totalPay = 0;
	$(indexTotalPrice).text(formatPrice(quantity * price));
	// total quantity
	$('.quantity').each(function() {
		totalQuantity += parseInt(this.value);
	});
	
	// total price
	$('.totalPrice').each(function() {
		totalPay += parseInt(unFormatPrice($(this).text()));
	});
	// total price pay
	$('#totalQuantity').text(totalQuantity);
	$('#totalPricePay').text(formatPrice(totalPay));
}
</script>
	<!--/Footer-->
	</body>
</html>