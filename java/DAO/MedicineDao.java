/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Business.Medicine;
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
public class MedicineDao extends Dao implements MedicineDaoInterface {
    
    public MedicineDao(){
        super();
    }
    public MedicineDao(String dbName){
        super(dbName);
    }
    public MedicineDao(String dbName, String poolName){
        super(dbName, poolName);
    }
    //display list of medicine
    @Override
    public ArrayList<Medicine> getallMedicineList(){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Medicine> med = new ArrayList();
        try{
            con = getConnection();
            String query = "Select * from medicine";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                Medicine m = new Medicine();
                m.setMedID(rs.getInt("medID"));
               m.setPill_identifierID(rs.getInt("pill_identifierID"));
                m.setName(rs.getString("name"));
                m.setSideEffects(rs.getString("sideEffects"));
                m.setWarnings(rs.getString("warnings"));
                m.setHowtoUse(rs.getString("howtoUse"));
                m.setStorage(rs.getString("storage"));
                m.setOverDose(rs.getString("overDose"));
                m.setImage(rs.getString("Image"));
                med.add(m);
                
                
                
            }
        } catch (SQLException e) {
           System.out.println("Exception occured in the getAllMedicineList() method: " + e.getMessage());
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
                 System.out.println("Exception occured in the finally section of the getAllMedicineList() method: " + e.getMessage());
          
            }
        }
        return med;
    }//end list of medicine
    //search name of medicine
    @Override
    public ArrayList<Medicine> getMedicinebyName(String name){
        ArrayList<Medicine> med = new ArrayList();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = getConnection();
            String query = "Select * from medicine WHERE name = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, name);
            rs = ps.executeQuery();
            while(rs.next()){
                Medicine m = new Medicine();
                m.setMedID(rs.getInt("medID"));
                m.setPill_identifierID(rs.getInt("pill_identifierID"));
                m.setName(rs.getString("name"));
                m.setSideEffects(rs.getString("sideEffects"));
                m.setWarnings(rs.getString("warnings"));
                m.setHowtoUse(rs.getString("howtoUse"));
                m.setStorage(rs.getString("storage"));
                m.setOverDose(rs.getString("overDose"));
                m.setImage(rs.getString("Image"));
                med.add(m);
            }
        } catch (SQLException ex) {
                System.out.println("an exception in the getMedicinebyName");
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
                System.out.println("An exception occurred when closing the ResultSet of the getMedicinebyName(): " + e.getMessage());
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
                System.out.println("An exception occurred when closing the PreparedStatement of the getMedicinebyName(): " + e.getMessage());
            }
            // Close connection
            freeConnection(con);
        }
        
        // Return results
        return med;
    }
    @Override
    public ArrayList<Medicine> getMedicinebypillID(int pillID){
        ArrayList<Medicine> med = new ArrayList();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = getConnection();
            String query = "Select * from medicine WHERE pill_identifierID = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, pillID);
            rs = ps.executeQuery();
            while(rs.next()){
                Medicine m = new Medicine();
                m.setMedID(rs.getInt("medID"));
                m.setPill_identifierID(rs.getInt("pill_identifierID"));
                m.setName(rs.getString("name"));
                m.setSideEffects(rs.getString("sideEffects"));
                m.setWarnings(rs.getString("warnings"));
                m.setHowtoUse(rs.getString("howtoUse"));
                m.setStorage(rs.getString("storage"));
                m.setOverDose(rs.getString("overDose"));
               m.setImage(rs.getString("Image"));
                med.add(m);
            }
        } catch (SQLException ex) {
                System.out.println("an exception in the getMedicinebyPillID");
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
                System.out.println("An exception occurred when closing the ResultSet of the getMedicinebyPillID(): " + e.getMessage());
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
                System.out.println("An exception occurred when closing the PreparedStatement of the getMedicinebyPillID(): " + e.getMessage());
            }
            // Close connection
            freeConnection(con);
        }
        
        // Return results
        return med;
    }
    //add new medicine
    @Override
    public boolean addMedicine(Medicine m){
        Connection con = null;
        PreparedStatement ps = null;
        int rowsAffected = 0;
        try{
            con = this.getConnection();
            String query = "INSERT INTO medicine VALUES(?,?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(query);
                ps.setInt(1, m.getMedID());
               ps.setInt(2, m.getPill_identifierID());
                ps.setString(3, m.getName());
                ps.setString(4, m.getSideEffects());
                ps.setString(5, m.getWarnings());
                ps.setString(6, m.getHowtoUse());
                ps.setString(7, m.getStorage());
                ps.setString(8, m.getOverDose());
                ps.setString(9, m.getImage());
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
     public int RemoveMedicine(int med){
               Connection con = null;
         PreparedStatement ps = null;
         int rowsAffected = 0;
         try{
                  
                con = this.getConnection();
                String query = "DELETE FROM medicine WHERE medID = ?";
                ps =  ps = con.prepareStatement(query);
                ps.setInt(1,  med);
                
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
                    System.err.println("A problem occurred when closing down the removemedicine method:\n" + e.getMessage());
                }
            }
           
            return rowsAffected;
   }
     @Override
       public Medicine getMedicinebyId(int id){
       // ArrayList<Medicine> med = new ArrayList();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Medicine medicine = null;
        try{
            con = getConnection();
            String query = "Select * from medicine WHERE medID = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                //Medicine m = new Medicine();
                int medID = rs.getInt("medID");
                int pill_identifierID = rs.getInt("pill_identifierID");
                String name = rs.getString("name");
                String sideEffects = rs.getString("sideEffects");
                String warnings = rs.getString("warnings");
                String howToUse = rs.getString("howToUse");
                String storage = rs.getString("storage");
                String overDose = rs.getString("overDose");
               String image = rs.getString("Image");
              medicine = new Medicine(medID, pill_identifierID, name, sideEffects,warnings, howToUse, storage, overDose, image);
            }
        } catch (SQLException ex) {
                System.out.println("an exception in the getMedicinebyID");
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
                System.out.println("An exception occurred when closing the ResultSet of the getMedicinebyID(): " + e.getMessage());
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
                System.out.println("An exception occurred when closing the PreparedStatement of the getMedicinebyID(): " + e.getMessage());
            }
            // Close connection
            freeConnection(con);
        }
        
        // Return results
        return medicine;
    }
     
     @Override
    public int EditMedicine(Medicine medicine){
        Connection con = getConnection();
        PreparedStatement ps = null;
        int rowsAffected = 0;
        try{
           // con = this.getConnection();
            String query = "UPDATE medicine SET pill_identifierID = ?, name = ?, sideEffects = ?, warnings = ?, howToUse = ?, storage = ?, overDose = ?  WHERE medID = ?";
            ps = con.prepareStatement(query);
               
               ps.setInt(1, medicine.getPill_identifierID());
                ps.setString(2, medicine.getName());
                ps.setString(3, medicine.getSideEffects());
                ps.setString(4, medicine.getWarnings());
                ps.setString(5, medicine.getHowtoUse());
                ps.setString(6, medicine.getStorage());
                ps.setString(7, medicine.getOverDose());
                ps.setInt(8, medicine.getMedID());
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
     
}//end class