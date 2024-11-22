<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 22.11.2024
  Time: 01:27
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ADMIN PANEL</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="/css/styles.css"/>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.min.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/action.js"></script>
</head>
<body>

<!-- Navbar (sit on top) -->

<div class="w3-top">
    <div class="w3-bar w3-white w3-card" id="myNavbar">
        <a href="/mastermind" class="w3-bar-item w3-button w3-wide">MASTERMIND</a>
        <!-- Right-sided navbar links -->
        <div class="w3-right w3-hide-small">
            <a href="/mastermind" class="w3-bar-item w3-button"><i class="fa fa-home"></i> Home</a>
            <a href="/mastermind/game" class="w3-bar-item w3-button"><i class="fa fa-hand-holding-heart"></i>
                Game</a>
            <a href="/mastermind/statistic" class="w3-bar-item w3-button"><i class="fa fa-users-gear"></i> Statistics</a>
            <sec:authorize access="isAnonymous()">
                <a href="/mastermind/login" class="w3-bar-item w3-button"><i class="fa fa-jedi-order"></i> Login</a>
                <a href="/mastermind/registration" class="w3-bar-item w3-button"><i class="fa fa-fort-awesome"></i>
                    Registration</a>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
                <a href="/mastermind/logout" class="w3-bar-item w3-button"><i class="fa fa-pencil"></i> Logout</a>
            </sec:authorize>
        </div>
    </div>
</div>



