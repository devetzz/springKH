<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- 헤더 영역 --%>
<%@ include file="./header.jsp" %>

<!-- 화면 영역 -->
<main>
    <h2>REGISTER</h2>
    <%-- Spring Form 방식 --%>
    <form:form modelAttribute="board" action="register">
        <table>
            <tr>
                <td>Title</td>
                <td><form:input path="title" /></td>
                <td><font color="red"><form:errors path="title" /></font></td>
            </tr>
            <tr>
                <td>Writer</td>
                <td><form:input path="writer" /></td>
                <td><font color="red"><form:errors path="writer" /></font></td>
            </tr>
            <tr>
                <td>Content</td>
                <td><form:textarea path="content" /></td>
                <td><font color="red"><form:errors path="content" /></font></td>
            </tr>
        </table>
    </form:form>
    <div>
    <button type="submit" id="btnRegister">게시판 입력</button>
    <button type="submit" id="btnList">게시판 전체 출력</button>
    </div>
</main>
<%-- footer 영역 --%>
<%@ include file="./footer.jsp" %>
<script>
    $(document).ready(function() {
        var formObj = $("#board");
        $("#btnRegister").on("click", function() { 
            formObj.attr("action", "/board/register");
            formObj.attr("method", "post"); formObj.submit();
        });
        $("#btnList").on("click", function() { 
            self.location = "/board/list";
        });
    });
</script>