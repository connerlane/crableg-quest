import greenfoot.*;

/**
 * Write a description of class Rays here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rays extends Actor
{
    /**
     * Act - do whatever the Rays wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int count = 0;
    public void act() 
    {
        count++;
        if(count % 4 == 0){
            setRotation(getRotation() + 1);
        }
    }    
}
