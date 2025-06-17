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
            <h1>Home0202 Header 영역입니다.</h1>
        </header>
        <hr>
        <main>
            <c:set var="myTitle">${board.title}</c:set>
            <table border="1">
                <tr>
                    <td>\${board title}</td>
                    <td>${myTitle}</td>
                </tr>
                
            </table>
            <c:set target="${board}" property="title" value="react" />
            <table border="1">
                <tr>
                    <td>\${board title}</td>
                    <td>${board.title}</td>
                </tr>
                
            </table>
        </main>

        <hr>
        <footer>
            <h1>Home0202 footer 영역입니다.</h1>
        </footer>
    </body>
    
</html>