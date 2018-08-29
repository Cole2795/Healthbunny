/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import Business.Messages;
import Business.Response;
import DAO.MessageDao;
import DAO.ResponseDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author d00185655
 */
public class ResponseCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = "";
        String responseMsg = request.getParameter("responseMessage");
        int user = Integer.parseInt(request.getParameter("userId"));

        String messageDate = request.getParameter("messageDate");
        ResponseDao responseDao = new ResponseDao("healthybunny");
        int messageId = Integer.parseInt(request.getParameter("messageid"));
        Response r = new Response(responseMsg, user, messageDate, messageId);
        boolean success = responseDao.addResponse(r);
        HttpSession session = request.getSession();
        if (success) {
            session.setAttribute("comment", r);
            forwardToJsp = "message.jsp?id=" + request.getParameter("topicId");
        } else {
            forwardToJsp = "error.jsp";

        }
        return forwardToJsp;

    }
}
