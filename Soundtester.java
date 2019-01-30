import java.util.concurrent.TimeUnit;
import javax.sound.sampled.Clip;
public class Soundtester{
    public static void main(String[] args)throws Exception{
        //clip launcher
        
        SoundLibrary sounds = new SoundLibrary("x");
        sounds.getClips("powerUp").start();
        TimeUnit.SECONDS.sleep(2);
        sounds.getClips("run").loop(Clip.LOOP_CONTINUOUSLY);
        TimeUnit.SECONDS.sleep(5);
        sounds.getClips("run").stop();
        
        //song player
        
        SongLibrary songs = new SongLibrary();
        songs.setSong(1);
        songs.getSong().start();
        TimeUnit.SECONDS.sleep(10);
        songs.getSong().stop();
        
        songs.setSong(2);
        songs.getSong().start();
        TimeUnit.SECONDS.sleep(10);
        songs.getSong().stop();
    }
    
}