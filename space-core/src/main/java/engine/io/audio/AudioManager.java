package engine.io.audio;

import engine.util.Util;
import javafx.scene.media.MediaPlayer;

import java.util.ArrayList;

/**
 * Manages the playing of audio sounds in the game.
 * The AudioManager is responsible for playing, pausing, resuming, stopping sounds,
 * and adjusting volume levels for different sound categories (background, effects).
 */
public class AudioManager {

    // List of active sounds
    private static ArrayList<Sound> sounds;

    // Volume levels for different sound categories
    private static double masterVolume = 1;
    private static double backgroundVolume = 1;
    private static double effectsVolume = 1;

    /**
     * Initializes the AudioManager by creating the list of sounds.
     * This method should be called before any sound can be played.
     */
    public static void init() {
        sounds = new ArrayList<>();
    }

    /**
     * Adds a new sound to the audio manager and starts playing it.
     * The sound is added to the appropriate mixer channel, and its volume and balance are set.
     *
     * @param url the URL of the sound file to play
     * @param v the volume of the sound (from 0.0 to 1.0)
     * @param p the pan of the sound (-1.0 for left, 1.0 for right)
     * @param mixer the mixer to assign the sound to (BACKGROUND or EFFECTS)
     * @return the index of the sound in the sounds list
     */
    public static int addSound(String url, float v, float p, Mixers mixer) {
        try {
            sounds.add(new Sound(new MediaPlayer(Util.getMedia(url)), v, mixer));
            MediaPlayer sound = sounds.get(sounds.size() - 1).getMediaPlayer();

            // Set the volume based on the mixer type
            switch (mixer) {
                case BACKGROUND:
                    sound.setVolume(v * masterVolume * backgroundVolume);
                    break;
                case EFFECTS:
                    sound.setVolume(v * masterVolume * effectsVolume);
                    break;
            }

            // Set the balance (stereo pan) for the sound
            sound.setBalance(p);
            sound.play();

            return sounds.size() - 1;
        } catch (Exception e) {
            throw e; // rethrow the exception if an error occurs
        }
    }

    /**
     * Retrieves the sound at the specified index in the sounds list.
     *
     * @param p the index of the sound in the list
     * @return the Sound object at the specified index
     */
    public static Sound getSound(int p) {
        return sounds.get(p);
    }

    /**
     * Pauses all currently playing sounds.
     * This method will pause every active sound in the `sounds` list.
     */
    public static void pauseAll() {
        for (int i = 0; i < sounds.size(); i++) {
            try {
                sounds.get(i).getMediaPlayer().pause();
            } catch (Exception ignored) {}
        }
    }

    /**
     * Resumes all currently paused sounds.
     * This method will play every sound that is currently paused in the `sounds` list.
     */
    public static void resumeAll() {
        for (int i = 0; i < sounds.size(); i++) {
            try {
                sounds.get(i).getMediaPlayer().play();
            } catch (Exception ignored) {}
        }
    }

    /**
     * Stops all currently playing sounds and marks them as inactive.
     * This method will stop every active sound in the `sounds` list and set their active status to false.
     */
    public static void stopAll() {
        for (int i = 0; i < sounds.size(); i++) {
            try {
                sounds.get(i).getMediaPlayer().stop();
                sounds.get(i).setActive(false);
            } catch (Exception ignored) {}
        }
    }

    /**
     * Sets the volume for a specific mixer channel (master, background, or effects).
     * This method adjusts the volume level for the specified sound category.
     *
     * @param v the new volume level (from 0.0 to 1.0)
     * @param mixer the mixer channel to set the volume for (MASTER, BACKGROUND, or EFFECTS)
     */
    public static void setVolume(double v, Mixers mixer) {
        switch (mixer) {
            case MASTER:
                masterVolume = v;
                break;
            case BACKGROUND:
                backgroundVolume = v;
                break;
            case EFFECTS:
                effectsVolume = v;
                break;
        }

        // Update the volume for all sounds based on the new global volume settings
        for (int i = 0; i < sounds.size(); i++) {
            try {
                Sound sound = sounds.get(i);
                switch (sound.getMixer()) {
                    case BACKGROUND:
                        sound.setVolume(sound.getOriginalVolume() * masterVolume * backgroundVolume);
                        break;
                    case EFFECTS:
                        sound.setVolume(sound.getOriginalVolume() * masterVolume * effectsVolume);
                        break;
                }
            } catch (Exception ignored) {}
        }
    }

    /**
     * Retrieves the current master volume level.
     *
     * @return the master volume level (from 0.0 to 1.0)
     */
    public static double getMasterVolume() {
        return masterVolume;
    }

    /**
     * Retrieves the current background volume level.
     *
     * @return the background volume level (from 0.0 to 1.0)
     */
    public static double getBackgroundVolume() {
        return backgroundVolume;
    }

    /**
     * Retrieves the current effects volume level.
     *
     * @return the effects volume level (from 0.0 to 1.0)
     */
    public static double getEffectsVolume() {
        return effectsVolume;
    }

    /**
     * Sets the volume of a specific sound by its ID.
     * The volume is adjusted relative to the master volume and the respective mixer channel.
     *
     * @param id the ID of the sound
     * @param v the new volume level for the sound (from 0.0 to 1.0)
     */
    public static void setVolumeOfSound(int id, float v) {
        try {
            Sound sound = sounds.get(id);
            sound.setVolume(v * masterVolume);
            switch (sound.getMixer()) {
                case BACKGROUND:
                    sound.setVolume(v * masterVolume * backgroundVolume);
                    break;
                case EFFECTS:
                    sound.setVolume(v * masterVolume * effectsVolume);
                    break;
            }
        } catch (Exception ignored) {}
    }

    /**
     * Destroys (removes) the sound at the specified index from the sounds list.
     * This method stops the sound and removes it from the manager's list of active sounds.
     *
     * @param id the ID of the sound to remove
     */
    public static void destroy(int id) {
        sounds.remove(id);
    }
}
