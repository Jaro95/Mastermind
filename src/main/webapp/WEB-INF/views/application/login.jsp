<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 22.11.2024
  Time: 18:20
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>
<div class="w3-display-container w3-light-grey main-height" id="contact">
    <p class="w3-center w3-jumbo cantact-info">Login</p>
    <c:if test="${not empty message}">
        <div class="alert alert-success">
                ${message}
        </div>
    </c:if>
    <c:if test="${not empty messageError}">
        <div class="alert alert-error">
                ${messageError}
        </div>
    </c:if>
    <div class="w3-center cantact-info">
        <form method="post">

            <div class="form-group">
                <input type="email" name="username" placeholder="Email">
            </div>
            <div class="form-group">
                <input type="password" name="password" placeholder="Password">
                <a href="/mastermind/recover" class="btn btn--small btn--without-border reset-password">Recover password</a>
            </div>

            <div class="form-group form-group--buttons">
                <a href="/mastermind/registration" class="btn btn--without-border">Registration</a>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <button class="w3-button w3-black" type="submit">Login
                </button>
            </div>
        </form>
    </div>
</div>
<jsp:include page="footer.jsp"/>
