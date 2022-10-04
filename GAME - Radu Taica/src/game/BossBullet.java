package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
//creating bullet for Boss object
public class BossBullet extends DynamicBody implements CollisionListener {
        private BossBullet bossBullet;

    public BossBullet(World world, Boss boss) {
        super(world, new BoxShape(.1f,0.5f));
        addImage(new BodyImage("data/BossBullet.png", 2f));
        setPosition(boss.getPosition().add(new Vec2(0f,-2f)));
        setGravityScale(0f);
        setLinearVelocity(new Vec2(0f,-8f));
        addCollisionListener(this);




    }
    @Override
    public void collide(CollisionEvent e){
        if(e.getOtherBody()instanceof StaticBody){
            destroy();
        }else if(e.getOtherBody()instanceof Bullet){
            destroy();
            e.getOtherBody().destroy();
        }else if(e.getOtherBody()instanceof UFO){
            destroy();
            e.getOtherBody().destroy();
        }

    }

}

