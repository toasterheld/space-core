package engine.core.audio;

import engine.util.Util;
import javafx.scene.media.MediaPlayer;

import java.util.ArrayList;

public class AudioManager {
    private static ArrayList<Sound> sounds;
    private static double masterVolume = 1;
    private static double backgroundVolume = 1;
    private static double effectsVolume = 1;


    public static void init() {
        sounds = new ArrayList<>();
    }


    public static int addSound(String url, float v, float p, Mixers mixer) {
        try {
            sounds.add(new Sound(new MediaPlayer(Util.getMedia(url)), v, mixer));
            MediaPlayer sound = sounds.get(sounds.size()-1).getMediaPlayer();

            switch (mixer) {
                case BACKGROUND:
                    sound.setVolume(v*masterVolume*backgroundVolume);
                    break;
                case EFFECTS:
                    sound.setVolume(v*masterVolume*effectsVolume);
                    break;
            }
            sound.setBalance(p);
            sound.play();

            return sounds.size()-1;
        } catch (Exception e) {
            throw (e);
        }
    }

    public static Sound getSound(int p) {
        return sounds.get(p);
    }


    public static void pauseAll() {
        for (int i = 0; i<sounds.size(); i++) {
            try {
                sounds.get(i).getMediaPlayer().pause();
            } catch (Exception ignored) {}
        }
    }

    public static void resumeAll() {
        for (int i = 0; i<sounds.size(); i++) {
            try {
                sounds.get(i).getMediaPlayer().play();
            } catch (Exception ignored) {}
        }
    }

    public static void stopAll() {
        for (int i = 0; i<sounds.size(); i++) {
            try {
                sounds.get(i).getMediaPlayer().stop();
                sounds.get(i).setActive(false);
            } catch (Exception ignored) {}
        }
    }

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

        for (int i = 0; i<sounds.size(); i++) {
            try {
                Sound sound = sounds.get(i);
                switch (sound.getMixer()) {
                    case BACKGROUND:
                        sound.setVolume(sound.getOriginalVolume()*masterVolume*backgroundVolume);
                        break;
                    case EFFECTS:
                        sound.setVolume(sound.getOriginalVolume()*masterVolume*effectsVolume);
                        break;
                }
            } catch (Exception ignored) {}
        }
    }

    public static double getMasterVolume() {
        return masterVolume;
    }

    public static double getBackgroundVolume() {
        return backgroundVolume;
    }

    public static double getEffectsVolume() {
        return effectsVolume;
    }

    public static void setVolumeOfSound(int id, float v) {
        try {
            Sound sound = sounds.get(id);
            sound.setVolume(v*masterVolume);
            switch (sound.getMixer()) {
                case BACKGROUND:
                    sound.setVolume(v*masterVolume*backgroundVolume);
                    break;
                case EFFECTS:
                    sound.setVolume(v*masterVolume*effectsVolume);
                    break;
            }
        } catch (Exception ignored) {}
    }
}
