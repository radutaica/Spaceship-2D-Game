package game;

import city.cs.engine.UserView;
import city.cs.engine.World;

import javax.swing.*;
import java.awt.*;
//setting gif as background
public class MyView extends UserView {
    Spaceship spaceship;
    private int levelNr;
    private Game game;


    private Image background;

    MyView(World world, Spaceship spaceship, int width, int height) {
        super(world, width, height);
        this.spaceship = spaceship;

        levelNr = 1;

    }
    public void addLevel(){
        levelNr++;
    }
    public int getLevelNr(){
        return levelNr;
    }

    @Override
    protected void paintBackground(Graphics2D g) {
        super.paintBackground(g);



        if (levelNr == 1) {
            this.background = new ImageIcon("data/giphy.gif").getImage();
            g.drawImage(background, 0, 0, this);
        } else if (levelNr == 2) {
            this.background = new ImageIcon("data/stars.gif").getImage();
            g.drawImage(background, 0, 0, this);

        }
        else if(levelNr == 3){
            this.background = new ImageIcon("data/level3.gif").getImage();
            g.drawImage(background, 0, 0, this);

        }


    }


    }




