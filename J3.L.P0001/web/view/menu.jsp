<%-- 
    Document   : menu
    Created on : Feb 17, 2020, 1:53:42 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/menu.css" rel="stylesheet" type="text/css"/>
        <title>Menu Page</title>
    </head>
    <body>
        <div class="menu">
            <table>
                <tr>
                    <td>
                        <a href="home"><b>Home</b></a>
                    </td>
                    <td>
                        <a href="take-quiz"><b>Take Quiz</b></a>
                    </td>
                    <td>
                        <a href="make-quiz"><b>Make Quiz</b></a>
                    </td>
                    <td>
                        <a href="manage-quiz?page=1"><b>Manage Quiz</b></a>
                    </td>
                    <td>
                        <c:if test="${not empty sessionScope.login}">
                            <a href="logout"><b>Log out</b></a>
                        </c:if>
                    </td>
                </tr>
            </table>
        </div>
    </body>
</html>
