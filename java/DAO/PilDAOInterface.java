/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Business.Pills;
import java.util.ArrayList;

/**
 *
 * @author campb
 */
public interface PilDAOInterface {
    public ArrayList<Pills> getallList();
      public boolean addpill(Pills m);
      public int RemovePill(int pill);
        public ArrayList<Pills> getPillByid(int pillid);
}
