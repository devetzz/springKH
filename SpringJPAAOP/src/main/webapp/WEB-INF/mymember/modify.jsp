<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%-- 헤더 영역 --%>
<%@ include file="./header.jsp" %>

<!-- 화면 영역 -->
<main>
    <h3>회원 정보 수정</h3>
    <form:form modelAttribute="mymember" action="modify">
        <form:hidden path="no" />
        <table>
            <tr>
                <td>userid</td>
                <td>
                    <form:input path="id" readonly="true" />
                </td>
                <td>
                    <font color="red">
                        <form:errors path="id" />
                    </font>
                </td>
            </tr>
            <tr>
                <td>Password</td>
                <td>
                    <form:password path="pw" />
                </td>
                <td>
                    <font color="red">
                        <form:errors path="pw" />
                    </font>
                </td>
            </tr>
            <tr>
                <td>username</td>
                <td>
                    <form:input path="name" />
                </td>
                <td>
                    <font color="red">
                        <form:errors path="name" />
                    </font>
                </td>
            </tr>
        </table>
    </form:form>
    <div> 
        <button type="submit" id="btnModify">수정</button> 
        <button type="submit" id="btnList">목록</button> 
    </div>
</main>
<%-- footer 영역 --%>
<%@ include file="./footer.jsp" %>
<script>
    $(document).ready(function() {
        var formObj = $("#mymember");
        $("#btnModify").on("click", function() { 
            formObj.attr("action", "/mymember/modify"); 
            formObj.attr("method", "post"); 
            formObj.submit();
        });
        $("#btnList").on("click", function() { 
            self.location = "/mymember/list";
        });
    });
</script>