/**
 * Created by kimboyoung on 2017. 11. 27..
 */

import java.io.Serializable;
public class SingerOf implements Serializable{
    public static final String
            SSID = "ssid",
            MMID = "mmid";

    public int ssid,mmid;

    public SingerOf(int ssid, int mmid)	{
        this.ssid = ssid;
        this.mmid = mmid;
    }

    public SingerOf(){}

    public int getSsid(){
        return ssid;
    }
    public int getMmid(){
        return mmid;
    }

    public void setSsid(int ssid){
        this.ssid = ssid;
    }
    public void setMmid(int mmid){
        this.mmid = mmid;
    }


    public String toString()	{
        return ssid + "," + mmid + ", NULL";
    }



}
