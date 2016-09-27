import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.io.InputStream;

/**
 * Created by RO-QC-LAB16 on 9/26/2016.
 */
public class Player {
    private String filename;
    private AudioStream audioStream;
    public Player() {
        filename = "sound.wav";
    }
    public void playSound() {
        try {
            InputStream inputStream = getClass().getResourceAsStream(filename);
            audioStream = new AudioStream(inputStream);
            AudioPlayer.player.start(audioStream);
        } catch( Exception e) {
            e.printStackTrace();
        }
    }
    public void stopSound() {
        AudioPlayer.player.stop(audioStream);
    }
}
