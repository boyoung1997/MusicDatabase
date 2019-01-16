import java.util.List;

/**
 * Created by kimboyoung on 2017. 12. 5..
 */
public interface Manage2 {

    public List<Music> getMusics();

    public List<Muser> getMusers();

    public List<PlayList> findMyPlayListByUno(int uno);

    public List<Music> findMusicByAlbum(String aname);

    public Music findMusicByMusicname(String musicname);

    public List<Music> findMusicBySinger(String sname);

    public Music findMidByMusicname(String musicname);

    public List<Music> findMusicByPid(int pid);

}
