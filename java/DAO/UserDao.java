package DAO;

//Ayesha
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Business.User;
import java.util.ArrayList;

public class UserDao extends Dao implements UserDaoInterface {

    public UserDao() {
        super();
    }

    // Constructor for use in direct access environment 
    // (used when you specify a database to access)
    public UserDao(String dbName) {
        super(dbName);
    }

    // Constructor for use in a pooled environment
    // (used when you specify a pool to access AND a specific database)
    public UserDao(String dbName, String poolName) {
        super(dbName, poolName);
    }
    
    //in services
    public User getUserbyUserName(String name) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User u = null;
        try {
            con = this.getConnection();

            String query = "SELECT * FROM users WHERE email = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, name);

            rs = ps.executeQuery();
            if (rs.next()) {
                int userId = rs.getInt("userId");
                String firstname = rs.getString("firstName");
                String lastname = rs.getString("lastName");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String dateofbirth = rs.getString("DateOfBirth");
                String passwordSalt = rs.getString("passwordSalt");
                int isAdmin = rs.getInt("isAdmin");
                String image = rs.getString("Images");

                u = new User(userId, firstname, lastname, email, password, passwordSalt, dateofbirth, isAdmin, image);
            }
        } catch (SQLException e) {
            System.err.println("\tA problem occurred during the findUserByUsernamePassword method:");
            System.err.println("\t" + e.getMessage());
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
                System.err.println("A problem occurred when closing down the findUserByUsernamePassword method:\n" + e.getMessage());
            }
        }
        return u;
    }
//in services
    public User getUserbyPassword(String password) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User u = null;
        try {
            con = this.getConnection();

            String query = "SELECT * FROM users WHERE password = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, password);

            rs = ps.executeQuery();
            if (rs.next()) {
                int userId = rs.getInt("userId");
                String firstname = rs.getString("firstName");
                String lastname = rs.getString("lastName");
                String email = rs.getString("email");
                String passwords = rs.getString("password");
                String dateofbirth = rs.getString("DateOfBirth");
                String passwordSalt = rs.getString("passwordSalt");
                int isAdmin = rs.getInt("isAdmin");
                String image = rs.getString("Images");

                u = new User(userId, firstname, lastname, email, passwords, passwordSalt, dateofbirth, isAdmin, image);
            }
        } catch (SQLException e) {
            System.err.println("\tA problem occurred during the getUserbyPassword method:");
            System.err.println("\t" + e.getMessage());
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
                System.err.println("A problem occurred when closing down the getUserbyPassword method:\n" + e.getMessage());
            }
        }
        return u;
    }

    //Login
    @Override
    public User findUserByUsernamePassword(String uname, String pword) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User u = null;
        try {
            con = this.getConnection();

            String query = "SELECT * FROM users WHERE email = ? AND PASSWORD = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, uname);
            ps.setString(2, pword);

            rs = ps.executeQuery();
            if (rs.next()) {
                int userId = rs.getInt("userId");
                String firstname = rs.getString("firstName");
                String lastname = rs.getString("lastName");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String dateofbirth = rs.getString("DateOfBirth");
                String passwordSalt = rs.getString("passwordSalt");
                int isAdmin = rs.getInt("isAdmin");
                String image = rs.getString("Images");

                u = new User(userId, firstname, lastname, email, password, passwordSalt, dateofbirth, isAdmin, image);
            }
        } catch (SQLException e) {
            System.err.println("\tA problem occurred during the findUserByUsernamePassword method:");
            System.err.println("\t" + e.getMessage());
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
                System.err.println("A problem occurred when closing down the findUserByUsernamePassword method:\n" + e.getMessage());
            }
        }
        return u;
    }

    @Override
    public boolean addUser(User u) {
        Connection con = null;
        PreparedStatement ps = null;
        int rowsAffected = 0;

        try {
            con = this.getConnection();

            String query = "INSERT INTO `users`(`userID`, `firstName`, `lastName`, `email`, `password`, `passwordSalt`, `DateOfBirth`, `isAdmin`, `Images`) VALUES (?,?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(query);
            ps.setInt(1, u.getUserId());
            ps.setString(2, u.getFirstName());
            ps.setString(3, u.getLastName());
            ps.setString(4, u.getEmail());
            ps.setString(5, u.getPassword());
            ps.setString(6, u.getPasswordSalt());
            ps.setString(7, u.getDateofBirth());
            ps.setInt(8, u.getisIsAdmin());
            ps.setString(9, u.getImage());
            rowsAffected = ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("\tA problem occurred during the addUser method:");
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
                System.err.println("A problem occurred when closing down the addUser method:\n" + e.getMessage());
            }
        }
        if (rowsAffected > 0) {
            System.out.println("user add");
        } else if (rowsAffected < 0) {
            System.out.println("user could not be added");
        }
        return true;

    }

    @Override
    public int updatePicture(String picture) {
        Connection conn = null;
        PreparedStatement ps = null;
        int rowsUpdated = 0;
        try {
            // Get a connection to the database
            conn = getConnection();

            // Set up the SQL and compile it for the database
            String query = "UPDATE users SET Images = ? WHERE userID = ?";
            ps = conn.prepareStatement(query);

            ps.setString(1, picture);

            rowsUpdated = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("An exception occurred in the updatePicture(): " + e.getMessage());
        } finally {
            // Close prepared statement
            try {
                ps.close();
            } catch (SQLException e) {
                System.out.println("An exception occurred when closing the PreparedStatement of the updatePicture(): " + e.getMessage());
            }
            // Close connection
            freeConnection(conn);
        }

        return rowsUpdated;
    }

    @Override
    public ArrayList<User> getCommentByUser(int user_id) {
        ArrayList<User> comment = new ArrayList();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            String query = "SELECT * FROM users WHERE userID = ?";
            ps = con.prepareStatement(query);
            // not too sure of below line
            ps.setInt(1, user_id);
            rs = ps.executeQuery();
            while (rs.next()) {
                User ln = new User();

                ln.setUserId(rs.getInt("userID"));
                ln.setFirstName(rs.getString("firstName"));
                ln.setLastName(rs.getString("lastName"));
                ln.setEmail(rs.getString("email"));
                ln.setPassword(rs.getString("password"));
                ln.setPasswordSalt(rs.getString("passwordSalt"));
                ln.setDateOfBirth(rs.getString("DateOfBirth"));
                ln.setIsAdmin(rs.getInt("isAdmin"));
                ln.setImage(rs.getString("Images"));
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

   
    

}
