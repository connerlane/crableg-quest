import greenfoot.*;
import java.util.List;
/**
 * Write a description of class IndicatorCover here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IndicatorCover extends Invincibility
{
    /**
     * Act - do whatever the IndicatorCover wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public int time;
   public IndicatorCover(int i) {
        
        setInitialLength();
        time = i;
        
    }
    public void act() 
    {
        
        List<Jameis> group = getObjectsInRange(3000,Jameis.class);
       
     
     time--;
        setLocation(group.get(0).getX(), group.get(0).getY() - 36);
       if (time == 0) {
           getWorld().removeObject(this);
           // Add your action code here.
    }    
}

public void setInitialLength() {
    
    GreenfootImage img = getImage();
    int width = 130;
    int height = 18;
    
    img.scale(width, height);
    
    
    
}

}
