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
            <h1>user/resultForm.jsp  Header 영역</h1>
        </header>
        <hr>
        <main>
            <h3>Spring Form Result </h3> 
            <table border="1"> 
                <tr> 
                    <td>유저ID</td> 
                    <td>${user.userId}</td> 
                </tr> 
                <tr> 
                    <td>이름</td> 
                    <td>${user.userName} </td> 
                </tr> 
                <tr> 
                    <td>암호</td> 
                    <td>${user.userPassword} </td> 
                </tr> 
                <tr>
                    <td>소개</td>
                    <td>${user.userIntroduction}</td>
                </tr>
                <tr>
                    <td>취미</td>
                    <td>
                        <c:forEach var="hobby" items="${user.cbList}">
                            <c:out value="${hobby}" /><br>
                        </c:forEach>
                    </td>
                </tr>
            </table>
        </main>

        <hr>
        <footer>
            <h1>footer 영역</h1>
        </footer>
    </body>
    
</html>