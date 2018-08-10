/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exam;

import com.exam.user.Userreg;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author aik
 */
public class LDAO {
    public void DoS(Userreg l){
        Session s=NewHibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.save(l);
        s.getTransaction().commit();
        s.close();
    }

    public boolean DoC(String mobile,String password){
        Session s=NewHibernateUtil.getSessionFactory().openSession();
        List<Userreg> lis=s.createQuery("from Userreg where mobile='"+mobile+"' and password='"+password+"'").list();
        if(lis.size()>0)return true;
        else return false;       
    }

}
