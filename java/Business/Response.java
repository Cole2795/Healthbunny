/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author d00185655
 */
public class Response {
    private int messageId;
    private String responseMessage;
    private int userId;
    private String Image;
    private String responseDate;

    public Response(String responseMessage, int userId, String responseDate, int messageId) {
        this.responseMessage = responseMessage;
        this.userId = userId;
        this.responseDate = responseDate;
        this.messageId = messageId;
    }
    
    
    public Response() {

    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

    public String getResponseDate() {
        return responseDate;
    }

    public void setResponseDate(String responseDate) {
        this.responseDate = responseDate;
    }

    @Override
    public String toString() {
        return "Response{" + "messageId=" + messageId + ", responseMessage=" + responseMessage + ", userId=" + userId + ", Image=" + Image + ", responseDate=" + responseDate + '}';
    }

    
    
    
}
