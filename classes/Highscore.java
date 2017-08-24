import greenfoot.*;
import java.awt.Color;

/**
 * Write a description of class Highscore here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Highscore extends AnimatedText
{
    /**
     * Act - do whatever the Highscore wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
    }
    
    public void display(){
        setImage(new GreenfootImage(" " + Publix.getHighScore(), 24, Color.WHITE, new Color(0, 0, 0, 0)));
    }
}
