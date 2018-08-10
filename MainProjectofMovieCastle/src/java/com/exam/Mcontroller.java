/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exam;

import com.exam.madding.Mschedule;
import com.exam.user.Userreg;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author l2pc209m
 */
@Controller
public class Mcontroller {

    String vis = "hid";
//-----user login part-------
    //reg user

    @RequestMapping("save.htm")
    public String doSave(@ModelAttribute("x") Userreg ur, Model m) {
        LDAO dao = new LDAO();
        dao.DoS(ur);
        return "login";
    }
    //log user

    @RequestMapping("loginC.htm")
    public String doLogin(@ModelAttribute("ln") Userreg ur, Model m) {
        LDAO dao = new LDAO();
        GetDataJDBC gdj = new GetDataJDBC();

        if (dao.DoC(ur.getMobile(), ur.getPassword())) {
            //set up user mobile number to send selecting movie page
            m.addAttribute("mnum", ur.getMobile());
            //m.addAttribute("un", gdj.getUserName(ur.getMobile()));

            //movie name send
            List<String> st = gdj.getMovieName();
            m.addAttribute("ai", "Select Movie");
            m.addAttribute("bi", st);

            return "movieSelect_1";
        } else {
            m.addAttribute("msgulg", "Login Fail");
            return "login";
        }
    }

    //log Admin
    @RequestMapping("loginAdmin.htm")
    public String doLogin(@ModelAttribute("ln") adminClass ur, Model m) {
        LDAO dao = new LDAO();
        MDAO mdao = new MDAO();
        GetDataJDBC gdj = new GetDataJDBC();
        List<Mschedule> li = mdao.doMAShow();
        // when admin name and password ok the are a fixed value it can be databse wise in future
        if (ur.getAdmin().equals("admin") && ur.getPassword().equals("admin")) {
            //for stutus panel movie selceting
            List<String> st = gdj.getMovieName();
            m.addAttribute("ai", "Select Movie");
            m.addAttribute("bi", st);
            //geting mscedule  table value

            m.addAttribute("ml", li);
            //visibility controll
            String vis = "hid";
            m.addAttribute("vis", vis);

            return "movieSeduleAdding";
        } else {
            m.addAttribute("msgalg", "Admin Login Fail");
            return "login";
        }
    }

//------movie adding or deleting   part-------    
    @RequestMapping("madding.htm")
    public String DoaddM(@ModelAttribute("add") Mschedule mv, Model m) throws ParseException {
        MDAO dao = new MDAO();
        GetDataJDBC gdj = new GetDataJDBC();

        String d = mv.getSmdate();
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dt = sdf.parse(d);
        java.sql.Date fd = new java.sql.Date(dt.getTime());
        mv.setMdate(fd);
        //dao.doMAdd(mv);
        dao.doMAdd(mv);
        List<Mschedule> li = dao.doMAShow();
        //for stutus panel movie selceting
        List<String> st = gdj.getMovieName();
        m.addAttribute("ai", "Select Movie");
        m.addAttribute("bi", st);
        ////geting mscedule  table value
        m.addAttribute("ml", li);
        
        //visibility controll
            String vis = "hid";
            m.addAttribute("vis", vis);
            
        return "movieSeduleAdding";
    }

    @RequestMapping("maddingdelte.htm")
    public String DoaddMDelete(@ModelAttribute("add2") Mschedule mv, Model m) {
        MDAO dao = new MDAO();
        GetDataJDBC gdj = new GetDataJDBC();
        dao.doMDelete(mv);
        List<Mschedule> li = dao.doMAShow();
        //for stutus panel movie selceting
        List<String> st = gdj.getMovieName();
        m.addAttribute("ai", "Select Movie");
        m.addAttribute("bi", st);
        //visibility controll
            String vis = "hid";
            m.addAttribute("vis", vis);

        m.addAttribute("ml", li);
        return "movieSeduleAdding";
    }
    //on movie change

    @RequestMapping("movieSelect.htm")
    public String DoMSelect(@ModelAttribute("ms1") Billing b, Model m) {
        String a = b.getMovieName();
        GetDataJDBC gdj = new GetDataJDBC();
        List<String> st = gdj.getMovieName();
        List<String> md = gdj.getMovieDate(a);
        st.remove(a);
        m.addAttribute("mnum", b.getUserNumber());
        m.addAttribute("bi", st);
        m.addAttribute("ai", a);
        m.addAttribute("mdt", md);
        return "movieSelect_1";
    }

