/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author Ayesha Khan
 */
public class CommunityTopics {

    private String communityName;
    private String topicName;
    private int topicId;
    private String image;

    public CommunityTopics(String communityName, String topicName, int topicId, String image) {
        this.communityName = communityName;
        this.topicName = topicName;
        this.topicId = topicId;
        this.image = image;
    }

    public CommunityTopics() {
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
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
    public String toString() {
        return "CommunityTopics{" + "communityName=" + communityName + ", topicName=" + topicName + ", topicId=" + topicId + ", image=" + image + '}';
    }

}
