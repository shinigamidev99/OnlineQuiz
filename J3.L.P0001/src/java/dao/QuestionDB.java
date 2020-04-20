/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Question;

/**
 *
 * @author Administrator
 */
public class QuestionDB {

    public List<Question> selectRandom(int top) throws Exception {
        List<Question> list = new ArrayList<>();
        DBContext context = new DBContext();
        String sql = "SELECT Top (?) [question_id]  ,[question],[option_1], [option_2]\n"
                + ",[option_3]\n"
                + ",[option_4]\n"
                + ",[answers]\n"
                + ",[date_created]\n"
                + "FROM Question\n"
                + "ORDER BY NEWID()";

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = context.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, top);
            rs = ps.executeQuery();
            while (rs.next()) {
                Question question = new Question();
                question.setQuestion_id(rs.getInt("question_id"));
                question.setQuestion(rs.getString("question"));
                question.setOption1(rs.getString("option_1"));
                question.setOption2(rs.getString("option_2"));
                question.setOption3(rs.getString("option_3"));
                question.setOption4(rs.getString("option_4"));
                question.setAnswers(rs.getString("answers"));
                question.setDateCreated(rs.getDate("date_created"));
                list.add(question);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            context.closeConnection(rs, ps, conn);
        }

        return list;
    }

    public int insert(Question question) throws Exception {
        DBContext context = new DBContext();
        int update = 0;
        String sql = "INSERT INTO [dbo].[Question]\n"
                + "           ([question]\n"
                + "           ,[option_1]\n"
                + "           ,[option_2]\n"
                + "           ,[option_3]\n"
                + "           ,[option_4]\n"
                + "           ,[answers]\n"
                + "           ,[date_created])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,GETDATE())";

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = context.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, question.getQuestion());
            ps.setString(2, question.getOption1());
            ps.setString(3, question.getOption2());
            ps.setString(4, question.getOption3());
            ps.setString(5, question.getOption4());
            ps.setString(6, question.getAnswers());
            update = ps.executeUpdate();
        } catch (Exception ex) {
            throw ex;
        } finally {
            context.closeConnection(null, ps, conn);
        }

        return update;
    }

    public int delete(int questionId) throws Exception {
        DBContext context = new DBContext();
        int update = 0;
        String sql = "DELETE FROM [dbo].[Question]\n"
                + "      WHERE question_id = ?";

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = context.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, questionId);
            update = ps.executeUpdate();
        } catch (Exception ex) {
            throw ex;
        } finally {
            context.closeConnection(null, ps, conn);
        }

        return update;
    }

    public int countQuestion() throws Exception {
        DBContext context = new DBContext();
        String sql = "SELECT COUNT(*)\n"
                + "  FROM [OnlineQuiz].[dbo].[Question]";

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int rows = 0;

        try {
            conn = context.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                rows = rs.getInt(1);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            context.closeConnection(rs, ps, conn);
        }
        return rows;
    }

    public List<Question> questionFromTo(int from, int to) throws Exception {
        DBContext context = new DBContext();
        String sql = "SELECT [question_id]\n"
                + "      ,[question]\n"
                + "      ,[option_1]\n"
                + "      ,[option_2]\n"
                + "      ,[option_3]\n"
                + "      ,[option_4]\n"
                + "      ,[answers]\n"
                + "      ,[date_created]\n"
                + "  FROM (\n"
                + "		SELECT *, ROW_NUMBER() OVER (ORDER BY question_id) as row\n"
                + "		FROM [OnlineQuiz].[dbo].[Question]\n"
                + "  ) a WHERE a.row >= ? AND a.row <= ?";

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Question> p = new ArrayList<>();

        try {
            conn = context.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, from);
            ps.setInt(2, to);
            rs = ps.executeQuery();
            while (rs.next()) {
                Question question = new Question();
                question.setQuestion_id(rs.getInt("question_id"));
                question.setQuestion(rs.getString("question"));
                question.setOption1(rs.getString("option_1"));
                question.setOption2(rs.getString("option_2"));
                question.setOption3(rs.getString("option_3"));
                question.setOption4(rs.getString("option_4"));
                question.setAnswers(rs.getString("answers"));
                question.setDateCreated(rs.getDate("date_created"));
                p.add(question);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            context.closeConnection(rs, ps, conn);
        }

        return p;
    }
}
