import greenfoot.*;
import java.awt.Color;
/**
 * Write a description of class VictoryScore here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class VictoryScore extends AnimatedText
{
    /**
     * Act - do whatever the VictoryScore wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int score;
    public VictoryScore(int scoreIn){
       score = scoreIn;
    }
    public int getScore(){
       return score;
    }
    public void act() 
    {
        // Add your action code here.
    }
}
