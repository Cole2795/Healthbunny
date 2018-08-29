/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Business.Messages;
import java.util.ArrayList;

/**
 *
 * @author Ayesha Khan
 */
public interface MessageDaoInterface {
    
    public boolean addMessages(Messages m);
    public ArrayList<Messages> getAllMessages();
    public ArrayList<Messages> getMessagesById(int topicId);
    
    
}
