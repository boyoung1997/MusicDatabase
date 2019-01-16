/**
 * Created by kimboyoung on 2017. 11. 27..
 */
import java.io.Serializable;
public class Muser implements Serializable{
    public static final String
            FNAME = "fname",
            LNAME = "lname",
            UID = "uid",
            FGENRE = "fgenre",
            PHONE = "phone";

    private String fname,lname,fgenre,phone;
    public int uid;

    public Muser(){}

    public Muser(String fname, String lname, int uid, String fgenre, String phone)	{
        this.fname = fname;
        this.lname = lname;
        this.uid = uid;
        this.fgenre = fgenre;
        this.phone = phone;
    }
    public String getFname(){
        return fname;
    }
    public String getLname(){
        return lname;
    }
    public int getUid(){
        return uid;
    }
    public String getFgenre(){
        return fgenre;
    }
    public String getPhone(){
        return phone;
    }

    public void setFname(String fname){
        this.fname = fname;
    }
    public void setLname(String lname){
        this.lname = lname;
    }
    public void setUid(int uid){
        this.uid = uid;
    }
    public void setFgenre(String fgenre){
        this.fgenre = fgenre;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }

    public String toString()	{
        return "first name: " + fname  + " " + "last name: " + lname +  " " + "uid: " + uid +  " " + "favorite genre: " + fgenre +  " " + "phone: " + phone;
    }



}
