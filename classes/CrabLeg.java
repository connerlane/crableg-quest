import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Life here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CrabLeg extends Tokens
{
    static int legsCreated;

    /**
     * Act - do whatever the Life wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public CrabLeg() {
        legsCreated++;
    }
    
    public void act() {
        fakeAnimation();
        pickUp();
    }
    
        public void pickUp() {
        List<Jameis> group = getObjectsInRange(30, Jameis.class);
        if (!group.isEmpty()) {
            group.get(0).legsCollected++;
            nom.play();
           getWorld().removeObject(this);
           
            
            
        }
    }

   
}
