import greenfoot.*;
import java.util.List;
/**
 * Write a description of class IndicatorBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IndicatorBar extends Invincibility

{
    /**
     * Act - do whatever the IndicatorBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public int energy = 350;
    public int time;

    public IndicatorBar(int i) {
        setInitialLength();
        time = i;
    }
    public void act() 
    {
        
        time--;
        if (time == 0) {
            getWorld().removeObject(this);
            return;
        }    

        setLength();
    }

    public void setLength() { 
        List<Jameis> group = getObjectsInRange(3000,Jameis.class);
        double proposedWidth = ((time / 3) * 0.01 * energy);
        int width = 100;
        if (proposedWidth > 0) {
            width = (int)proposedWidth;
            setLocation((group.get(0).getX()) - (energy - width)/2, group.get(0).getY() - 36);
        }
        else {
             getWorld().removeObject(this);
            }
        GreenfootImage img = getImage();
        img.scale(width, img.getHeight());

    }

public void setInitialLength() {
   
    GreenfootImage img = getImage();
    int width = 130;
    int height = 18;
    energy = width;
    img.scale(width, height);
    
    
    
}



}
