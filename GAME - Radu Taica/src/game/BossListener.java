package game;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;

import city.cs.engine.World;

import static org.jbox2d.common.MathUtils.sin;

public class BossListener implements StepListener {
    private float time=0;
    private GameLevel level;


    public void preStep(StepEvent e) {

        //add a boss to the game after 12 seconds
        time= time+ e.getStep();
        if(time>12) {
            level.addBoss();
            level.removeStepListener(this);

        }
    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }
    BossListener(GameLevel level){
        super();
        this.level = level;
    }

}
