import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Aggro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Aggro extends EnemySymbols
{
    private int time = 0;

    //  List<Worker> 
    int targetX;
    int targetY;
    int workerId;
    /**
     * Act - do whatever the Question wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Aggro(int id) {

        workerId = id;
    }

    public void act() 
    {

        /**if (time < 1) { 
        List<Worker> l2 = getObjectsInRange(4 , Worker.class);
        //l.add(0, l2.get(0));
        Worker heh = l2.get(0);
        targetX = heh.getX();
        targetY = heh.getY();
        }
         */
        //  Actor guy = l.get(0);
        Publix asd = (Publix) getWorld();
        if (workerId == 1) {
            Worker ww1 = asd.getw1();
            targetX = ww1.getX();
            targetY = ww1.getY();

        }
        if (workerId == 2) {
            Worker ww2 = asd.getw2();
            targetX = ww2.getX();
            targetY = ww2.getY();

        }
        if (workerId == 3) {
            Worker ww3 = asd.getw3();
            targetX = ww3.getX();
            targetY = ww3.getY();

        }
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
