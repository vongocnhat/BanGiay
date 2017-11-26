<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<footer id="footer"><!--Footer-->
		
		
		<div class="footer-widget">
			<div class="container">
				<div class="row">
					<div class="col-sm-2">
						<div class="single-widget">
							<h2>Thông tin liên hệ</h2>
							<ul class="nav nav-pills nav-stacked">
								<li><p>Fpt Software</p></li>
								<li><p>Khu đô thị FPT City, Hòa Hải, Ngũ Hành Sơn, Đà Nẵng</p></li>
								<li><p>VietNam</p></li>
								<li><p>Mobile:  0236 3952 332</p></li>
								<li><p>Fax: 1-714-252-0026</p></li>
								<li><p>Email: info@fsoft.com</p></li>
							</ul>
						</div>
					</div>
					<div class="col-sm-2">
						<div class="single-widget">
							<h2>Đối tác tiêu biểu</h2>
							<ul class="nav nav-pills nav-stacked">
								<li><a href="http://www.nganluong.vn/" target="_blank"><img src="images/doitac.png" style="width: 100%;"/></a></li>
							</ul>
						</div>
					</div> 

					<div class="col-sm-3 col-sm-offset-1">
						<div class="single-widget">
							<h2>Nhận Thông Tin Khuyến Mãi</h2>
							<form action="#" class="searchform">
								<input type="text" placeholder="Nhập Email Của Bạn" />
								<button type="submit" class="btn btn-default"><i class="fa fa-arrow-circle-o-right"></i></button>
								
							</form>
						</div>
					</div>
					
				</div>
			</div>
		</div>
		
		<div class="footer-bottom">
			<div class="container">
				<div class="row">
					<p class="pull-left">Copyright © 2017 T3Shoes.</p>
					<p class="pull-right">Designed by <span><a href="#">Team3</a></span></p>
				</div>
			</div>
		</div>
		
	</footer>
<script>
	function formatPriceAll(vitri){
		var nf = new Intl.NumberFormat();
		$(vitri).find(".formatPrice").each(function(){
			$(this).text(nf.format($(this).text()) + " VND");
		});
	}
	function formatPrice(price){
		var nf = new Intl.NumberFormat();
		return nf.format(price) + " VND";
	}
	function unFormatPrice(price){
		var priceLong = price.replace(new RegExp(",", 'g'), "");
		return priceLong.replace(" VND", "");
	}
	formatPriceAll("body");
</script>