/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.Objects;

/**
 *
 * @author Ayesha Khan
 */
public class Community {

    public int comId;
    public String comName;

    public Community(int comId, String comName) {
        this.comId = comId;
        this.comName = comName;
    }

    public Community() {
    }

    public int getComId() {
        return comId;
    }

    public void setComId(int comId) {
        this.comId = comId;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.comId;
        hash = 97 * hash + Objects.hashCode(this.comName);
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
        final Community other = (Community) obj;
        if (this.comId != other.comId) {
            return false;
        }
        if (!Objects.equals(this.comName, other.comName)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Community{" + "comId=" + comId + ", comName=" + comName + '}';
    }

    
    
}
