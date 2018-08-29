/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Business.Topics;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Ayesha Khan
 */
public class TopicDao extends Dao implements TopicDaoInterface {

    public TopicDao() {
        super();
    }

    public TopicDao(String dbName) {
        super(dbName);
    }

    public TopicDao(String dbName, String poolName) {
        super(dbName, poolName);
    }

    @Override
    public ArrayList<Topics> getAllTopics(int communityId) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Topics> topics = new ArrayList();
        try {
            con = getConnection();
            String query = "Select topicId, topicName, Image FROM topic WHERE comId = " +communityId;
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Topics c = new Topics();
                c.setTopicId(rs.getInt("topicId"));
                c.setTopicName(rs.getString("topicName"));
                c.setImage(rs.getString("Image"));
                topics.add(c);

            }
        } catch (SQLException e) {
            System.out.println("Exception occured in the listOfTopics() method: " + e.getMessage());
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
                System.out.println("Exception occured in the finally section of the listOfTopics() method: " + e.getMessage());

            }
        }
        return topics;
    }
    @Override
    public ArrayList<Topics> getTopicbytopicid(int topicId){
        ArrayList<Topics> med = new ArrayList();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = getConnection();
            String query = "Select * from topic WHERE topicId = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, topicId);
            rs = ps.executeQuery();
            while(rs.next()){
                Topics m = new Topics();
                m.setTopicId(rs.getInt("topicId"));
                m.setTopicName(rs.getString("topicName"));
                m.setComId(rs.getInt("comId"));
                m.setImage(rs.getString("Image"));
                med.add(m);
            }
        } catch (SQLException ex) {
                System.out.println("an exception in the getTopicbytopicid");
         }
          finally
        {
            // Close resultset
            try{
                if(rs != null)
                {
                    rs.close();
                }
            }
            catch(SQLException e)
            {
                System.out.println("An exception occurred when closing the ResultSet of the getTopicbytopicid(): " + e.getMessage());
            }
            // Close prepared statement
            try{
                if(ps!= null)
                {
                    ps.close();
                }
            }
            catch(SQLException e)
            {
                System.out.println("An exception occurred when closing the PreparedStatement of the getTopicbytopicid(): " + e.getMessage());
            }
            // Close connection
            freeConnection(con);
        }
        
        // Return results
        return med;
    }
    @Override
    public ArrayList<Topics> getallTopicList(){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Topics> med = new ArrayList();
        try{
            con = getConnection();
            String query = "Select * from topic";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                Topics m = new Topics();
                m.setTopicId(rs.getInt("topicId"));
               m.setTopicName(rs.getString("topicName"));
                m.setComId(rs.getInt("comId"));
                m.setImage(rs.getString("Image"));
               
                med.add(m);
                
                
                
            }
        } catch (SQLException e) {
           System.out.println("Exception occured in the getallTopicList() method: " + e.getMessage());
       } finally {
            try{
                if(rs !=null){
                    rs.close();
                }
                if(ps != null){
                    ps.close();
                }
                if(con != null){
                    freeConnection(con);
                }
            }catch(SQLException e){
                 System.out.println("Exception occured in the finally section of the getallTopicList() method: " + e.getMessage());
          
            }
        }
        return med;
    }//end list of medicine

}
