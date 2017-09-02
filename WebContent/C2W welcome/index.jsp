<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en" class="body-full-height">
    
<head>        
        <!-- META SECTION -->
        <title>Click 2 Wizard</title>            
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        
        <link rel="icon" href="favicon.ico" type="image/x-icon" />
        <!-- END META SECTION -->
        
        <!-- CSS INCLUDE -->        
        <link rel="stylesheet" type="text/css" id="theme" href="css/theme-default.css"/>
        <!-- EOF CSS INCLUDE -->                          
    </head>
    <body>
        
        <div class="login-container">
        
            <div class="login-box animated fadeInDown">
                <div class="login-logo"></div>
                <div class="login-body">
                    <div class="login-title"><strong>Welcome</strong>, Please login</div>
                    <form  action="<%= request.getContextPath()%>/SignIn" method="post">
	                    <div class="form-group">
	                        <div class="col-md-12">
	                            <input type="text" style="margin: 9px 0px" name="username" class="form-control" placeholder="Username"/ >
	                        </div>
	                    </div>
	                    <div class="form-group">
	                        <div class="col-md-12">
	                            <input type="password" style="margin: 0px 0px 9px 0px" name="password" class="form-control" placeholder="Password"/>
	                        </div>
	                    </div>
	                    <div class="form-group">
	                        <div class="col-md-6">
	                            <a href="#" class="btn btn-link btn-block">Forgot your password?</a>
	                        </div>
	                        <div class="col-md-6">
	                        	<input type="hidden" name="flag" value="signin"> 
	                            <button type="submit" class="btn btn-info btn-block">Log In</button>
	                        </div>
	                    </div>
                    </form>
                </div>
                <a href="signup.jsp" class="button">Start Your Free Trial Today</a><br><br><br>
                <div class="login-footer">
                    <div class="pull-left">
                        &copy; 2015 Click 2 Wizard
                    </div>
                    <div class="pull-right">
                        <a href="#">About</a> |
                        <a href="#">Privacy</a> |
                        <a href="#">Contact Us</a>
                    </div>
                </div>
            </div>
            
        </div>
        
    </body>

</html>






<%-- 








<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Click 2 Wizard</title>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="UTF-8" />

    <link rel="icon" type="image/ico" href="assets/images/favicon.ico" />
    <!-- Bootstrap -->
    
    <link href="css/signin.css" rel="stylesheet">
    <link href="css/bootstrap.css" rel="stylesheet">

    
  </head>
<body>
	<div class=" container bg1">
		<div class="navbar navbar-fixed-top">
			<div class="top"><a href="index.jsp" class="c2w">Click 2 Wizard</a></div>
		</div>
		
		<div class="divider">
		</div>
		
		<div class="row" style="margin-top: 50px;">
	        <div class="col-md-8 columns">
	            <h2 class="a1"><strong>Click 2 Wizard</strong> A Dynamic database management system</h2>
	            <h4 class="a2">Click 2 Wizard is an application platform that empowers end users to rapidly build their own business applications with zero programming, replacing generic software, databases or spreadsheets.</h4>
	        </div>
	        
	        <div class="col-md-3">
	        	<div class="field" style="width: 315px;margin: 0 auto;">  
		        	<h3>Sign-In</h3>  
		        	<% String e=(String)request.getAttribute("error"); %>
		            <form  action="<%= request.getContextPath()%>/SignIn" method="post">
			            <div class="login">
			            	<input name="username" type="text" class="input" placeholder="Username"><br>
			    			<input name="password" type="password" class="input" placeholder="Password"><br>
			    			<h4><% out.print(e); %></h4>
				            <input type="submit" class="login-submit" value="Submit">
			    			<input type="hidden" name="flag" value="signin"> 
			    		</div>
		    		</form>
		    		<a href="signup.jsp" class="button">Start Your Free Trial Today</a><br><br><br>
	    		</div>
	        </div>
  	  	</div>
  	  	
	</div>
</body>
</html> --%>