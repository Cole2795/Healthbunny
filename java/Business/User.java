package Business;

import java.util.Objects;
/*
* Author Ayesha
*/

/**
 *
 * @author Ayesha Khan
 */
public class User implements Comparable
{
    private int userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password, DateOfBirth;
    private String passwordSalt;
    private int isAdmin;
    private String image;
 

    public User(){
    passwordSalt = "";
    }
   
    public User(int userId,String firstName, String lastName, String email, String password,String passwordSalt, String dateofBirth, int isadmin, String image) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.passwordSalt = passwordSalt;
        this.DateOfBirth = dateofBirth;
        this.isAdmin = isadmin;
        this.image = image;
       
    }
    
    public User(String firstName, String lastName, String email, String password, String passSalt, String dateofBirth, String image) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.passwordSalt = passSalt;
         this.DateOfBirth = dateofBirth;
        this.isAdmin = 0;
        this.image =image;
        
       
    }
        public User(String firstName, String lastName, String email, String password, String dateofBirth, String passSalt, int isadmin, String image) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
         this.passwordSalt = passSalt;
         this.DateOfBirth = dateofBirth;
           this.isAdmin = isadmin;
           this.image = image;
       
        
       
    }


    public User(int userId, String firstname, String lastname, String email, String hashPass, String passSalt, String DateOfBirth, String image) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.passwordSalt = passwordSalt;
        this.DateOfBirth = DateOfBirth;
        this.image = image;
        
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

   
    /**
     *
     * @return
     */
    public int getUserId() {
        return userId;
    }

    /**
     *
     * @param user_id
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     *
     * @return
     */
   

    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     */
   


    /**
     *
     * @return
     */
    public String getDateofBirth() {
        return DateOfBirth;
    }

    /**
     *
     * @param username
     */
    public void setDateofBirth(String dateofBirth) {
        this.DateOfBirth= dateofBirth;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String DateOfBirth) {
        this.DateOfBirth = DateOfBirth;
    }

    public String getPasswordSalt() {
        return passwordSalt;
    }

    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
    }

    public int getisIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    
    /**
     *
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     *
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     *
     * @return
     */
    @Override   
    public String toString() {
        return "User{" + "userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password=" + password + ", DateOfBirth=" + DateOfBirth + ", passwordSalt=" + passwordSalt + ", isAdmin=" + isAdmin + '}';
    }

//    }
    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.email);
        return hash;
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return true;
    }
    
    /**
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(Object o)
    {
        User u = (User) o;
        return this.email.compareTo(u.email);
    }
}
