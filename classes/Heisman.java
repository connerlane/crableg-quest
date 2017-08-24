import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Life here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Heisman extends Tokens
{
    int frame = 0;

    public void act() {
        fakeAnimation();
        pickUp();
    }
    public void fakeAnimation() {
        if( frame == 0)setLocation(getX(), getY() - 1);
        else if (frame == 9)setLocation(getX(), getY() - 1);
        else if (frame == 18) setLocation(getX(), getY() - 1);
        else if ( frame == 27)setLocation(getX(), getY() + 1);
        else if ( frame == 36)setLocation(getX(), getY() + 1);
        else if ( frame == 45)setLocation(getX(), getY() + 1);
        else if ( frame > 45){
            frame = 0;
            return;
        }
        else{

        }
        frame++;
    }

    public void pickUp() {
        List<Jameis> group = getObjectsInRange(25, Jameis.class);
        if (!group.isEmpty()) {
            group.get(0).isTurnt = true;
            group.get(0).turntCount = 0;
            power.play();
            getWorld().removeObject(this);
            

        }
    }

}
