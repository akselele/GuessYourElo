<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Guess Your Elo</title>
    <link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body>
<div id="container">
    <header>
        <h1>
            <span>Guess Your Elo</span>
        </h1>
        <nav>
            <ul>
                <li><a href="Servlet">Guess Your Elo</a></li>
                <li><a href="Servlet?command=overview">Person Overview</a></li>
                <li><a href="Servlet?command=signUp">Sign up</a></li>
                <li><a href="Servlet?command=submit">Submit a clip</a></li>
            </ul>
        </nav>

    </header>
    <main>
        <p>Your play has successfully been submitted!</p>
        <a href="Servlet">Return to guess page</a>
    </main>
    <footer> Videos are not mine and are videos of the respecting players </footer>
</div>
</body>
</html>