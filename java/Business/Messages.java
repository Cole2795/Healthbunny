/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.Objects;

/**
 *
 * @author Ayesha Khan
 */
public class Messages {

    private int messageId;
    private String messageTitle;
    private String message;
    private String messageDate;
    private int userId;
    private int topicId;
    private String image;

    public Messages( String messageTitle, String message, String messageDate, int userId, int topicId) {
        this.messageTitle = messageTitle;
        this.message = message;
        this.messageDate = messageDate;
        this.userId = userId;
        this.topicId = topicId;

    }

    public Messages() {

    }

    public Messages(String title, String message, String messageDate, int user, int topic, String Image) {
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public String getMessageTitle() {
        return messageTitle;
    }

    public void setMessageTitle(String messageTitle) {
        this.messageTitle = messageTitle;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessageDate() {
        return messageDate;
    }

    public void setMessageDate(String messageDate) {
        this.messageDate = messageDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + this.messageId;
        hash = 19 * hash + Objects.hashCode(this.messageTitle);
        hash = 19 * hash + Objects.hashCode(this.message);
        hash = 19 * hash + Objects.hashCode(this.messageDate);
        hash = 19 * hash + this.userId;
        hash = 19 * hash + this.topicId;
        hash = 19 * hash + Objects.hashCode(this.image);
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
        final Messages other = (Messages) obj;
        if (this.messageId != other.messageId) {
            return false;
        }
        if (this.messageDate != other.messageDate) {
            return false;
        }
        if (this.userId != other.userId) {
            return false;
        }
        if (this.topicId != other.topicId) {
            return false;
        }
        if (!Objects.equals(this.messageTitle, other.messageTitle)) {
            return false;
        }
        if (!Objects.equals(this.message, other.message)) {
            return false;
        }
        if (!Objects.equals(this.image, other.image)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Messages{" + "messageId=" + messageId + ", messageTitle=" + messageTitle + ", message=" + message + ", messageDate=" + messageDate + ", userId=" + userId + ", topicId=" + topicId + ", image=" + image + '}';
    }
    
   
}
