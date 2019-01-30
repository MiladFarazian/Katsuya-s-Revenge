import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

class SongLibrary{
    private Clip levelSong;
    File songFile;
    public void setSong (int value)throws Exception{
        //song
        
        songFile = new File ("song_" + value + ".wav");
        AudioInputStream audiostream = AudioSystem.getAudioInputStream(songFile);
        levelSong = AudioSystem.getClip();
        levelSong.open(audiostream);
    }
    
    public Clip getSong(){
        return levelSong;
    }
}