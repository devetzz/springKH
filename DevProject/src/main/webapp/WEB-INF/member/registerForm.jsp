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
            <h1>registerForm.jsp  Header 영역</h1>
        </header>
        <%-- <hr>
        <main>
            <form action="/member/register" method="post">
                userId: <input type="text" name="userId" value="hong"><br>
                password: <input type="text" name="password" value="1234"><br>
                dateOfBirth: <input type="text" name="dateOfBirth" value="20001020"><br>
                <input type="submit" value="register">
            </form>
            <hr>
            <form action="/member/registerSelect" method="post">
                nationality: <select name="nationality" multiple>
                    <option value="Korea" selected>대한민국</option>
                    <option value="Germany">독일</option>
                    <option value="Australia">호주</option>
                    <option value="Canada">캐나다</option>
                </select><br>
                <input type="submit" value="registerSelect">
            </form>
            <hr>
            <form action="/member/registerBoard" method="post">
                userId: <input type="text" name="userId" value="hong"><br>
                password: <input type="text" name="password" value="1234"><br>
                dateOfBirth: <input type="text" name="dateOfBirth" value="20001020"><br>
                boardNo: <input type="text" name="board.boardNo" value="200"><br>
                <input type="submit" value="register">
            </form> --%>
            <hr>
            <form action="/member/registerFileupload" method="post" enctype="multipart/form-data">
                userId: <input type="text" name="userId" value="hong"><br>
                password: <input type="text" name="password" value="1234"><br>
                file: <input type="file" name="picture[0]"><br>
                file2: <input type="file" name="picture[1]"><br>
                <input type="submit" value="register">
            </form>
        </main>

        <hr>
        <footer>
            <h1>footer 영역</h1>
        </footer>
    </body>
    
</html>