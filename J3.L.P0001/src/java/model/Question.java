/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.text.SimpleDateFormat;
/**
 *
 * @author Administrator
 */
public class Question {

    private int question_id;
    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String answers;
    private Date dateCreated;

    public Question() {
    }

    public Question(int question_id, String question, String option1, String option2, String option3, String option4, String answers, Date dateCreated) {
        this.question_id = question_id;
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.answers = answers;
        this.dateCreated = dateCreated;
    }

    public Question(String question, String option1, String option2, String option3, String option4, String answers) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.answers = answers;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public String getAnswers() {
        return answers.trim();
    }

    public void setAnswers(String answers) {
        this.answers = answers;
    }

    public String getDateFormat() {
        return new SimpleDateFormat("dd-MMM-yyy").format(this.dateCreated);
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return "Question{" + "question_id=" + question_id + ", question=" + question + ", option1=" + option1 + ", option2=" + option2 + ", option3=" + option3 + ", option4=" + option4 + ", answers=" + answers + ", dateCreated=" + dateCreated + '}';
    }
    
}
