/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Business.Messages;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Ayesha Khan
 */
public class MessageDao extends Dao implements MessageDaoInterface {

    public MessageDao() {
        super();
    }

    public MessageDao(String dbName) {
        super(dbName);
    }

    public MessageDao(String dbName, String poolName) {
        super(dbName, poolName);
    }

    @Override
    public boolean addMessages(Messages m) {
        Connection con = null;
        PreparedStatement ps = null;
        int rowsAffected = 0;

        try {
            con = this.getConnection();

            String query = "INSERT INTO `messages`"
                    + "(`messageTitle`, `message`, `messageDate`,`userId`,`topicId`,`Image`) "
                    + "VALUES (?,?,NOW(),?,?,'logo.png')";
            ps = con.prepareStatement(query);
            ps.setString(1, m.getMessageTitle());
            ps.setString(2, m.getMessage());
            ps.setInt(3, m.getUserId());
            ps.setInt(4, m.getTopicId());
            rowsAffected = ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("\tA problem occurred during the addMessage method:");
            System.err.println("\t" + e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.err.println("A problem occurred when closing down the addMessage method:\n" + e.getMessage());
            }
        }
        if (rowsAffected > 0) {
            System.out.println("message add");
        } else if (rowsAffected < 0) {
            System.out.println("message could not be added");
        }
        return true;

    }

    @Override
    public ArrayList<Messages> getAllMessages() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Messages> message = new ArrayList();
        try {
            con = getConnection();
            String query = "SELECT * FROM messages";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Messages m = new Messages();
                m.setMessageId(rs.getInt("messageId"));
                m.setMessageTitle(rs.getString("messageTitle"));
                m.setMessage(rs.getString("message"));
                m.setMessageDate(rs.getString("messageDate"));
                m.setUserId(rs.getInt("userId"));
                m.setTopicId(rs.getInt("topicId"));
                m.setImage(rs.getString("Image"));
                message.add(m);

            }
        } catch (SQLException e) {
            System.out.println("Exception occured in the getAllMessages() method: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the getAllMessages() method: " + e.getMessage());

            }
        }
        return message;

    }

    @Override
    public ArrayList<Messages> getMessagesById(int topicId) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Messages> message = new ArrayList();
        try {
            con = getConnection();
            String query = "SELECT * FROM messages WHERE topicId = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, topicId);
            rs = ps.executeQuery();
            while (rs.next()) {
                Messages m = new Messages();
                m.setMessageId(rs.getInt("messageId"));
                m.setMessageTitle(rs.getString("messageTitle"));
                m.setMessage(rs.getString("message"));
                m.setMessageDate(rs.getString("messageDate"));
                m.setUserId(rs.getInt("userId"));
                m.setTopicId(rs.getInt("topicId"));
                m.setImage(rs.getString("Image"));
                message.add(m);

            }
        } catch (SQLException e) {
            System.out.println("Exception occured in the getMessagesById() method: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the getAllMedicineList() method: " + e.getMessage());

            }
        }
        return message;

    }
}
