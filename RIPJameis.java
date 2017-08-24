import greenfoot.*;

/**
 * Write a description of class RIPJameis here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RIPJameis extends Sprites
{
    /**
     * Act - do whatever the RIPJameis wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int count = 0;
    public void act() 
    {
        count++;
        if(getX() != 440){
            if(getX() > 440){
                setLocation(getX()-1, getY());
            }
            if(getX() < 440){
                setLocation(getX()+1, getY());

            }
            if(getY() != 280){
                if(getY() < 100 && getY() > 0){
                    if(count % 3 == 0)
                    setLocation(getX(), getY() + 1);
                }
                if(getY() < 560 && getY() > 360){
                    if(count % 3 == 0)
                    setLocation(getX(), getY() -1);
                }
            }
        }

    }
}
