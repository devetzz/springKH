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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script type="text/javascript">
    $(document).ready(function () {
        $("#putBtn").on("click", function () {
            var boardNo = $("#boardNo"); 
            var title = $("#title");
            var content = $("#content"); 
            var writer = $("#writer");
            var boardNoVal = boardNo.val(); 
            var titleVal = title.val(); 
            var contentVal = content.val(); 
            var writerVal = writer.val();
            var boardObject = {
            boardNo: boardNoVal,
            title: titleVal,
            content: contentVal,
            writer: writerVal
            };

            $.ajax({
            type: "put",
            url: "/board/" + boardNoVal,
            data: JSON.stringify(boardObject),
            contentType: "application/json; charset=utf-8", 
            success: function (result) {
                console.log("result: " + result); 
                if (result === "SUCCESS") {
                alert("SUCCESS");
                }
            }
            });
        });

        $("#getBtnAccept").on("click", function () {
            var boardNo = $("#boardNo"); 
            var boardNoVal = boardNo.val(); 

            $.ajax({
                type: "GET",
                url: "/board/" + boardNoVal,
                headers: {
                    "Accept": "application/xml" 
                },
                success: function(result) {
                    console.log("result: " + JSON.stringify(result));
                    alert(JSON.stringify(result));
                }
            });
        });


        $("#putHeaderBtn").on("click", function () {
        var boardNo = $("#boardNo");
        var title = $("#title"); 
        var content = $("#content"); 
        var writer = $("#writer");
        var boardNoVal = boardNo.val(); 
        var titleVal = title.val(); 
        var contentVal = content.val(); 
        var writerVal = writer.val();

        var boardObject = {
            boardNo: boardNoVal,
            title: titleVal,
            content: contentVal,
            writer: writerVal
        };
        $.ajax({
            type: "put",
            url: "/board/" + boardNoVal, 
            headers: {"X-HTTP-Method-Override": "PUT"},
            data: JSON.stringify(boardObject),
            contentType: "application/json; charset=utf-8",
            success: function (result) {
            console.log("result: " + result); 
            if (result === "SUCCESS") {
                alert("SUCCESS");
            }
            }
        });
        });
    });
    </script>
    <body>
        <header>
            <h1>ajaxHome.jsp  Header 영역</h1>
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
                <button id="putBtn">수정(put)</button>
                <button id="putHeaderBtn">수정(put with header)</button>
                <button id="getBtnAccept">수정(getBtnAccept)</button>
            </div>
        </main>

        <hr>
        <footer>
            <h1>footer 영역</h1>
        </footer>
    </body>
    
</html>