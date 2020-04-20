<%-- 
    Document   : make_quiz
    Created on : Feb 17, 2020, 9:23:04 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Make Quiz Page</title>
    </head>
    <body>
        <div class="make-quiz">
            <form action="make-quiz" method="post">
                <table>
                    <tr>
                        <td class="text-top">Question: </td>
                        <td>
                            <textarea name="question" rows="8" cols="67">${param.question}</textarea>
                        </td>
                    </tr>
                    <tr>
                        <td class="text-top">Option1: </td>
                        <td>
                            <textarea name="option1" rows="4" cols="67">${param.option1}</textarea>
                        </td>
                    </tr>
                    <tr>
                        <td class="text-top">Option2: </td>
                        <td>
                            <textarea name="option2" rows="4" cols="67">${param.option2}</textarea>
                        </td>
                    </tr>
                    <tr>
                        <td class="text-top">Option3: </td>
                        <td>
                            <textarea name="option3" rows="4" cols="67">${param.option3}</textarea>
                        </td>
                    </tr>
                    <tr>
                        <td class="text-top">Option4: </td>
                        <td>
                            <textarea name="option4" rows="4" cols="67">${param.option4}</textarea>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            Answer(s)
                            <c:forEach var="i" begin="0" end="3" step="1">
                                <input type="checkbox" name="answer" value="${i + 1}" 
                                       <c:forEach var="j" items="${paramValues.answer}">
                                           ${j == i + 1 ? 'checked' : ''}
                                       </c:forEach>
                                       /> Option ${i + 1}
                            </c:forEach>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Save" name="submit"/></td>
                    </tr>
                </table>
            </form>
            <jsp:include page="sucsess.jsp"/>
            <jsp:include page="error.jsp"/>
        </div>
    </body>
</html>
