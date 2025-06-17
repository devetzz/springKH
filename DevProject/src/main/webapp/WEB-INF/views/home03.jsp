<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Locale" %>

<%-- 컨트롤러 영역 --%>
<%
// 지역 객체 참조 변수
Date date = new Date();
DateFormat df = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, Locale.KOREA);
String serverTime = df.format(date);
%>

<%-- 화면 영역 --%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html" charset=UTF-8>
        <!-- <meta charset="utf-8" /> -->
        <title>title</title>
    </head>
    <body>
        <header>
            <h1>Home03 Header 영역입니다.</h1>
        </header>
        <hr>
        <main>
            <h1>Home03 page 입니다.</h1>
            <h2> 현재시각 <%= serverTime %> </h2>
        </main>
        <hr>
        <footer>
            <h1>Home03 footer 영역입니다.</h1>
        </footer>
    </body>
    
</html>