<script src="admin_assets/vendor/jquery/jquery.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="admin_assets/vendor/bootstrap/js/bootstrap.min.js"></script>

<!-- Metis Menu Plugin JavaScript -->
<script src="admin_assets/vendor/metisMenu/metisMenu.min.js"></script>

<!-- DataTables JavaScript -->
<script src="admin_assets/vendor/datatables/js/jquery.dataTables.min.js"></script>
<script
	src="admin_assets/vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>

<!-- Custom Theme JavaScript -->
<script src="admin_assets/dist/js/sb-admin-2.js"></script>

<!-- Add search select -->
<script src="admin_assets/select2/js/select2.js"></script>

<!--my jquery-->
<script src="admin_assets/myjsandcss/js/myjquery.hidemenu.js"></script>

<script src="admin_assets/myjsandcss/js/myjquery.table.js"></script>

<!--freezeheader-->
<script src="admin_assets/freezeheader/js/dataTables.fixedHeader.min.js"></script>

<script src="admin_assets/myjsandcss/js/myjquery.form_validation.js"></script>
<!--fileupload-->
<script src="admin_assets/myjsandcss/js/myjquery.fileupload.js"></script>
<script>
	var url = window.location.href.substring(window.location.href.indexOf("quanly"));
// 	quanly/order/danhsach.do
// 	quanly/category/danhsach.do
	$(".activeLink").each(function(){
		if(url == $(this).attr("href"))
		{
			
			$(this).addClass("active");
			return false;
		}
	});
	function formatPriceAll(vitri){
		var nf = new Intl.NumberFormat();
		$(vitri).find(".formatPrice").each(function(){
			$(this).text(nf.format($(this).text()) + " VND");
		});
	}
</script>