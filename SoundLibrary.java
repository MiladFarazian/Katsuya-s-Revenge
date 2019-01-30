import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
//import java.util.concurrent.TimeUnit;
//import java.util.Timer;
//import java.util.TimerTask;

class SoundLibrary{
    private Clip soundThrow;
    private Clip soundImpact;
    private Clip soundJump;
    private Clip soundRun;
    private Clip soundSword;
    private Clip soundGong;
    private Clip soundDeath;
    private Clip soundBlip;
    private Clip soundMelee;
    private Clip soundYuh;
    private Clip soundPowerUp;
    public SoundLibrary(String filename)throws Exception{
        //throw
        
        File audiofile = new File("throw_1.wav");
        AudioInputStream audiostream = AudioSystem.getAudioInputStream(audiofile);
        soundThrow = AudioSystem.getClip();
        soundThrow.open(audiostream);
        
        
        //impact
        
        File audiofile2 = new File ("Impact_1.wav");
        audiostream = AudioSystem.getAudioInputStream(audiofile2);
        soundImpact = AudioSystem.getClip();
        soundImpact.open(audiostream);
        
        //jump
        
        File audiofile3 = new File ("spin_jump.wav");
        audiostream = AudioSystem.getAudioInputStream(audiofile3);
        soundJump = AudioSystem.getClip();
        soundJump.open(audiostream);
        
        //footsteps
        
        File audiofile4 = new File ("running_1.wav");
        audiostream = AudioSystem.getAudioInputStream(audiofile4);
        soundRun = AudioSystem.getClip();
        soundRun.open(audiostream);
        
        // enemy sword
        
        File audiofile5 = new File ("sword_1.wav");
        audiostream = AudioSystem.getAudioInputStream(audiofile5);
        soundSword = AudioSystem.getClip();
        soundSword.open(audiostream);
        
        //gong
        
        File audiofile6 = new File ("gong.wav");
        audiostream = AudioSystem.getAudioInputStream(audiofile6);
        soundGong = AudioSystem.getClip();
        soundGong.open(audiostream);
        
        //death
        
        //File audiofile7 = new File ("death_1.wav");
        //audiostream = AudioSystem.getAudioInputStream(audiofile7);
        //soundDeath = AudioSystem.getClip();
        //soundDeath.open(audiostream);
        
        //blip
        
        File audiofile8 = new File ("blip_1.wav");
        audiostream = AudioSystem.getAudioInputStream(audiofile8);
        soundBlip = AudioSystem.getClip();
        soundBlip.open(audiostream);
        
        //melee
        
        File audiofile9 = new File ("slap_1.wav");
        audiostream = AudioSystem.getAudioInputStream(audiofile9);
        soundMelee = AudioSystem.getClip();
        soundMelee.open(audiostream);
        
        //yuh
        /*
        File audiofile10 = new File ("yuhh_1.wav");
        audiostream = AudioSystem.getAudioInputStream(audiofile10);
        soundYuh = AudioSystem.getClip();
        soundYuh.open(audiostream);
        */
        //power up
        
        File audiofile11 = new File ("powerUp_1.wav");
        audiostream = AudioSystem.getAudioInputStream(audiofile11);
        soundPowerUp = AudioSystem.getClip();
        soundPowerUp.open(audiostream);
    }
    
    public Clip getClips(String file){
        if (file == "throw"){
            //sound1.setFramePosition(0);
            soundThrow.setFramePosition(0);
            return soundThrow;
        }
        else if (file == "impact"){
            soundImpact.setFramePosition(0);
            return soundImpact;
        }
        else if (file == "jump"){
            soundJump.setFramePosition(0);
            return soundJump;
        }
        else if (file == "run"){
            soundRun.setFramePosition(0);
            return soundRun;
        }
        else if (file == "sword"){
            soundSword.setFramePosition(0);
            return soundSword;
        }
        else if (file == "gong"){
            soundGong.setFramePosition(0);
            return soundGong;
        }
        else if (file == "death"){
            return soundDeath;
        }
        else if (file == "blip"){
            soundBlip.setFramePosition(0);
            return soundBlip;
        }
        else if (file == "melee"){
            soundMelee.setFramePosition(0);
            return soundMelee;
        }
        else if (file == "yuh"){
            soundYuh.setFramePosition(0);
            return soundYuh;
        }
        else if (file == "powerUp"){
            soundPowerUp.setFramePosition(0);
            return soundPowerUp;
        }
        else{
            return null;
        }
    }
}