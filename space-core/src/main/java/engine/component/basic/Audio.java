package engine.component.basic;

import engine.component.Component;
import engine.entity.Entity;
import engine.io.audio.AudioManager;
import engine.io.audio.Mixers;
import engine.util.Vector2D;
import javafx.scene.media.MediaPlayer;

public class Audio extends Component {

    private MediaPlayer mediaPlayer;

    private String path;
    private int volume;
    private int pan;

    public Audio(Entity parent) {
        super(parent);
    }


    public void playSound(){
        AudioManager.addSound(path, volume, pan, Mixers.MASTER);
    }


    public int getVolume() {
        return volume;
    }

    public int getPan() {
        return pan;
    }

    public String getPath() {
        return path;
    }

    public void setPan(int pan) {
        this.pan = pan;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}
