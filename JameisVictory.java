import greenfoot.*;

/**
 * Write a description of class JameisVictory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class JameisVictory extends Sprites
{
    /**
     * Act - do whatever the JameisVictory wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private int count = 0;
    public void act() 
    {
        count++;
        if(count < 10){
            move(-17);
        }
        else{
            if(count % 10 == 0){
                move(-1);
            }
        }
    }    
}
