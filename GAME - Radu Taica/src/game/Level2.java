package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.swing.*;

public class Level2 extends GameLevel {

    private Game game;

    @Override
    public void populate(Game game,MyView view) {
        this.game = game;
        super.populate(game,view);
        addStepListener(new BossListener(this));
        addStepListener(new HealthListener(this));

        getSpaceship().addCollisionListener(new Collision(getSpaceship(), this,game));
        // make the ground
        Shape groundShape = new BoxShape(20, 0.5f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -12.5f));





        //make bullet
        Bullet bullet = new Bullet(this, getSpaceship());
        bullet.setPosition(getSpaceship().getPosition().add(new Vec2(0f, 2f)));
        bullet.addCollisionListener(new Collision(bullet));


        //make UFO
        Timer timer = new Timer(1200,new UFOSpawn(this));
        timer.setInitialDelay(0);
        timer.start();




        // walls
        Shape wallShape = new BoxShape(0.5f, 20);
        Body leftWall = new StaticBody(this, wallShape);
        leftWall.setPosition(new Vec2(-12.5f, 0));
        Body rightWall = new StaticBody(this, wallShape);
        rightWall.setPosition(new Vec2(12.5f, 0));
        Sounds.getBackground2().loop();

    }
    public void stop(){
        super.stop();
        Sounds.getBackground2().stop();
    }
    @Override
    public Vec2 startPosition(){return new Vec2(0,-2);}

    public void addBoss() {


    }
    @Override
    public int getLevelNumber() {
        return 2;
    }

    public void addPotion(){
        HealthPotion potion = new HealthPotion(this);
        potion.addCollisionListener(new Collision(potion));
        potion.setPosition(new Vec2(2f,5f));
        System.out.println("potion");
    }


}


