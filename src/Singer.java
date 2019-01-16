/**
 * Created by kimboyoung on 2017. 11. 27..
 */

import java.io.Serializable;
public class Singer implements Serializable{
    public static final String
            SID = "sid",
            SNAME = "sname";

    private String sname;
    public int sid;


    public Singer(int sid, String sname, int group_id)	{
        this.sid = sid;
        this.sname = sname;
    }
    public Singer(){}

    public int getSid(){
        return sid;
    }
    public String getSname(){
        return sname;
    }
    public void setSid(int sid){
        this.sid = sid;
    }
    public void setSname(String sname){
        this.sname = sname;
    }



    public String toString()	{
        return sid + " " + sname + " "  + ", NULL";
    }



}
