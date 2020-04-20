<%-- 
    Document   : error
    Created on : Feb 20, 2020, 9:02:57 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/main.css" rel="stylesheet" type="text/css"/>
        <title>Error Page</title>
    </head>
    <body>
        <div class="element-center">
            <div class="top-box"></div>
            <div class="main">
                <jsp:include page="menu.jsp"/>
                <div class="my-body">
                    <jsp:include page="error.jsp"/>
                    <c:if test="${empty error}">
                        <h1 class="error">Not found page!</h1>
                    </c:if>
                </div>
            </div>
        </div>
    </body>
</html>
