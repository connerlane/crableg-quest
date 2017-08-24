import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Worker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Worker extends Sprites
{
    int move;
    public static final GreenfootSound stun = new GreenfootSound("stun.wav");
    public Worker (int number) {

        id = number;
    }
    int timeSpooked = 1;
    int radius = 10000;
    int id;
    int workingCount = 0;
    double verticalSpeed;
    double horizontalSpeed;
    int timeAggroed = 0;
    private boolean blockedLeft = false;
    private boolean blockedRight = false;
    private boolean blockedUp = false;
    private boolean blockedDown = false;
    int randoMove = 0; //random move number declaration
    private int frame;
    private boolean working = false;
    private boolean standingStill;
    private int disabledCount = 0;
    private boolean disabled = false;
    private boolean heismanScored = false;
    stars s = new stars();
    public void addedToWorld(World world) {

    }

    public void act() {
        if (!disabled) {
            working = false;
            standingStill = true;
            checkForWalls();
            pursuePlayer();

            if(standingStill) {
                setImage("WorkerStill.png");
            }
            else {
                runAnimation(); 
            }

            walkAnimation();
        }

        if (disabled) {
            setImage("WorkerStill.png");
            disabledCount++;
            List<stars> group1 = getObjectsInRange(20,stars.class);
            if(group1.size() != 0) {
                group1.get(0).setRotation(group1.get(0).getRotation() + 2);
            }
        }
        if (disabledCount > 150) {
            List<stars> group1 = getObjectsInRange(20,stars.class);
            getWorld().removeObject(group1.get(0));
            disabledCount = 0;
            disabled = false;
            heismanScored = false;
        }
    }

    public void disable() {
        
        getWorld().addObject(s, this.getX(), this.getY());
        disabled = true;
        List<Jameis> group = getObjectsInRange(3000,Jameis.class);
        if (group.size()== 0)return;
        else if(!heismanScored){
            group.get(0).heismans++;
            heismanScored = true;
            stun.play();
        }

    }
    
    public boolean getDisabled(){
        return disabled;
    }

    public void pursuePlayer() {
        List<Jameis> group = getObjectsInRange(3000,Jameis.class);
        if (group.size()== 0)return;
        Actor guy = group.get(0);

        int targetX = guy.getX();
        int targetY = guy.getY();
        double r = Math.sqrt(Math.pow(getX()-guy.getX(),2)+Math.pow(getY()-guy.getY(),2));       
        radius = (int) r;

        if(isAtEdge()){
            turn(Greenfoot.getRandomNumber (45));
            move(1);
        }
        if (r > 250) {
            working = true;
            timeAggroed = 0;

            if(Greenfoot.getRandomNumber(100) < 3) {
                turn(Greenfoot.getRandomNumber(90)-45);

            }

            if(Greenfoot.getRandomNumber(100) < 30) {

                randoMove = Greenfoot.getRandomNumber(3);
                move(randoMove);

                if (blockedUp || blockedDown || blockedLeft || blockedRight) {
                    Integer rotationd = Math.round(getRotation());
                    int rotation = rotationd.intValue();

                    //Shelf shelf;
                    //shelf = (Shelf) getOneIntersectingObject(Shelf.class);

                    // List <Shelf> shelves = getObjectsInRange(20, Shelf.class);
                    //rotation > 0 && rotation < 180 ||rotation > 180 && rotation <= 359
                    if ((blockedUp && (rotation > 180 && rotation <= 359)) || (blockedDown && (rotation > 0 && rotation < 180))) {
                        move(-randoMove);

                    }
                    if ((blockedRight && ((rotation > 270 && rotation < 360 ) || (rotation >= 0 && rotation < 90 ))) || 
                    (blockedLeft && (rotation > 90 && rotation < 270  ))) {
                        move(-randoMove);

                    }
                }
            }
        }

        else if ( r > 225 && r < 250) {
            standingStill = true;
            if(Greenfoot.getRandomNumber(100) < 2){
                turn(45);

            }
            if (timeSpooked == 0) {

                getWorld().addObject(new Question(), this.getX(), this.getY());

            }
            timeSpooked++;

        }
        else if (radius == 0) {

            move = 3;

        }

        else if (r < 225) {
            timeSpooked = 0;
            standingStill = false;
            move = 3;

            turnTowards(targetX,targetY);
            if (timeAggroed == 0) {

                getWorld().addObject(new Aggro(id), this.getX(), this.getY());
                timeAggroed++;

            }

            move(move);

            if (blockedUp || blockedDown || blockedLeft || blockedRight) {
                //Shelf shelf;
                //shelf = (Shelf) getOneIntersectingObject(Shelf.class);
                Integer rotationd = Math.round(getRotation());
                int rotation = rotationd.intValue();

                // List <Shelf> shelves = getObjectsInRange(20, Shelf.class);
                //rotation > 0 && rotation < 180 ||rotation > 180 && rotation <= 359
                if ((blockedUp && (rotation > 180 && rotation <= 359)) || (blockedDown && (rotation > 0 && rotation < 180))) {
                    move(-move);
                    if (rotation == 90 || rotation == 91 || rotation == 89 || rotation == 270 || rotation == 271 ||rotation ==269) {
                        standingStill = true;
                    }
                    horizontalSpeed = Math.cos(rotation * 0.017453);
                    int speed = (int) Math.round(horizontalSpeed * move);
                    if (speed == 0 && horizontalSpeed > 0) speed = 1;
                    if (speed == 0 && horizontalSpeed < 0) speed = -1;
                    if (speed == 0 && horizontalSpeed == 0) {
                        speed = 0;

                    }
                    setLocation(getX() + speed, getY() );

                }

                if ((blockedRight && ((rotation > 270 && rotation < 360 ) || (rotation >= 0 && rotation < 90 ))) || 
                (blockedLeft && (rotation > 90 && rotation < 270  ))) {
                    if (rotation < 181  && rotation > 179 || rotation == 359 || rotation == 0 || rotation == 1) {
                        standingStill = true;
                    }
                    move(-move);
                    verticalSpeed = Math.sin(rotation * 0.017453);
                    int speed = (int) Math.round(verticalSpeed * move);

                    if (speed == 0 && verticalSpeed > 0) speed = 1;
                    if (speed == 0 && verticalSpeed < 0) speed = -1;
                    if (speed == 0 && verticalSpeed == 0) {
                        speed = 0;

                    }
                    setLocation(getX() , getY() + speed);

                }

            }

        }
        else {
            move(1);
            if (getOneIntersectingObject(Shelf.class) != null) { 
                move(-1); //if worker hits a wall, move back the same amount moved forward.
                standingStill = true;
            }
        }

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

    public void runAnimation() {
        int RUNSPEED = 5;
        if(0 <= frame && frame < RUNSPEED) {setImage("WorkerStill.png");}
        else if(RUNSPEED <= frame && frame < RUNSPEED*2) {setImage("WorkerW1.png");}
        else if(RUNSPEED*2 <= frame && frame < RUNSPEED*3) {setImage("WorkerW2.png");}
        else if(RUNSPEED*3 <= frame && frame < RUNSPEED*4 - 1) {setImage("WorkerW3.png");}
        else if(RUNSPEED*4 - 1 <= frame) {

            frame = 0;
            return;
        }
        frame++;

    }

    public void walkAnimation() {

        Integer rotationd = Math.round(getRotation());
        int rotation = rotationd.intValue();

        //Shelf shelf;
        //shelf = (Shelf) getOneIntersectingObject(Shelf.class);

        // List <Shelf> shelves = getObjectsInRange(20, Shelf.class);
        //rotation > 0 && rotation < 180 ||rotation > 180 && rotation <= 359
        if ((blockedUp && (rotation > 180 && rotation <= 359)) || (blockedDown && (rotation > 0 && rotation < 180))) {
            working = false;

        }
        if ((blockedRight && ((rotation > 270 && rotation < 360 ) || (rotation >= 0 && rotation < 90 ))) || 
        (blockedLeft && (rotation > 90 && rotation < 270  ))) {
            working = false;

        }

        if (working) {
            workingCount++;
            int RUNSPEED = 20;
            if(0 <= workingCount && workingCount < RUNSPEED) {setImage("WorkerStill.png");}
            else if(RUNSPEED <= workingCount && workingCount < RUNSPEED*2) {setImage("WorkerW1.png");}
            else if(RUNSPEED*2 <= workingCount && workingCount < RUNSPEED*3) {setImage("WorkerW2.png");}
            else if(RUNSPEED*3 <= workingCount && workingCount < RUNSPEED*4 - 1) {setImage("WorkerW3.png");}
            else if(RUNSPEED*4 - 1 <= workingCount) {
                workingCount = 0;

            }
        }
    }
}
