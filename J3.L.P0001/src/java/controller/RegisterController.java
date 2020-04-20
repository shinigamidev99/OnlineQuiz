/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AccountDB;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;

/**
 *
 * @author Administrator
 */
public class RegisterController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            if (request.getParameter("submit") != null) {
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                String userType = request.getParameter("role");
                String email = request.getParameter("email");
                String error = null;

                // begin: check it can register.
                // check fill field. If it is correct then check account is exit. 
                if (username.isEmpty() || password.isEmpty() || email.isEmpty() || userType.isEmpty()) {
                    error = "Please fill out all fields!";
                } else {
                    AccountDB adb = new AccountDB();
                    Account account = adb.selectByUsername(username);
                    boolean isExit = false;

                    if (account != null) {
                        isExit = true;
                    }

                    // begin: check if all is correct insert to database, else set error.
                    if (isExit) {
                        error = "Username is exit! Please enter again!";
                    } else {
                        adb.insert(new Account(username, password, userType.equals("1"), email));
                        request.setAttribute("sucsess", "Register is successful");
                    }
                    // end: check if all is correct insert to database, else set error
                }
                // end: check it can register. 

                if (error != null) {
                    request.setAttribute("error", error);
                }
            }

            request.getRequestDispatcher("/view/main.jsp?action=register").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("error", ex);
            request.getRequestDispatcher("handler-error").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
