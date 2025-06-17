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
            <h2>Spring Form 입력 화면</h2>
            <!-- modelAttribute 속성에 폼 객체의 속성명을 지정한다. -->
            <form:form modelAttribute="user" method="post" action="register">
                <table>
                    <tr>
                        <td>유저ID</td>
                        <td><form:input path="userId" />
                        <font color="red"><form:errors path="userId" /></font></td>
                    </tr>
                    <tr>
                        <td>이름</td>
                        <td><form:input path="userName" />
                        <font color="red"><form:errors path="userName" /></font></td>
                    </tr>
                    <tr>
                        <td>암호</td>
                        <td><form:password path="userPassword" />
                        <font color="red"><form:errors path="userPassword" /></font></td>
                    </tr>
                    <tr>
                        <td>소개</td>
                        <td>
                            <form:textarea path="userIntroduction" rows="6" cols="30" />
                        </td>
                    </tr>
                    <tr>
                        <td>취미(cbList) : </td>
                        <td>
                            <form:checkboxes path="cbList" items="${hobbyBoxList}" itemValue="value" itemLabel="label" />
                            
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