<%@include file="/WEB-INF/templates/include.jsp" %>
<div class="content">
      <div class="container">
        <div class="page-header">
          <h1>Signin to CityPages</h1>
        </div>
        <div class="row">
          <div class="span6 offset3">
            <h4 class="widget-header"><i class="icon-lock"></i> Signin to Citypages</h4>
            <div class="widget-body">
              <div class="center-align">
              
                <form:form action="login" commandName="user" method="POST" class="form-horizontal form-signin-signup">
                  <!-- <input type="text" name="email" placeholder="Email">
                  <input type="password" name="password" placeholder="Password"> -->
                   
                  <form:input path="email" placeholder="Email"/>
                  <form:errors path="email"/>
                  
                   
                  <form:password path="password" placeholder="Password"/>
                  <form:errors path="password"/>
                  
                  <div class="remember-me">
                    <div class="pull-left">
                      <label class="checkbox">
                        <input type="checkbox"> Remember me
                      </label>
                    </div>
                    <div class="pull-right">
                      <a href="#">Forgot password?</a>
                    </div>
                    <div class="clearfix"></div>
                  </div>
                  <input type="submit" value="Signin" class="btn btn-primary btn-large">
                </form:form>
                
                <!-- <h4><i class="icon-question-sign"></i> Don't have an account?</h4>
                <a href="signup.html" class="btn btn-large bottom-space">Signup</a>
                <h4><i class="icon-thumbs-up"></i> Sign in with third party account</h4>
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
                  <li>
                    <a class="btn-github">
                      <i class="icon-github icon-large"></i>
                      Signin with Github
                    </a>
                  </li>
                </ul> -->
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>