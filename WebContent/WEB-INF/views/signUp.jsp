<%@include file="/WEB-INF/templates/include.jsp"%>
<%@ page session="false"%>
<!-- Start: MAIN CONTENT -->
<div class="content">
	<div class="container">
		<div class="page-header">
			<h1>Signup to CityPages</h1>

		</div>
		<div class="row">
			<div class="span6 offset3">
				<h4 class="widget-header">
					<i class="icon-gift"></i>
					<spring:message code="label.form.title"></spring:message>
				</h4>
				<div class="widget-body">

					<div class="center-align">
						<form:form action="registration" commandName="user" method="POST"
							class="form-horizontal form-signin-signup">
							<tr>
								<td><form:input path="firstName" placeholder="First Name" /></td>

								<td><form:errors path="firstName"
										cssClass="alert alert-error" element="div" /></td>
							</tr>


							<form:input path="lastName" placeholder="Last Name" />

							<form:errors path="lastName" cssClass="alert alert-error"
								element="div" />


							<form:input path="email" placeholder="Email" />
							<form:errors path="email" cssClass="alert alert-error"
								element="div" />



							<form:input path="password" placeholder="password"
								type="password" />
							<form:errors path="password" cssClass="alert alert-error"
								element="div" />

							<form:input path="matchingPassword"
								placeholder="confirm password" type="password" />
							<form:errors cssClass="alert alert-error" element="div" />


							<div>

								<input type="submit" value="Signup"
									class="btn btn-primary btn-large"> <a
									class="btn btn-primary btn-large" href="login.html">Signin</a>

							</div>
						</form:form>

						<!--  <h4><i class="icon-thumbs-up"></i> Sign in with third party account</h4>
                <ul class="signin-with-list">
                  <li>
                    <a class="btn-twitter">
                      <i class="icon-twitter icon-large"></i>
                      Signin with Twitter
                    </a>
                  </li>
                  <li>
                    <a class="btn-facebook">
                      <i class="icon-facebook icon-large"></i>
                      Signin with Facebook
                    </a>
                  </li>
                  <li>
                    <a class="btn-google">
                      <i class="icon-google-plus icon-large"></i>
                      Signin with Google
                    </a>
                  </li>
                 
                </ul> -->
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- End: MAIN CONTENT -->