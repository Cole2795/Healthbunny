/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.Objects;

/**
 *
 * @author campb
 */
public class Contact {
    private int contactID;
    private User userID;
    private int userId;
    private String message;
    
    public Contact(){
        
    }
    public Contact(int contactID, int userId, String message){
        this.contactID = contactID;
        this.userId = userId;
        this.message= message;
    }
    public Contact(User userID, String message){
        this.userID = userID;
        this.message = message;
    }

    public Contact(String feedback) {
     }

    public Contact(int userId, String feedback) {
        this.userId = userId;
        this.message = feedback;
      }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getContactID() {
        return contactID;
    }

    public void setContactID(int contactID) {
        this.contactID = contactID;
    }

    public User getUserID() {
        return userID;
    }

    public void setUserID(User userID) {
        this.userID = userID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Contact other = (Contact) obj;
        if (this.contactID != other.contactID) {
            return false;
        }
        if (!Objects.equals(this.userID, other.userID)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Contact{" + "contactID=" + contactID + ", userID=" + userID + ", message=" + message + '}';
    }
    
    
    
}
