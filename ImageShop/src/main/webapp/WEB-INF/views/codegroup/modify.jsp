<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Image Shop</title>
        <!-- <script type="text/javascript" src="/js/test.js"></script> -->
        <link rel="stylesheet" href="/css/codegroup.css">
    </head>
    <body>
        <jsp:include page="/WEB-INF/views/common/header.jsp" />
        <jsp:include page="/WEB-INF/views/common/menu.jsp" />
        <div align="center">
            
        <h2>
            <spring:message code="codegroup.header.modify" />
        </h2>
        <form:form modelAttribute="codeGroup" action="modify">
            <table>
                <tr>
                    <td>
                        <spring:message code="codegroup.groupCode" />
                    </td>
                    <td>
                        <form:input path="groupCode" />
                    </td>
                    <td>
                        <font color="red">
                            <form:errors path="groupCode" />
                        </font>
                    </td>
                </tr>
                <tr>
                    <td>
                        <spring:message code="codegroup.groupName" />
                    </td>
                    <td>
                        <form:input path="groupName" />
                    </td>
                    <td>
                        <font color="red">
                            <form:errors path="groupName" />
                        </font>
                    </td>
                </tr>
            </table>
        </form:form>
        <div>
            <button type="submit" id="btnModify">
                <spring:message code="action.modify" />
            </button>
            <button type="submit" id="btnList">
                <spring:message code="action.list" />
            </button>
        </div>


        </div>
        <jsp:include page="/WEB-INF/views/common/footer.jsp" />
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
    $(document).ready(function () {
        var formObj = $("#codeGroup");
        $("#btnModify").on("click", function () {
            formObj.submit();
        });
        $("#btnList").on("click", function () {
            self.location = "list";
        });
    });
</script>
    </body>
</html>