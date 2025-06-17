<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- 헤더 영역 --%>
<%@ include file="./header.jsp" %>

<!-- 화면 영역 -->
<main>
    <h2>READ</h2>
    <form:form modelAttribute="member">
        <form:hidden path="no" />
        <table>
            <tr>
                <td>ID</td>
                <td><form:input path="id" readonly="true" /></td>
            </tr>
            <tr>
                <td>PW</td>
                <td><form:password path="pwd" readonly="true" /></td>
            </tr>
            <tr>
                <td>NAME</td>
                <td><form:input path="name" readonly="true" /></td>
            </tr>
        </table>
    </form:form>
    <div>
        <button type="submit" id="btnModify">Modify</button>
        <button type="submit" id="btnDelete">Delete</button>
        <button type="submit" id="btnList">List</button>
    </div>
</main>
<%-- footer 영역 --%>
<%@ include file="./footer.jsp" %>
<script>
    $(document).ready(function() { 
        var formObj = $("#member"); 
        console.log(formObj);
        $("#btnModify").on("click", function() {
            var no = $("#no");
            var noVal = no.val();
            self.location = "/member/modify?no=" + noVal;
        });
        $("#btnDelete").on("click", function() { 
            formObj.attr("action", "/member/delete");
            formObj.submit();
        });
        $("#btnList").on("click", function() { 
            self.location = "/member/list";
        });
    });
</script>