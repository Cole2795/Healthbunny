/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import Business.Messages;
import DAO.MessageDao;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
/**
 *
 * @author Ayesha Khan
 */
public class MessageCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = "";
        String title = request.getParameter("messageTitle");
        String message = request.getParameter("message");
        String messageDate = request.getParameter("messageDate");
        int user = Integer.parseInt(request.getParameter("userId"));
        int topic = Integer.parseInt(request.getParameter("topicId"));
        MessageDao messagedao = new MessageDao("healthybunny");
                

        Messages m = new Messages(title, message, messageDate, user, topic);
        boolean success = messagedao.addMessages(m);
        HttpSession session = request.getSession();
        if (success) {
            session.setAttribute("comment", m);
            forwardToJsp = "message.jsp?id="+topic;
        } else {
            forwardToJsp = "error.jsp";

        }
        return forwardToJsp;

    }
}
