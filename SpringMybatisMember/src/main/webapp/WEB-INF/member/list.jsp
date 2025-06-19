<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- 헤더 영역 --%>
<%@ include file="./header.jsp" %>
<!-- 화면 영역 -->
<main>
    <h2>게시판 리스트</h2>
    <a href="insertForm">게시판 입력</a>
    <table border="1">
        <tr>
            <th align="center" width="80">NO</th>
            <th align="center" width="200">ID</th>
            <th align="center" width="150">PW</th>
            <th align="center" width="150">NAME</th>
            <th align="center" width="180">REGDATE</th>
        </tr>
        <c:choose>
            <c:when test="${empty list}">
                <tr>
                    <td colspan="4">
                    List is empty.
                    </td>
                </tr>
            </c:when>
            <c:otherwise>
                <c:forEach var="member" items="${list}">
                <tr>
                    <td align="center">${member.no}</td>
                    <td align="left"><a href="/member/read?no=${member.no}">${member.id}</a></td>
                    <td align="left">${member.pwd}</td>
                    <td align="left">${member.name}</td>
                    <td align="center"><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${member.regDate}" /></td>
                    </tr>
                </c:forEach>
            </c:otherwise>
        </c:choose>
    </table>
</main>
<%-- footer 영역 --%>
<%@ include file="./footer.jsp" %>