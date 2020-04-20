<%-- 
    Document   : login
    Created on : Feb 17, 2020, 8:04:18 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <div class="login">
            <c:choose>
                <c:when test="${empty sessionScope.login}">
                    <h1>Login Form</h1>
                    <form action="login" method="post">
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
                                <td></td>
                                <td>
                                    <input type="submit" value="Sign in" name="submit"/>
                                    <a href="register">Register</a>
                                </td>
                            </tr>
                        </table>
                    </form>
                </c:when>
                <c:otherwise>
                    <div>Welcome <span>${sessionScope.login.username}</span></div>

                </c:otherwise>
            </c:choose>
            <table>
                <tr>
                    <td colspan="2"><jsp:include page="error.jsp"/></td>
                </tr>
            </table>
        </div>
    </body>
</html>
