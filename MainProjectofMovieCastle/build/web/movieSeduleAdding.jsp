<%-- 
    Document   : movieSeduleAdding
    Created on : May 28, 2018, 1:59:37 AM
    Author     : aik
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>

    <body onload="tabHidding()">
        <!--  main div  -->
        <div class="container" style="background-color: #a6e1ec;width: 100%">
            <h1 style="text-align: center"> Movie Adding and Status Panel</h1>
            <!--  movie adding div  -->
            <div style="border:1px solid #dedede;margin:5px 0 10px 10px;float:left;width: 30%;">
                <h4 style="text-align: center">Add Movie</h4>
                <form action="madding.htm" style="margin: 20px">
                    <table>
                        <tr>
                            <td>Date:</td><td><input type="date" name="smdate"></td>
                        </tr>
                        <tr>
                            <td>Movie Name:</td><td><input type="text" name="mname"></td>
                        </tr>
                        <tr>
                            <td>Diamond Price:</td><td><input type="text" name="dsprice"></td>
                        </tr>
                        <tr>
                            <td>Platinum Price:</td><td><input type="text" name="psprice"></td>
                        </tr>
                        <tr>
                            <td>Gold Price:</td><td><input type="text" name="gsprice"></td>
                        </tr>
                        <tr>
                            <td>Silver Price:</td><td><input type="text" name="ssprice"></td>
                        </tr>
                        <tr>
                            <td><input type="submit" value="Add Movie"></td>
                        </tr>
                    </table>
                </form>
            </div>   
            <!-- movie seat selling  status div  -->
            <div class="col-md-3" style="border:1px solid #dedede;margin:5px 0 10px 0px;float:right;width: 30%">
                <div class="m-tickets-instantly" style="border:none;">
                    <h4 style="text-align: center">Select movie see status</h4>                            
                    <div class="clearfix"></div>


                    <form action="movieSelectForAdmin.htm">                          
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
                        </div>

                    </form>   
                    <!-- that 3 field will be hidden -->
                    <form action="seeStatus.htm">                          
                        <input type="text"  value="${ai}" name="movieName" hidden=""/>
                        <input type="text" id="md" name="showDate"  hidden=""/>
                        <input type="text" id="mt" name="sTime" hidden=""/>
                        <input type="text" id="vtster"  value="${vis}" hidden=""/><!-- that one for hidding status and info table -->
                        <div class="col-md-12" style="margin:9px 0; padding:0;">
                            <button class="btn btn-default btn-block" type="submit" onclick=""><span class="glyphicon glyphicon-search"></span> Buy Tickets</button>
                        </div>
                    </form>                       

                </div>  
            </div>


            <!-- show result div  -->
            <div id="tab1" style=" margin: auto">
                <table  class="table" >
                    <tr>
                        <th>Movie Date</th>
                        <th> Movie Time</th>
                        <th>Diamond sit Price</th>
                        <th>Platinum sit Price</th>
                        <th>Gold sit Price</th>
                        <th>Silver sit Price</th>
                        <th>Deleting</th>
                    </tr>
                    <c:forEach items="${ml}" var="a">
                        <tr>
                            <td>${a.mdate}</td>
                            <td>${a.mname}</td>
                            <td>${a.dsprice}</td>
                            <td>${a.psprice}</td>
                            <td>${a.gsprice}</td>
                            <td>${a.ssprice}</td>
                            <td><a href="maddingdelte.htm?mdate=${a.mdate}">Delete</a></td>
                        </tr>

                    </c:forEach>
                </table>
            </div> 
            <!-- show Sold seat Stutus ... initially it will be hidden-->
            <div id="tab2"  style="border:1px solid #dedede;max-width: 90%; margin: auto">
                <div  class="col-lg-6 col-md-6 col-sm-12" >

                    <p style="text-align:center">Selected movie name: <span style="color: blue"> ${mn} </span> date: <span style="color: blue"> ${md} </span> show time: <span style="color: blue"> ${mt} </span></p>
                    <table class="table">
                        <tr>
                            <th>Seat Type</th>
                            <th>Sold Seat(total)</th>
                            <th>Unsold Seat</th>
                            <th>Unite Price</th>
                            <th>Sold Price(total)</th>                           
                        </tr>
                        <c:forEach items="${list}" var="a">
                            <tr>
                                <td>${a.seatType}</td>                              
                                <td>${a.soldSeat} (${a.totalseat})</td>                              
                                <td>${a.unSoldSeat}</td>                              
                                <td>${a.unitePrice}</td>                              
                                <td>${a.soldPrice} (${a.totalSoldPrice})</td>                                                         
                            </tr>

                        </c:forEach>
                        <tr>
                            <td colspan="3"><h4>Total Sold Price</td></h4><td colspan="2"><h4>${stprice}(${tprice}) TK</h4></td>
                        </tr>

                    </table>
                    <input id="soldS" value="${ssit}" hidden=""><!--hidding Solded Seat-->

                </div> 
            </div>


        </div>

        <script>

            function callfd(val) {
                document.getElementById("md").value = val;
            }
            function callfst(val) {
                document.getElementById("mt").value = val;
            }
            
            //table hidding function
            function tabHidding() {
               var val= document.getElementById("vtster").value;
                if (val == "vis") {
                     document.getElementById("tab1").style.visibility = "hidden";
                     document.getElementById("tab2").style.visibility = "visible";
                }
                if (val == "hid"){
                     document.getElementById("tab1").style.visibility = "visible";
                    document.getElementById("tab2").style.visibility = "hidden";
                }

            }

        </script>                      


    </body>
</html>
