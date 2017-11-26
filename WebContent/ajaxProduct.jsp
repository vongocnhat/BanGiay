<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/struts.jsp" %>
<% int i = 0; %>
<logic:iterate id="prov" name="danhSachProductForm"
	property="listProduct">
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