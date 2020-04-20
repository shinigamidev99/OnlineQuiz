<%-- 
    Document   : sucsess
    Created on : Mar 9, 2020, 2:41:05 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sucsess Page</title>
    </head>
    <body>
    <c:if test="${not empty sucsess}">
        <div class="sucsess">
            ${sucsess}
        </div>
    </c:if>
</body>
</html>
