/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Business.Contact;
import java.util.ArrayList;

/**
 *
 * @author campb
 */
public interface ContactDaoInterface {
    public ArrayList<Contact> getallMessage();
    public boolean addContact(Contact c);
    
}
