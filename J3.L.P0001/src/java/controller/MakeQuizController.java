package controller;

import dao.QuestionDB;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Question;

/**
 *
 * @author Administrator
 */
public class MakeQuizController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try {
            if (request.getParameter("submit") != null) {
                String result = "";
                String question = request.getParameter("question");
                String option1 = request.getParameter("option1");
                String option2 = request.getParameter("option2");
                String option3 = request.getParameter("option3");
                String option4 = request.getParameter("option4");
                String[] answer = request.getParameterValues("answer");

                boolean isOptionCorrect = !option1.isEmpty() && !option2.isEmpty() && !option3.isEmpty() && !option4.isEmpty();
                boolean isAnswerCorrect = answer != null && answer.length < 4;

                // begin: check fill fields and choose. If it is correct then insert to database.
                if (!question.isEmpty() && isOptionCorrect && isAnswerCorrect) {
                    QuestionDB qdb = new QuestionDB();
                    for (String ans : answer) {
                        result += ans;
                    }

                    qdb.insert(new Question(question, option1, option2, option3, option4, result.trim()));
                    request.setAttribute("sucsess", "Make a quiz is sucsessful!");
                } else {
                    request.setAttribute("error", "Fill all in the fields or do not choose all the answers!");
                }
                // end: check fill fields and choose. If it is correct then insert to database.
            }
            
            request.getRequestDispatcher("/view/main.jsp?action=make-quiz").forward(request, response);
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
