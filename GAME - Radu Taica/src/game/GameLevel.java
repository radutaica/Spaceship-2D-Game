package game;

import city.cs.engine.SoundClip;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

import javax.swing.*;

public abstract class GameLevel extends World {
    private Spaceship spaceship;
    public  int ufoNR;




    public void populate(Game game,MyView view){
        //make spaceship
        spaceship = new Spaceship(this, view);
        spaceship.setPosition(startPosition());


    }


    public Spaceship getSpaceship(){
        return spaceship;
    }


    public abstract Vec2 startPosition();
    public abstract void addBoss();
    public abstract int getLevelNumber();
    public abstract void addPotion();




}
