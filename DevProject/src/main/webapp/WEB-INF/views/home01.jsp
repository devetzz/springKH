<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html" charset=UTF-8>
        <!-- <meta charset="utf-8" /> -->
        <title>title</title>
    </head>
    <body>
        <header>
            <h1>Home01 Header 영역입니다.</h1>
        </header>
        <hr>
        <main>
            <h1>Home01 page 입니다.</h1>
            <h2>${serverTime}</h2>
            <p>boardNo ${board.boardNo} </p>
            <p>title ${board.title} </p>
            <p>content ${board.content} </p>
            <p>writer ${board.writer} </p>
            <p>regDate ${board.regDate} </p>
        </main>
        <hr>
        <footer>
            <h1>Home01 footer 영역입니다.</h1>
        </footer>
    </body>
    
</html>