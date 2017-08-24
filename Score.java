import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.awt.Color;
/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score extends HUDMenu
{
    /**
     * Act - do whatever the Score wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int score = 0;
    int[] stuff;
    public void act() 
    {
       List<Jameis> group = getObjectsInRange(3000,Jameis.class);
       if(group.size() == 0)  return;
       stuff = group.get(0).getStuffCollected();
       calculateScoreValues();
    } 
    
    public void calculateScoreValues(){
       score = stuff[0] * 10 + stuff[1] * 500 + stuff[2] * 100 + 5* stuff[3];
    }
    
    public void display(){
        setImage(new GreenfootImage(" " + score, 30, Color.WHITE, new Color(155, 47, 0)));
    }
   
    public int getScore() {
        return score;
    }
}
