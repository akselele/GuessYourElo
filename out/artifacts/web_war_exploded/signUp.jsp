<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta charset="UTF-8">
    <title>Sign Up</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div id="container">
    <header>
        <h1><span>Guess Your Elo</span></h1>
        <nav>
            <ul>
                <li><a href="Servlet">Guess Your Elo</a></li>
                <li><a href="Servlet?command=overview">Person Overview</a></li>
                <li id="actual"><a href="Servlet?command=signUp">Sign up</a></li>
                <li><a href="Servlet?command=submit">Submit a clip</a></li>

            </ul>
        </nav>
        <h2>
            Sign Up
        </h2>

    </header>
    <main>
        <c:if test = "${not empty errors}">
            <div class="alert-danger">
                <ul>
                    <c:forEach items="${errors}" var="error">
                        <li>${error}</li>
                    </c:forEach>
                </ul>
            </div>
        </c:if>

        <form method="post" action="Servlet?command=addPerson" novalidate="novalidate">
            <!-- novalidate in order to be able to run tests correctly -->
            <p><label for="username">Username</label><input type="text" id="username" name="username"
                                                         required value ="${fn:escapeXml(usernamePreviousValue)}"></p>
            <p><label for="email">Email</label><input type="email" id="email" name="email" required value ="${fn:escapeXml(emailPreviousValue)}"></p>
            <p><label for="password">Password</label><input type="password" id="password" name="password"
                                                            required value ="${fn:escapeXml(PasswordPreviousValue)}"></p>
            <p><input type="submit" id="signUp" value="Sign Up"></p>

        </form>
    </main>
    <footer>
        Videos are not mine and are videos of the respecting players
    </footer>
</div>
</body>
</html>
