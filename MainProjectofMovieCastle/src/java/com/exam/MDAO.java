/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exam;

import com.exam.madding.Mschedule;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author l2pc209m
 */
public class MDAO {
    

    public void doMAdd(Mschedule ms) {
        Session s = NewHibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.save(ms);
        s.getTransaction().commit();
        s.close();
    }

    public void doMDelete(Mschedule ms) {
        Session s = NewHibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.delete(ms);
        s.getTransaction().commit();
        s.close();
    }

    public List doMAShow() {
        Session s = NewHibernateUtil.getSessionFactory().openSession();
        Query q = s.createQuery("FROM Mschedule f ORDER BY f.mdate DESC");
        List<Mschedule> li = q.list();
        return li;

    }

//    public List view(int sitid) {
//        Session s = NewHibernateUtil.getSessionFactory().openSession();
//        Query q = s.createQuery("FROM Moviedemotable WHERE sitid=" + sitid + "");
//        List<Moviedemotable> li = q.list();
//        return li;
//
//    }
//    
//    public List show() {
//        List<Moviedemotable> sc = new ArrayList<>();
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo2", "root", "apcl123456");
//            PreparedStatement pstmt = con.prepareStatement("SELECT *FROM Moviedemotable");
//            ResultSet rs = pstmt.executeQuery();
//            while (rs.next()) {
//                Moviedemotable sc1 = new Moviedemotable();
//                sc1.setSitid(rs.getInt("sitid"));
//                sc1.setStype(rs.getString("stype"));
//                sc1.setPrice(rs.getInt("price"));
//                sc.add(sc1);
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return sc;
//    }
}
