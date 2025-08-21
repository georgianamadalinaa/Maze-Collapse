package pro;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

public class MelodiePlayerSimplu{
    private Clip clip;

    public MelodiePlayerSimplu(String filePath) {
        try {
            File audioFile = new File(filePath);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);

            AudioFormat format = audioInputStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);

            if (!AudioSystem.isLineSupported(info)) {
                System.out.println("Format audio neacceptat!");
                return;
            }

            clip = (Clip) AudioSystem.getLine(info);
            clip.open(audioInputStream);

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void play() {
        if (clip != null) {
            clip.start();
        }
    }

    public void stop() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }

    public void loop() {
        if (clip != null) {
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
    }

    public static void main(String[] args) {
        // Exemplu de utilizare
        MelodiePlayerSimplu player = new MelodiePlayerSimplu("C:\\Users\\ga214\\Eclipse-JAVA-2022-09-workspace\\P1\\SSound.wav");
        player.play();

        // Așteaptă puțin înainte de a opri programul
        try {
            Thread.sleep(5000); // Așteaptă 5 secunde
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        player.stop();
    }
}
