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
            <h1>Home1101 Header 영역입니다.</h1>
        </header>
        <hr>
        <main>
            <h4>절대 URL</h4>
                <c:redirect url="http://localhost:8080/boardjstl/list" />
            <h4>redirect 이후의 코드는 실행되지 않는다.</h4>
        </main>

        <hr>
        <footer>
            <h1>Home1101 footer 영역입니다.</h1>
        </footer>
    </body>
    
</html>