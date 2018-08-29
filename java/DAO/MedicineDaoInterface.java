/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Business.Medicine;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author campb
 */
public interface MedicineDaoInterface {
    //display list of medicine list
    public ArrayList<Medicine> getallMedicineList();
    //search name of medicine
    public ArrayList<Medicine> getMedicinebyName(String name);
    //add new medicine
    public boolean addMedicine(Medicine m);
    public int RemoveMedicine(int med);
    public Medicine getMedicinebyId(int id);
    public int EditMedicine(Medicine medicine);
    public ArrayList<Medicine> getMedicinebypillID(int pillID);
}
