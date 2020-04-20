<%-- 
    Document   : home
    Created on : Feb 19, 2020, 12:55:27 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/main.css" rel="stylesheet" type="text/css"/>
        <title>Home Page</title>
    </head>
    <body>
        <div class="element-center">
            <div class="top-box"></div>
            <div class="main">
                <jsp:include page="menu.jsp"/>
                <div class="my-body">
                    <c:if test="${empty errorInFilter}">
                        <c:if test="${param.action eq 'home'}">
                            <jsp:include page="login.jsp"/>
                        </c:if>
                        <c:if test="${param.action eq 'take-quiz'}">
                            <jsp:include page="take_quiz.jsp"/>
                        </c:if>
                        <c:if test="${param.action eq 'make-quiz'}">
                            <jsp:include page="make_quiz.jsp"/>
                        </c:if>
                        <c:if test="${param.action eq 'manage-quiz'}">
                            <jsp:include page="manage_quiz.jsp"/>
                        </c:if>
                        <c:if test="${param.action eq 'register'}">
                            <jsp:include page="register.jsp"/>
                        </c:if>
                    </c:if>
                    <c:if test="${not empty errorInFilter}">
                        <div class="error">
                            ${errorInFilter}
                        </div>
                    </c:if>
                </div>
            </div>
        </div>
    </body>
</html>
