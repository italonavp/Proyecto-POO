/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BEAN;

/**
 *
 * @author laboratorioesan
 */
public class Region {
    private int IDregion;
    private String Regdesc;
    
        public Region(){
            
        }

    public Region(int IDregion, String Regdesc) {
        this.IDregion = IDregion;
        this.Regdesc = Regdesc;
    }

    public int getIDregion() {
        return IDregion;
    }

    public void setIDregion(int IDregion) {
        this.IDregion = IDregion;
    }

    public String getRegdesc() {
        return Regdesc;
    }

    public void setRegdesc(String Regdesc) {
        this.Regdesc = Regdesc;
    }
        
}
