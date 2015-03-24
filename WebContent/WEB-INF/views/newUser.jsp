<%@include file="/WEB-INF/templates/include.jsp" %>
	<h1>New User Page</h1>
	<form:form method="GET" commandName="user"
		action="${pageContext.request.contextPath}/views/home/home.jsp">
		<table>
			<tbody>
				<tr>
					<td>User name:</td>
					<td><form:input path="name" /></td>
					
				</tr>
				<tr>
					<td>Email:</td>
					<td><form:input path="email" /></td>
					
				</tr>
				<tr>
					<td>Password:</td>
					<td><form:input path="password" /></td>
					
				</tr>
				<tr>
					<td><input type="submit" value="Create" /></td>
					<td></td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</form:form>
	<a href="${pageContext.request.contextPath}/">Home page</a>
