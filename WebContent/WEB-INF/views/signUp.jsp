<%@include file="/WEB-INF/templates/include.jsp" %>
<!-- Start: MAIN CONTENT -->
    <div class="content">
      <div class="container">
        <div class="page-header">
          <h1>Signup to CityPags</h1>
        </div>
        <div class="row">
          <div class="span6 offset3">
            <h4 class="widget-header"><i class="icon-gift"></i> Be a part of Bootbusiness</h4>
            <div class="widget-body">
              <div class="center-align">
                <form:form action="registration" commandName="user" method ="POST" class="form-horizontal form-signin-signup">
                  <form:input path ="firstName" placeholder="First Name"/>
                  <form:errors path ="firstName"/>
                  
                 <form:input path="lastName" placeholder="Last Name"/>
                 <form:errors path ="lastName"/>
                <form:input path="email" placeholder="Email"/>
                <form:errors path ="email"/>
                  <form:password path="password" placeholder="Password"/>
                  <form:errors path ="password"/>
                 <form:password path="matchingPassword" placeholder="Password Confirmation"/>
                  <form:errors path ="matchingPassword"/> 
                  <div>
                    <input type="submit" value="Signup" class="btn btn-primary btn-large">
                    <a class="btn btn-primary btn-large" href="login.html">Signin</a>
                    
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