import greenfoot.*;
import java.util.List;
/**
 * Write a description of class Tokens here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */



public class Tokens extends Actor
{
    int frame = 0;
    public static final GreenfootSound ding = new GreenfootSound("PickUp.wav");
    public static final GreenfootSound nom = new GreenfootSound("nom.wav");
    public static final GreenfootSound power = new GreenfootSound("power.wav");
    /**
     * Act - do whatever the Tokens wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
    } 

    public void fakeAnimation() {
        if( frame == 0)setLocation(getX(), getY() - 1);
        else if (frame == 9)setLocation(getX(), getY() - 1);
        else if (frame == 18) setLocation(getX(), getY() - 1);
        else if ( frame == 27)setLocation(getX(), getY() + 1);
        else if ( frame == 36)setLocation(getX(), getY() + 1);
        else if ( frame == 45)setLocation(getX(), getY() + 1);
        else if ( frame > 45){
            frame = 0;
            return;
        }
        else{
            
        }
        frame ++;
    }
    
    public void pickUp() {
        List<Jameis> group = getObjectsInRange(30, Jameis.class);
        if (!group.isEmpty()) {

           getWorld().removeObject(this);
            
            
        }
    }
}  

