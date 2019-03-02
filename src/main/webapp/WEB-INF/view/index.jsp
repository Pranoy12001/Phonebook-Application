<%-- 
    Document   : index
    Created on : Feb 27, 2019, 8:39:12 PM
    Author     : Pranoy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Login - PhoneBook</title>
        <s:url var="url_css" value="resources/css/style.css"/>
        <link href="$(url_css)" rel="stylesheet" type="text/css"/>
    </head>
    <s:url var="url_bg" value="resources/images/background.jpg"/>
    <body background="${url_bg}">
        <table border ="1" width="80%" align="center">
            <tr>
                <td style="height: 80px;">
                    <%-- Header --%>
                    <jsp:include page="include/header.jsp"/>
                </td>
            </tr>
            <tr>
                <td style="height: 25px;">
                    <jsp:include page="include/menu.jsp"/>
                </td>
            </tr>
            <tr>
                <td style="height: 350px;" valign="top">
                    <%-- Content --%>
                    <h1>User Login</h1>
                    To Do
                </td>
            </tr>
            <tr>
                <td style="height: 25px;">
                    <%-- footer --%>
                    <jsp:include page="include/footer.jsp"/>
                </td>
            </tr>
        </table>
    </body>
</html>
