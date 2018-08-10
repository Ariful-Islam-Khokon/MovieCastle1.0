/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author l2pc215m
 */
public class GetDataJDBC extends BaseDAO{
       Connection con;
        public String getUserName(String mob) {
        String userName="";

        try {
             con=getConnection();
            PreparedStatement pstmt = con.prepareStatement("SELECT uname FROM userreg where mobile='"+mob+"'");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                userName=rs.getString("uname");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return userName;
    }

    public List<String> getMovieName() {
        List<String> movieName = new ArrayList<>();

        try {
             con=getConnection();
            PreparedStatement pstmt = con.prepareStatement("SELECT  distinct mname FROM mschedule where mdate>=DATE(NOW())");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                movieName.add(rs.getString("mname"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return movieName;
    }

    public List<String> getMovieDate(String mn) {
        List<String> movieDate = new ArrayList<>();

        try {
              con=getConnection();
            PreparedStatement pstmt = con.prepareStatement("SELECT mdate FROM mschedule where mname='" + mn + "'");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                movieDate.add(rs.getString("mdate"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return movieDate;

    }
//for get avilable sit numbers

    public int getAvSit(String mn, String dt, String st, int fsit, int lsit) {
        String c = "";
        List<Integer> sarray = new ArrayList<>();
        try {
            con=getConnection();
            PreparedStatement pstmt = con.prepareStatement("SELECT sitid FROM transactiontab where mname='" + mn + "' and mdate='" + dt + "' and showtime='"+st+"'");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                c = rs.getString("sitid");
                for (String retval : c.split(",")) {
                    int sint = Integer.parseInt(retval);
                    if (sint >= fsit && sint <= lsit) {
                        sarray.add(sint);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sarray.size();
    }
    
//for get sold sit numbers

    public List<String> getSoldSit(String mn, String dt, String st) {
        String c = "";
        List<String> sarray = new ArrayList<>();
        try {
             con=getConnection();
            PreparedStatement pstmt = con.prepareStatement("SELECT sitid FROM transactiontab where mname='" + mn + "' and mdate='" + dt + "' and showtime='"+st+"'");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                c = rs.getString("sitid");
                for (String retval : c.split(",")){
                        sarray.add(retval);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sarray;
    }

//for get users buing sit numbers

    public int getUserBuingSeat(String mn, String dt, String st,String mob){
        int c=0;

        try {
             con=getConnection();
            PreparedStatement pstmt = con.prepareStatement("SELECT totalsit FROM transactiontab where mname='" + mn + "' and mdate='" + dt + "' and showtime='"+st+"'and mobile='"+mob+"'");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                c=c+rs.getInt("totalsit");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }    

    public int getSitPrice(String mn, String dt, String sitprice) {
        int P = 12;
        try {
             con=getConnection();
            PreparedStatement pstmt = con.prepareStatement("select " + sitprice + " FROM mschedule where mname='" + mn + "' and mdate='" + dt + "'");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                P = rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return P;
    }

    public boolean doConfirm(String md, String mn, String st, String sid, String user, int bill, int ts,String mob) throws ParseException {
        int i = 0;
        try {
            con=getConnection();
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO transactiontab(tdate,mdate,mname,showtime,sitid,user,bill,totalsit,mobile) VALUES (DATE(NOW()),DATE '" + md + "','" + mn + "','" + st + "','" + sid + "','" + user + "'," + bill + "," + ts + ",'"+mob+"')");
            i = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (i > 0) {
            return true;
        } else {
            return false;
        }
    }

}
