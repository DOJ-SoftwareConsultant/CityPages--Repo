<%@include file="/WEB-INF/templates/include.jsp"%>

<!DOCTYPE html>
<html lang="en">


<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description"
	content="Bootbusiness | Short description about company">
<meta name="author" content="Your name">
<title><tiles:insertAttribute name="title" defaultValue="" /></title>
<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- Bootstrap responsive -->
<link href="css/bootstrap-responsive.min.css" rel="stylesheet">
<!-- Font awesome - iconic font with IE7 support -->
<link href="css/font-awesome.css" rel="stylesheet">
<link href="css/font-awesome-ie7.css" rel="stylesheet">
<!-- Bootbusiness theme -->
<link href="css/boot-business.css" rel="stylesheet">
</head>

<body>
	<!-- Start: HEADER -->
	<section id="header">
		<tiles:insertAttribute name="header" defaultValue="" />
	</section>
	<!-- End: Navigation wrapper -->
	<!-- End: HEADER -->
	<!-- Start: MAIN CONTENT -->
	<section id="body">
		<!-- Page content -->
		<tiles:insertAttribute name="body" />
		<!-- End of page content -->
	</section>
	<!-- End: MAIN CONTENT -->
	<!-- Start: FOOTER -->
	<section id="footer">
		<tiles:insertAttribute name="footer" defaultValue="" />
	</section>

	<!-- End: FOOTER -->
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/boot-business.js"></script>
</body>
</html>
