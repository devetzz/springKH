<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- 헤더 영역 --%>
<%@ include file="./header.jsp" %>

<!-- 화면 영역 -->
<main>
    <div>
        <h2>서버에 문제가 발생했습니다.</h2>
        <h2>${message}</h2>
        <a href="/board/list">List</a>

    </div>
</main>
<%-- footer 영역 --%>
<%@ include file="./footer.jsp" %>
