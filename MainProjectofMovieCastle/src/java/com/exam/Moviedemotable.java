package com.exam;
// Generated Jul 20, 2018 2:43:28 PM by Hibernate Tools 4.3.1



/**
 * Moviedemotable generated by hbm2java
 */
public class Moviedemotable  implements java.io.Serializable {


     private int sitid;
     private String stype;
     private Integer price;
     private String status;

    public Moviedemotable() {
    }

	
    public Moviedemotable(int sitid) {
        this.sitid = sitid;
    }
    public Moviedemotable(int sitid, String stype, Integer price, String status) {
       this.sitid = sitid;
       this.stype = stype;
       this.price = price;
       this.status = status;
    }
   
    public int getSitid() {
        return this.sitid;
    }
    
    public void setSitid(int sitid) {
        this.sitid = sitid;
    }
    public String getStype() {
        return this.stype;
    }
    
    public void setStype(String stype) {
        this.stype = stype;
    }
    public Integer getPrice() {
        return this.price;
    }
    
    public void setPrice(Integer price) {
        this.price = price;
    }
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }




}

