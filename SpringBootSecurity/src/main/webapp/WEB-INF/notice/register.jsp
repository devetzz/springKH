<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%-- 헤더 영역 --%>
<%@ include file="./header.jsp" %>

<!-- 화면 영역 -->
<main>
    <h3>공지사항 등록 : 로그인한 관리자만 접근 가능</h3>
    <form action="/logout" method="post">
        <sec:csrfInput />
        <button>로그아웃</button>
    </form>
</main>
<%-- footer 영역 --%>
<%@ include file="./footer.jsp" %>
