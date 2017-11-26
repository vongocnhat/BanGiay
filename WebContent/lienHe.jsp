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
<title>Phản hồi || Liên hệ</title>
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
	 
	 <div id="contact-page" class="container">
    	<div class="bg">
  			   			
						
    		<div class="row">  	
	    	<h2 class="title text-center">Phản hồi với <strong>Chúng tôi</strong></h2>    			    				      
	    		<div class="col-sm-8">
	    			<div class="contact-form">
	    				<h2 class="title text-center">Thông tin phản hổi</h2>
	    				<div class="status alert alert-success" style="display: none"></div>
	    				<html:form action="/lien-he" method="post">
							<div class="form-group col-md-6">
								<input type="text" name="name" class="form-control" required="required" placeholder="Tên đầy đủ">
				            </div>
				            <div class="form-group col-md-6">
				                <input type="email" name="email" class="form-control" required="required" placeholder="Email">
				            </div>

				            <div class="form-group col-md-12">
				                <textarea name="contentFeedBack" id="message" required="required" class="form-control" rows="8" placeholder="Nội dung"></textarea>
				            </div>          
				            <div class="form-group col-md-12">
				                <html:submit styleClass="btn btn-primary">Gửi Phản Hổi</html:submit>
				            	<html:hidden property="submit" value="submit"/>
				            </div>	    				
	    				</html:form>
	    			</div>
	    		</div>
	    		<div class="col-sm-4">
	    			<div class="contact-info">
	    				<h2 class="title text-center">Thông tin liên hệ</h2>
	    				<address>
	    					<p>Fpt Software</p>
							<p>Khu đô thị FPT City, Hòa Hải, Ngũ Hành Sơn, Da Nang</p>	
							<p>VietNam</p>
							<p>Mobile:  0236 3952 332</p>
							<p>Fax: 1-714-252-0026</p>
							<p>Email: info@fsoft.com</p>
	    				</address>
	    				<div class="social-networks">
	    					<h2 class="title text-center">Mạng xã hội</h2>
							<ul>
								<li>
									<a href="#"><i class="fa fa-facebook"></i></a>
								</li>
								<li>
									<a href="#"><i class="fa fa-twitter"></i></a>
								</li>
								<li>
									<a href="#"><i class="fa fa-google-plus"></i></a>
								</li>
								<li>
									<a href="#"><i class="fa fa-youtube"></i></a>
								</li>
							</ul>
	    				</div>
	    			</div>
    			</div>    			
	    	</div>  
    	</div>	
    </div><!--/#contact-page-->
	

	<!-- Footer -->
	<jsp:include page="cuoiTrang.jsp"/>
	<!--/Footer-->
</body>
</html>