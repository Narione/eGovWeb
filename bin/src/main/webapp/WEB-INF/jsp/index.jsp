<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
    <title>Index</title>
</head>
<body>
인사말: ${greeting}<br />


<%--현재 로그인 사용자: <sec:authentication property="principal.authorities" />--%>
<!-- isAnonymous() : 로그인 안 한 상태  -->
<sec:authorize access="isAnonymous()">
    <p><a href="<c:url value="/login"/>">로그인</a></p>
</sec:authorize>
<!-- 로그인 한 상태 -->
<sec:authorize access="isAuthenticated()">
    <form action="/logout" method="post">
        <sec:authentication property="principal.username" />님 안녕하세요.
<%--        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">--%>
        <sec:csrfInput/>
        <p><button type="submit">로그아웃</button></p>
    </form>
</sec:authorize>

<p><a href="<c:url value="/register/step1"/>">[회원가입으로 이동]</a></p>
<p><a href="<c:url value="/board/list"/>">게시판</a></p>
</body>
</html>