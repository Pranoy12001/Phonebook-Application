<%-- 
    Document   : Registration
    Created on : MAR 21, 2019, 8:39:12 PM
    Author     : Pranoy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Registration - PhoneBook</title>
        <s:url var="url_css" value="resources/css/style.css"/>
        <link href="${url_css}" rel="stylesheet" type="text/css"/>
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
                    <h3>User Registration</h3>
                    <c:if test="${err != null}">
                        <p class="error">
                            ${err}
                        </p>
                    </c:if>
                    <s:url var="url_reg" value="/register"></s:url>
                    <f:form action="${url_reg}" modelAttribute="command">
                        <table border="1">
                            <tr>
                                <td>Name</td>
                                <td><f:input path="user.name"/></td>
                            </tr>
                            <tr>
                                <td>Phone</td>
                                <td><f:input path="user.phone"/></td>
                            </tr>
                            <tr>
                                <td>Email</td>
                                <td><f:input path="user.email"/></td>
                            </tr>
                            <tr>
                                <td>Address</td>
                                <td><f:textarea path="user.address"/></td>
                            </tr>
                            <tr>
                                <td>Login Name</td>
                                <td><f:input path="user.loginName"/></td>
                            </tr>
                            <tr>
                                <td>Password</td>
                                <td><f:password path="user.password"/></td>
                            </tr>
                            
                            <tr>
                                <td colspan="2" align="right">
                                    <button>
                                        Submit
                                    </button>
                                </td>
                            </tr>
                        </table>
                    </f:form>
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
