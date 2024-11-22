<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>
<div class="w3-container w3-light-grey">

    <div class="w3-row-padding">
        <div class="w3-col m6" style="padding:128px 200px">
            <img class="w3-image w3-round-large" src="/images/mapache-pedro.gif" alt="Buildings" width="350"
                 height="200">
        </div>
        <div class="user-information">
            <h3>Statystyki</h3>
            <p>Ilość zarejestrowanych graczy: ${countPlayers}</p>
            <p>Rozegranych gier: ${countGame}</p>
            <sec:authorize access="isAuthenticated()">
                <p>Rozegrałeś gier: ${gamePlayer} </p>
                <p>Wygranych: ${win}</p>
                <p>Przegranych: ${lose}</p>
            </sec:authorize>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp"/>