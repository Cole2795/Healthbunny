package DAO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Business.Pills;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author campb
 */
public class PilDao extends Dao implements PilDAOInterface {
    
    public PilDao(){
        super();
    }
    public PilDao(String dbName){
        super(dbName);
    }
    public PilDao(String dbName, String poolName){
        super(dbName, poolName);
    }
    //display list of condition
    @Override
    public ArrayList<Pills> getallList(){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Pills> cond = new ArrayList();
        try{
            con = getConnection();
            String query = "Select * from pill_identifier";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                Pills c = new Pills();
                c.setPillidentifier(rs.getInt("pill_identifierID"));
                c.setShape(rs.getString("shape"));
                c.setImage(rs.getString("Image"));
                cond.add(c);
                
                
                
            }
        } catch (SQLException e) {
           System.out.println("Exception occured in the getallList() method: " + e.getMessage());
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
                 System.out.println("Exception occured in the finally section of the getallList() method: " + e.getMessage());
          
            }
        }
        return cond;
    }//end list of bodycategory
    @Override
   public boolean addpill(Pills m){
        Connection con = null;
        PreparedStatement ps = null;
        int rowsAffected = 0;
        try{
            con = this.getConnection();
            String query = "INSERT INTO pill_identifier VALUES(?,?,?)";
            ps = con.prepareStatement(query);
               ps.setInt(1, m.getpillidentifierID());
                ps.setString(2, m.getShape());
               ps.setString(3, m.getImage() );
                rowsAffected = ps.executeUpdate();

        } catch (SQLException ex) {
             System.err.println("\tA problem occurred during the addpill method:");
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
                    System.err.println("A problem occurred when closing down the addpill method:\n" + e.getMessage());
                }
            }
            if(rowsAffected > 0){
                System.out.println("pill add");
            }else if(rowsAffected < 0){
                System.out.println("pill could not be added");
            }
            return true;
    }
   @Override
   public int RemovePill(int pill){
        
         Connection con = null;
         PreparedStatement ps = null;
         int rowsAffected = 0;
         try{
                  
                con = this.getConnection();
                String query = "DELETE FROM pill_identifier WHERE pill_identifierID = ?";
                ps =  ps = con.prepareStatement(query);
                ps.setInt(1,  pill);
                
                rowsAffected = ps.executeUpdate();
                
                
         }
         catch( Exception e )
        {
            System.out.println("Exception occurred: " + e.getMessage());
            e.printStackTrace();
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
                    System.err.println("A problem occurred when closing down the removepill method:\n" + e.getMessage());
                }
            }
           
            return rowsAffected;
   }
   public ArrayList<Pills> getPillByid(int pillid) {
        ArrayList<Pills> comment = new ArrayList();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            String query = "SELECT * FROM pill_identifier WHERE pill_identifierID = ?";
            ps = con.prepareStatement(query);
            // not too sure of below line
            ps.setInt(1, pillid);
            rs = ps.executeQuery();
            while (rs.next()) {
                Pills ln = new Pills();

                ln.setPillidenitiferID(rs.getInt("pill_identifierID"));
                ln.setShape(rs.getString("shape"));
               ln.setImage("Image");
                comment.add(ln);
            }
        } catch (SQLException e) {
            System.out.println("an exception in the getCommentByUser");
        } finally {
            // Close resultset
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                System.out.println("An exception occurred when closing the ResultSet of the getCommentByUser(): " + e.getMessage());
            }
            // Close prepared statement
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                System.out.println("An exception occurred when closing the PreparedStatement of the getCommentByUser(): " + e.getMessage());
            }
            // Close connection
            freeConnection(con);
        }

        // Return results
        return comment;
    }
}//end class