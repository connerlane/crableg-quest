import greenfoot.*;

/**
 * Write a description of class AnimatedText here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AnimatedText extends Actor
{
    protected int count = 0;
    protected int transparency = 2;
    protected boolean goingUp = true;
    public void fadeInAndOutAndMove() { //method for animated text; 
        getImage().setTransparency(transparency);
        count++;
        if(goingUp){
            transparency += 2;
        }
        else{
            transparency -= 2;
        }
        if (count % 4 == 0) setLocation(getX() + 1, getY() + 1);
        if(transparency > 253){
            goingUp = false;
            count = 0;
        }
        if(transparency <= 0) {
            goingUp = true;
        }
    }

    public int getTransparency() {
        return transparency; 
    }

    public void fadeIn() {
        getImage().setTransparency(transparency);
        count++;
        if(transparency != 255){
            transparency++;
        }

    }
}

