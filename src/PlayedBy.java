/**
 * Created by kimboyoung on 2017. 11. 27..
 */

import java.io.Serializable;
public class PlayedBy implements Serializable {
    public static final String
            MPID = "mpid",
            MMID = "mmid";

    public int mpid,mmid;

    public PlayedBy(int mpid, int mmid)	{
        this.mpid = mpid;
        this.mmid = mmid;
    }

    public PlayedBy(){

    }

    public int getMpid(){
        return mpid;
    }
    public int getMmid(){
        return mmid;
    }
    public void setMpid(int mpid){
        this.mpid = mpid;
    }
    public void setMmid(int mmid) {
        this.mmid = mmid;
    }



    public String toString()	{
        return mpid + "," + mmid + ", NULL";
    }



}
