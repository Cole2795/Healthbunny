package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Dao {
   
    
    private DataSource datasource;
    private String databaseName;
    private final String DEFAULT_DB = "healthybunny";
    
    
    // Used where no parameters are supplied - allows for direct access to a default database
    public Dao(){
        databaseName = DEFAULT_DB;
    }
    
    // Used to specify the name of a database to access directly
    // Useful for when we are testing 
    // This will not provide pooled database access
    public Dao(String dbName)
    {
        this.databaseName = dbName;
    }
    
    // Constructor for use by pooled connections
    // Supply the name of the database and the connection pool name to use
    public Dao(String dbName, String datasourceContext)
    {
        this(dbName);
        Connection con = null;
        //String DATASOURCE_CONTEXT = "jdbc/Connection_Pooling_Example";
        String DATASOURCE_CONTEXT = datasourceContext;
        try {
            Context initialContext = new InitialContext();
            DataSource ds = (DataSource)initialContext.lookup("java:comp/env/" + DATASOURCE_CONTEXT);
            if(ds != null){
                datasource = ds;
                System.out.println("Connection pool located!");
            }
            else{
		System.out.println(("Failed to lookup datasource."));
            }
        }catch (NamingException ex ){
            System.out.println("Cannot get connection: " + ex);
        }
    }
    private Connection getDirectConnection()
    {

        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/" + databaseName;
        String username = "root";
        String password = "";
        Connection con = null;
        
        try 
        {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
        } 
        catch (ClassNotFoundException ex1) 
        {
            System.out.println("Failed to find driver class " + ex1.getMessage());
            System.exit(1);
        } 
        catch (SQLException ex2) 
        {
            System.out.println("Connection failed " + ex2.getMessage());
            System.exit(2);
        }
        return con;
    }
    
    public Connection getConnection()
    {

        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/" + databaseName;
        String username = "root";
        String password = "";
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException ex1) {
            System.out.println("Failed to find driver class " + ex1.getMessage());
            System.exit(1);
        } catch (SQLException ex2) {
            System.out.println("Connection failed " + ex2.getMessage());
            System.exit(2);
        }
        return con;
    }

    public void freeConnection(Connection con)
    {
        try {
            if (con != null) {
                con.close();
                con = null;
            }
        } catch (SQLException e) {
            System.out.println("Failed to free connection: " + e.getMessage());
            System.exit(1);
        }
    }

}