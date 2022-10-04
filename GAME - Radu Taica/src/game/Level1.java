package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;


import javax.swing.*;

import static org.jbox2d.common.MathUtils.sin;

public class Level1 extends GameLevel {



    @Override
    public void populate(Game game,MyView view) {

        super.populate(game,view);
        addStepListener(new BossListener(this));
        getSpaceship().addCollisionListener(new Collision(getSpaceship(),this,game));
        // make the ground
        Shape groundShape = new BoxShape(20, 0.5f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -12.5f));
        addStepListener(new HealthListener(this));





        //make bullet
        Bullet bullet = new Bullet(this, getSpaceship());
        bullet.setPosition(getSpaceship().getPosition().add(new Vec2(0f, 2f)));
        bullet.addCollisionListener(new Collision(bullet));

        //make UFO

       Timer timer = new Timer(1500,new UFOSpawn(this));
       timer.setInitialDelay(0);
       timer.start();





        // walls
        Shape wallShape = new BoxShape(0.5f, 20);
        Body leftWall = new StaticBody(this, wallShape);
        leftWall.setPosition(new Vec2(-12.5f, 0));
        Body rightWall = new StaticBody(this, wallShape);
        rightWall.setPosition(new Vec2(12.5f, 0));
        Sounds.getBackground().loop();

    }
    public void stop(){
        super.stop();
        Sounds.getBackground().stop();
    }
    @Override
    public Vec2 startPosition(){return new Vec2(0,-2);}

    public void addBoss(){
    }

    @Override
    public int getLevelNumber() {
        return 1;
    }
    public void addPotion(){

    }

}


