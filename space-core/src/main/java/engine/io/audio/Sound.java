package engine.io.audio;

import javafx.scene.media.MediaPlayer;

/**
 * Represents a sound in the game, encapsulating a media player for playback,
 * volume control, and the mixer channel it belongs to (e.g., background or effects).
 */
public class Sound {
    private final MediaPlayer mediaPlayer;  // The media player that handles the playback of the sound
    private final Mixers mixer;  // The mixer channel this sound belongs to (e.g., BACKGROUND, EFFECTS)

    private boolean isActive = true;  // Indicates if the sound is currently active (playing)

    private float originalVolume = 1.0f;  // The original volume set when the sound was created

    /**
     * Creates a new Sound object with a MediaPlayer, volume, and mixer channel.
     *
     * @param mediaPlayer the MediaPlayer instance that will play the sound
     * @param volume the initial volume for the sound (from 0.0 to 1.0)
     * @param mixer the mixer channel to which this sound belongs (BACKGROUND, EFFECTS, etc.)
     */
    public Sound(MediaPlayer mediaPlayer, float volume, Mixers mixer) {
        this.mediaPlayer = mediaPlayer;
        this.originalVolume = volume;
        this.mixer = mixer;
    }

    /**
     * Retrieves the MediaPlayer associated with this sound.
     *
     * @return the MediaPlayer used for playing the sound
     */
    public MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    /**
     * Retrieves the mixer channel this sound belongs to (BACKGROUND, EFFECTS, etc.).
     *
     * @return the mixer associated with this sound
     */
    public Mixers getMixer() {
        return mixer;
    }

    /**
     * Checks if the sound is currently active (playing).
     *
     * @return true if the sound is active, false otherwise
     */
    public boolean isActive() {
        return isActive;
    }

    /**
     * Sets the active state of the sound. If set to false, the sound is considered stopped.
     *
     * @param active true to mark the sound as active, false to stop the sound
     */
    public void setActive(boolean active) {
        isActive = active;
    }

    /**
     * Retrieves the original volume of the sound, as it was set when the sound was created.
     *
     * @return the original volume of the sound (from 0.0 to 1.0)
     */
    public float getOriginalVolume() {
        return originalVolume;
    }

    /**
     * Sets the volume of the sound. This will adjust the playback volume based on the given level.
     *
     * @param volume the new volume level to set (from 0.0 to 1.0)
     */
    public void setVolume(double volume) {
        mediaPlayer.setVolume(volume);
    }
}
