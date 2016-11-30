package ecommerce.presentation.controllers;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class authentificationController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
                                            throws ServletException, IOException {
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/login.jsp");
        dispatcher.forward(request, response);
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
                                            throws ServletException, IOException {
        // Recuperating POST parameters
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        
        // [TEST-ONLY] Let it pass if user:pass == admin:admin
        if(login.equals("admin") && password.equals("admin")) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/cpanel.jsp");
            dispatcher.forward(request, response);
        }
    }

}
