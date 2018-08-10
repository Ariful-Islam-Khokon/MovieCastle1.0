<%-- 
    Document   : reg
    Created on : Jun 8, 2018, 9:20:59 PM
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
        <h1>Registration Page!</h1>
        
        <form action="save.htm">
            <table>
                <tr>
                    <td>Mobile No: </td><td><input type="text" name="mobile"></td>
                </tr>
                <tr>
                    <td>Name: </td><td><input type="text" name="uname"></td>
                </tr>
                <tr>
                    <td>Password: </td><td><input type="text" name="password"></td>
                </tr>
                <tr>
                    <td>Email: </td><td><input type="text" name="email"></td>
                </tr>                
                <tr>
                    <td></td><td><input type="submit" value="Register"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
