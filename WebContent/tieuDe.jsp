<%@page import="model.bean.Person"%>
<%@page import="model.bean.Account"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/struts.jsp"%>
<header id="header"><!--header-->
		<div class="header-middle"><!--header-middle-->
			<div class="container">
				<div class="row">
					<div class="col-sm-4">
						<div class="logo pull-left">
							<a href="trang-chu.do"><img src="images/home/logo03.jpg" alt="" /></a>
						</div>

					</div>
					<div class="col-sm-8">
						<div class="shop-menu pull-right">
							<ul class="nav navbar-nav">
						
									<%
										Person person = (Person) request.getSession().getAttribute("person");
										if(person==null || person.getUserName()==null|| person.getUserName().isEmpty())
										{						
									%>						
								
<!-- 										<li><a href="#"><i class="fa fa-crosshairs"></i> Thanh toán</a></li> -->
										<li><a href="gio-hang.do"><i class="fa fa-shopping-cart"></i> Giỏ hàng</a></li>
										<li><a href="dang-nhap-dang-ky.do"><i class="fa fa-lock"></i> Đăng nhập || Đăng ký</a></li>									
										
									<%
										}else{
									%>
											<li><a href="thong-tin-tai-khoan.do">Xin Chào: <%=person.getFullName()%></a></li>
											<li><a href="tim-kiem-san-pham.do?submit=submitYeuThich"><i class="fa fa-star"></i> Sản phẩm yêu thích</a></li>
<!-- 											<li><a href="#"><i class="fa fa-crosshairs"></i> Thanh toán</a></li> -->
											<li><a href="gio-hang.do"><i class="fa fa-shopping-cart"></i> Giỏ hàng</a></li>
	
											<li><a href="dang-xuat.do"><i class="fa fa-lock"></i> Đăng Xuất</a></li>
									<%
										}
									%>
																		
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div><!--/header-middle-->
	
		<div class="header-bottom"><!--header-bottom-->
			<div class="container">
				<div class="row">
					<div class="col-sm-7">
						<div class="navbar-header">
							<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
								<span class="sr-only">Toggle navigation</span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
							</button>
						</div>
						<div class="mainmenu pull-left">
							<ul class="nav navbar-nav collapse navbar-collapse">
								<li><a href="trang-chu.do">Trang Chủ</a></li>
								<li class="dropdown"><a href="#">Shop<i class="fa fa-angle-down"></i></a>
                                    <ul role="menu" class="sub-menu">
                                        <li><a href="#cacSanPham">Sản Phẩm</a></li>
                                    </ul>
                                </li> 
								<li class="dropdown"><a href="#">Blog<i class="fa fa-angle-down"></i></a>
                                    <ul role="menu" class="sub-menu">
                                        <li><a href="#">Blog List</a></li>
										<li><a href="#">Blog Single</a></li>
                                    </ul>
                                </li> 
								<li><a href="lien-he.do">Liên hệ</a></li>
							</ul>
						</div>
					</div>
					<div class="col-sm-5">
						<div class="search_box pull-right">
						<form action="tim-kiem-san-pham.do" method="get">
							<input type="text" placeholder="Tìm kiếm" name="stringSearch"/>
							<button type="submit" class="btn btn-default">Tìm kiếm</button>
				            <input type="hidden" name="submit" value="submit"/>
						</form>
						</div>
					</div>
				</div>
			</div>
		</div><!--/header-bottom-->
	</header><!--/header-->
	