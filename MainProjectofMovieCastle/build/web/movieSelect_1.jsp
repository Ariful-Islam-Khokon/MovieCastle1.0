<%-- 
    Document   : movie select
    Created on : May 30, 2018, 12:40:18 AM
    Author     : aik
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
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
        </head>
        <body>
            <div class="col-md-3" style="border:1px solid #dedede;margin:10px 0 10px 20px;">
                <div class="m-tickets-instantly" style="border:none;">
                    <h4 style="margin:30px 0 30px 40px;">Buy movie tickets instantly</h4>                            
                    <div class="clearfix"></div>


                    <form action="movieSelect.htm">                          
                        <div class="form-group">
                            <select on class="form-control valid-empty" name="movieName" id="movie_name"  onchange="this.form.submit()">
                                <option value="${ai}">${ai}</option>
                            <c:forEach items="${bi}" var="a">
                                <option>${a}</option>
                            </c:forEach>

                        </select>
                    </div>
                    <div class="form-group">
                        <select class="form-control valid-empty" name="showDate" id="show_date" required="" onchange="callfd(this.value)">
                            <option value="-1">Select Show Date</option>   
                            <c:forEach items="${mdt}" var="b">
                                <option>${b}</option>
                            </c:forEach>

                        </select>
                    </div>
                    <div class="form-group">
                        <select class="form-control valid-empty" name="show_time" id="show_time" required="" onchange="callfst(this.value)">
                            <option value="-1">Select Show Time</option>
                            <option value="4:30pm">4:30pm</option>
                            <option value="7:30pm">7:30pm</option>
                        </select>
                    </div>       <!-- that 1 field will be hidden -->
                                <input type="text"  value="${mnum}" name="userNumber" hidden=""/>
                </form>   
                <!-- that 4 field will be hidden -->
                <form action="goMainPage.htm">                          
                    <input type="text"  value="${ai}" name="movieName" hidden=""/>
                    <input type="text" id="md" name="showDate" hidden="" />
                    <input type="text" id="mt" name="sTime" hidden="" />
                    <input type="text"  value="${mnum}" name="userNumber" hidden=""/>
                    <div class="col-md-12" style="margin:9px 0; padding:0;">
                        <button class="btn btn-default btn-block" type="submit" onclick=""><span class="glyphicon glyphicon-search"></span> Buy Tickets</button>
                    </div>
                </form>                       

            </div>  
        </div>
        <script>

            function callfd(val){
            document.getElementById("md").value = val;
            }
            function callfst(val){
            document.getElementById("mt").value = val;
            }

        </script>               

    </body>
</html>
