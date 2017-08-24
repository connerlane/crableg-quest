import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class VictoryLegs here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class VictoryLegs extends Tokens
{
    private int count = 0;
    int moveSpeed;
    /**
     * Act - do whatever the VictoryLegs wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public VictoryLegs() {
        setRotation(Greenfoot.getRandomNumber(360));
        if(Greenfoot.getRandomNumber(100) < 50){
            moveSpeed = Greenfoot.getRandomNumber(4) + 2;
        }
        else{
            moveSpeed = 1;
        }
    }

    public void act() 
    {
        count++;
        if(count % 2 == 0){
            setLocation(getX(), getY()+moveSpeed);
        }
        if(getY() > 570){
            getWorld().removeObject(this);
        }
    }    
}
