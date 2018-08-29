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
public class Pills {
    private int pillidenitiferID;
    private String shape;
     private String image;
    
    public Pills(){
        
    }
    public Pills(int pillidnitiferID, String shape, String image){
        this.pillidenitiferID = pillidnitiferID;
        this.shape = shape;
        this.image = image;
    }

    public int getPillidenitiferID() {
        return pillidenitiferID;
    }

    public void setPillidenitiferID(int pillidenitiferID) {
        this.pillidenitiferID = pillidenitiferID;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    

    public Pills(int pill_identifierID) {
    }
    public void setPillidentifier(int pillidnitifer){
        this.pillidenitiferID = pillidnitifer;
    }
    public int getpillidentifierID(){
        return pillidenitiferID;
    }
    public void setShape(String shape){
        this.shape = shape;
    }
    public String getShape(){
        return shape;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.pillidenitiferID;
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
        final Pills other = (Pills) obj;
        if (this.pillidenitiferID != other.pillidenitiferID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pill{" + "pillidenitifer=" + pillidenitiferID + ", shape=" + shape + '}';
    }
    
}
