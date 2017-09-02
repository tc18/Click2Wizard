<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@page import="project.pro_bord_servlet"%>
<%	String pro_name=(String)session.getAttribute("p2");
   System.out.println(pro_name);	%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html lang="en">
    <head>        
        <!-- META SECTION -->
        <title><%out.println(pro_name);%></title>         
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
                    <li class="active"><%out.println(pro_name);%></li>
                </ul>
                <!-- END BREADCRUMB -->                       
                
                <!-- PAGE CONTENT WRAPPER -->
                <div class="page-content-wrap">
                	
                	
                	<div class="content-frame-top">                        
                        <div class="page-title">                    
                           <!--  <h2><span class="fa fa-tachometer"></span>Database</h2> -->
                            <!-- Page content -->
					        <!-- page header -->
					        <div class="pageheader">
						        			        
							  	<form action="<%=request.getContextPath() %>/cre_tbl_servlet" method="post">
							       	<h2><strong><%out.println(pro_name);%></strong></h2>
								        
							       	<input class="search1 " type="text" name="tbl_name" placeholder="Enter New Table Name... ">
							        	
							       	<input type="hidden" name="flag" value="goin">
							          
							        <input type="hidden" name="pro_name" value="<%out.print(pro_name);%>">
							        <button type="submit" class="btn btn-info btn-sm">Create</button>
							            
							        <button class="btn btn-default btn-sm">Import Table</button>
								   	<button class="btn btn-default btn-sm">Export Project</button>
							    </form>
							    </div>
						        <!-- /page header -->
                            
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
                    <%-- <div class="row">
                        <div class="col-md-3">
                            <div class="widget widget-default widget-item-icon " onclick="location.href='pages-messages.html';">
                                <form action="<%=request.getContextPath()%>/Servlet" method="post">
	                                <button class="block tile" type="submit">
		                                <div class="widget-item-left">
		                                    <span class="fa fa-envelope"></span>
		                                </div>                             
		                                <div class="widget-data">
		                                    <div class="widget-int num-count">48</div>
		                                    <div class="widget-title">New messages</div>
		                                    <div class="widget-subtitle">In your mailbox</div>
		                                </div>   
	                                </button>
                                </form>   
                                <div class="widget-controls">                                
                                    <a href="#" class="widget-control-right widget-remove" data-toggle="tooltip" data-placement="top" title="Remove Widget"><span class="fa fa-times"></span></a>
                                </div>
                            </div>                            
                            END WIDGET MESSAGES
                        </div>
                   	</div> --%>
                    <!-- END WIDGETS -->                    
                    
                    <!-- content main container -->
			       	<div class="main">
			
			            <!-- Tables -->
	    		        <div class="row">
	    		      
	    		      		<c:forEach items="${sessionScope.p1}" var="i">
							<div class="col-md-3">
	                        <form action="<%=request.getContextPath()%>/Servlet" method="post">
								<input type="hidden" name="flag" value="go_tbl">
								<input type="hidden" name="pro_name" value="akash">
								<input type="hidden" name="tbl_name" value="${i.data}">
								<button class="block tile" type="submit">
									<div>
									  	<strong><h3>${i.data}</h3></strong>
									  	<strong>Size</strong>: 35.4 kb <br>
									  	<strong>No. of Tables</strong>: 24 
									</div>
								</button>	
							</form>
							</div>
							</c:forEach>
							
	    		      		<!-- <div class="col-md-3">
								<div class=" block tile ">
									<a href="pro1_t1_datasheet.jsp">
								  		<strong><h3>Table 1</h3></strong>
								  		<strong>Size</strong> : 20.6 kb <br>
								  		<strong>No. of Rows</strong>: 56 
								  	</a>
							  	</div>
					  		</div>
					  			
							<div class="col-md-3">
								<div class=" block tile ">
									<a href="pro1_t2_datasheet.jsp">
									<strong><h3>Table 2</h3></strong>
								  	<strong>Size</strong>: 25 kb <br>
								  	<strong>No. of Rows</strong>: 76 
								  	</a>
								</div>
							</div>
							  
							<div class="col-md-3">
								<div class=" block tile ">
									<a href="pro1_t2_datasheet.jsp">
									<strong><h3>Table 3</h3></strong>
								  	<strong>Size</strong>: 25 kb <br>
								  	<strong>No. of Rows</strong>: 76 
								  	</a>
								</div>
							</div> -->
					  
			            </div>
			            <!-- /cards -->
				                        
					</div>
					<!-- /content container -->
                </div>
                <!-- END PAGE CONTENT WRAPPER -->                                
            </div>            
            <!-- END PAGE CONTENT -->
        </div>
        <!-- END PAGE CONTAINER -->

        
        <!-- START PRELOADS -->
        <audio id="audio-alert" src="images/1.mp3" preload="auto"></audio>
        <audio id="audio-fail" src="images/1.mp3" preload="auto"></audio>
        <!-- END PRELOADS -->                  
        
    <!-- START SCRIPTS -->
        <%@ include file="z_script.txt" %>
    <!-- END SCRIPTS -->         
    </body>
</html>






