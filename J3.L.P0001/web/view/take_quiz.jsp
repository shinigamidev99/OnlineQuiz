<%-- 
    Document   : take_quiz
    Created on : Feb 17, 2020, 8:26:07 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/take-quiz.css" rel="stylesheet" type="text/css"/>
        <title>Take Quiz Page</title>
    </head>
    <body>
        <div class="take-quiz">
            <c:if test="${not empty sessionScope.login}">
                <div class="name-welcome">Welcome <span>${sessionScope.login.username}</span></div>
                <c:if test="${empty questionEmpty}">
                    <c:if test="${empty sessionScope.questions and empty finishQuiz}">
                        <jsp:include page="prepare_quiz.jsp"/>
                    </c:if>
                    <c:if test="${not empty sessionScope.questions and empty finishQuiz}">
                        <jsp:include page="start_quiz.jsp"/>
                    </c:if>
                    <c:if test="${not empty finishQuiz}">
                        <jsp:include page="finish_quiz.jsp"/>
                    </c:if>
                </c:if>
                <jsp:include page="error.jsp"/>
            </c:if>
        </div>
    </body>
</html>
