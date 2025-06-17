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
    $(document).ready(function() {
        $("#putBtn").on("click", function() {
            var userObjectArray = [
                {userId:"name01", password:"pw01"},
                {userId:"name02", password:"pw02"} ];

            $.ajax({
                type : "post",
                url : "/board/registerArray",
                data : JSON.stringify(userObjectArray),
                contentType : "application/json; charset=utf-8",
                success : function(result) {
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
            <h1>ajaxArrayHome.jsp  Header 영역</h1>
        </header>
        <hr>

        <main>
            <h1>Ajax Array Home</h1>
            
            <div>
                <button id="putBtn">수정(put)</button>
            </div>
        </main>

        <hr>
        <footer>
            <h1>footer 영역</h1>
        </footer>
    </body>
    
</html>