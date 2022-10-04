package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

//creating spaceship

public class Spaceship extends Walker {

    private static final Shape SpaceshipShape = new PolygonShape(
            -0.011f, 0.43f, -0.483f, -0.184f, -0.477f, -0.43f, 0.477f, -0.42f, 0.477f, -0.122f, 0.007f, 0.43f);
    private static final BodyImage image1 =
            new BodyImage("data/spaceship.png", 2.25f);
    private static final BodyImage image2 =
            new BodyImage("data/spaceship2.png", 2.25f);
    private static final BodyImage image3 =
            new BodyImage("data/spaceship3.png", 2.25f);
    public int lives = 3;


    private MyView view;
    public Spaceship(World world,MyView view) {
        super(world, SpaceshipShape);
        this.view=view;
        if(view.getLevelNr()==1){
            addImage(image1);
        }
        else if (view.getLevelNr()==2){
            addImage(image2);
        }
        else if(view.getLevelNr() == 3){
            addImage(image3);
        }

        this.setGravityScale(0);


        }

    public int getLivesCount() {
        return lives;
    }

    public void decrementLivesCount() {
        lives--;
        System.out.println("Ouch");
    }
    public void shoot(){
        new Bullet(this.getWorld(),this);
    }
    public void incrementLives(){
        lives++;
        System.out.println("+1 health");
    }
    public float time = 0;


}





