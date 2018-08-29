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
public class Topics {

    private int topicId;
    private String topicName;
    private int comId;
    private String image;

    public Topics(int topicId, String topicName, int comId, String image) {
        this.topicId = topicId;
        this.topicName = topicName;
        this.comId = comId;
        this.image = image;
         
    }
    public Topics(){
    }

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public int getComId() {
        return comId;
    }

    public void setComId(int comId) {
        this.comId = comId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + this.topicId;
        hash = 43 * hash + Objects.hashCode(this.topicName);
        hash = 43 * hash + this.comId;
        hash = 43 * hash + Objects.hashCode(this.image);
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
        final Topics other = (Topics) obj;
        if (this.topicId != other.topicId) {
            return false;
        }
        if (this.comId != other.comId) {
            return false;
        }
        if (!Objects.equals(this.topicName, other.topicName)) {
            return false;
        }
        if (!Objects.equals(this.image, other.image)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Topics{" + "topicId=" + topicId + ", topicName=" + topicName + ", comId=" + comId + ", image=" + image + '}';
    }
    

}
