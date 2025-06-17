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
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        
    </head>
    <body>
        <header>
            <h1>registerAjaxFileUpForm.jsp  Header 영역</h1>
        </header>
        <hr>
        <main>
            <div>
                <input type="file" id="inputFile">
            </div>
        </main>

        <hr>
        <footer>
            <h1>footer 영역</h1>
        </footer>
    </body>
    <script type="text/javascript">
        $(document).ready(function() {
            $("#inputFile").on("change", function(event){ 
                console.log("change");
                var files = event.target.files;
                var file = files[0];
                console.log(file);
                var formData = new FormData();
                formData.append("file", file);
                $.ajax({
                    type : "post",
                    url : "/member/uploadAjax", 
                    data: formData, 
                    dataType:'text', 
                    processData: false, 
                    contentType: false, 
                    success: function(data){
                        alert(data);
                    }
                });
            });
        });
    </script>
</html>