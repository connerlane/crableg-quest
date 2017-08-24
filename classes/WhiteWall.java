import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WhiteWall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WhiteWall extends Actor
{
    /**
     * Act - do whatever the WhiteWall wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    int time = 0;
    boolean hasAppeared = false;
    public WhiteWall(int transparency){
        getImage().setTransparency(transparency);
        time = transparency;
    }

    public void act() 
    {
        
        if(!hasAppeared) time += 15;
        if(time > 254)hasAppeared = true;
        if(hasAppeared) time -= 15;
        if(time < 255 && time >= 0){
            getImage().setTransparency(time);
        }
        if(hasAppeared && time == 0)getWorld().removeObject(this);

    }    
}
