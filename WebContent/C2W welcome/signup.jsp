<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Sign Up</title>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="UTF-8" />

    <link rel="icon" type="image/ico" href="assets/images/favicon.ico" />
    <!-- Bootstrap -->
    
    <link href="css/signup.css" rel="stylesheet">
    <link href="css/bootstrap.css" rel="stylesheet">

    
  </head>
<body>
	<div class=" container bg1">
		<div class="navbar navbar-fixed-top">
			<div class="top"><a href="index.jsp" class="c2w">Click 2 Wizard</a></div>
		</div>
		
		<div class="divider">
		</div>
		
		<div class="row">
		
			<div class="col-md-7 des">
				<p class="a1">Click 2 Wizard</p>
				<p class="a2">Click 2 Wizard is the all-inclusive online database platform designed for business users to create sophisticated web forms, reports and complete web and mobile applications fast and without coding.</p>
			</div>
			
			<div class="col-md-4">
				<div class="field"  style="">
					<form  action="<%= request.getContextPath()%>/SignUp" method="post">
			 			<input type="hidden" value="register" name="flag">
						<div class="title">Create An Account</div>
							<table class="t1">
								<tr>
									<td class="t2">Name :</td>
									<td><input class="input" placeholder="First Name" name="fn" id="Firstname" autofocus="autofocus" type="text"></td>
								</tr>	
									
								<tr>
									<td class="t2">&nbsp;</td>
									<td ><input class="input" placeholder="Last Name" name="ln" id="lastname" autofocus="autofocus"  type="text"  style="clear:both;float: right;"  ></td>
								</tr>
									
								<tr>				
									<td class="t2">Email :</td>
									<td><input class="input" placeholder="Eamil ID" name="email" id="username" type="email"></td>
								</tr>
											
									
								<tr>				
									<td class="t2">Create Password :</td>
									<td><input class="input" placeholder="Password" name="pw" id="password" type="password"></td>
								</tr>
											
									
								<tr>				
									<td class="t2">Confirm Password :</td>
									<td><input class="input" placeholder="Confirm Password" name="pw" id="confirm password" type="password"></td>
								</tr>
											
									
								<tr>				
									<td class="t2">Phone No. :	</td>
									<td><input class="input" placeholder="Ph No." name="pn" id="username" type="number"></td>
								</tr>
											
									
								<tr>				
									<td class="t2">Country :</td>
									<td><input class="input" placeholder="Country" name="cn" id="username" type="text"></td>
								</tr>
								
								<tr>				
									<td class="t2">Security Question :	</td>
									<td>
										<select class="input" name="que" >
											<option value="que1">What's your favorite food ?</option>
											<option value="que2">What's your childhood name ?</option>
											<option value="que3">What's your favorite movie ?</option>
											<option value="que4">What's your pet name ?</option>													
										</select>
									</td>
								</tr>
								<tr>
									<td class="t2">&nbsp;</td>	
									<td>	
										<input class="input" placeholder="Answer" name="ans" id="username" type="text">
									</td>
								</tr>
																
								<tr>
									<td>
										<div class="buttons">
											<input type="submit" class="login-submit" value="Submit">
										</div>
									</td>
								</tr>
							</table>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>