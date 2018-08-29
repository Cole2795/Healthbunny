/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Business.Topics;
import java.util.ArrayList;

/**
 *
 * @author Ayesha Khan
 */
public interface TopicDaoInterface {

    public ArrayList<Topics> getAllTopics(int communityId);
    public ArrayList<Topics> getTopicbytopicid(int topicId);
    public ArrayList<Topics> getallTopicList();

}
