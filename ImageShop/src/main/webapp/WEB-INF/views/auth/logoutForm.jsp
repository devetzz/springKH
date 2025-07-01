<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Image Shop</title>
        <!-- <script type="text/javascript" src="/js/test.js"></script> -->
        <%-- <link rel="stylesheet" href="/css/codegroup.css"> --%>
    </head>
    <body>
        <jsp:include page="/WEB-INF/views/common/header.jsp" />
        <jsp:include page="/WEB-INF/views/common/menu.jsp" />
        <div align="center">
            
        <h2><spring:message code="auth.header.logout" /></h2>
        <form action="/auth/logout" method="post">
            <sec:csrfInput /><button><spring:message code="action.logout" /></button>
        </form>

        </div>
        <jsp:include page="/WEB-INF/views/common/footer.jsp" />

    </body>
</html>