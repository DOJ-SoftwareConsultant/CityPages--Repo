<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@include file="/WEB-INF/templates/include.jsp" %>
<head>
<meta charset="utf-8" />

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="robots" content="index, follow" />
<meta name="language" content="en" />

<title><tiles:getAsString name="pageTitle"
		defaultValue="CityPages | By doj consultant" /></title>
</head>

<body>
	<!-- start page wrapper -->
	<div>

		<tiles:insertAttribute name="header" defaultValue="" />
		<!-- Page content -->
		<tiles:insertAttribute name="body" defaultValue="" />
		<!-- End of page content -->
		<tiles:insertAttribute name="footer" defaultValue="" />

		<!-- end page wrapper -->
	</div>
</body>
</html>
