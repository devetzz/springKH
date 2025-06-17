<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
            <h1>Home04 Header 영역입니다.</h1>
        </header>
        <hr>
        <main>
            <h1>NAME 문자열배열 출력</h1>
            <c:forEach var="data" items="${name}">
                <p> <c:out value="${data}" /></p>
            </c:forEach>
            <h1>NAME 문자열배열 첨자형식 출력</h1>
                <p> ${name[0]}</p>
                <p> ${name[1]}</p>
                <p> ${name[2]}</p>
            <h1>NAMELIST LIST 출력</h1>
            <c:forEach var="data" items="${nameList}">
                <p> <c:out value="${data}" /></p>
            </c:forEach>
        </main>
        <hr>
        <footer>
            <h1>Home04 footer 영역입니다.</h1>
        </footer>
    </body>
    
</html>