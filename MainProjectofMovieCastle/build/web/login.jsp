<%-- 
    Document   : login
    Created on : Jun 8, 2018, 9:20:40 PM
    Author     : aik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <script src="resources/js/bootstrap.min.js" type="text/javascript"></script>
        <link href="resources/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Satisfy|Bree+Serif|Candal|PT+Sans"/>
        <link rel="stylesheet" type="text/css" href="css/font-awesome.min.css"/>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
        <link rel="stylesheet" type="text/css" href="css/style.css"/>
        <style>
            #logReg{
                margin: auto;
            }
        </style>
    </head>
    <body >





        <section id="banner">
            <div class="bg-color" >
                <!-- admin login start -->
                <div>

                    <form action="loginAdmin.htm" >
                        <div class="form-group">
                            <label class="col-sm-1 control-label">Admin Name</label>
                            <div class="col-sm-2">
                                <input style="color: white" class="form-control" type="text" name="admin" placeholder="admin">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-1 control-label">Password</label>
                            <div class="col-sm-2">
                                <input style="color: white" class="form-control" type="password" name="password" placeholder="admin">
                            </div>
                        </div>     

                        <div class="form-group">
                            <div class="col-sm-1">
                                <button type="submit" class="btn btn-danger" onclick="">Admin Login</button>
                            </div>
                        </div>
                        <div class="col-sm-4"><p>${msgalg}</p></div>
                    </form>
                </div>
                <!-- admin login end -->
                <header id="header">
                    <div class="container">
                        <div class="row">
                            <div class="inner text-center">
                                <h1 class="logo-name">Movie Castle</h1>
                                <p style="text-align:center">One of the best Cinema hall in Bangladesh.It provides good hospitality with foods,comfortable environment to watch movie. You can buy tickets online.First you have to register for online ticket booking and get our support.  </p>
                                <!-- User login and registration  Start -->
                                <br/><br/>
                                
                                
                                <div id="uslg" style="visibility: visible">
                                <!-- User login Start -->
                                <form action="loginC.htm">

                                    <div class="form-group">
                                        <label class="col-sm-offset-2 col-sm-2 control-label">Mobile No</label>

                                        <div  class="col-sm-5 ">
                                            <input style="color: white" class="form-control" type="text" name="mobile" placeholder="Enter mobile number">
                                        </div><div class="col-sm-offset-3"></div>
                                    </div><br/>

                                    <div class="form-group">
                                        <label class="col-sm-offset-2 col-sm-2 control-label">Password</label>
                                        <div class="col-sm-5">
                                            <input style="color: white"  class="form-control " type="password" name="password" placeholder="Enter password">
                                        </div>                                            
                                    </div> <br/><br/>    

                                    <div class="form-group">
                                        <div class="col-sm-offset-4 col-sm-2">
                                            <button type="submit" class="btn btn-primary" onclick="">User Login</button>
                                        </div>

                                        <div style="background-color: #4CAF50;border-radius: 7px; color: white; cursor: pointer " class="col-sm-1">
                                            <h5 onclick="tabHidding()">Sign Up</h5>
                                        </div>
                                    </div><br/>

                                    <div class="col-sm-offset-4 col-sm-2"><p>${msgulg}</p></div>
                                </form>
                                
                                <br/>
                                </div>
                                <!-- User login end -->

                                <!-- User Registration start --> 
                                <div id="usrg" style="display: none">
                                <form action="save.htm">

                                    <div class="form-group">
                                        <label class="col-sm-offset-2 col-sm-2 control-label">Mobile No</label>

                                        <div  class="col-sm-5 ">
                                            <input style="color: white" class="form-control" type="text" name="mobile" placeholder="Enter mobile number">
                                        </div><div class="col-sm-offset-3"></div>
                                    </div><br/>
                                    <div class="form-group">
                                        <label class="col-sm-offset-2 col-sm-2 control-label">Name</label>

                                        <div  class="col-sm-5 ">
                                            <input style="color: white" class="form-control" type="text" name="uname" placeholder="Enter your name">
                                        </div><div class="col-sm-offset-3"></div>
                                    </div><br/>
                                    <div class="form-group">
                                        <label class="col-sm-offset-2 col-sm-2 control-label">Password</label>

                                        <div  class="col-sm-5 ">
                                            <input style="color: white" class="form-control" type="text" name="password" placeholder="Enter passwowrd">
                                        </div><div class="col-sm-offset-3"></div>
                                    </div><br/>
                                    <div class="form-group">
                                        <label class="col-sm-offset-2 col-sm-2 control-label">Email</label>

                                        <div  class="col-sm-5 ">
                                            <input style="color: white" class="form-control" type="text" name="email" placeholder="Enter yoru email">
                                        </div><div class="col-sm-offset-3"></div>
                                    </div><br/>
                                    
                                    <div class="form-group">
                                        <div class="col-sm-offset-4 col-sm-2">
                                            <button type="submit" class="btn btn-primary" onclick="">Register</button>
                                        </div>
                                    </div><br/>


                                </form>
                                </div>    
                                    
                                <!-- User Registration end -->  
                            </div>
                            <!-- User login and registration  end -->

                            <!-- User login end -->     

                        </div>
                    </div>

                </header>
            </div>
        </section>    

        <script>

            //login hidding function
            function tabHidding() {
                    document.getElementById("uslg").style.display ="none";
                    document.getElementById("usrg").style.display="block";
            }

        </script>                               
    </body>
</html>
