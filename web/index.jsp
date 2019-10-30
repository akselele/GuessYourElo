<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <title>Guess Your Elo</title>
  <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div id="container">
  <header>
    <h1>
      <span>Guess Your Elo</span>
    </h1>
    <nav>
      <ul>
        <li id="actual"><a href="Servlet">Guess Your Elo</a></li>
        <li><a href="Servlet?command=overview">Person Overview</a></li>
        <li><a href="Servlet?command=signUp">Sign up</a></li>
        <li><a href="Servlet?command=submit">Submit a clip</a></li>
      </ul>
    </nav>

  </header>
  <main>
    <c:if test = "${not empty wrong}">
      <div class="alert-danger">
        <ul>
            <li>${wrong}</li>
        </ul>
      </div>
    </c:if>

    <c:if test = "${not empty right}">
      <div class="alert-safety">
        <ul>
          <li>${right}</li>
        </ul>
      </div>
    </c:if>
    <form method="post" action="Servlet?command=guessElo&rankUrl=${url}" novalidate="novalidate">
    <p align="center"><iframe id="video" width="560" height="315" src="${url}" frameborder="0" allowfullscreen>
    </iframe></p>
      <div align="center">
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
      <button align="center" id="submit" type="submit" id="guessElo">Guess Rank</button>
      </div>
    </form>
  </main>
  <footer> Videos are not mine and are videos of the respecting players </footer>
</div>
</body>
</html>