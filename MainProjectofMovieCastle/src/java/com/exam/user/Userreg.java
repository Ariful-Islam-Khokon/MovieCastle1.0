package com.exam.user;
// Generated Jul 20, 2018 2:43:28 PM by Hibernate Tools 4.3.1



/**
 * Userreg generated by hbm2java
 */
public class Userreg  implements java.io.Serializable {


     private String mobile;
     private String uname;
     private String password;
     private String email;

    public Userreg() {
    }

	
    public Userreg(String mobile) {
        this.mobile = mobile;
    }
    public Userreg(String mobile, String uname, String password, String email) {
       this.mobile = mobile;
       this.uname = uname;
       this.password = password;
       this.email = email;
    }
   
    public String getMobile() {
        return this.mobile;
    }
    
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public String getUname() {
        return this.uname;
    }
    
    public void setUname(String uname) {
        this.uname = uname;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }




}


