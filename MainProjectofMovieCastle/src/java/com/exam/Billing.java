/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exam;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aik
 */
public class Billing {

    public String user;
    public String password;
    public String cNum;
    public String pNum;

    public String movieName;
    public String showDate;
    public String sTime;

    public String idval;
    public String idfinal;

    public String billc;
     public String userNumber;

     
    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }
    public int tsit;

    public String getIdfinal() {
        return idfinal;
    }

    public void setIdfinal(String idfinal) {
        this.idfinal = idfinal;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public String s = "";

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getcNum() {
        return cNum;
    }

    public void setcNum(String cNum) {
        this.cNum = cNum;
    }

    public String getpNum() {
        return pNum;
    }

    public void setpNum(String pNum) {
        this.pNum = pNum;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getShowDate() {
        return showDate;
    }

    public void setShowDate(String showDate) {
        this.showDate = showDate;
    }

    public String getsTime() {
        return sTime;
    }

    public void setsTime(String sTime) {
        this.sTime = sTime;
    }

    public String getIdval() {
        for (String retval : idval.split("\\]|\\[")) {
            s = s + retval;
        }
        return idval = s;
    }

    public void setIdval(String idval) {
        this.idval = idval;
    }

    public String getBillc() {
        return billc;
    }

    public void setBillc(String billc) {
        this.billc = billc;
    }

    public int getTsit() {
        List<Integer> lis = new ArrayList<>();
        for (String retval : idval.split(",")) {
            lis.add(Integer.parseInt(retval));
        }

        return tsit = lis.size();
    }

    public void setTsit(int tsit) {
        this.tsit = tsit;
    }

}
