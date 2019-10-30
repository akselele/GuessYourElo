package controller;

import db.DbException;
import domain.model.Game;
import domain.model.Person;
import domain.model.ShopService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
private ShopService shopService = new ShopService();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String command = request.getParameter("command");
        String destination;
        switch(command == null?"":command){
            default:
                    destination = showHome(request,response);
                break;
            case "addGame":
                destination = addGame(request,response);
                break;
            case "overview":
                destination = showOverview(request,response);
                break;
            case "addPerson":
                destination = addPerson(request,response);
                break;
            case "signUp":
                destination = showSignUp(request,response);
                break;
            case "successSignUp":
                destination = showSuccessSignUp(request,response);
                break;
            case "guessElo":
                destination = guessElo(request,response);
                break;
            case "submit":
                destination = showSubmit(request,response);
                break;
        }
        request.getRequestDispatcher(destination).forward(request,response);
    }

    private String showSubmit(HttpServletRequest request, HttpServletResponse response) {
        return "submit.jsp";
    }

    private String addGame(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<String> errors = new ArrayList<>();

        Game game = new Game();
        setUrl(game, request, errors);
        String rank =request.getParameter("rank");

        if(errors.size() == 0){
            try{
                shopService.add(game, rank);
                return "successPages/submitSuccess.jsp";
            } catch(IllegalArgumentException exc){
                request.setAttribute("errors", exc.getMessage());
                return "submit.jsp";
            }
        }
        else{
            request.setAttribute("errors", errors);
            return "submit.jsp";
        }
    }

    private void setUrl(Game game, HttpServletRequest request, ArrayList<String> errors) {
        String url =request.getParameter("url");
        try{
            game.setUrl(url);
            request.setAttribute("urlClass", "has-succes");
            request.setAttribute("urlPreviousValue", url);
        }catch(IllegalArgumentException | StringIndexOutOfBoundsException exc){
            errors.add("There was an error adding your clip. Maybe it wasn't a plays.tv clip!");
            request.setAttribute("urlClass", "has-error");
        }
    }

    private String showOverview(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("persons",shopService.getAll());
        return "personoverview.jsp";
    }

    private String showSignUp(HttpServletRequest request, HttpServletResponse response) {
        return "signUp.jsp";
    }

    //TODO
    private String showSuccessSignUp(HttpServletRequest request, HttpServletResponse response) {
        return "successPages/signUpSuccess.jsp";
    }

    private String guessElo(HttpServletRequest request, HttpServletResponse response) {
        String rank =request.getParameter("rank");
        String url = request.getParameter("rankUrl");
        url = getEmbedUrl(url);
        if(shopService.checkRank(rank,url)){
            request.setAttribute("right","You got this one right!");
            return showHome(request,response);
        }
        request.setAttribute("wrong","You got this one wrong!");
        return showHome(request,response);
    }

    private String showHome(HttpServletRequest request, HttpServletResponse response) {
        String url = "https://plays.tv/embed/" + getEmbedUrl(shopService.getRandom());
        request.setAttribute("url",url);
        return "index.jsp";
    }

    private String getEmbedUrl(String string){
        return string.substring(23,41);
    }

    private String addPerson(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<String> errors = new ArrayList<>();

        Person person = new Person();
        setUsername(person, request, errors);
        setEmail(person, request, errors);
        setPassword(person, request, errors);

        if(errors.size() == 0){
            try{
                shopService.add(person);
                return showSuccessSignUp(request,response);
            } catch(IllegalArgumentException exc){
                request.setAttribute("errors", exc.getMessage());
                return "signUp.jsp";
            }
        }
        else{
            request.setAttribute("errors", errors);
            return "signUp.jsp";
        }
    }

    private void setEmail(Person person, HttpServletRequest request, ArrayList<String> errors){
        String email =request.getParameter("email");
        try{
            person.setEmail(email);
            request.setAttribute("emailClass", "has-succes");
            request.setAttribute("emailPreviousValue", email);
        }catch(IllegalArgumentException exc){
            errors.add(exc.getMessage());
            request.setAttribute("emailClass", "has-error");
        }
    }

    private void setUsername(Person person, HttpServletRequest request, ArrayList<String> errors){
        String username =request.getParameter("username");
        try{
            person.setUsername(username);
            request.setAttribute("usernameClass", "has-succes");
            request.setAttribute("usernamePreviousValue", username);
        }catch(IllegalArgumentException exc){
            errors.add(exc.getMessage());
            request.setAttribute("usernameClass", "has-error");
        }
    }

    private void setPassword(Person person, HttpServletRequest request, ArrayList<String> errors) {
        String password =request.getParameter("password");
        try{
            person.setHashedPassword(password);
            request.setAttribute("PasswordClass", "has-succes");
            request.setAttribute("PasswordPreviousValue", password);
        }catch(IllegalArgumentException exc){
            errors.add(exc.getMessage());
            request.setAttribute("PasswordClass", "has-error");
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            throw new DbException(e.getMessage(),e);
        }
    }


}
