package controller;

import bean.PagingBean;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
public class ManageQuizController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            PagingBean bean = new PagingBean();
            int pages = bean.getPages();

            String error = null;
            String page = request.getParameter("page");

            // begin: check page if it is not correct set atribute error
            if (page == null) {
                error = "Page not found!";
            } else {
                int p = 0;

                try {
                    p = Integer.parseInt(page);
                } catch (Exception ex) {
                    error = "Page not found!";
                }

                if (p > pages || p <= 0) {
                    error = "Page not found!";
                }
            }

            if (error != null) {
                request.setAttribute("error", error);
            }
            // end: check page if it is not correct set atribute error

            request.getRequestDispatcher("/view/main.jsp?action=manage-quiz").forward(request, response);
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
