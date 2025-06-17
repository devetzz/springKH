<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
            <h1>Home0901 Header 영역입니다.</h1>
        </header>
        <hr>
        <main>
            <c:import url="/boardjstl/search">
                <c:param name="title" value="orange" />
            </c:import>
            <a href="http://localhost:8080/boardjstl/search?title=orange">boardjstl/search?title=orange</a>
            <br><br>
            <form action="/boardjstl/search" method="GET">
                <input type="text" name="title" value="orange">
                <input type="submit" value="전송">
            </form>
        </main>

        <hr>
        <footer>
            <h1>Home0901 footer 영역입니다.</h1>
        </footer>
    </body>
    
</html>