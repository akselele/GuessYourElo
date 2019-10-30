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
                <li><a href="Servlet?command=signUp">Sign up</a></li>
                <li id="actual"><a href="Servlet?command=submit">Submit a clip</a></li>

            </ul>
        </nav>
        <h2>
            Submit a clip
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
<div align="center">
        <form method="post" action="Servlet?command=addGame" novalidate="novalidate">
            <!-- novalidate in order to be able to run tests correctly -->
            <p><label for="url">Plays.tv url</label><input type="text" id="url" name="url"
                                                            required value ="${fn:escapeXml(urlPreviousValue)}"></p>
            <select name="rank">
                <option id="bronze"  name="rank" value="bronze">Bronze</option>
                <option id="silver"  name="rank" value="silver">Silver</option>
                <option id="gold"  name="rank" value="gold">Gold</option>
                <option id="platinum"  name="rank" value="platinum">Platinum</option>
                <option id="diamond"  name="rank" value="diamond">Diamond</option>
                <option id="master"  name="rank" value="master">Master</option>
                <option id="grandmaster"  name="rank" value="grandmaster">Grandmaster</option>
                <option id="challenger"  name="rank" value="challenger">Challenger</option>
            </select>

            <button type="submit" id="addGame">Submit clip</button>

        </form>
</div>
    </main>
    <footer>
        Videos are not mine and are videos of the respecting players
    </footer>
</div>
</body>
</html>
