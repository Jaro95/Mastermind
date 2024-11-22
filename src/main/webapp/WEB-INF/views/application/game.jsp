<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 22.11.2024
  Time: 11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>

<div class="game-container">
    <h1>Mastermind</h1>
    <p>Try to guess the secret code!</p>
    <p>You have 15 attempts</p>
    <c:if test="${not empty error}">
        <div class="error">${error}</div>
    </c:if>
    <c:if test="${not empty winner}">
        <div class="results" id="results">
            <h2>${winner}</h2>
            <h2>${secretCode}</h2>
        </div>
    </c:if>
    <c:if test="${not empty lose}">
        <div class="results" id="results">
            <h2>${lose}</h2>
            <h2>${secretCode}</h2>
        </div>
    </c:if>

    <div class="results" id="results">
        <ol>
            <c:forEach var="attempt" items="${information}">
                <li>Code: ${attempt.key} ${attempt.value}</li>
            </c:forEach>
        </ol>
    </div>
    <form:form method="post" modelAttribute="mastermindGame">
        <form:input path="secretCode" type="hidden"/>
        <form:input path="attemptsCount" type="hidden"/>
        <c:if test="${empty winner && empty lose}">
            <div class="guess-input">
                <p>Attempt: ${attemptsCount + 1} <input type="number" id="guess" name="guess"
                                                        placeholder="Enter your guess (e.g., 1234)" maxlength="4"
                                                        oninput="this.value = this.value.replace(/[^0-9]/g, '').slice(0, 4)">
                </p>
            </div>
        </c:if>
        <div class="buttons">
            <c:if test="${empty winner && empty lose}">
                <button class="submit-button" id="submit">Submit Guess</button>
            </c:if>
            <a href="${pageContext.request.contextPath}/mastermind/game/reset" class="reset-button" id="reset">Reset
                Game</a>
        </div>
    </form:form>

</div>

<jsp:include page="footer.jsp"/>
