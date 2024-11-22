<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 22.11.2024
  Time: 01:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>
<div class="w3-light-grey">
    <p class="w3-center w3-jumbo cantact-info">Welcome to game mastermind</p>
    <div class="w3-center contact-info">
        <img class="w3-image w3-round-large" src="/images/mapache-pedro.gif" alt="Buildings" width="350"
             height="200">
    </div>
    <div class="w3-center contact-info">
            <p>Click the button to start the game: </p>

            <a href="/mastermind/game" class="w3-button w3-black" >Start</a>
            </p>
    </div>
</div>

<jsp:include page="footer.jsp"/>