package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import static org.jbox2d.common.MathUtils.sin;

//creating potion
public class HealthPotion extends StaticBody {
    public HealthPotion(World world) {
        super(world, new BoxShape(.2f,1f));
        addImage(new BodyImage("data/potion.png", 2f));



    }
}