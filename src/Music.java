/**
 * Created by kimboyoung on 2017. 11. 27..
 */

import java.io.Serializable;
import java.sql.*;
public class Music implements Serializable{
    public static final String
            MID = "mid",
            MUSICNAME = "musicname",
            RNUM = "rnum",
            GENRE = "genre",
            ANO = "ano";

    private String musicname,genre;
    private int ano;
    public int mid, rnum;

    public Music() {}

    public Music(int mid, String musicname, int rnum,  String genre, int ano)	{
        this.mid = mid;
        this.musicname = musicname;
        this.rnum = rnum;
        this.genre = genre;
        this.ano = ano;
    }
    public int getMid(){
        return mid;
    }
    public String getMusicName(){
        return musicname;
    }
    public int getRnum(){
        return rnum;
    }
    public String getGenre(){
        return genre;
    }
    public int getAno(){
        return ano;
    }

    public void setMid(int mid){
        this.mid = mid;
    }
    public void setMusicname(String musicname){
        this.musicname = musicname;
    }
    public void setRnum(int Rnum){
        this.rnum = rnum;
    }
    public void setGenre(String genre){
        this.genre = genre;
    }
    public void setAno(int ano){
        this.ano = ano;
    }



    public String toString()	{
        return "id: " + mid + " " + "music name: " + musicname + " " + "recommended number: " + rnum + " " + "genre: " + genre + " " + "album number: " + ano ;
    }


}
