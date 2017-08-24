import greenfoot.*;

/**
 * Write a description of class Disclaimer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Disclaimer extends AnimatedText
{
    /**
     * Act - do whatever the Disclaimer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        fadeInAndOut();
    }

    public void fadeInAndOut(){
        if(transparency < 3 && !goingUp)getWorld().removeObject(this);
        getImage().setTransparency(transparency);
        count++;
        if(goingUp){
            transparency += 2;
        }
        else{
            transparency -= 2;
        }

        if(transparency > 253){
            goingUp = false;
            count = 0;
        }
        if(transparency <= 0) {
            goingUp = true;
        }
        
    }
}

