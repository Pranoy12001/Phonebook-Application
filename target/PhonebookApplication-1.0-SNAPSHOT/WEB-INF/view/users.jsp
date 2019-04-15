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
        <title>User List</title>
        <s:url var="url_css" value="../resources/css/style.css"/>
        <link href="$(url_css)" rel="stylesheet" type="text/css"/>
        <s:url var="url_jqlib" value="/resources/js/jquery-3.4.0.min.js"/>
        <script src="${url_jqlib}"></script>
        <script>
            function changeStatus(uid, lstatus){
                console.log(uid+"==="+lstatus);
                $.ajax({
                    url: "change_status",
                    async: false,
                    data: {userId:uid, loginStatus:lstatus},
                    success: function (data) {
                       alert(data); 
                    },
                    error: function (xhr, status, error) {
                        console.log("========"+error);
                    }
               
                });
            }
        </script>
    </head>
    <s:url var="url_bg" value="../resources/images/background.jpg"/>
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
                    <h3>User List</h3>
                    <table border = "1" cellpadding ="3" width="100%">
                            <tr>
                                <th>SL</th>
                                <th>USER ID</th>
                                <th>NAME</th>
                                <th>PHONE</th>
                                <th>EMAIL</th>
                                <th>ADDRESS</th>
                                <th>USERNAME</th>
                                <th>STATUS</th>
                            </tr>
                            <c:if test="${empty userList}">
                                <tr>
                                    <td colspan="8" align="center">
                                        <p class="error">
                                            No Records Present.
                                        </p>
                                    </td>
                                </tr>
                            </c:if>
                            <c:forEach var="u" items="${userList}" varStatus="st">
                                <tr>
                                    <td>${st.count}</td>
                                    <td>${u.userId}</td>
                                    <td>${u.name}</td>
                                    <td>${u.phone}</td>
                                    <td>${u.email}</td>
                                    <td>${u.address}</td>
                                    <td>${u.loginName}</td>
                                    <td>
                                        <select id="id_${u.userId}" onchange="changeStatus(${u.userId}, $(this).val())">
                                            <option value="1">Active</option>
                                            <option value="2">Block</option>
                                        </select>
                                        <script>
                                            $('#id_${u.userId}').val(${u.loginStatus});
                                        </script>
                                    </td>
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
