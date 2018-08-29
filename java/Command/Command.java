/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Cole
 */
public interface Command {

    public final String IMAGES_FOLDER_PATH = "../Images/";

    /**
     *
     * @param request - send it
     * @param response- send back
     * @return
     */
    public String execute(HttpServletRequest request, HttpServletResponse response);
    
}
