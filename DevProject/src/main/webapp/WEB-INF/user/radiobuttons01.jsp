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
            <h1>user/registerForm.jsp  Header 영역</h1>
        </header>
        <hr>
        <main>
            <form:form modelAttribute="user" method="post" action="register">
                <table>
                    <tr>
                        <td>성별</td>
                        <td>
                            <form:select path="nationality" items="${nationalityCodeMap}" />
                        </td>
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