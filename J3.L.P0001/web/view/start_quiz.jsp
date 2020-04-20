<%-- 
    Document   : question
    Created on : Feb 27, 2020, 10:37:52 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/take-quiz.css" rel="stylesheet" type="text/css"/>
        <script src="javascript/take_quiz.js" type="text/javascript"></script>
        <title>Question Page</title>
    </head>
    <body>
        <div class="question">
            <form action="take-quiz" method="post" id="takeQuizForm"> 
                <table>
                    <tr>
                        <td><span id="indexCurrent"></span><span id="numberQuestion">${fn:length(sessionScope.questions)}</span></td>
                        <td class="time-remaining">Time remaining: <span id="time">${sessionScope.timeRemaining}</span>
                        </td>
                        <td></td>
                    </tr>

                    <c:forEach var="entry" items="${sessionScope.questions}">
                        <tr id="question${entry.key}" class="hidden">
                            <td colspan="2">
                                <div class="question-take">${entry.value.question}</div>

                                <c:set var="answser" value="answser${entry.key}"/>

                                <div><input type="checkbox" name="${answser}" value="1"/>${entry.value.option1}</div>
                                <div><input type="checkbox" name="${answser}" value="2"/>${entry.value.option2}</div>
                                <div><input type="checkbox" name="${answser}" value="3"/>${entry.value.option3}</div>
                                <div><input type="checkbox" name="${answser}" value="4"/>${entry.value.option4}</div>
                            </td>
                            <td></td>
                        </tr>
                    </c:forEach>

                    <tr>
                        <td><input type="submit" value="Finish" name="finish"/></td>
                        <td></td>
                        <td><input type="button" value="Next" name="next" onclick="nextQuestion()"/></td>
                    </tr>
                </table>
            </form>
        </div>
        <script>
            main();
            start();
        </script>
    </body>
</html>
