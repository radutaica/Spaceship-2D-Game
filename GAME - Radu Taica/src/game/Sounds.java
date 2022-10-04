package game;

import city.cs.engine.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Sounds {
    private static SoundClip background;
    private static SoundClip bg2;
    private static SoundClip bg3;
    private static SoundClip ufoSound;
    private static SoundClip bulletSound;
    private static SoundClip spaceshipSound;
    static {
        try {
            background = new SoundClip("data/Sounds/backgroundsounds.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            ex.printStackTrace();
        }
    }
    static {
        try {
            bg2=new SoundClip("data/sounds/level2.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            ex.printStackTrace();
        }
    }
    static {
        try {
            bg3=new SoundClip("data/sounds/level3.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            ex.printStackTrace();
        }
    }
    static {
        try {
            ufoSound=new SoundClip("data/sounds/ufo.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            ex.printStackTrace();
        }
    }
    static {
        try {
            bulletSound=new SoundClip("data/sounds/Bullet.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            ex.printStackTrace();
        }
    }
    static {
        try {
            spaceshipSound=new SoundClip("data/sounds/Spaceship.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            ex.printStackTrace();
        }
    }

    public static SoundClip getBackground() {
        return background;
    }
    public static SoundClip getBackground2() {
        return bg2;
    }
    public static SoundClip getBackground3() {
        return bg3;
    }
    public static SoundClip getUfoSound(){return ufoSound;}
    public static SoundClip getBulletSound(){return bulletSound;}
    public static SoundClip getSpaceshipSound(){return spaceshipSound;}
    }




