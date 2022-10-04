package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**collision listener for collision between the objects*/
public class Collision implements CollisionListener {
    private Bullet bullet;
    private Spaceship spaceship;
    private UFO ufo;
    private Boss boss;
    private GameLevel level;
    private Game game;
    private BossBullet bossBullet;
    private HealthPotion potion;
    public static int nBoss = 1;
    public static int nUfos = 0;


    public Collision(Spaceship spaceship, GameLevel level, Game game) {
        this.spaceship = spaceship;
        this.level = level;
        this.game = game;
    }

    public Collision(UFO ufo, GameLevel level) {
        this.ufo = ufo;
        this.level = level;
        nUfos++;

    }


    public Collision(Bullet bullet) {
        this.bullet = bullet;
    }

    public Collision(BossBullet bossBullet){
        this.bossBullet= bossBullet;

    }

    public Collision(Boss boss, GameLevel level, Game game) {
        this.boss = boss;
        this.level = level;
        this.game = game;

    }

    public Collision(HealthPotion potion) {
        this.potion = potion;
    }



    @Override
    public void collide(CollisionEvent e) {
        /**collision spaceship with ufo*/
            if (e.getReportingBody() == spaceship && !(e.getOtherBody() instanceof StaticBody)) {
                /**decrement spacehip lives if it collides with anything that is not a static body*/
                spaceship.decrementLivesCount();
                game.getPanel().setHealth(spaceship.getLivesCount());
                Sounds.getSpaceshipSound().play();


                if (e.getOtherBody() instanceof UFO) {
                    e.getOtherBody().destroy();
                    nUfos--;
                }

                System.out.println(spaceship.getLivesCount());
                /**destroy spaceship and exit game if no lives remaining*/
                if (spaceship.getLivesCount() <= 0) {
                    e.getReportingBody().destroy();
                    Sounds.getSpaceshipSound().play();
                    System.exit(0);
                    if (e.getOtherBody() instanceof UFO) e.getOtherBody().destroy();
                    System.out.println("Spaceship");
                }

            }
            /**collision bullet with ufo*/
            if (e.getReportingBody() == ufo && (e.getOtherBody() instanceof Bullet)) {
                e.getOtherBody().destroy();
                e.getReportingBody().destroy();
                System.out.println("BULLET");
                Sounds.getBulletSound().play();
                nUfos--;

            }
            /**collision ufo with walls*/
             else if (e.getReportingBody() == ufo && (e.getOtherBody() instanceof StaticBody)) {
                e.getReportingBody().destroy();
                System.out.println("Wall");
                Sounds.getUfoSound().play();
                nUfos--;

            }
             /**collision boss with bullet*/
            else if (e.getReportingBody() == boss && (e.getOtherBody() instanceof Bullet)) {
                /**decrease boss lives*/
                boss.decrementLives();
                Sounds.getSpaceshipSound().play();
                game.getPanel().setBossHP(boss.getLivesCount());
                e.getOtherBody().destroy();
                /**make it not rotate when hit by the bullet*/
                boss.setLinearVelocity(new Vec2(boss.getLinearVelocity().x, 0));
                boss.setAngularVelocity(0);
                boss.setAngle(0);

                if (boss.getLivesCount() == 0) {
                    e.getReportingBody().destroy();
                    nBoss--;
                    System.out.println("boss" + nBoss);
                }
            }
            /**collision of bullet with potion*/
            else if (e.getOtherBody()instanceof Bullet && e.getReportingBody()== potion){
                e.getOtherBody().destroy();
                e.getReportingBody().destroy();
            }
            /**collision spaceship with bossbullet*/
            else if (e.getReportingBody()==spaceship&&e.getOtherBody() instanceof BossBullet){
                spaceship.decrementLivesCount();
                e.getOtherBody().destroy();
                Sounds.getSpaceshipSound().play();
                if (spaceship.getLivesCount() <= 0) {
                    e.getReportingBody().destroy();
                    System.exit(0);
                }
            }
            /**collision of UFO with potion*/
            else if(e.getOtherBody()==potion && e.getReportingBody()instanceof UFO){
                e.getReportingBody().destroy();
                e.getOtherBody().destroy();
            }
            /**collision spaceship with potion*/
            else if(e.getOtherBody()instanceof HealthPotion && e.getReportingBody()==spaceship){
                /**increases nr of lives only if livescount is smaller than max(3)*/
                if(spaceship.getLivesCount()<3){
                    spaceship.incrementLives();
                    game.getPanel().setHealth(spaceship.getLivesCount());
                }
                e.getOtherBody().destroy();
                Sounds.getUfoSound().play();
            }





        }


    }

