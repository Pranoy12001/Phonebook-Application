<%-- 
    Document   : index
    Created on : Feb 27, 2019, 8:39:12 PM
    Author     : Pranoy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Dashboard</title>
        <s:url var="url_css" value="/resources/css/style.css"/>
        <link href="${url_css}" rel="stylesheet" type="text/css"/>
    </head>
        <s:url var="url_bg" value="/resources/images/background.jpg"/>

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
                    <h3>Contact List</h3>
                    <table border = "1">
                        <tr>
                            <td>SL</td>
                            <td>CID</td>
                            <td>NAME</td>
                            <td>PHONE</td>
                            <td>EMAIL</td>
                            <td>ADDRESS</td>
                            <td>REMARK</td>
                            <td>ACTION</td>
                        </tr>
                        <c:forEach var="c" items="${contactList}" varStatus="st">
                            <tr>
                                <td>${st.count}</td>
                                <td>${c.contactId}</td>
                                <td>${c.name}</td>
                                <td>${c.phone}</td>
                                <td>${c.email}</td>
                                <td>${c.address}</td>
                                <td>${c.remarks}</td>
                                <td>EDIT | DELETE</td>
                            </tr>
                        </c:forEach>
                    </table>
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
