<%-- 
    Document   : test
    Created on : Apr 12, 2019, 8:21:59 PM
    Author     : Pranoy
--%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <s:url var="url_jqlib" value="/resources/js/jquery-3.4.0.min.js"/>
        <script src="${url_jqlib}"></script>
        <script>
            $(document).ready(function(){
                alert("Jquery is ready and integrated");
            });
        </script>
    </head>
    <body>
        <h1>Ajax Test Page</h1>
    </body>
</html>
