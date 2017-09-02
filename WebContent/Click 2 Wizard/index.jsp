<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html lang="en">
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
		<link rel="stylesheet" type="text/css" id="theme" href="css/style.css"/>
		
        <!-- EOF CSS INCLUDE -->                                       
    </head>
    <body>
        <!-- START PAGE CONTAINER -->
        <div class="page-container">
            
            <!-- START PAGE SIDEBAR -->
             <%@ include file="z_slider.txt" %>
            <!-- END PAGE SIDEBAR -->
            
            <!-- PAGE CONTENT -->
            <div class="page-content">
                
                <!-- START X-NAVIGATION VERTICAL -->
                	<%@ include file="z_header.txt" %>
                <!-- END X-NAVIGATION VERTICAL -->                     

                <!-- START BREADCRUMB -->
                <ul class="breadcrumb">
                    <li><a href="#">Home</a></li>                    
                    <li class="active">Dashboard</li>
                </ul>
                <!-- END BREADCRUMB -->                       
                
                <!-- PAGE CONTENT WRAPPER -->
                <div class="page-content-wrap">
                	
                	<div class="content-frame-top">                        
                        <div class="page-title">                    
                           <!--  <h2><span class="fa fa-tachometer"></span>Database</h2> -->
                            <form action="<%=request.getContextPath() %>/Servlet" method="post">
				        		<div class="pageheader">
				            		<h2><i class="fa fa-tachometer"></i> Projects
				            		<input class="search1 " type="text" name="pro_name" placeholder="Enter New Project Name... ">
					            	<button type="submit" class="btn btn-info btn-md">Create</button>
					            	<input type="hidden" name="flag" value="cre_pro">
				          		</div>
				          	</form>
                        </div>                                      
                       <%--  <div class="pull-right">  
                        	<!-- page header -->
				          	<form action="<%=request.getContextPath() %>/Servlet" method="post">
				        		<div class="pageheader">
				            		<h2><i class="fa fa-tachometer"></i> Projects
				            		<input class="search1 " type="text" name="pro_name" placeholder="Enter New Project Name... ">
					            	<button type="submit" class="btn btn-info btn-sm">Create</button>
					            	<input type="hidden" name="flag" value="cre_pro">
				          		</div>
				          	</form>
				          	<!-- /page header -->                          
                            <button class="btn btn-primary"><span class="fa fa-upload"></span>Create</button>
                            
                        </div>   --%>                       
                    </div>
                    
                    <!-- START WIDGETS -->                    
                    <div class="row">
                        <!-- <div class="col-md-3">
                            START WIDGET MESSAGES
                            <div class="widget widget-default widget-item-icon" onclick="location.href='pages-messages.html';">
                                <div class="widget-item-left">
                                    <span class="fa fa-envelope"></span>
                                </div>                             
                                <div class="widget-data">
                                    <div class="widget-int num-count">48</div>
                                    <div class="widget-title">New messages</div>
                                    <div class="widget-subtitle">In your mailbox</div>
                                </div>      
                                <div class="widget-controls">                                
                                    <a href="#" class="widget-control-right widget-remove" data-toggle="tooltip" data-placement="top" title="Remove Widget"><span class="fa fa-times"></span></a>
                                </div>
                            </div>                            
                            END WIDGET MESSAGES
                        </div> -->
                        
                        <c:forEach items="${sessionScope.list}" var="i">
						<div class="col-md-3">
                        <form action="<%=request.getContextPath()%>/Servlet" method="post">
							<input type="hidden" name="pro_name" value="${i.pro_name}">
							<input type="hidden" name="flag" value="go_pro">
							<button class="block tile" type="submit">
								<div>
								  	<strong><h3>${i.pro_name}</h3></strong>
								  	<strong>Size</strong>: 35.4 kb <br>
								  	<strong>No. of Tables</strong>: 24 
								</div>
							</button>	
						</form>
						</div>
						</c:forEach>
						
                    </div>
                    <!-- END WIDGETS -->                    
                    
                    
                </div>
                <!-- END PAGE CONTENT WRAPPER -->                                
            </div>            
            <!-- END PAGE CONTENT -->
        </div>
        <!-- END PAGE CONTAINER -->

        <!-- MESSAGE BOX-->
        <div class="message-box animated fadeIn" data-sound="alert" id="mb-signout">
            <div class="mb-container">
                <div class="mb-middle">
                    <div class="mb-title"><span class="fa fa-sign-out"></span> Log <strong>Out</strong> ?</div>
                    <div class="mb-content">
                        <p>Are you sure you want to log out?</p>                    
                        <p>Press No if youwant to continue work. Press Yes to logout current user.</p>
                    </div>
                    <div class="mb-footer">
                        <div class="pull-right">
                            <form action="<%=request.getContextPath() %>/Servlet" method="post">
                            	<input type="hidden" name="flag" value="logout">
                            	<button type="submit" class="btn btn-success btn-lg">Yes</button>
                            	<button class="btn btn-default btn-lg mb-control-close">No</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- END MESSAGE BOX-->
        
        <!-- START PRELOADS -->
        <audio id="audio-alert" src="images/1.mp3" preload="auto"></audio>
        <audio id="audio-fail" src="images/1.mp3" preload="auto"></audio>
        <!-- END PRELOADS -->                  
        
    <!-- START SCRIPTS -->
        <%@ include file="z_script.txt" %>
    <!-- END SCRIPTS -->         
    </body>
</html>






