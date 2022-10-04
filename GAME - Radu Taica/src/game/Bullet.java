package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

//creating bullet

public class Bullet extends DynamicBody {
    public Bullet(World world, Spaceship spaceship) {
        super(world, new BoxShape(.2f,1f));
        addImage(new BodyImage("data/Bullet.png", 2f));

        setPosition(spaceship.getPosition().add(new Vec2(0,2f)));
        setGravityScale(0f);
        setLinearVelocity(new Vec2(0f,8f));

    }
}
