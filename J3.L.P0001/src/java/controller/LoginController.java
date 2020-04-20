package controller;

import dao.AccountDB;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;

/**
 *
 * @author Administrator
 */
public class LoginController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            HttpSession session = request.getSession();

            // begin: check account and text box when user submit
            if (request.getParameter("submit") != null) {
                if (username.isEmpty() || password.isEmpty()) {
                    request.setAttribute("error", "Please fill all text box!");
                } else {
                    handleAccountLogin(request, session, username, password);
                }
            }
            // end: check account and text box when user submit

            request.getRequestDispatcher("home").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("error", ex);
            request.getRequestDispatcher("handler-error").forward(request, response);
        }
    }

    // check account is correct, if wrong set a attribute error
    private void handleAccountLogin(HttpServletRequest request, HttpSession session, String username, String password) throws Exception {
        boolean isCorrect = false;
        AccountDB adb = new AccountDB();
        Account account = adb.selectByUsername(username);

        if (account != null && account.getPassword().equals(password)) {
            session.setAttribute("login", account);
            isCorrect = true;
        }

        if (!isCorrect) {
            request.setAttribute("error", "Username or password is not correct!");
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
