<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%-- 헤더 영역 --%>
<%@ include file="./header.jsp" %>

<!-- 화면 영역 -->
<main>
    <h3>회원 상세 정보</h3>
    <form:form modelAttribute="mymember">
        <form:hidden path="no" />
        <table>
            <tr>
                <td>userid</td>
                <td>
                    <form:input path="id" readonly="true" />
                </td>
            </tr>
            <tr>
                <td>username</td>
                <td>
                    <form:input path="name" readonly="true" />
                </td>
            </tr>
        </table>
    </form:form>
    <div>
        <button type="submit" id="btnModify">수정</button>
        <button type="submit" id="btnRemove">삭제</button>
        <button type="submit" id="btnList">목록</button>
    </div>
</main>
<%-- footer 영역 --%>
<%@ include file="./footer.jsp" %>
<script>
    $(document).ready(function() {
        var formObj = $("#mymember"); 
        console.log(formObj);
        $("#btnModify").on("click", function() { 
            formObj.attr("action", "/mymember/modify"); 
            formObj.attr("method", "get"); formObj.submit();
        });
        $("#btnRemove").on("click", function() { 
            formObj.attr("action", "/mymember/remove"); 
            formObj.submit();
        });
        $("#btnList").on("click", function() { 
            self.location = "/mymember/list";
        });
    });
</script>