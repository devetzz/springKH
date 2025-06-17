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
            <h1>form.jsp  Header 영역</h1>
        </header>
        <hr>
        <main>
            <form action="/member/submit" method="post">
                이름 : <input type="text" name="name">
                <button type="submit">전송</button>
            </form>
        </main>

        <hr>
        <footer>
            <h1>footer 영역</h1>
        </footer>
    </body>
    
</html>