<%-- 
    Document   : number_question
    Created on : Feb 27, 2020, 10:32:24 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/take-quiz.css" rel="stylesheet" type="text/css"/>
        <title>Number question Page</title>
    </head>
    <body>
        <div class="number-question">
            <form action="take-quiz" method="post">
                <table>
                    <tr>
                        <td>
                            <div>Enter number of questions: </div>
                            <input type="number" name="number" value="" min="1" max="${max}" required/>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><div><input type="submit" value="start" name="start"/></div></td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>
