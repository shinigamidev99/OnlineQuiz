package controller;

import dao.QuestionDB;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Question;

/**
 *
 * @author Administrator
 */
public class TakeQuizController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try {
            HttpSession session = request.getSession();
            QuestionDB qdb = new QuestionDB();

            Object timeStart = session.getAttribute("timeStart");
            String finish = request.getParameter("finish");
            String number = request.getParameter("number");

            // check list question in database 
            if (qdb.countQuestion() <= 0) {
                request.setAttribute("error", "Now, List question is empty. Please return again after!");
                request.setAttribute("questionEmpty", "Questions is empty");
            } else {
                int num = 0;
                String error = null;
                int maxSize = qdb.countQuestion();

                try {
                    num = Integer.parseInt(number);
                } catch (Exception ex) {
                    error = "Out of " + 1 + " to " + maxSize + "!";
                }

                // when user click start
                if (request.getParameter("start") != null) {
                    int timeOneQ = 0;
                    try {
                        timeOneQ = Integer.parseInt(new config.Config().getConfigValue("timeOneQ"));
                    }catch(Exception ex) {
                        error = "Error get time one question in config!";
                    }
                    
                    startQuiz(request, session, timeOneQ, num, error, maxSize, qdb);
                } else {
                    // when prepare start quiz
                    prepareQuiz(request, maxSize);
                }

                // when user refresh, click finish,
                // go to another page and return this page
                if (timeStart != null || finish != null) {
                    finishQuiz(request, timeStart, finish, session);
                }
            }

            request.getRequestDispatcher("/view/main.jsp?action=take-quiz").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("error", ex);
            request.getRequestDispatcher("handler-error").forward(request, response);
        }
    }

    private void prepareQuiz(HttpServletRequest request, int maxSize) throws Exception {
        request.setAttribute("max", maxSize);
    }

    // Process when start quiz
    private void startQuiz(HttpServletRequest request,
            HttpSession session, int timeOneQ, int num, String error, int maxSize, QuestionDB qdb) throws Exception {

        if (error == null) {
            // begin: check num input in range. 
            //        If is correct then random question and set atribute
            if (num > maxSize || num < 1) {
                error = "Out of " + 1 + " to " + maxSize + "!";
            } else {
                List<Question> list = qdb.selectRandom(num);
                HashMap<Integer, Question> questions = new HashMap<>();

                for (int i = 0; i < num; i++) {
                    questions.put(i, list.get(i));
                }

                int timeRemaining = timeOneQ * num;

                session.setAttribute("questions", questions);
                session.setAttribute("timeStart", new Date());
                session.setAttribute("timeRemaining", timeRemaining);
                session.setAttribute("totalTime", timeRemaining);
            }
            // end: check num input in range. 
            //      If is correct then random question and set atribute
        }

        if (error != null) {
            request.setAttribute("error", error);
        }
    }

    // Process when quiz finish or in process do quiz
    private void finishQuiz(HttpServletRequest request, Object time, String finish,
            HttpSession session) throws Exception {
        Date start = (Date) time;
        Date end = new Date();
        int totalTime = (int) session.getAttribute("totalTime");
        int timeCurrent = (int) Math.floor((end.getTime() - start.getTime()) * 0.001);

        // begin: check calculator for user or reject
        if (timeCurrent >= totalTime || finish != null) {
            String conclude;

            if (timeCurrent > totalTime) {
                conclude = "Time exceeded! You submit too late.";
            } else {
                double result = result(request, session);

                double percent = (result / 10) * 100;
                DecimalFormat f = new DecimalFormat("#.##");
                conclude = f.format(result) + " (" + f.format(percent) + "%)" + " - " + (result > 5 ? "Passed" : "Failed");
            }

            request.setAttribute("finishQuiz", conclude);
            session.removeAttribute("timeStart");
            session.removeAttribute("questions");
            session.removeAttribute("timeRemaining");
            session.removeAttribute("totalTime");
        } else {
            // user have time and not finish return time remaining for user 
            int timeRemaining = totalTime - timeCurrent;
            session.setAttribute("timeRemaining", timeRemaining);
        }
        // end: check can calculator for user or reject
    }

    // Return result
    private double result(HttpServletRequest request, HttpSession session) {
        double result = 0;
        HashMap<Integer, Question> questions = (HashMap<Integer, Question>) session.getAttribute("questions");
        double pointOneQ = (double) 10 / questions.size();

        for (Map.Entry<Integer, Question> entry : questions.entrySet()) {
            Integer key = entry.getKey();
            Question value = entry.getValue();

            String[] answsers = request.getParameterValues("answser" + key);

            String ans = "";

            if (answsers != null) {
                for (String answser : answsers) {
                    ans += answser;
                }

                if (ans.equals(value.getAnswers())) {
                    result += pointOneQ;
                }
            }
        }

        return result;
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
