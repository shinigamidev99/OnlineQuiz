/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.QuestionDB;
import java.io.Serializable;
import java.util.List;
import model.Question;

/**
 *
 * @author Administrator
 */
public class PagingBean implements Serializable {

    private int page, size;
    private QuestionDB qdb;

    public PagingBean() {
        size = 5;
        page = 1;
        qdb = new QuestionDB();
    }

    public void setPage(int page) {
        this.page = page;
    }
    
    public int getPage() {
        return page;
    }

    public int getSize() {
        return size;
    }

    // get number pages
    public int getPages() throws Exception {
        int rows = qdb.countQuestion();
        return (int) Math.ceil(rows * 1.0 / size);
    }

    // get list question
    public List<Question> getQuestions() throws Exception {
        int from = (page - 1) * size + 1;
        int to = page * size;
        List<Question> p = qdb.questionFromTo(from, to);
        return p;
    }
}
