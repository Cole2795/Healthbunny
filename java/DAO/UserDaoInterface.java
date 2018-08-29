package DAO;

import Business.User;
import java.util.ArrayList;

/**
 *
 * @author Ayesha/Nicole
 */
public interface UserDaoInterface 
{
    public int updatePicture(String picture);
    public User findUserByUsernamePassword(String uname, String pword);
    public ArrayList<User> getCommentByUser(int user_id);
    public boolean addUser(User u);
    
}
