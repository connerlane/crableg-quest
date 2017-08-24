import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Pig here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Jameis extends Sprites
{
    //tells what frame the animation is on.
    private int score = 0;
    private int frame;
    //tells what if sprite is still
    private boolean standingStill;
    private final GreenfootSound SAD = new GreenfootSound("sad.mp3");
    private boolean isDead = false;
    private int timeDead = 0;
    private static int lives = 3;
    public int moveSpeed;
    public int legsCollected = 0;
    public int trophiesCollected = 0;
    public int heismans = 0;
    public int timeBonus = 0;
    private boolean canLeave = false;
    private boolean blockedLeft = false;
    private boolean blockedRight = false;
    private boolean blockedUp = false;
    private boolean blockedDown = false;
    private boolean isBlinking;
    private int RUNSPEED;

    public boolean isTurnt = false;
    public int turntCount = 0;
    private int sprintCount = 0;
    public Jameis() {
        setImage("JameisWinstonStill.png");
        frame = 0;
    }

    public void act() {
        moveSpeed = 3;
        sprint();
        if (!isDead) { 
            standingStill = true;
            handleKeyPress();
            if(standingStill){
                if (!isBlinking) {
                    setImage("JameisWinstonStill.png");
                }
            }
            else {
                if (!isBlinking) {
                    runAnimation();
                }
                checkForWalls();
            }

        }
        invincible();

        RIP();

    }    

    public void invincible() {
        if (isTurnt) {
            int terminalCount = 300;
            if (turntCount == 0) {

                getWorld().addObject(new IndicatorBar(terminalCount), getX(), getY() - 36);
                getWorld().addObject(new IndicatorCover(terminalCount), getX(), getY() - 36);

            }
            if (turntCount % 6 == 0) {
                getWorld().addObject(new Sparkle(), this.getX(), this.getY());
            }

            turntCount++;
            if (turntCount > terminalCount) {

                isTurnt = false;
                turntCount = 0;

            }
        }

    }

    public void playSadMusic()
    {
        if (!SAD.isPlaying())
        {
            SAD.setVolume(20);
            SAD.playLoop();
        }
    }

    public void stopSadMusic()
    {
        if(SAD.isPlaying())
        {
            SAD.stop();
        }
    }

    public static int getLives() {
        return lives;
    }

    public static void decrementLives() {
        lives--;
    }

    public static void setLives(int livesIn) {
        lives = livesIn;
    }

    public int[] getStuffCollected(){
        return new int[]{legsCollected, trophiesCollected, heismans, timeBonus};
    }

    public void setStuffCollected(int[] stuff){
        legsCollected = stuff[0];
        trophiesCollected = stuff[1];
        heismans = stuff[2];
        timeBonus = stuff[3];

    }

    public void RIP() {

        List<Worker> group = getObjectsInRange(38,Worker.class);
        List<Timer> group2 = getObjectsInRange(3000, Timer.class);
        if (group.size() == 0 && group2.size() == 0) return;
        if (group.size() != 0 && group.get(0).getDisabled()) return;
        if (group.size() != 0 || group2.get(0).isTimeUp()) {

            if (!isTurnt) {
                isDead = true;
                Publix.theme.stop();
                playSadMusic();
                timeDead++;
            }
            else group.get(0).disable();

            /** FOR NOW...........
            if (timeDead < 43) {
            GreenfootImage img = getImage();
            int width = (int)(img.getWidth() * 1.08);
            int height = (int)(img.getHeight() * 1.08);
            img.scale(width, height);
            setImage(img);

            }
             */
            if (timeDead > 150 && lives > 1) {
                decrementLives();

                Publix newp = new Publix(Publix.getLevelCount());
                Jameis pal = newp.getJameis();
                newp.playMusic();
                Greenfoot.setWorld(newp);
                pal.lives = lives;
                SAD.stop();

            }
            timeDead++;
        }
    }

    public void sprint() {
        if(getWorld().getObjects(SprintBar.class).size() >= 1){
            List<SprintBar> group = getObjectsInRange(3000,SprintBar.class);

            int energy = group.get(0).getEnergy();
            if (Greenfoot.isKeyDown("shift") && energy > 1 && !standingStill) {
                sprintCount++;
                moveSpeed = 5;
                if (sprintCount % 6 == 0 && !standingStill) {
                    getWorld().addObject(new Dust(), this.getX(), this.getY());
                    getWorld().addObject(new Dust(), this.getX()+1, this.getY()+1);
                    getWorld().addObject(new Dust(), this.getX()-1, this.getY()-1);
                    getWorld().addObject(new Dust(), this.getX()-2, this.getY()-2);
                    
                }
            }
        }
    }
    
    public boolean isStandingStill() {
        return standingStill;
    }
    
    public boolean turnt() {
        return isTurnt;
    }
    public void handleKeyPress() {
        checkLeft();
        checkUp();
        checkRight();
        checkDown();

        checkUpRight();
        checkUpLeft();
        checkDownLeft();
        checkDownRight();

    }

    public void checkUpRight() {
        if (Greenfoot.isKeyDown("right") && Greenfoot.isKeyDown("up"))

            setRotation(-45);
    }

    public void checkDownRight() {
        if (Greenfoot.isKeyDown("right") && Greenfoot.isKeyDown("down"))

            setRotation(45);
    }

    public void checkDownLeft() {
        if (Greenfoot.isKeyDown("left") && Greenfoot.isKeyDown("down"))

            setRotation(135);
    }

    public void checkUpLeft() {
        if (Greenfoot.isKeyDown("left") && Greenfoot.isKeyDown("up"))
            setRotation(-135);
    }

    public void checkLeft() {
        if (Greenfoot.isKeyDown("left") && blockedLeft == false) {
            setRotation(180);
            move(moveSpeed);
            standingStill = false;
        }
    }

    public void checkRight() {
        if (Greenfoot.isKeyDown("right") && blockedRight == false) {
            setRotation(0);
            move(moveSpeed);

            standingStill = false;
        }
    }

    public void checkUp() {
        if (Greenfoot.isKeyDown("up") && blockedUp == false) {
            setRotation(270);
            move(moveSpeed);

            standingStill = false;
        }
    }

    public void checkDown() {
        if (Greenfoot.isKeyDown("down") && blockedDown == false) {
            setRotation(90);
            move(moveSpeed);

            standingStill = false;
        }
    }

    public void runAnimation() {
        RUNSPEED = 20/moveSpeed;
        if(0 <= frame && frame < RUNSPEED) {setImage("JameisWinstonStill.png");}
        else if(RUNSPEED <= frame && frame < RUNSPEED*2) {setImage("JameisWinstonW1.png");}
        else if(RUNSPEED*2 <= frame && frame < RUNSPEED*3) {setImage("JameisWinstonW2.png");}
        else if(RUNSPEED*3 <= frame && frame < RUNSPEED*4 - 1) {setImage("JameisWinstonW3.png");}
        else if(RUNSPEED*4 - 1 <= frame) {

            frame = 0;
            return;
        }
        frame++;

    }

    public void checkForWalls() {
        Actor wallLeft = getOneObjectAtOffset(-20, 0, Shelf.class);
        if (wallLeft != null)
        {
            blockedLeft = true;
        } else {
            blockedLeft = false;
        }
        Actor wallRight = getOneObjectAtOffset(20, 0, Shelf.class);
        if (wallRight != null)
        {
            blockedRight = true;
        } else {
            blockedRight = false;
        }
        Actor wallUp = getOneObjectAtOffset(0, -20, Shelf.class);
        if (wallUp != null)
        {
            blockedUp = true;
        } else {
            blockedUp = false;
        }
        Actor wallDown = getOneObjectAtOffset(0, 20, Shelf.class);
        if (wallDown != null)
        {
            blockedDown = true;
        } else {
            blockedDown = false;
        }
    } 

    public boolean getIsDead() {
        return isDead;
    }

}

