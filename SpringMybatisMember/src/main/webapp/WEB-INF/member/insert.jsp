<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- 헤더 영역 --%>
<%@ include file="./header.jsp" %>

<!-- 화면 영역 -->
<main>
    <h2>사용자 입력</h2>
    <%-- Spring Form 방식 --%>
    <form:form modelAttribute="member" action="insert">
        <table>
            <tr>
                <td>ID</td>
                <td><form:input path="id" /></td>
                <td><font color="red"><form:errors path="id" /></font></td>
            </tr>
            <tr>
                <td>PW</td>
                <td><form:password path="pwd" /></td>
                <td><font color="red"><form:errors path="pwd" /></font></td>
            </tr>
            <tr>
                <td>NAME</td>
                <td><form:input path="name" /></td>
                <td><font color="red"><form:errors path="name" /></font></td>
            </tr>
        </table>
    </form:form>
    <div>
    <button type="submit" id="btnInsert">게시판 입력</button>
    <button type="submit" id="btnList">게시판 전체 출력</button>
    </div>
</main>
<%-- footer 영역 --%>
<%@ include file="./footer.jsp" %>
<script>
    $(document).ready(function() {
        var formObj = $("#member");
        $("#btnInsert").on("click", function() { 
            formObj.attr("action", "/member/insert");
            formObj.attr("method", "post"); formObj.submit();
        });
        $("#btnList").on("click", function() { 
            self.location = "/member/list";
        });
    });
</script>