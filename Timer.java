import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.util.List;

public class Timer extends HUDMenu
{
    /**
     * Act - do whatever the Timer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int time = 60;
    private int count = 3660;
    public void act() 
    {
        List<Jameis> group = getObjectsInRange(3000,Jameis.class);
        if(time == 0)
        {
            return;
        }

        if(group.size() >= 1){
            if(group.get(0).getIsDead() == false){
                if(count > 0)
                {
                    count--;
                    if (count % 60 == 0){
                        time--;
                    }
                }
                
            }   
        }
        
    }

    private void display()
    {

        setImage(new GreenfootImage(" " + time, 30, Color.WHITE, new Color(155, 47, 0)));
    }

    public boolean isTimeUp()
    {
        return time == 0;
    }
    
    public int getTime(){
        return time;
    }

}

