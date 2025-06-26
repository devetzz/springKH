<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- 헤더 영역 --%>
<%@ include file="./header.jsp" %>

<!-- 화면 영역 -->
<main>
    <h2>READ</h2>
    <form:form modelAttribute="board">
        <form:hidden path="no" />
        <table>
            <tr>
                <td>Title</td>
                <td><form:input path="title" readonly="true" /></td>
            </tr>
            <tr>
                <td>Writer</td>
                <td><form:input path="writer" readonly="true" /></td>
            </tr>
            <tr>
                <td>Content</td>
                <td><form:textarea path="content" readonly="true" /></td>
            </tr>
        </table>
    </form:form>
    <div>
        <button type="submit" id="btnModify">Modify</button>
        <button type="submit" id="btnRemove">Remove</button>
        <button type="submit" id="btnList">List</button>
    </div>
</main>
<%-- footer 영역 --%>
<%@ include file="./footer.jsp" %>
<script>
    $(document).ready(function() { 
        var formObj = $("#board"); 
        console.log(formObj);
        $("#btnModify").on("click", function() {
            var no = $("#no");
            var noVal = no.val();
            self.location = "/board/modify?no=" + noVal;
        });
        $("#btnRemove").on("click", function() { 
            formObj.attr("action", "/board/remove");
            formObj.submit();
        });
        $("#btnList").on("click", function() { 
            self.location = "/board/list";
        });
    });
</script>