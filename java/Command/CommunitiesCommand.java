/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import Business.Community;
import Business.CommunityTopics;
import Business.Topics;
import DAO.CommunityDao;
import DAO.TopicDao;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ayesha Khan
 */
public class CommunitiesCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = "";

        CommunityDao comunityDao = new CommunityDao("healthybunny");
        TopicDao topicDao = new TopicDao("healthybunny");
        ArrayList<Community> communities = comunityDao.listOfCom();
        ArrayList<Topics> topics = null;
        ArrayList<CommunityTopics> communityTopics = new ArrayList();
        int oldCommunityId = 0;

        for (Community c : communities) {
            int newCommunityId = c.getComId();

            int communityId = c.getComId();
            topics = topicDao.getAllTopics(communityId);
            for (Topics t : topics) {
                CommunityTopics ct = new CommunityTopics();
                if (oldCommunityId != newCommunityId) {
                    ct.setCommunityName(c.getComName());
                    oldCommunityId = newCommunityId;
                } else {
                    ct.setCommunityName("");
                }
                ct.setTopicName(t.getTopicName());
                ct.setTopicId(t.getTopicId());
                ct.setImage(t.getImage());
                communityTopics.add(ct);
            }

        }
        HttpSession session = request.getSession();
        session.setAttribute("communityTopics", communityTopics);
        forwardToJsp = "community.jsp";
        return forwardToJsp;

    }

}
