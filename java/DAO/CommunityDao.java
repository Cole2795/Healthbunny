/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Business.Community;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Ayesha Khan
 */
public class CommunityDao extends Dao implements CommunityDaoInterface {

    public CommunityDao() {
        super();
    }

    public CommunityDao(String dbName) {
        super(dbName);
    }

    public CommunityDao(String dbName, String poolName) {
        super(dbName, poolName);
    }

    @Override
    public ArrayList<Community> listOfCom() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Community> community = new ArrayList();
        try {
            con = getConnection();
            String query = "Select comId, comName FROM commmunity";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Community c = new Community();
                c.setComId(rs.getInt("comId"));
                c.setComName(rs.getString("comName"));
                community.add(c);

            }
        } catch (SQLException e) {
            System.out.println("Exception occured in the listOfCom() method: " + e.getMessage());
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
                System.out.println("Exception occured in the finally section of the listOfCom() method: " + e.getMessage());

            }
        }
        return community;
    }

}
