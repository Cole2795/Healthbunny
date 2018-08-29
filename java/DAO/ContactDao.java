/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Business.Contact;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author campb
 */
public class ContactDao extends Dao implements ContactDaoInterface {
    
  public ContactDao(){
        super();
    }
    public ContactDao(String dbName){
        super(dbName);
    }
    public ContactDao(String dbName, String poolName){
        super(dbName, poolName);
    }
    @Override
    public ArrayList<Contact> getallMessage(){
         Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Contact> contact = new ArrayList();
        try{
            con = getConnection();
            String query = "Select * from contact";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                Contact m = new Contact();
                m.setContactID(rs.getInt("contactID"));
               m.setUserId(rs.getInt("userId"));
                m.setMessage(rs.getString("message"));
                
                contact.add(m);
                
                
                
            }
        } catch (SQLException e) {
           System.out.println("Exception occured in the getAllMessage() method: " + e.getMessage());
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
                 System.out.println("Exception occured in the finally section of the getAllMessage() method: " + e.getMessage());
          
            }
        }
        return contact;
    }
    @Override 
    public boolean addContact(Contact c){
         Connection con = null;
        PreparedStatement ps = null;
        int rowsAffected = 0;
        try{
            con = this.getConnection();
            String query = "INSERT INTO contact (userID, message) VALUES(?,?)";
            ps = con.prepareStatement(query);
                ps.setInt(1, c.getUserId());
                ps.setString(2, c.getMessage());
              
                rowsAffected = ps.executeUpdate();

        } catch (SQLException ex) {
             System.err.println("\tA problem occurred during the addContacts method:");
                System.err.println("\t"+ex.getMessage());
            } 
            finally 
            {
                try 
                {
                    if (ps != null) 
                    {
                        ps.close();
                    }
                    if (con != null) 
                    {
                        freeConnection(con);
                    }
                } 
                catch (SQLException e) 
                {
                    System.err.println("A problem occurred when closing down the Addcontacts method:\n" + e.getMessage());
                }
            }
            if(rowsAffected > 0){
                System.out.println("contact add");
            }else if(rowsAffected < 0){
                System.out.println("contact could not be added");
            }
            return true;
    }
    
}
