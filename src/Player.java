import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.io.InputStream;

/**
 * Created by RO-QC-LAB16 on 9/26/2016.
 */
public class Player {
    String filename;
    public Player() {
        filename = "sound.wav";
    }
    public void playSound() {
        try {
            InputStream inputStream = getClass().getResourceAsStream(filename);
            AudioStream audioStream = new AudioStream(inputStream);
            AudioPlayer.player.start(audioStream);
        } catch( Exception e) {
            e.printStackTrace();
        }
    }
}
