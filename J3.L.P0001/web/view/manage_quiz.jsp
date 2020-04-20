<%-- 
    Document   : manage_quiz
    Created on : Feb 17, 2020, 9:42:26 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/manage-quiz.css" rel="stylesheet" type="text/css"/>
        <title>Manage Quiz Page</title>
    </head>
    <body>
        <c:if test="${empty error}">
            <jsp:useBean id="p" class="bean.PagingBean"/>
            <jsp:setProperty name="p" property="*"/>
            <div class="manage-quiz">
                <table>
                    <tr>
                        <td>
                            Number of questions: <span>${fn:length(p.questions)}</span>
                        </td>
                    </tr>
                </table>
                <br>
                <table>
                    <tr>
                        <th>Question</th>
                        <th>DateCreated</th>
                        <th>Action</th>
                    </tr>
                    <c:forEach var="qu" items="${p.questions}">
                        <tr>
                            <td class="row-question">${qu.question}</td>
                            <td>${qu.dateFormat}</td>
                            <td>
                                <a href="delete?id=${qu.question_id}&page=${fn:length(p.questions) == 1 ? (param.page - 1) : param.page}" onclick="return confirm('Do you want delete this question?')">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <div class="paging">
                <c:forEach var="i" begin="1" end="${p.pages}" step="1">
                    <c:url value="" var="next">
                        <c:param name="page" value="${i}"/>
                    </c:url>
                    <c:if test="${i != param.page}">
                        <a href="${next}">${i}</a>
                    </c:if>
                    <c:if test="${i == param.page}">
                        <a class="active">${i}</a>
                    </c:if>
                </c:forEach>
            </div>
        </c:if>
        <jsp:include page="error.jsp"/>
    </body>
</html>