    //on movie change for admin page
    @RequestMapping("movieSelectForAdmin.htm")
    public String DoMSelectForAdmin(@ModelAttribute("ms1") Billing b, Model m) {
        String a = b.getMovieName();
        MDAO dao = new MDAO();
        GetDataJDBC gdj = new GetDataJDBC();
        List<String> st = gdj.getMovieName();
        List<String> md = gdj.getMovieDate(a);
        st.remove(a);
        m.addAttribute("mnum", b.getUserNumber());
        m.addAttribute("bi", st);
        m.addAttribute("ai", a);
        m.addAttribute("mdt", md);
        ////geting mscedule  table value
        List<Mschedule> li = dao.doMAShow();
        m.addAttribute("ml", li);

        //visibility controll
        String vis = "hid";
        m.addAttribute("vis", vis);

        return "movieSeduleAdding";
    }

    //for see sold seat info button event
    @RequestMapping("seeStatus.htm")
    public String seeSoldStatus(@ModelAttribute("ms3") Billing b, Model m) {
        int stprice = 0;
        int tprice = 0;
        GetDataJDBC gdj = new GetDataJDBC();

        List<ForSoldStatus> sl = new ArrayList<>();

        String mname = b.getMovieName();
        String mdate = b.getShowDate();
        String mtime = b.getsTime();

        int soldDseat = gdj.getAvSit(mname, mdate, mtime, 1, 51);
        int soldPseat = gdj.getAvSit(mname, mdate, mtime, 52, 103);
        int soldGseat = gdj.getAvSit(mname, mdate, mtime, 104, 126);
        int soldSseat = gdj.getAvSit(mname, mdate, mtime, 127, 146);

        int dsa = 51 - soldDseat;
        int psa = 52 - soldPseat;
        int gsa = 23 - soldGseat;
        int ssa = 20 - soldSseat;

        int dsp = gdj.getSitPrice(mname, mdate, "dsprice");
        int psp = gdj.getSitPrice(mname, mdate, "psprice");
        int gsp = gdj.getSitPrice(mname, mdate, "gsprice");
        int ssp = gdj.getSitPrice(mname, mdate, "ssprice");

        ForSoldStatus m1 = new ForSoldStatus();
        ForSoldStatus m2 = new ForSoldStatus();
        ForSoldStatus m3 = new ForSoldStatus();
        ForSoldStatus m4 = new ForSoldStatus();

        m1.setSeatType("Diamond");
        m1.setSoldSeat(soldDseat);
        m1.setTotalseat(51);
        m1.setUnSoldSeat(dsa);
        m1.setUnitePrice(dsp);
        m1.setSoldPrice(dsp * soldDseat);
        m1.setTotalSoldPrice(51 * dsp);
        sl.add(m1);
        //to show total sold seat and total seat can be sold  price in last row price in status info table
        stprice = stprice + dsp * soldDseat;
        tprice = tprice + 51 * dsp;

        m2.setSeatType("Platinum");
        m2.setSoldSeat(soldPseat);
        m2.setTotalseat(52);
        m2.setUnSoldSeat(psa);
        m2.setUnitePrice(psp);
        m2.setSoldPrice(psp * soldPseat);
        m2.setTotalSoldPrice(52 * psp);
        sl.add(m2);

        stprice = stprice + psp * soldPseat;
        tprice = tprice + 52 * psp;

        m3.setSeatType("Gold");
        m3.setSoldSeat(soldGseat);
        m3.setTotalseat(23);
        m3.setUnSoldSeat(gsa);
        m3.setUnitePrice(gsp);
        m3.setSoldPrice(gsp * soldGseat);
        m3.setTotalSoldPrice(23 * gsp);
        sl.add(m3);

        stprice = stprice + gsp * soldGseat;
        tprice = tprice + 23 * gsp;

        m4.setSeatType("Silver");
        m4.setSoldSeat(soldSseat);
        m4.setTotalseat(20);
        m4.setUnSoldSeat(ssa);
        m4.setUnitePrice(ssp);
        m4.setSoldPrice(ssp * soldSseat);
        m4.setTotalSoldPrice(20 * ssp);
        sl.add(m4);

        stprice = stprice + ssp * soldSseat;
        tprice = tprice + 20 * ssp;

        //sending value to sitMap page
        m.addAttribute("mn", mname);
        m.addAttribute("md", mdate);
        m.addAttribute("mt", mtime);
        m.addAttribute("list", sl);
        m.addAttribute("stprice", stprice);
        m.addAttribute("tprice", tprice);

        List<String> st = gdj.getMovieName();
        m.addAttribute("ai", "Select Movie");
        m.addAttribute("bi", st);

        //visibility controll
        String vis = "vis";
        m.addAttribute("vis", vis);

        return "movieSeduleAdding";
    }

    @RequestMapping("movieSelectStart.htm")
    public String DoMSelectStart(@ModelAttribute("ms2") Billing b, Model m) {
        GetDataJDBC gdj = new GetDataJDBC();
        List<String> st = gdj.getMovieName();
        m.addAttribute("ai", "Select Movie");
        m.addAttribute("bi", st);
        return "movieSelect_1";
    }

