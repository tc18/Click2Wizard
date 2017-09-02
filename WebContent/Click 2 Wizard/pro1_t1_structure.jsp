<!DOCTYPE html>
<html lang="en">
<head>        
        <!-- META SECTION -->
        <title>Structure</title>            
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        
        <link rel="icon" href="favicon.ico" type="image/x-icon" />
        <!-- END META SECTION -->
        
        <!-- CSS INCLUDE -->        
        <link rel="stylesheet" type="text/css" id="theme" href="css/theme-default.css"/>
        <!-- EOF CSS INCLUDE -->                   
	
	
	<script language="javascript">
    	var j=1;
    	function addRow(tableID)
		{
		    var table=document.getElementById(tableID);
		    var rowCount=table.rows.length;
		    var row=table.insertRow(rowCount);
		    var colCount=table.rows[0].cells.length;
			
			
		    for(var i=0;i<colCount;i++)
		    {
		         var newcell=row.insertCell(i);
		         newcell.innerHTML=table.rows[1].cells[i].innerHTML;
		         switch(newcell.childNodes[0].type)    
		        { 
		            case"text":newcell.childNodes[0].value="";
		            break;
		            
		            case"checkbox":newcell.childNodes[0].checked=false;
		            case"checkbox":newcell.childNodes[0].value=j;
		            break;
		            
		            case"select-one":newcell.childNodes[0].selectedIndex=0;
		           	break;
		        }
		    }
		    j++;
		}
		
		function deleteRow(tableID)
		{
		    try
		    {
		        var table=document.getElementById(tableID);
		        var rowCount=table.rows.length;
		        for(var i=0;i<rowCount;i++)
		        {
		            var row=table.rows[i];
		            var chkbox=row.cells[0].childNodes[0];
		            if(null!=chkbox&&true==chkbox.checked)
		            {
		                if(rowCount<=1)
		                {
		                    alert("Cannot delete all the rows.");
		                    break;
		                }
		                table.deleteRow(i);
		                rowCount--;
		                i--;
		            }
		        }
		    }
		    catch(e)
		    {
		        alert(e);
		    }
		}
		
		
		
	</script>
	<style>
	.select11
	{
		font-size: 12px;
		padding: 4px 15px;
		line-height: 20px;
		font-weight: 400;
		-moz-border-radius: 5px;
		-webkit-border-radius: 5px;
		border-radius: 5px;
	}
	input[type=checkbox] 
	{
		height: 20px;
		width: 20px;
		margin-top: 4px;
	}
	</style>  
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
                    <li><a href="#">Forms Stuff</a></li>
                    <li class="active">Form Validation</li>
                </ul>
                <!-- END BREADCRUMB -->
                
                <!-- PAGE TITLE -->
                <div class="page-title"> 
                	<%	String s= (String)session.getAttribute("table_name");
					String pro_name= (String)session.getAttribute("p");%>                   
                    <div class="pageheader">
			     	    <h2>
			     	    	<strong><%out.print(pro_name);%></strong>
		            		<span><%out.print(s);%></span>
		            	</h2>
		            </div>		      
                </div>
                <!-- END PAGE TITLE -->                
                
                
                
                
                
                <!-- Page content -->
		        <div id="content" class="">
		          
				
                <!-- PAGE CONTENT WRAPPER -->
                <div class="page-content-wrap">                
                
                    <!-- START VALIDATIONENGINE PLUGIN -->
                    <div class="block">
                                <form action="<%=request.getContextPath() %>/cre_tbl_servlet" class="form-horizontal" method="post">
                                    <%-- <input type="hidden" name="i" value="${i.value}">--%>
			            			<input type="hidden" name="pro_name" value="akash">
		            				<input type="hidden" name="tbl_name" value="<%out.print(s);%>">
		            				<input type="hidden" name="flag" value="pro_name">
		            		
				            		<!-- Tables -->
				            		<div class="row cards">
				         	  			<div class="tile-body no-vpadding" style="margin-bottom: 10px;">
						              		<div class="table-responsive table-1">
						                		<table id="dataTable" class="table table-custom table-sortable nomargin">
											        <thead>
						      		                   <tr>
						        	                	   <th class="sortable" style="width:80px">Action</th>
						            	            	   <th class="sortable sort-numeric sort-asc">Field Name</th>
						            	            	   <th class="sortable sort-alpha">Datatype</th>
						                	        	   <th class="sortable sort-alpha">Size</th>
						                	        	   <th class="sortable"style="width:50px;">PK</th>
						                    	    	   <th class="sortable sort-amount" style="width: 50px;">NN</th>
						                    	    	   <th class="sortable sort-amount" style="width: 50px;">AI</th>
						                        		</tr>
						                      		</thead>
											        <tbody>
											        <!-- <tr style="display: none;">
											            <td><input type="checkbox" name="chk"></td>
											            <td><input type="text" name="text"></td>
											            <td>
											                <select style="font-size:17px;" name="select">
											                    <option value="INTEGER">INTEGER</option>
											                    <option value="CHAR">CHAR</option>
											                    <option value="VARCHAR">VARCHAR</option>
											                    <option value="TEXT">TEXT</option>
											                    <option value="NUMERIC">NUMERIC</option>
											                    <option value="DATE">DATE</option>
											                    <option value="FLOAT">FLOAT</option>
											                    <option value="TIME">TIME</option>
											                    <option value="BINARY">BINARY</option>
											                    <option value="IMAGE">IMAGE</option>
											                </select>
											            </td>
											            <td><input type="text" name="size" placeholder="size" style="font-size:17px;"></td>
											            <td><input type="checkbox" name="pk" value="0" checked></td>
											            <td><input type="checkbox" name="nn" value="0" checked></td>
											            <td><input type="checkbox" name="ai" value="0" checked></td>
											            
											        </tr> -->
											  		<tr>
											            <td><input type="checkbox" name="chk"></td>
											            <td><input type="text" class="form-control" name="text"></td><!-- validate[required,maxSize[8]] form-control -->
											            <td>
											                <select style="font-size:14px;" name="select"  class="validate[required] form-control select11" id="formGender" >
											                    <option value="INTEGER">INTEGER</option>
											                    <option value="CHAR">CHAR</option>
											                    <option value="VARCHAR">VARCHAR</option>
											                    <option value="TEXT">TEXT</option>
											                    <option value="NUMERIC">NUMERIC</option>
											                    <option value="DATE">DATE</option>
											                    <option value="FLOAT">FLOAT</option>
											                    <option value="TIME">TIME</option>
											                    <option value="BINARY">BINARY</option>
											                    <option value="IMAGE">IMAGE</option>
											                </select>
											            </td>
											            <td><input type="text" name="size" placeholder="size" style="font-size:14px;" class="form-control"></td><!-- validate[required,custom[integer],min[0],max[255]] form-control -->
											            <td><input type="checkbox" name="pk" value="0"></td>
											            <td><input type="checkbox" name="nn" value="0"></td>
											            <td><input type="checkbox" name="ai" value="0"></td>
											            
											        </tr>
											  		</tbody>
											    </table>
											    
											    <input type="button" class="btn btn-primary btn-md" value="Add Row" onclick="addRow('dataTable')">
											    <input type="button" class="btn btn-danger btn-md" value="Delete Row" onclick="deleteRow('dataTable')">
						                		
						                   	</div>
						                </div>
									 	<!-- End of table -->
				          			</div>
							        <!-- /content container -->
									<input type="submit" class="btn btn-info btn-md" value="Submit"/>
								</form>
		       		</div>                                               
		            <!-- END VALIDATIONENGINE PLUGIN -->
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
                            <a href="pages-login.html" class="btn btn-success btn-lg">Yes</a>
                            <button class="btn btn-default btn-lg mb-control-close">No</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- END MESSAGE BOX-->

        <!-- START PRELOADS -->
        <audio id="audio-alert" src="audio/alert.mp3" preload="auto"></audio>
        <audio id="audio-fail" src="audio/fail.mp3" preload="auto"></audio>
        <!-- END PRELOADS -->                 
        
    <!-- START SCRIPTS -->
        <!-- START PLUGINS -->
        <script type="text/javascript" src="js/jquery.min.js"></script>
        <script type="text/javascript" src="js/jquery-ui.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <!-- END PLUGINS -->
        
        <!-- THIS PAGE PLUGINS -->
        <script type='text/javascript' src='js/icheck.min.js'></script>
        <script type="text/javascript" src="js/jquery.mCustomScrollbar.min.js"></script>
        
        <script type='text/javascript' src='js/bootstrap-datepicker.js'></script>        
        <script type='text/javascript' src='js/bootstrap-select.js'></script>                   
        <script type="text/javascript" src="js/bootstrap-file-input.js"></script>   

        <script type='text/javascript' src='js/jquery.validationEngine-en.js'></script>
        <script type='text/javascript' src='js/jquery.validationEngine.js'></script>  
        <script type="text/javascript" src="js/jquery.tagsinput.min.js"></script>      

        <script type='text/javascript' src='js/jquery.validate.js'></script>                

        <script type='text/javascript' src='js/jquery.maskedinput.min.js'></script>
        <!-- END THIS PAGE PLUGINS -->               

        <!-- START TEMPLATE -->
        <!-- <script type="text/javascript" src="js/settings.js"></script> -->
        
        <script type="text/javascript" src="js/plugins.js"></script>
        <script type="text/javascript" src="js/actions.js"></script>
        <!-- END TEMPLATE -->
        
        <script type="text/javascript">
            var jvalidate = $("#jvalidate").validate({
                ignore: [],
                rules: {                                            
                        login: {
                                required: true,
                                minlength: 2,
                                maxlength: 8
                        },
                        password: {
                                required: true,
                                minlength: 5,
                                maxlength: 10
                        },
                        're-password': {
                                required: true,
                                minlength: 5,
                                maxlength: 10,
                                equalTo: "#password2"
                        },
                        age: {
                                required: true,
                                min: 18,
                                max: 100
                        },
                        email: {
                                required: true,
                                email: true
                        },
                        date: {
                                required: true,
                                date: true
                        },
                        credit: {
                                required: true,
                                creditcard: true
                        },
                        site: {
                                required: true,
                                url: true
                        }
                    }                                        
                });                                    

        </script>
        
    <!-- END SCRIPTS -->          
        
    </body>
</html>






