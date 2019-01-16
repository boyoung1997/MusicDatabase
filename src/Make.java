/**
 * Created by kimboyoung on 2017. 12. 5..
 */
import java.util.*;

public class Make implements Manage2{
    private MusicUserManage dao = new MusicUserManage();

    @Override
    public List<Music> getMusics() {
        return dao.selectAllMusics();
    }
    @Override
    public List<Muser> getMusers() {
        return dao.selectAllUsers();
    }
    @Override
    public List<PlayList> findMyPlayListByUno(int uno){
        return dao.selectPlayListByUno(uno);
    }

    public List<Music> findMusicByAlbum(String aname) {
        return dao.selectMusicByAlbum(aname);
    }

    public List<Music> findMusicBySinger(String sname){
        return dao.selectMusicBySinger(sname);
    }
    public Music findMusicByMusicname(String musicname){
        return dao.selectOneMusic(musicname);

    }
    public Music findMidByMusicname(String musicname){
        return dao.selectMidByMusicname(musicname);
    }

    public List<Music> findMusicByPid(int pid){
        return dao.selectMusicByPid(pid);
    }
}
