import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Music
{
    /**
     * Constructs a Music class
     */
    public Music(){}

    /**
     * Plays the music and sound effects
     * @param File the sound file to be played
     */
    public static void playMusic(File Sound){
        try{
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(Sound));
            clip.start();
        }
        catch(Exception ignored){}
        //https://www.youtube.com/watch?v=QVrxiJyLTqU
    }
}
