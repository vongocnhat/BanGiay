<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/struts.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Đặt Hàng</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/prettyPhoto.css" rel="stylesheet">
    <link href="css/price-range.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
	<link href="css/main.css" rel="stylesheet">
	<link href="css/responsive.css" rel="stylesheet">
<script src="js/jquery-1.11.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="admin_assets/calendar/css/datepicker.min.css">
<style>
.no-spin::-webkit-calendar-picker-indicator, .no-spin::-webkit-outer-spin-button, .no-spin::-webkit-inner-spin-button {
    -webkit-appearance: none;
    display:none;
</style>
</head>
<body>
<!-- Header -->
<jsp:include page="tieuDe.jsp"/>
<!-- /Header -->
	<section><!--form-->
	<div class="container">
		<div class="row">
			<div class="col-sm-4">
				<div class="login-form">
					<!--sign up form-->
					<h2>Nhập thông tin người nhận hàng</h2>
					<form action="dat-hang.do" method="post" id="formDatHang">
						Tên Đầy Đủ: <html:text name="personForm" property="fullName" />
						<div style="float: left;">
							<span>
								<html:radio name="personForm" property="gender" value="Nam"/>
								<label style="font-weight: normal">Nam</label>
							</span>
						</div>
						<div style="float: left;">
							<span>
								<html:radio name="personForm" property="gender" value="Nữ"/>
								<label style="font-weight: normal">Nữ</label>
							</span>
						</div>
						<span>
							<html:radio name="personForm" property="gender" value="Khác"/>
							<label style="font-weight: normal">Khác</label>
						</span>
						</br>
						Ngày Sinh: <input type="date" name="birthday" value='<bean:write name="personForm" property="birthday" />' class="no-spin" />
						Địa Chỉ: <html:text name="personForm" property="address" />
						Số Điện Thoại: <html:text name="personForm" styleId="phone" property="phone" />
						Email: <input type="email" name="email" value='<bean:write name="personForm" property="email" />' />
						<div class="row">
							<div class="col-sm-6">
							<span>
								<button type="submit" class="btn btn-danger btnSubmit" name="method" value="offline">
									Thanh Toán Khi Nhận Hàng							
								</button>						
							</span>
							<span>
								<button type="submit" class="btn btn-success btnSubmit" name="method" value="baokim">
									Thanh Toán Bằng Bảo Kim
									<img src="https://www.baokim.vn/cdn/assets/x_home/e52d8edd/images/home_v2/logo-bt-new.png" />
								</button>
							</span>
							<span>
								<button type="submit" class="btn btn-success btnSubmit" name="method" value="nganluong">
									Thanh Toán Bằng Ngân Lượng
									<img src="https://www.nganluong.vn/css/newhome/img/button/safe-pay-1.png"border="0" />
								</button>
							</span>
							<span>
								<button type="button" class="btn btn-success" id="xoaHetThongTin">Xóa Hết Thông Tin</button>
							</span>
							</div>
						</div>
						<html:hidden name="personForm" property="submit" value="submitDatHang" />
					</form>
				</div>
				<!--/sign up form-->
			</div>
		</div>
	</div>
	</section>
<jsp:include page="cuoiTrang.jsp"/>
<script>
	$("input").attr("required", true);
	$("input").attr("max", "9999-12-31");
	//
	var method;
	$(".btnSubmit").click(function(){
		var phone=document.getElementById('phone');
		var arrPhone = phone.value.split("");
		for(var i = 0 ; i < arrPhone.length ; i++)
		{
			if(!(arrPhone[i].charCodeAt() >= 48 && arrPhone[i].charCodeAt() <= 57))
			{
				return phone.setCustomValidity("Chỉ Được Nhập Số");
			}
		}
		phone.setCustomValidity("");
		method=$(this).val();
	});
	$("#formDatHang").submit(function(e){
		if(method == "baokim")
			alert("Bạn Sẽ Thanh Toán Trên Trang BaoKim.vn")
		else
			if(method == "nganluong")
			{
				alert("Bạn Sẽ Thanh Toán Trên Trang NganLuong.vn")
	 			e.preventDefault();
	 			var url = "dat-hang.do?method=nganluong&submit=submitDatHang"; // the script where you handle the form input.
	 		    $.ajax({
	 		           type: "POST",
	 		           url: url,
	 		           data: $("#formDatHang").serialize()
	 		         });
				var orderId = '<bean:write name="cartForm" property="orderId" />';
				var totalPrice = '<bean:write name="cartForm" property="totalPrice" />';
				var desciption = "Hãy đăng nhập và thanh toán chúng tôi sẽ chuyển hàng cho bạn ngay";
				window.location.href = "https://www.nganluong.vn/button_payment.php?receiver=volam22714611@gmail.com&product_name="+orderId+"&price="+totalPrice+"&return_url=http://localhost:8080/BanGiay/dat-hang.do?method=submitOnline&comments="+desciption
			}
	});
	$("#xoaHetThongTin").click(function(){
		$("input").val("");
		$('input[type="radio"]').attr("checked", false);
	});
</script>
<script type="text/javascript" src="admin_assets/calendar/js/datepicker.min.js" ></script>
<script type="text/javascript" src="admin_assets/calendar/js/datepicker.en.js" ></script>
<script>
      $(document).ready(function(){
          $('input[type="date"]').datepicker({
              language: 'en',
              dateFormat: 'yyyy-mm-dd',
              todayButton: new Date(),
              clearButton: true,
              autoClose: true,
          });
      });
  </script>
</body>
</html>