    //for go to sitmap page
    @RequestMapping("goMainPage.htm")
    public String goMainPage(@ModelAttribute("ms3") Billing b, Model m) {
        GetDataJDBC gdj = new GetDataJDBC();

        List<MakeList> sl = new ArrayList<>();

        String mname = b.getMovieName();
        String mdate = b.getShowDate();
        String mtime = b.getsTime();

        int dsa = 51 - gdj.getAvSit(mname, mdate, mtime, 1, 51);
        int psa = 52 - gdj.getAvSit(mname, mdate, mtime, 52, 103);
        int gsa = 23 - gdj.getAvSit(mname, mdate, mtime, 104, 126);
        int ssa = 20 - gdj.getAvSit(mname, mdate, mtime, 127, 146);

        //all sold sit id in a array to String converting
        List<String> soldSit = gdj.getSoldSit(mname, mdate, mtime);
        String sslds = "";

        if (soldSit.size() > 0) {

            int i;
            for (i = 0; i < (soldSit.size() - 1); i++) {
                sslds = sslds + soldSit.get(i) + ",";
            }
            sslds = sslds + soldSit.get(i);
        }

        int dsp = gdj.getSitPrice(mname, mdate, "dsprice");
        int psp = gdj.getSitPrice(mname, mdate, "psprice");
        int gsp = gdj.getSitPrice(mname, mdate, "gsprice");
        int ssp = gdj.getSitPrice(mname, mdate, "ssprice");

        MakeList ml = new MakeList();
        MakeList m2 = new MakeList();
        MakeList m3 = new MakeList();
        MakeList m4 = new MakeList();
        ml.setN1("Diamond");
        ml.setN2("" + dsa);
        ml.setN3(dsp);
        sl.add(ml);

        m2.setN1("Platinum");
        m2.setN2("" + psa);
        m2.setN3(psp);
        sl.add(m2);

        m3.setN1("Gold");
        m3.setN2("" + gsa);
        m3.setN3(gsp);
        sl.add(m3);

        m4.setN1("Silver");
        m4.setN2("" + ssa);
        m4.setN3(ssp);
        sl.add(m4);
        //counting available seat for user
        int availSeatForUser = 10 - gdj.getUserBuingSeat(mname, mdate, mtime, b.getUserNumber());

        //sending value to sitMap page
        m.addAttribute("mn", mname);
        m.addAttribute("md", mdate);
        m.addAttribute("mt", mtime);
        m.addAttribute("list", sl);
        m.addAttribute("ssit", sslds);//all sold sit id in a attribute
        m.addAttribute("mnum", b.getUserNumber()); //user pn number sending will be hiden
        m.addAttribute("userName", gdj.getUserName(b.getUserNumber()));
        m.addAttribute("uavs", availSeatForUser); //user pn number sending will be hiden
        return "sitMap";
    }

    // billing conferming page... page name test.jsp
    @RequestMapping("gobilling.htm")
    public String DoNext(@ModelAttribute("ms2") Billing b, Model m) {
        GetDataJDBC gdj = new GetDataJDBC();

        m.addAttribute("md", b.getShowDate());
        m.addAttribute("mn", b.getMovieName());
        m.addAttribute("mt", b.getsTime());
        m.addAttribute("sitid", b.getIdval());
        m.addAttribute("mnum", b.getUserNumber());
        m.addAttribute("userName", gdj.getUserName(b.getUserNumber()));

        m.addAttribute("bl", b.getBillc());
        m.addAttribute("ts", b.getTsit());
        return "test";
    }

    @RequestMapping("confirm.htm")
    public String DoConfirm(@ModelAttribute("ms2") FinalBilling b, Model m) throws ParseException {
        GetDataJDBC jd = new GetDataJDBC();

        String md = b.getShowDate();
        String mn = b.getMovieName();
        String mt = b.getsTime();
        String sitid = b.getIdval();
        String user = b.getUser();
        String umobile = b.getMobile();
        int bl = Integer.parseInt(b.getBillc());
        int ts = b.getTsit();

        if (jd.doConfirm(md, mn, mt, sitid, user, bl, ts, umobile)) {
            m.addAttribute("ai", "success!!! \n\n a file named ticket hasben sent to your desktop...print and show that on Entry time ");
            PdfGenarator pdg=new PdfGenarator();
            //Report Call here
            Connection con;
           
                pdg.pdf();
           
            return "confirmationPage";

        } else {
            m.addAttribute("ai", "Somethin wrong data can not be inserted!!!");
            return "confirmationPage";
        }

    }

}
