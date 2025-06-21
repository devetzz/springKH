<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- 헤더 영역 --%>
<%@ include file="./header.jsp" %>

<!-- 화면 영역 -->
<main>
    <h3>회원 등록</h3>
    <form:form modelAttribute="mymember" action="/member/register">
    <table>
        <tr>
            <td>id</td>
            <td><form:input path="id" /></td>
            <td><font color="red"><form:errors path="id" /></font></td>
        </tr>
        <tr>
            <td>pw</td>
            <td><form:password path="pw" /></td>
            <td><font color="red"><form:errors path="pw" /></font></td>
        </tr>
        <tr>
            <td>name</td>
            <td><form:input path="name" /></td>
            <td><font color="red"><form:errors path="name" /></font></td>
        </tr>
    </table>
    </form:form>

    <div>
        <button type="submit" id="btnRegister">등록</button>
        <button type="submit" id="btnList">목록</button>
    </div>
</main>

<%@ include file="./footer.jsp"%>
<script>
    $(document).ready(function() {
        var formObj = $("#mymember");
        $("#btnRegister").on("click", function() {
            formObj.attr("action", "/mymember/register");
            formObj.attr("method", "post");
            formObj.submit();
        });
        $("#btnList").on("click", function() { 
            self.location = "/mymember/list";
        });
    });
</script>