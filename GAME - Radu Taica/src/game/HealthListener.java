package game;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;

public class HealthListener implements StepListener {
    private float hTime=0;
    private GameLevel level;

    public void preStep(StepEvent e) {
        hTime= hTime+ e.getStep();
        if(hTime>=5) {
            level.addPotion();
            level.removeStepListener(this);

        }
    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }
    HealthListener(GameLevel level){
        super();
        this.level = level;
    }

}
