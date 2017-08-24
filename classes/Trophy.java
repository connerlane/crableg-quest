import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Life here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Trophy extends Tokens
{

    /**
     * Act - do whatever the Life wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
        public void act() {
        fakeAnimation();
        pickUp();
    }
        public void pickUp() {
        List<Jameis> group = getObjectsInRange(30, Jameis.class);
        if (!group.isEmpty()) {
           ding.play();
           getWorld().removeObject(this);
           group.get(0).trophiesCollected++; 
            
        }
    }
}
