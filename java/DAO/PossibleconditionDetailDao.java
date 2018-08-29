/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import Business.Possibleconditions_details;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author campb
 */
public class PossibleconditionDetailDao extends Dao implements PossibleconditionDetailDaoInterface {
    
    public PossibleconditionDetailDao(){
        super();
    }
    public PossibleconditionDetailDao(String dbName){
        super(dbName);
    }
    public PossibleconditionDetailDao(String dbName, String poolName){
        super(dbName, poolName);
    }
    //display list of medicine
    @Override
    public ArrayList<Possibleconditions_details> getallConditionsDetailsList(){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Possibleconditions_details> c = new ArrayList();
        try{
            con = getConnection();
            String query = "Select * from possibleconditions_details";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                Possibleconditions_details po = new Possibleconditions_details();
                po.setPossibleCondition_DetailsID(rs.getInt("possibleCondition_DetailsID"));
              //   po.setPossibleConditionID(rs.getInt("possibleConiditionID"));
                po.setTitle(rs.getString("title"));
                po.setHowCommon(rs.getString("howCommon"));
                po.setDiagnosedBy(rs.getString("diagnosedBy"));
                 po.setTreatment(rs.getString("treatment"));
                  po.setMadeWorseBy(rs.getString("madeWorseBy"));
                   po.setFact(rs.getString("fact"));
                c.add(po);
                
                
                
            }
        } catch (SQLException e) {
           System.out.println("Exception occured in the getAllbodypartList() method: " + e.getMessage());
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
                 System.out.println("Exception occured in the finally section of the getAllbodypartList() method: " + e.getMessage());
          
            }
        }
        return c;
    }//end list of bodycategory
    //search name of medicine
    public ArrayList<Possibleconditions_details> getConditionsDetailbyName(String title){
        ArrayList<Possibleconditions_details> pc = new ArrayList();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = getConnection();
            String query = "Select * from possibleconditions_details WHERE title = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, title);
            rs = ps.executeQuery();
            while(rs.next()){
                Possibleconditions_details po  = new Possibleconditions_details();
               po.setPossibleCondition_DetailsID(rs.getInt("possibleCondition_DetailsID"));
            // po.setPossibleConditionID(rs.getInt("possibleConditionID"));
                po.setTitle(rs.getString("title"));
                po.setHowCommon(rs.getString("howCommon"));
                po.setDiagnosedBy(rs.getString("diagnosedBy"));
                 po.setTreatment(rs.getString("treatment"));
                  po.setMadeWorseBy(rs.getString("madeWorseBy"));
                   po.setFact(rs.getString("fact"));
               
                pc.add(po);
            }
        } catch (SQLException ex) {
                System.out.println("an exception in the getBooksByTitle");
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
                System.out.println("An exception occurred when closing the ResultSet of the getbodypartByName(): " + e.getMessage());
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
                System.out.println("An exception occurred when closing the PreparedStatement of the getbodypartByName(): " + e.getMessage());
            }
            // Close connection
            freeConnection(con);
        }
        
        // Return results
        return pc;
    }
     public boolean addCondtionpossible(Possibleconditions_details m){
        Connection con = null;
        PreparedStatement ps = null;
        int rowsAffected = 0;
        try{
            con = this.getConnection();
            String query = "INSERT INTO possibleconditions_details VALUES(?,?,?,?,?,?,?)";
            ps = con.prepareStatement(query);
               ps.setInt(1, m.getPossibleCondition_DetailsID());
               
                ps.setString(2, m.getTitle());
                 ps.setString(3, m.getHowCommon());
                 ps.setString(4, m.getDiagnosedBy());
                 ps.setString(5, m.getTreatment());
                 ps.setString(6, m.getMadeWorseBy());
                 ps.setString(7, m.getFact());
                rowsAffected = ps.executeUpdate();

        } catch (SQLException ex) {
             System.err.println("\tA problem occurred during the addmedicine method:");
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
                    System.err.println("A problem occurred when closing down the addmedicine method:\n" + e.getMessage());
                }
            }
            if(rowsAffected > 0){
                System.out.println("medicine add");
            }else if(rowsAffected < 0){
                System.out.println("medicine could not be added");
            }
            return true;
    }
       @Override
    public int RemoveCondtion(String condition){
        
         Connection con = null;
         PreparedStatement ps = null;
         int rowsAffected = 0;
         try{
                  
                con = this.getConnection();
                String query = "DELETE FROM possibleconditions_details WHERE title = ?";
                ps =  ps = con.prepareStatement(query);
                ps.setString(1,  condition);
                
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
                    System.err.println("A problem occurred when closing down the addmedicine method:\n" + e.getMessage());
                }
            }
           
            return rowsAffected;
   }
    
      public Possibleconditions_details getConditionbyId(String titles){
       // ArrayList<Medicine> med = new ArrayList();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Possibleconditions_details possiblecondDetails = null;
        try{
            con = getConnection();
            String query = "Select * from Possibleconditions_details WHERE possibleCondition_DetailsID = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, titles);
            rs = ps.executeQuery();
            while(rs.next()){
                //Medicine m = new Medicine();
                int possibleCondition_DetailsID = rs.getInt("possibleCondition_DetailsID");
               // int possibleConditionID = rs.getInt("possibleConditionID");
                String title = rs.getString("title");
                String howCommon = rs.getString("howCommon");
                String diagnosedBy = rs.getString("diagnosedBy");
                String treatment = rs.getString("treatment");
                String madeWorseBy = rs.getString("madeWorseBy");
                String fact = rs.getString("fact");
              //s  m.setImage(rs.getBytes("image"));
              possiblecondDetails = new Possibleconditions_details(possibleCondition_DetailsID, title, howCommon,diagnosedBy, treatment, madeWorseBy, fact);
            }
        } catch (SQLException ex) {
                System.out.println("an exception in the getBooksByTitle");
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
                System.out.println("An exception occurred when closing the ResultSet of the getCustomersByName(): " + e.getMessage());
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
                System.out.println("An exception occurred when closing the PreparedStatement of the getCustomersByName(): " + e.getMessage());
            }
            // Close connection
            freeConnection(con);
        }
        
        // Return results
        return possiblecondDetails;
    }
      public int EditCondition(Possibleconditions_details pcs){
        Connection con = getConnection();
        PreparedStatement ps = null;
        int rowsAffected = 0;
        try{
           // con = this.getConnection();
            String query = "UPDATE Possibleconditions_details SET title = ?, howCommon = ?, diagnosedby = ?, treatment = ?, madeWorseBy = ?, fact = ?  WHERE title = ?";
            ps = con.prepareStatement(query);
               
               ps.setString(1, pcs.getTitle());
                ps.setString(2, pcs.getHowCommon());
                ps.setString(3, pcs.getDiagnosedBy());
                ps.setString(4, pcs.getTreatment());
                ps.setString(5, pcs.getMadeWorseBy());
                ps.setString(6, pcs.getFact());
       
                //ps.setString(9, m.());
                rowsAffected = ps.executeUpdate();

        } catch (SQLException ex) {
             System.err.println("\tA problem occurred during the editmedicine method:");
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
                    System.err.println("A problem occurred when closing down the editmedicine method:\n" + e.getMessage());
                }
            }
//            if(rowsAffected > 0){
//                System.out.println("medicine add");
//            }else if(rowsAffected < 0){
//                System.out.println("medicine could not be added");
//            }
            return rowsAffected;
    }


}