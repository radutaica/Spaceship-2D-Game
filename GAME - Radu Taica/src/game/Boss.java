package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import static org.jbox2d.common.MathUtils.sin;
//create boss
public class Boss extends DynamicBody {
        private int lives=10;
        private static final Shape bossShape = new PolygonShape(
                -0.138f,0.469f, -0.714f,0.071f, -0.65f,-0.429f, 0.653f,-0.454f, 0.708f,0.003f, 0.448f,0.399f, -0.012f,0.482f);
        private static final BodyImage image =
                new BodyImage("data/boss.png", 3.25f);
    public Boss(World world) {
        super(world, bossShape);
        addImage(image);
        world.addStepListener(new Position());
        //make the boss not rotate
        this.setGravityScale(0);
        this.setPosition(new Vec2(0,100));
        this.setAngle(0);
        this.setAngularVelocity(0);


    }
    public int getLivesCount() {
        return lives;
    }

    public void decrementLives() {
        lives--;
        System.out.println("Boss life decreased ");
    }
    class Position implements StepListener{
        private float time=0;
        //move Boss on X axis
        @Override
        public void preStep(StepEvent e){
            float Bossx= sin(time)*5;
            time += e.getStep();
            Boss.this.setPosition(new Vec2(Bossx, 10));
            //shoot in a certain time period
            if (time%1<0.01d){
                Boss.this.shootBoss();
            }

        }
        public void postStep(StepEvent e){

        }

    }
    // make the Boss shoot bullets
    public void shootBoss(){
        new BossBullet(this.getWorld(),this);
    }


}



