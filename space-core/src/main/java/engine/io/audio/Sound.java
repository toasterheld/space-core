package engine.io.audio;

import javafx.scene.media.MediaPlayer;

public class Sound {
    private final MediaPlayer mediaPlayer;
    private final Mixers mixer;

    private boolean isActive = true;

    private float originalVolume = 1.0f;

    public Sound(MediaPlayer mediaPlayer, float volume, Mixers mixer) {
        this.mediaPlayer = mediaPlayer;
        this.originalVolume = volume;
        this.mixer = mixer;
    }


    public MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    public Mixers getMixer() {
        return mixer;
    }

    public boolean isActive() {
        return isActive;
    }
    public void setActive(boolean active) {
        isActive = active;
    }

    public float getOriginalVolume() {
        return originalVolume;
    }
    public void setVolume(double volume) {
        mediaPlayer.setVolume(volume);
    }
}
