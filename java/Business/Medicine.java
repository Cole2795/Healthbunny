/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author campb
 */
public class Medicine {

    private int medID;
    private int pill_identifierID;
    private String name;
    private String sideEffects;
    private String warnings;
    private String howtoUse;
    private String storage;
    private String overDose;
    private String image;

    public Medicine(int medID, int pill_identifierID, String name, String sideEffects, String warnings, String howtoUse, String storage, String overDose, String image) {
        this.medID = medID;
        this.pill_identifierID = pill_identifierID;
        this.name = name;
        this.sideEffects = sideEffects;
        this.warnings = warnings;
        this.howtoUse = howtoUse;
        this.storage = storage;
        this.overDose = overDose;
        this.image = image;
    }

    public Medicine() {
    }

    public Medicine(int pill_identifierID, String name, String sideeffect, String warning, String howtouse, String storage, String overdose) {
        this.pill_identifierID = pill_identifierID;
        this.name = name;
        this.sideEffects = sideeffect;
        this.warnings = warning;
        this.howtoUse = howtouse;
        this.storage = storage;
        this.overDose = overdose;
    }

    public Medicine(String name, String sideEffects, String warnings, String howtoUse, String storage, String overDose) {
    }

    public int getMedID() {
        return medID;
    }

    public void setMedID(int medID) {
        this.medID = medID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSideEffects() {
        return sideEffects;
    }

    public void setSideEffects(String sideEffects) {
        this.sideEffects = sideEffects;
    }

    public int getPill_identifierID() {
        return pill_identifierID;
    }

    public void setPill_identifierID(int pill_identifierID) {
        this.pill_identifierID = pill_identifierID;
    }

    public String getWarnings() {
        return warnings;
    }
    
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setWarnings(String warnings) {
        this.warnings = warnings;
    }

    public String getHowtoUse() {
        return howtoUse;
    }

    public void setHowtoUse(String howtoUse) {
        this.howtoUse = howtoUse;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public String getOverDose() {
        return overDose;
    }

    public void setOverDose(String overDose) {
        this.overDose = overDose;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + this.medID;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Medicine other = (Medicine) obj;
        if (this.medID != other.medID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Medicine{" + "medID=" + medID + ", name=" + name + ", sideEffects=" + sideEffects + ", warnings=" + warnings + ", howtoUse=" + howtoUse + ", storage=" + storage + ", overDose=" + overDose + '}';
    }

}
