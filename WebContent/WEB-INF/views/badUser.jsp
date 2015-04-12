<%@include file="/WEB-INF/templates/include.jsp"%>
<fmt:setBundle basename="messages" />
<%@ page session="true"%>
<html>
<head>

	<title><spring:message
code="label.badUser.title"></spring:message></title>
</head>
<body>
<div class="alert alert-error">
<h1>

				 ${param.message}
</h1>
</div>
<br>
<a href="<c:url value="/user/registration" />"><spring:message
code="label.form.loginSignUp"></spring:message></a>

</body>
</html>
