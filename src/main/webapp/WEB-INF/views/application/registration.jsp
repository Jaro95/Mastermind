<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 22.11.2024
  Time: 18:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>
<div class="w3-display-container w3-light-grey main-height" id="contact">
    <p class="w3-center w3-jumbo cantact-info">Registration</p>
    <div class="w3-center cantact-info">

        <form:form method="post" modelAttribute="registrationRequest">
            <div class="form-group">
                <form:input path="email" type="email" placeholder="Email"/>
                <form:errors path="email" cssClass="alert alert-error"/>
            </div>

            <div class="form-group">
                <form:input type="password" path="password" placeholder="Hasło"/>
                <h3><form:errors path="password" cssClass="alert alert-error"/></h3>
            </div>
            <div class="form-group">
                <form:input type="password" path="repeatPassword" placeholder="Powtórz hasło"/>
                <h3><form:errors path="repeatPassword" cssClass="alert alert-error"/></h3>
            </div>

            <div class="form-group form-group--buttons">
                <button class="btn" type="submit">Crate account</button>
            </div>
        </form:form>
    </div>
</div>
<jsp:include page="footer.jsp"/>
