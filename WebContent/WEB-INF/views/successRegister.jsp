<%@include file="/WEB-INF/templates/include.jsp"%>
<%@ page session="true"%>

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title><spring:message code="label.pages.home.title"></spring:message></title>
</head>
<body>
<h1>Hello</h1>
	<div class="container">
		<div class="span12">
			<div id="success">
				<spring:message code="message.regSucc"></spring:message>
			</div>
			<a href="<c:url value="login.html" />"><spring:message
					code="label.login"></spring:message></a>
		</div>
	</div>
</body>
</html>