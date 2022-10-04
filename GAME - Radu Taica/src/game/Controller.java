package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.security.Key;

/**
 * Key handler to control the spaceship
 */
public class Controller extends KeyAdapter {
    private static float moveRight = 5;
    private static  float moveUp = 5;
    private static  float moveDown = -5;
    private static  float moveLeft = -5;
    private Game game;
    private GameLevel currentLevel;



    private Spaceship body;

    public Controller(Spaceship body,GameLevel level, Game game) {
        this.body = body;
        this.game =game;
        currentLevel = level;


    }

    /**setting movements for different keys*/
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_W:
                /**press W for going up*/
                body.setLinearVelocity(new Vec2(0,moveUp));
                break;
            case KeyEvent.VK_Q:
                /**press Q to exit the game*/
                System.exit(0);
                break;
            case KeyEvent.VK_A:
                /**press A to go left*/
                body.startWalking(moveLeft);
                break;
            case KeyEvent.VK_D:
                /**press D to go right*/
                body.startWalking(moveRight);
                break;
            case KeyEvent.VK_S:
                /**press S for going down*/
                body.setLinearVelocity(new Vec2(0,moveDown));
                break;
            case KeyEvent.VK_T:
                GameSaver gs = new GameSaver("data/scores.txt");
                try {
                    gs.saveGame(currentLevel);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            case KeyEvent.VK_R:
                GameLoader gl = new GameLoader("data/scores.txt", game);
                try {
                    GameLevel loadgame = gl.loadGame();
                    game.goToLevel(loadgame);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }



        }



    }

    /**stop moving when keys are released*/
    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {

            case KeyEvent.VK_A:
                body.stopWalking();
                body.setLinearVelocity(new Vec2(0, 0));
                break;
            case KeyEvent.VK_D:
                body.stopWalking();
                body.setLinearVelocity(new Vec2(0, 0));
                break;
            case KeyEvent.VK_W:
                body.setLinearVelocity(new Vec2(0, 0));
                break;
            case KeyEvent.VK_S:
                body.setLinearVelocity(new Vec2(0, 0));
                break;


            case KeyEvent.VK_SPACE:
                if (game.level != 1) {
                    /**shoot after pressing space*/
                    body.shoot();
                    break;
                }
                }

        }
        public void setBody (Walker body){
            this.body = (Spaceship) body;
        }
        public void setWorld (GameLevel level){
            this.currentLevel = level;
        }
    }

