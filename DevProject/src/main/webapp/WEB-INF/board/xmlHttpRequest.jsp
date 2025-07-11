<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- 화면 영역 --%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html" charset=UTF-8>
        <!-- <meta charset="utf-8" /> -->
        <title>title</title>
    </head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script type="text/javascript">
        document.addEventListener("DOMContentLoaded", function () {
        var postBtn = document.getElementById("postBtn");
        var putJsonBtn = document.getElementById("putJsonBtn");
        var putXmlBtn = document.getElementById("putXmlBtn");
        postBtn.addEventListener("click", function () {
            var boardNo = document.getElementById("boardNo").value;
            var title = document.getElementById("title").value;
            var content = document.getElementById("content").value;
            var writer = document.getElementById("writer").value;
            var boardObject = {
                boardNo: boardNo,
                title: title,
                content: content,
                writer: writer
            };
            var xhr = new XMLHttpRequest();
            var url = "/board/" + boardNo;
            xhr.open("POST", url, true);
            xhr.setRequestHeader("Content-Type", "application/json; charset=utf-8");
            xhr.onload = function () {
                if (xhr.status === 200) {
                    var result = xhr.responseText;
                    console.log("result: " + result);
                    if (result === "SUCCESS") {
                        alert("SUCCESS");
                    } else {
                        // Handle other responses or errors if needed
                    }
                } else {
                    console.error("Request failed. Status: " + xhr.status);
                    // Handle error scenario if needed
                }
            };
            xhr.onerror = function () {
                console.error("Request failed. Network error.");
                // Handle network errors if needed
            };
            xhr.send(JSON.stringify(boardObject));
        });
        putJsonBtn.addEventListener("click", function () {
            var boardNo = document.getElementById("boardNo").value;
            var title = document.getElementById("title").value;
            var content = document.getElementById("content").value;
            var writer = document.getElementById("writer").value;
            var boardObject = {
                boardNo: boardNo,
                title: title,
                content: content,
                writer: writer
            };
            var xhr = new XMLHttpRequest();
            var url = "/board/" + boardNo;
            xhr.open("PUT", url, true);
            xhr.setRequestHeader("Content-Type", "application/json; charset=utf-8");
            xhr.onload = function () {
                if (xhr.status === 200) {
                    var result = xhr.responseText;
                    console.log("result: " + result);
                    if (result === "SUCCESS") {
                        alert("SUCCESS");
                    } else {
                        // Handle other responses or errors if needed
                    }
                } else {
                    console.error("Request failed. Status: " + xhr.status);
                    // Handle error scenario if needed
                }
            };
            xhr.onerror = function () {
                console.error("Request failed. Network error.");
                // Handle network errors if needed
            };
            xhr.send(JSON.stringify(boardObject));
        });
        //실습하지말 것
        putXmlBtn.addEventListener("click", function () {
            var boardNo = document.getElementById("boardNo").value;
            var title = document.getElementById("title").value;
            var content = document.getElementById("content").value;
            var writer = document.getElementById("writer").value;
            var xmlData = "<Board>";
            xmlData += "<boardNo>" + boardNo + "</boardNo>";
            xmlData += "<title>" + title + "</title>";
            xmlData += "<content>" + content + "</content>";
            xmlData += "<writer>" + writer + "</writer>";
            xmlData += "<regDate>2018-12-10</regDate>"; // Hardcoded regDate as in the original script
            xmlData += "</Board>";
            var xhr = new XMLHttpRequest();
            var url = "/board/" + boardNo;
            xhr.open("PUT", url, true);
            xhr.setRequestHeader("Content-Type", "application/xml; charset=utf-8");
            xhr.onload = function () {
                if (xhr.status === 200) {
                    var result = xhr.responseText;
                    console.log("result: " + result);
                    if (result === "SUCCESS") {
                        alert("SUCCESS");
                    } else {
                        // Handle other responses or errors if needed
                    }
                } else {
                    console.error("Request failed. Status: " + xhr.status);
                    // Handle error scenario if needed
                }
            };
            xhr.onerror = function () {
                console.error("Request failed. Network error.");
                // Handle network errors if needed
            };
            xhr.send(xmlData);
        });
    });
    </script>
    <body>
        <header>
            <h1>xmlHttpRequest.jsp  Header 영역</h1>
        </header>
        <hr>

        <main>
            <h1>Ajax Home</h1>
            <form>
                boardNo: <input type="text" name="boardNo" value="" id="boardNo"><br>
                title: <input type="text" name="title" value="" id="title"><br>
                content: <input type="text" name="content" value="" id="content"><br>
                writer: <input type="text" name="writer" value="" id="writer"><br>
            </form>
            <div>
                <button id="postBtn">수정(put)</button>
                <button id="postHeaderBtn">수정(put with header)</button>
            </div>
        </main>

        <hr>
        <footer>
            <h1>footer 영역</h1>
        </footer>
    </body>
    
</html>