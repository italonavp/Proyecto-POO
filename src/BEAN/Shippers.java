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
public class Shippers {
    private int IdShippers;
    private String CompanyName;
    private String phone;

    public Shippers() {
    }

    public Shippers(int IdShippers, String CompanyName, String phone) {
        this.IdShippers = IdShippers;
        this.CompanyName = CompanyName;
        this.phone = phone;
    }

    public int getIdShippers() {
        return IdShippers;
    }

    public void setIdShippers(int IdShippers) {
        this.IdShippers = IdShippers;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String CompanyName) {
        this.CompanyName = CompanyName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    
}
