/**
 * Created by kimboyoung on 2017. 11. 28..
 */
import java.util.List;

public interface Manage {
    public void addMusicMusic(int mid, String musicname, int rnum,  String genre, int ano);

    public void addMusicAlbum(int aid, String aname);

    public void addMusicSinger(int sid, String sname);

    public void addUser(String fname, String lname, int uid, String fgenre, String phone);

    public void removeMusic(String musicname);

    public void removeUser(int uid);

    //show all users
    public List<Muser> selectAllUsers();

    //show all musics
    public List<Music> selectAllMusics();

    //search music by musicname
    public Music selectOneMusic(String musicname);

    //search music by singer
    public List<Music> selectMusicBySinger(String sname);

    //search music by album
    public List<Music> selectMusicByAlbum(String aname);

    public boolean userExist(int usrNum);

    //see my playlist
    public List<PlayList> selectPlayListByUno(int uno);

    //make playlist
    public void addPlayList(int pid, int uno);

    //remove playlist
    public void deletePlayList(int pid);

    //add music to playlist
    public void addToPlayList(int pid, int mid);

    //search music by mid
    public Music selectMidByMusicname(String musicname);

    public void addReference(String musicname);





}
