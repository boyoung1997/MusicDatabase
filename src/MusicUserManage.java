/**
 * Created by kimboyoung on 2017. 11. 27..
 */
import java.util.*;
import java.sql.*;


public class MusicUserManage implements Manage{
    static final String URL = "jdbc:mysql://127.0.0.1:3306/dbproj?autoReconnect=true&useSSL=false";
    static final String USER = "root";
    static final String PASSWORD = "dake1004";

    //load jdbc driver
    public MusicUserManage() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //get connection
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    //close connection
    private void close(ResultSet rs, PreparedStatement pstmt, Connection con) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Adds a music to the database to which the MusicSearch object is connected
     */
    @Override
    public void addMusicMusic(int mid, String musicname, int rnum, String genre, int ano) {
        Connection con = null;
        PreparedStatement pstmt = null;

        String sql = "INSERT INTO Music VALUES (?,?,?,?,?) ";

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1,mid);
            pstmt.setString(2, musicname);
            pstmt.setInt(3,rnum);
            pstmt.setString(4, genre);
            pstmt.setInt(5, ano);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(null, pstmt, con);
        }

    }
    @Override
    public void addMusicAlbum(int aid, String aname) {
        Connection con = null;
        PreparedStatement pstmt = null;

        String sql = "INSERT INTO Album VALUES (?,?) ";

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1,aid);
            pstmt.setString(2, aname);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(null, pstmt, con);
        }

    }
    @Override
    public void addMusicSinger(int sid, String sname) {
        Connection con = null;
        PreparedStatement pstmt = null;

        String sql = "INSERT INTO Singer VALUES (?,?) ";

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1,sid);
            pstmt.setString(2, sname);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(null, pstmt, con);
        }

    }
    /**
     * Adds an user to the database with the following parameters as values for its attributes
     */
    @Override
    public void addUser(String fname, String lname, int uid, String fgenre, String phone){
        Connection con = null;
        PreparedStatement pstmt = null;

        String sql = "INSERT INTO Muser VALUES (?, ?, ?,?, ?)";

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, fname);
            pstmt.setString(2, lname);
            pstmt.setInt(3, uid);
            pstmt.setString(4, fgenre);
            pstmt.setString(5,phone);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(null, pstmt, con);
        }
    }
    /**
     * Remove values for a music entry
     */
    @Override
    public void removeMusic(String musicname){
        Connection con = null;
        PreparedStatement pstmt = null;

        String sql = "DELETE FROM Music WHERE musicname = ?";

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, musicname);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(null, pstmt, con);
        }
        //Todo delete from playlist

    }
    /**
     * Remove values for a user entry
     */
    @Override
    public void removeUser(int uid) {
        Connection con = null;
        PreparedStatement pstmt = null;

        String sql = "DELETE FROM Muser WHERE uid = ?";

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1,uid);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(null, pstmt, con);
        }

    }


    /**
     * Show all users
     */
    @Override
    public List<Muser> selectAllUsers(){
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        List<Muser> all = new ArrayList<Muser>();
        Muser user = null;

        String sql = "SELECT * " +
                "FROM Muser " +
                "ORDER By uid DESC";

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                user = new Muser();
                user.setFgenre(rs.getString("fgenre"));
                user.setFname(rs.getString("fname"));
                user.setLname(rs.getString("lname"));
                user.setPhone(rs.getString("phone"));
                user.setUid(rs.getInt("uid"));
                all.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs, pstmt, con);
        }

        return all;
    }

    /**
    *Search by music name
     */
    @Override
    public Music selectOneMusic(String musicname){
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Music music = null;

        String sql = "SELECT * " +
                "FROM Music " +
                "WHERE musicname = ?";
        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, musicname);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                music = new Music();
                music.setMid(rs.getInt("mid"));
                music.setMusicname(rs.getString("musicname"));
                music.setRnum(rs.getInt("rnum"));
                music.setGenre(rs.getString("genre"));
                music.setAno(rs.getInt("ano"));
                return music;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs, pstmt, con);
        }
        return null;
    }

    /**
     * Show all music
     */
    @Override
    public List<Music> selectAllMusics(){
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        List<Music> all = new ArrayList<Music>();
        Music music = null;

        String sql = "SELECT * " +
                "FROM Music " +
                "ORDER By mid DESC";

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                music = new Music();
                music.setMid(rs.getInt("mid"));
                music.setMusicname(rs.getString("musicname"));
                music.setRnum(rs.getInt("rnum"));
                music.setGenre(rs.getString("genre"));
                music.setAno(rs.getInt("ano"));
                all.add(music);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs, pstmt, con);
        }

        return all;
    }

    @Override
    public List<Music> selectMusicBySinger(String sname){
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        List<Music> matched = new ArrayList<Music>();
        Music music = null;

        String sql = "SELECT Music.mid, Music.musicname, Music.rnum, Music.genre, Music.ano " +
                "FROM Music, Singer, SingerOf " +
                "WHERE Music.mid = SingerOf.mmid AND SingerOf.ssid = Singer.sid AND Singer.sname = ?";

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, sname);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                music = new Music();
                music.setMid(rs.getInt("mid"));
                music.setMusicname(rs.getString("musicname"));
                music.setRnum(rs.getInt("rnum"));
                music.setGenre(rs.getString("genre"));
                music.setAno(rs.getInt("ano"));
                matched.add(music);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs, pstmt, con);
        }
        return matched;
    }

    @Override
    public List<Music> selectMusicByAlbum(String aname) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        List<Music> matched = new ArrayList<Music>();
        Music music = null;

        String sql = "SELECT Music.mid, Music.musicname, Music.rnum, Music.genre, Music.ano " +
                "FROM Music, Album " +
                "WHERE Music.ano = Album.aid AND Album.aname = ?";

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, aname);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                music = new Music();
                music.setMid(rs.getInt("mid"));
                music.setMusicname(rs.getString("musicname"));
                music.setRnum(rs.getInt("rnum"));
                music.setGenre(rs.getString("genre"));
                music.setAno(rs.getInt("ano"));
                matched.add(music);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs, pstmt, con);
        }
        return matched;
    }

    @Override
    public void addPlayList(int pid, int uno){
        Connection con = null;
        PreparedStatement pstmt = null;

        String sql = "INSERT INTO PlayList VALUES (?, ?)";

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, pid);
            pstmt.setInt(2, uno);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(null, pstmt, con);
        }
    }

    @Override
    public void deletePlayList(int pid){
        Connection con = null;
        PreparedStatement pstmt = null;

        String sql = "DELETE FROM PlayList WHERE pid = ?";

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, pid);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(null, pstmt, con);
        }

    }

    public Music selectMidByMusicname(String musicname){
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Music music = null;

        String sql = "SELECT mid " +
                "FROM Music " +
                "WHERE musicname = ?";
        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, musicname);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                music = new Music();
                music.setMid(rs.getInt("mid"));
                return music;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs, pstmt, con);
        }
        return null;

    }

    //Todo add method 'addToPlayList'
    public void addToPlayList(int mpid, int mmid){
        //open mysql
        Connection con = null;
        PreparedStatement pstmt = null;

        //add music to playlist
        String sql = "INSERT INTO PlayedBy VALUES (?,?)";
        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, mpid);
            pstmt.setInt(2, mmid);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(null, pstmt, con);
        }

    }

    @Override
    public boolean userExist(int uid){
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Muser user = null;

        String sql = "SELECT * " +
                "FROM Muser " +
                "WHERE uid = ?";

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, uid);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                user = new Muser(rs.getString("fname"), rs.getString("lname"), rs.getInt("uid"), rs.getString("fgenre"), rs.getString("phone"));
                return true;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs, pstmt, con);
        }
        return false;

    }


    public List<PlayList> selectPlayListByUno(int uno){
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        List<PlayList> matched = new ArrayList<PlayList>();
        PlayList playList = null;

        String sql = "SELECT * " +
                "FROM PlayList " +
                "WHERE uno = ?";

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, uno);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                playList = new PlayList();
                playList.setUno(rs.getInt("uno"));
                playList.setPid(rs.getInt("pid"));
                matched.add(playList);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs, pstmt, con);
        }
        return matched;
    }

    public List<Music> selectMusicByPid(int pid){
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        List<Music> matched = new ArrayList<Music>();
        Music music = null;

        String sql = "SELECT Music.mid, Music.musicname, Music.rnum, Music.genre, Music.ano " +
                "FROM Music, PlayList, PlayedBy " +
                "WHERE Music.mid = PlayedBy.mmid AND PlayedBy.mpid = PlayList.pid AND PlayList.pid = ?";

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, pid);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                music = new Music();
                music.setMid(rs.getInt("mid"));
                music.setMusicname(rs.getString("musicname"));
                music.setRnum(rs.getInt("rnum"));
                music.setGenre(rs.getString("genre"));
                music.setAno(rs.getInt("ano"));
                matched.add(music);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs, pstmt, con);
        }
        return matched;
    }

    public void addReference(String musicname){
        Connection con = null;
        PreparedStatement pstmt = null;

        String sql = "UPDATE Music " +
                "SET rnum = rnum + 1 " +
                "WHERE musicname = ?";
        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, musicname);
            pstmt.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            close(null, pstmt, con);
        }
    }


}