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
                    <c:if test="${param.act eq 'sv'}">
                        <p class="success">
                            Contact is successfully added.
                        </p>
                    </c:if>
                        
                    <c:if test="${param.act eq 'del'}">
                        <p class="success">
                            Contact is successfully deleted.
                        </p>
                    </c:if>
                    
                    <c:if test="${param.act eq 'edit'}">
                        <p class="success">
                            Contact is successfully edited.
                        </p>
                    </c:if>
                     
                    <table width="100%">
                        <tr align="right">
                            <td>
                                <form action="<s:url value="/user/contact_search"/>">
                                    <input type="text" name="freeText" placeholder="Enter Text to Search"/>
                                    <button>Find</button>
                                </form>
                            </td>
                        </tr>
                    </table>

                    <form action="<s:url value="/user/bulk_cdelete"/>">
                        <button>Delete Selected Records</button><br/><br/>
                        <table border = "1" cellpadding ="3" width="100%">
                            <tr>
                                <th>SELECT</th>
                                <th>CID</th>
                                <th>NAME</th>
                                <th>PHONE</th>
                                <th>EMAIL</th>
                                <th>ADDRESS</th>
                                <th>REMARK</th>
                                <th>ACTION</th>
                            </tr>
                            <c:if test="${empty contactList}">
                                <tr>
                                    <td colspan="8" align="center">
                                        <p class="error">
                                            No Records Present.
                                        </p>
                                    </td>
                                </tr>
                            </c:if>
                            <c:forEach var="c" items="${contactList}" varStatus="st">
                                <tr>
                                    <td align="center"><input type="checkbox" name="cid" value="${c.contactId}"/></td>
                                    <td>${c.contactId}</td>
                                    <td>${c.name}</td>
                                    <td>${c.phone}</td>
                                    <td>${c.email}</td>
                                    <td>${c.address}</td>
                                    <td>${c.remarks}</td>
                                    <s:url var="url_del" value="/user/del_contact">
                                        <s:param name="cid" value="${c.contactId}"/>
                                    </s:url>
                                    <s:url var="url_edit" value="/user/edit_contact">
                                        <s:param name="cid" value="${c.contactId}"/>
                                    </s:url>
                                    <td><a href="${url_edit}">EDIT</a> | <a href="${url_del}">DELETE</a></td>
                                </tr>
                            </c:forEach>
                        </table>
                    </form>
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
