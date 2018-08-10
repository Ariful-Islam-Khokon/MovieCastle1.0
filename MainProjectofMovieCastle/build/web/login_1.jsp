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
    </head>
    <body>
        <h1>Login Page!</h1>

        <form action="loginAdmin.htm">
            <table>
                <tr>
                    <td>Admin Name:</td><td><input type="text" name="admin" placeholder="admin"></td>
                </tr>
                <tr>
                    <td>Password:</td><td><input type="password" name="password" placeholder="admin"></td>
                </tr>
                <tr>
                    <td></td><td><input type="submit" value="Admin Login"></td>
                </tr>
                <tr>
                    <td></td><td>${ai}</td>
                </tr>
            </table>
        </form>
        
        <form action="loginC.htm">
            <table>
                <tr>
                    <td>Mobile No:</td><td><input type="text" name="mobile"></td>
                </tr>
                <tr>
                    <td>Password:</td><td><input type="password" name="password"></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Login"></td><td><a href="reg.jsp"><h3>Sign Up</h3></a></td>
                </tr>
                <tr>
                    <td></td><td>${ai}</td>
                </tr>
            </table>
        </form>
    </body>
</html>
