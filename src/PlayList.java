/**
 * Created by kimboyoung on 2017. 11. 27..
 */

import java.io.Serializable;
public class PlayList implements Serializable{
    public static final String
            PID = "pid",
            UNO = "uno";

    private int uno;
    public int pid;

    public PlayList(int pid, int uno)	{
        this.pid = pid;
        this.uno = uno;
    }

    public PlayList(){}

    public int getUno(){
        return uno;
    }
    public int getPid(){
        return pid;
    }
    public void setUno(int uno){
        this.uno = uno;
    }
    public void setPid(int pid){
        this.pid = pid;
    }


    public String toString()	{
        return "playlist id: " + pid + " " + "your id: "+ uno;
    }



}
