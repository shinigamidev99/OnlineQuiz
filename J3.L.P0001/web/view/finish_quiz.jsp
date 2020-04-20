<%-- 
    Document   : result
    Created on : Feb 27, 2020, 10:38:41 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/take-quiz.css" rel="stylesheet" type="text/css"/>
        <title>Result Page</title>
    </head>
    <body>
        <div class="result">
            <div class="your-score">Your score <span>${finishQuiz}</span></div>
            <div>Take another test <a href="take-quiz"><input type="button" value="Start" /></a></div>
        </div>
    </body>
</html>
