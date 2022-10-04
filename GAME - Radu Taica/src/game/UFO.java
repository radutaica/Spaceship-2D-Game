package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
//creating UFO
public class UFO extends DynamicBody {
    private static final Shape UFOShape = new PolygonShape(
            -0.039f, 0.123f, -0.327f, -0.03f, -0.313f, -0.14f, 0.299f, -0.147f, 0.295f, -0.026f, 0.007f, 0.116f);
    private static final BodyImage image =
            new BodyImage("data/ufo.png", 3.25f);


    public UFO(World world) {
        super(world, UFOShape);
        addImage(image);



    }

}




