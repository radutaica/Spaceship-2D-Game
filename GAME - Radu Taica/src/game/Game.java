package game;

import city.cs.engine.*;

import javax.swing.*;
import java.awt.*;


public class Game {

    /** The World in which the bodies move and interact. */
    private GameLevel world;
    private GameLevel lev;

    /** A graphical display of the world (a specialised JPanel). */
    private MyView view;
    public int level;
    private Controller controller;
    private float time=0;
    public int score = 0;
    private ControlPanel panel;


    public Game() {

        /**make the world*/

        level = 1;
        world = new Level1();

        view = new MyView(world, world.getSpaceship(),500,500);
        world.populate(this,view);
        /** make a view*/
        this.world.addStepListener(new TimeListener());

        panel = new ControlPanel(this);

        /**display the view in a frame*/
        final JFrame frame = new JFrame("Space battle");
        frame.add(panel.getMainPanel(), BorderLayout.NORTH);

        /** setting buttons for the spaceship*/
        controller = new Controller(world.getSpaceship(), world,this);
        frame.addKeyListener(controller);
        view.addMouseListener(new GiveFocus(frame));
        controller.setWorld(world);






        /**quit the application when the game window is closed*/
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        /**display the world in the window*/
        frame.add(view);

        /**don't let the game window be resized*/
        frame.setResizable(false);
        /**size the game window to fit the world view*/
        frame.pack();
        /** make the window visible*/
        frame.setVisible(true);
        /** get keyboard focus*/
        frame.requestFocus();

        /** start!*/

        world.start();



    }
    /**checking if the level is complete so it can pass to the next one*/
    class TimeListener implements StepListener{
        @Override
        public void preStep(StepEvent e){

            Game.this.time += e.getStep();
            if (level ==1) {
                if (isLevel1Completed()) {
                    goNextLevel();
                }

            }else if(level==2){

                if(isLevel1Completed()){
                    goNextLevel();
                }

            }else if(level==3){
                if(isCurrentLevelCompleted()){
                    goNextLevel();
                }
            }


        }
        @Override
        public void postStep(StepEvent e){}
    }
    /**checking if level 1 and 2 are complete*/
    public boolean isLevel1Completed(){
        return Collision.nUfos<=0;
    }
    /**checking if level 3 is complete*/
    public boolean isCurrentLevelCompleted(){

        return Collision.nUfos<=0 && Collision.nBoss<=0;
    }
    public Spaceship getPlayer(){
        return world.getSpaceship();
    }
    /** loading the level the user saved*/
    public void goToLevel(GameLevel lev){
        world.stop();
        level = lev.getLevelNumber();
        world = lev;
        /**switch keyboard control to new player*/
        controller.setBody(world.getSpaceship());
        controller.setWorld(world);

        /**fill with bodies*/
        world.populate(this,view);

        /**show the world in new view*/
        view.setWorld(world);
        panel.setHealth(3);
        panel.setBossHP(10);
        controller.setWorld(world);
        world.addStepListener(new TimeListener());
        world.start();

    }
    public void goNextLevel(){
        world.stop();
        if(level >3){
            System.exit(0);
        }else{
            level++;

            if (level == 2){
                view.addLevel();
                /**get a new world*/
                world = new Level2();
                /**fill with bodies*/
                world.populate(this,view);
                /**switch keyboard control to new player*/
                controller.setBody(world.getSpaceship());
                /**show the world in new view*/
                view.setWorld(world);
                panel.setHealth(3);
                panel.setBossHP(10);
                controller.setWorld(world);
                world.addStepListener(new TimeListener());

                world.start();
            }else if(level ==3){
                view.addLevel();
                /**get a new world*/
                world = new Level3();
                /**fill with bodies*/
                world.populate(this,view);
                /**switch keyboard control to new player*/
                controller.setBody(world.getSpaceship());
                /**show the world in new view*/
                view.setWorld(world);
                panel.setHealth(3);
                panel.setBossHP(10);
                controller.setWorld(world);
                world.addStepListener(new TimeListener());
                world.start();
            }
        }
    }
    public void pauseGame(){
        world.stop();
    }
    public void resumeGame(){
        world.start();
        if(level == 1){
        Sounds.getBackground().loop();}
        else if(level==2){
            Sounds.getBackground2().loop();
        }
        else if(level==3){
            Sounds.getBackground3().loop();
        }

    }






    /** Run the game. */
    public static void main(String[] args) {

        new Game();
    }
    public void incrementScore(){
        score++;
    }
    public int getScore() {
        return score;
    }
    public void decrementScore(){
        score--;
    }

    public ControlPanel getPanel() {
        return panel;
    }
}
