/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exam;

/**
 *
 * @author khoko
 */
public class ForSoldStatus {

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public int getSoldSeat() {
        return soldSeat;
    }

    public void setSoldSeat(int soldSeat) {
        this.soldSeat = soldSeat;
    }

    public int getUnSoldSeat() {
        return unSoldSeat;
    }

    public void setUnSoldSeat(int unSoldSeat) {
        this.unSoldSeat = unSoldSeat;
    }

    public int getUnitePrice() {
        return unitePrice;
    }

    public void setUnitePrice(int unitePrice) {
        this.unitePrice = unitePrice;
    }

    public int getSoldPrice() {
        return soldPrice;
    }

    public void setSoldPrice(int soldPrice) {
        this.soldPrice = soldPrice;
    }

    public int getTotalseat() {
        return totalseat;
    }

    public void setTotalseat(int totalseat) {
        this.totalseat = totalseat;
    }

    public int getTotalSoldPrice() {
        return totalSoldPrice;
    }

    public void setTotalSoldPrice(int totalSoldPrice) {
        this.totalSoldPrice = totalSoldPrice;
    }
   
    String seatType;
    int soldSeat;
    int unSoldSeat;
    int unitePrice;
    int soldPrice;
    int totalseat;
    int totalSoldPrice;
    

}
