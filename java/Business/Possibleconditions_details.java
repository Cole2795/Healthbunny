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
public class Possibleconditions_details {
        private int possibleCondition_DetailsID;
        private String title;
        private String howCommon;
        private String diagnosedBy;
        private String treatment;
        private String madeWorseBy;
        private String fact;

    public Possibleconditions_details(int possibleCondition_DetailsID,  String title, String howCommon, String diagnosedBy, String treatment, String madeWorseBy, String fact) {
        this.possibleCondition_DetailsID = possibleCondition_DetailsID;
        this.title = title;
        this.howCommon = howCommon;
        this.diagnosedBy = diagnosedBy;
        this.treatment = treatment;
        this.madeWorseBy = madeWorseBy;
        this.fact = fact;
    }

    public Possibleconditions_details() {
    }

    public Possibleconditions_details(String title, String howCommon, String diagnosedBy, String treatment, String madeWorseBy, String fact) {
       this.title = title;
        this.howCommon = howCommon;
        this.diagnosedBy = diagnosedBy;
        this.treatment = treatment;
        this.madeWorseBy = madeWorseBy;
        this.fact = fact;
    }
    

    public int getPossibleCondition_DetailsID() {
        return possibleCondition_DetailsID;
    }

    public void setPossibleCondition_DetailsID(int possibleCondition_DetailsID) {
        this.possibleCondition_DetailsID = possibleCondition_DetailsID;
    }

   

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHowCommon() {
        return howCommon;
    }

    public void setHowCommon(String howCommon) {
        this.howCommon = howCommon;
    }

    public String getDiagnosedBy() {
        return diagnosedBy;
    }

    public void setDiagnosedBy(String diagnosedBy) {
        this.diagnosedBy = diagnosedBy;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public String getMadeWorseBy() {
        return madeWorseBy;
    }

    public void setMadeWorseBy(String madeWorseBy) {
        this.madeWorseBy = madeWorseBy;
    }

    public String getFact() {
        return fact;
    }

    public void setFact(String fact) {
        this.fact = fact;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.possibleCondition_DetailsID;
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
        final Possibleconditions_details other = (Possibleconditions_details) obj;
        if (this.possibleCondition_DetailsID != other.possibleCondition_DetailsID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Possibleconditions_details{" + "possibleCondition_DetailsID=" + possibleCondition_DetailsID  + ", title=" + title + ", howCommon=" + howCommon + ", diagnosedBy=" + diagnosedBy + ", treatment=" + treatment + ", madeWorseBy=" + madeWorseBy + ", fact=" + fact + '}';
    }
        
        
}
