/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Business.Response;
import java.util.ArrayList;

/**
 *
 * @author d00185655
 */
public interface ResponseDaoInterface {
        public boolean addResponse(Response r);

        public ArrayList<Response> getReponseById(int messageid);

    
}
