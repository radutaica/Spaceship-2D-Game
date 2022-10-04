package game;

import org.jbox2d.common.Vec2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ThreadLocalRandom;

public class UFOSpawn implements ActionListener {
    private int totalUFOs;
    private GameLevel level;
    private int min = -10;
    private int max = 10;
    private int min1 = 15;
    private int max1 = 16;
    UFOSpawn(GameLevel level) {
        this.level = level;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (totalUFOs >= 10) {
            return;
        }

        int randomNumX = ThreadLocalRandom.current().nextInt(min, max + 1);
        int randomNumY = ThreadLocalRandom.current().nextInt(min1, max1 + 1);
        UFO ufo = new UFO(level);
        ufo.setPosition(new Vec2(randomNumX, randomNumY));
        ufo.addCollisionListener(new Collision(ufo, level));
        ufo.setGravityScale(0.07f);


        totalUFOs++;


        System.out.println(totalUFOs);
        }
    }

