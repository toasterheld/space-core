package engine.component.basic;

import engine.component.Component;
import engine.entity.Entity;
import engine.io.audio.AudioManager;
import engine.io.audio.Mixers;
import engine.util.Vector2D;
import javafx.scene.media.MediaPlayer;

/**
 * Represents an audio component that can be attached to an entity.
 * This component provides functionality to play sounds with configurable properties such as path, volume, and pan.
 */
public class Audio extends Component {

    private MediaPlayer mediaPlayer;

    private String path;
    private int volume;
    private int pan;

    /**
     * Constructs an Audio component associated with the specified parent entity.
     *
     * @param parent the parent entity to which this audio component belongs
     */
    public Audio(Entity parent) {
        super(parent);
    }

    /**
     * Plays a sound using the current audio settings (path, volume, pan).
     * The sound is routed through the master audio mixer by default.
     */
    public void playSound() {
        AudioManager.addSound(path, volume, pan, Mixers.MASTER);
    }

    // Getter and Setter methods

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
