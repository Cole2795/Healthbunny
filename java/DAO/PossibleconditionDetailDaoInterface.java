/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Business.Possibleconditions_details;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author campb
 */
public interface PossibleconditionDetailDaoInterface {

    public ArrayList<Possibleconditions_details> getallConditionsDetailsList();

    public ArrayList<Possibleconditions_details> getConditionsDetailbyName(String title);

    public boolean addCondtionpossible(Possibleconditions_details m);

    public int RemoveCondtion(String condition);

    public Possibleconditions_details getConditionbyId(String title);


    public int EditCondition(Possibleconditions_details pcs);

}
