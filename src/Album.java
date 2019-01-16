/**
 * Created by kimboyoung on 2017. 11. 27..
 */

import java.io.Serializable;

public class Album implements Serializable {
    public static final String
            AID = "aid",
            ANAME = "aname";


    private String aname;
    public int aid;

    public Album(int aid, String aname){
        this.aid = aid;
        this.aname = aname;
    }

    public Album(){}

    public String getAname(){
        return aname;
    }
    public int getAid(){
        return aid;
    }
    public void setAname(String aname){
        this.aname = aname;
    }
    public void setAid(int aid){
        this.aid = aid;
    }


    public String toString()	{
        return aid + " " + aname + ", NULL";
    }

}
