/**
 * Created by kimboyoung on 2017. 12. 4..
 */
import java.io.*;
import java.util.*;

public class DBProj {
    private Manage2 manage = new Make(); //for function class
    private Manage aaa = new MusicUserManage();//for making class

    private String readCommandLine() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String input = br.readLine();
        return input;
    }

    public void startWork() {
        Scanner scan = new Scanner(System.in);
        String fname = null;
        String lname = null;
        String fgenre = null;
        String phone = null;
        int uid = 0;
        String menu = null;
        do {
            System.out.println("****Select Menu****");
            System.out.println("1. Admin Menu");
            System.out.println("2. User Menu");
            System.out.println("q. Exit");
            System.out.println("**********************");
            System.out.print(">>");
            try {
                menu = readCommandLine();
                if (menu.equals("1")) {
                    while(true){
                        //Todo admin menu
                        int adNum;
                        System.out.println("0. Return to previous menu");
                        System.out.println("1. View music list");
                        System.out.println("2. Add music");
                        System.out.println("3. Delete music");
                        System.out.println("4. View customer list");
                        System.out.print("Enter number : ");
                        adNum = scan.nextInt();
                        if (adNum == 0) break;
                        Admin(adNum);
                    }
                } else if (menu.equals("2")) {
                    System.out.print("Enter uid : ");
                    int usrNum = scan.nextInt();
                    // search whether user exist or not
                    MusicUserManage mu = new MusicUserManage();
                    mu.userExist(usrNum);
                    // if no user exist
                    if (!mu.userExist(usrNum)) {
                        System.out.println("Failed to login");
                        System.out.println("Do you want to register? If so enter 0, if not enter 1");
                        int registerOrNot = scan.nextInt();
                        if (registerOrNot == 0) {
                            //Todo add user
                            System.out.println("Enter fname, lname, uid, fgenre, phone");
                            //scan
                            try{
                                fname = readCommandLine();
                                lname = readCommandLine();
                                uid = scan.nextInt();
                                fgenre = readCommandLine();
                                phone= readCommandLine();
                            }
                            catch(Exception e){
                                e.printStackTrace();
                            }
                            aaa.addUser(fname,lname,uid,fgenre,phone);
                        }
                    } else { // if user exist
                        System.out.println("Login Approved!");
                        while (true) {
                            System.out.println("");
                            System.out.println("0. Return to previous menu");
                            System.out.println("1. View my playlist list");
                            System.out.println("2. Add playlist");
                            System.out.println("3. Delete playlist");
                            System.out.println("4. Add music to playlist");
                            System.out.println("5. Search music");
                            System.out.println("6. Cancel account");
                            System.out.print("Enter number : ");
                            usrNum = scan.nextInt();
                            if (usrNum == 0) break;
                            User(usrNum);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println();
        }
        while (!menu.equals("q"));
        System.out.println("Quit system");
    }

    public void Admin(int menu) {
        int mid = 0;
        String musicname = null;
        int rnum = 0;
        String genre = null;
        int ano = 0;
        int aid = 0;
        String aname = null;
        int sid = 0;
        String sname = null;
        Scanner scan = new Scanner(System.in);

        if (menu==1) {
            //Todo view music
            List<Music> musics = manage.getMusics();
            for (Music music : musics) {
                System.out.println(music);
                System.out.println("");
            }
        }
        else if (menu==2) {
            //Todo add music
            //Singer
            System.out.println("Enter sid, sname");
            sid = scan.nextInt();
            try{
                sname = readCommandLine();
            }
            catch(Exception e){
                e.printStackTrace();
            }
            aaa.addMusicSinger(sid,sname);

            //Album
            System.out.println("Enter aid,aname");
            aid = scan.nextInt();
            try{
                aname = readCommandLine();
            }
            catch(Exception e){
                e.printStackTrace();
            }
            aaa.addMusicAlbum(aid,aname);

            //Music
            System.out.println("Enter mid, musicname, rnum, genre, ano");
            try{
                mid = scan.nextInt();
                musicname = readCommandLine();
                rnum = scan.nextInt();
                genre = readCommandLine();
                ano = scan.nextInt();
            }
            catch(Exception e){
                e.printStackTrace();
            }
            aaa.addMusicMusic(mid,musicname,rnum,genre,ano);

        } else if (menu==3) {
            //Todo delete music
            System.out.println("Enter musicname");
            //scan
            try{
                musicname = readCommandLine();
            }
            catch(Exception e){
                e.printStackTrace();
            }
            aaa.removeMusic(musicname);

        } else if (menu==4) {
            //Todo view customer list
            List<Muser> users = manage.getMusers();
            for (Muser user : users) {
                System.out.println(user);
                System.out.println("");
            }
        }
        System.out.println();
    }

    public void User(int menu) {
        Scanner scan = new Scanner(System.in);
        //initialization
        int uid;
        int pid = 0;
        int uno = 0;
        int rnum = 0;
        String musicname = null;
        String aname = null;
        String sname = null;
        int select;
        if (menu == 1) {
            //Todo view my playlist
            System.out.println("Enter your own id again : ");
            System.out.println(">>");
            uid = scan.nextInt();
            List<PlayList> playLists = manage.findMyPlayListByUno(uid);
            for (PlayList playList : playLists) {
                System.out.println(playList);
                System.out.println("");
            }
            System.out.println("What playlist you want to see? enter pid");
            pid = scan.nextInt();
            List<Music> musics = manage.findMusicByPid(pid);
            for(Music music : musics){
                System.out.println(music);
                System.out.println("");
            }

        }else if(menu==2){
            //Todo add playlist
            System.out.println("Enter your own id and playlist id : ");
            System.out.println(">>");
            uid = scan.nextInt();
            pid = scan.nextInt();
            aaa.addPlayList(pid,uid);

        }else if(menu==3){
            //Todo delete playlist
            System.out.println("Enter playlist id : ");
            System.out.println(">>");
            pid = scan.nextInt();
            aaa.deletePlayList(pid);

        }  else if (menu == 4) {
            //Todo Add music to playlist
            //search PlayList first
            System.out.println("Enter musicname");
            try{
                musicname = readCommandLine();
            }
            catch(Exception e){
                e.printStackTrace();
            }
            //find mid
            Music music = manage.findMidByMusicname(musicname);
            //then add mid to played_by
            System.out.println("Enter pid");
            pid = scan.nextInt();
            aaa.addToPlayList(pid, music.getMid());
            System.out.println("Do you want to raise reference count? If so enter 0, or not, enter 1");
            rnum = scan.nextInt();
            if(rnum==0) aaa.addReference(musicname);

        }  else if (menu == 5) {
            System.out.println("Search by musicname enter 1, Search by Signer enter 2, search by album enter 3");
            System.out.println(">>");
            select = scan.nextInt();
            if(select == 1){
                //Todo search by music name
                System.out.println("Enter music name");
                try{
                    musicname = readCommandLine();
                }
                catch(Exception e){
                    e.printStackTrace();
                }
                Music music = manage.findMusicByMusicname(musicname);
                System.out.println(music);

            }
            else if (select == 2){
                //Todo search by singer name
                System.out.print("Enter singer name : ");
                try{
                    sname = readCommandLine();
                }
                catch(Exception e){
                    e.printStackTrace();
                }
                List<Music> musics = manage.findMusicBySinger(sname);
                for (Music music2 : musics) {
                    System.out.println(music2);
                    System.out.println("");
                }
            }
            else if (select == 3){
                //Todo search by album name
                System.out.println("Enter album name");
                try{
                    aname = readCommandLine();
                }
                catch(Exception e){
                    e.printStackTrace();
                }
                List<Music> musics2 = manage.findMusicByAlbum(aname);
                for (Music music3 : musics2) {
                    System.out.println(music3);
                    System.out.println("");
                }
            }
        }
        else if (menu == 6) {
            System.out.println("Enter your id");
            uid = scan.nextInt();
            aaa.removeUser(uid);
        }
        System.out.println("");
    }
    public static void main(String[] args) throws Exception {
        DBProj ui = new DBProj();
        ui.startWork();
    }
}