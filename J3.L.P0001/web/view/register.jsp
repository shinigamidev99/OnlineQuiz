<%-- 
    Document   : register
    Created on : Feb 17, 2020, 9:54:35 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
    </head>
    <body>
        <div class="register">
            <form action="register" method="post">
                <h1>Registration Form</h1>
                <table>
                    <tr>
                        <td><label for="username">User Name: </label></td>
                        <td>
                            <input type="text" name="username" class="input-text" id="username" value="${param.username}" />
                        </td>
                    </tr>
                    <tr>
                        <td><label for="password">Password: </label></td>
                        <td>
                            <input type="password" name="password" class="input-text" id="password" value="${param.password}" />
                        </td>
                    </tr>
                    <tr>
                        <td><label>User Type: </label></td>
                        <td>
                            <select name="role">
                                <option value="0" ${param.role == 0 ? 'selected':''}>Normal</option>
                                <option value="1" ${param.role == 1 ? 'selected':''}>Teacher</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td><label for="email">Email: </label></td>
                        <td>
                            <input type="email" name="email" id="email" value="${param.email}" />
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <input type="submit" value="Register" name="submit" />
                        </td>
                    </tr>
                </table>
            </form>
            <table>
                <tr>
                    <td colspan="2">
                        <jsp:include page="error.jsp"/>
                        <jsp:include page="sucsess.jsp"/>
                    </td>
                </tr>
            </table>
        </div>
    </body>
</html>
