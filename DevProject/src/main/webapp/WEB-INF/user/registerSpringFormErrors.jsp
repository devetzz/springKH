<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%-- 화면 영역 --%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html" charset=UTF-8>
        <!-- <meta charset="utf-8" /> -->
        <title>title</title>
    </head>
    <body>
        <header>
            <h1>user/registerSpringFormErrors.jsp  Header 영역</h1>
        </header>
        <hr>
        <main>
            <form:form modelAttribute="user" method="post" action="register">
                <table>
                    <tr>
                        <td>유저ID</td>
                        <td><form:input path="userId" /><font color="red"><form:errors path="userId" /></font></td>
                    </tr>
                    <tr>
                        <td>이름</td>
                        <td><form:input path="userName" /><font color="red"><form:errors path="userName" /></font></td>
                    </tr>
                    <tr>
                        <td>E-MAIL</td>
                        <td><form:input path="email" /><font color="red"><form:errors path="email" /></font></td>
                    </tr>
                </table>
                <form:button name="register">등록</form:button>
            </form:form>
        </main>
        <hr>
        <footer>
            <h1>footer 영역</h1>
        </footer>
    </body>
    
</html>