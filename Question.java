import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Question here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Question extends EnemySymbols
{
    private int time = 0;

    //  List<Worker> 
    int targetX;
    int targetY;
    /**
     * Act - do whatever the Question wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (time < 1) { 
            List<Worker> l2 = getObjectsInRange(4 , Worker.class);
            //l.add(0, l2.get(0));
            Worker heh = l2.get(0);
            targetX = heh.getX();
            targetY = heh.getY();
        }
        //  Actor guy = l.get(0);

        if (time < 8) {
            
            setLocation(targetX, targetY - time*3);

            
            
        }
        else if (time >= 8 && time < 22) {
           
            setLocation(targetX, targetY - 24);
        }
        else if (time >= 22) {

            getWorld().removeObject(this);

        }
        time++;
    }    
}
