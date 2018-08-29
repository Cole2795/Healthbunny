/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Business.Response;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author d00185655
 */
public class ResponseDao extends Dao implements ResponseDaoInterface {

    public ResponseDao() {
        super();
    }

    public ResponseDao(String dbName) {
        super(dbName);
    }

    public ResponseDao(String dbName, String poolName) {
        super(dbName, poolName);
    }

    @Override
    public boolean addResponse(Response r) {
        Connection con = null;
        PreparedStatement ps = null;
        int rowsAffected = 0;

        try {
            con = this.getConnection();

            String query = "INSERT INTO `response`"
                    + "(`responseMessage`,`userId`,`messageid`,`responseDate`) "
                    + "VALUES (?,?,?,NOW())";
            ps = con.prepareStatement(query);
            ps.setString(1, r.getResponseMessage());
            ps.setInt(2, r.getUserId());
            ps.setInt(3, r.getMessageId());
            rowsAffected = ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("\tA problem occurred during the addResponse method:");
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
                System.err.println("A problem occurred when closing down the addResonse method:\n" + e.getMessage());
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
    public ArrayList<Response> getReponseById(int messageid) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Response> message = new ArrayList();
        try {
            con = getConnection();
            String query = "SELECT * FROM response WHERE messageid = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, messageid);
            rs = ps.executeQuery();
            while (rs.next()) {
                Response r = new Response();
                r.setMessageId(rs.getInt("messageid"));
                r.setResponseMessage(rs.getString("responseMessage"));
                r.setUserId(rs.getInt("userId"));
      
                r.setResponseDate(rs.getString("responseDate"));

                message.add(r);

            }
        } catch (SQLException e) {
            System.out.println("Exception occured in the getReponseById() method: " + e.getMessage());
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
                System.out.println("Exception occured in the finally section of the getReponseById() method: " + e.getMessage());

            }
        }
        return message;

    }
}
