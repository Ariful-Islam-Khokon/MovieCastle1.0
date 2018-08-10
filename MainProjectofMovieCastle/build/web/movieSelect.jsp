<%-- 
    Document   : movie select
    Created on : May 30, 2018, 12:40:18 AM
    Author     : aik
--%>

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
                
                
                <form  action="" >                          
                    <div class="form-group">
                        <select on class="form-control valid-empty" name="movie_id" id="movie_id" required="">
                            <option value="-1">Select Movie</option>
                            <%
                               try {
                                    Class.forName("com.mysql.jdbc.Driver");
                                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo2", "root", "apcl123456");
                                    PreparedStatement pstmt = con.prepareStatement("SELECT  distinct mname FROM mschedule ");
                                    ResultSet rs = pstmt.executeQuery();
                                    while (rs.next()) {%>
                                    <option value="<%=rs.getString(1)%>"><%=rs.getString(1)%></option>  
                                <%    }

                                } catch (Exception e) {
                                   e.printStackTrace();
                              }
                            
                            %>
                            
                        </select>
                    </div>
                    <div class="form-group">
                        <select class="form-control valid-empty" name="show_date" id="show_date" required="">
                            <option value="-1">Select Show Date</option>                                                            
                        </select>
                    </div>
                    <div class="form-group">
                        <select class="form-control valid-empty" name="show_time" id="show_time" required="">
                            <option value="-1">Select Show Time</option>
                            <option value="4:30pm">4:30pm</option>
                            <option value="7:30pm">7:30pm</option>
                        </select>
                    </div>
                    <div class="col-md-12" style="margin:9px 0; padding:0;">
                        <button class="btn btn-default btn-block" type="submit" onclick=""><span class="glyphicon glyphicon-search"></span> Buy Tickets</button>
                    </div>
                    <div class="clearfix"></div>
                </form>                   
            </div>  
        </div>
    </body>
</html>
