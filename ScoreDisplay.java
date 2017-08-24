import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class ScoreDisplay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoreDisplay extends HUDMenu
{
    /**
     * Act - do whatever the ScoreDisplay wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int digit;
    private int value = 0;
    String[] images = {"score0.png", "score1.png", "score2.png", "score3.png", "score4.png",
                        "score5.png", "score6.png", "score7.png", "score8.png", "score9.png"};
    public ScoreDisplay(int digitIn){
       digit = digitIn;
    }
    public void act() 
    {
        List<Score> group = getObjectsInRange(3000, Score.class);
        if(group.size() == 0) return;
        else{
            String temp = (" " + group.get(0).getScore()).trim();
            if(temp.length() - 1 >= digit){
                value = Character.getNumericValue(temp.charAt(temp.length() - digit - 1));
            }
        }
        setImage("score" + value + ".png");
    }    
}
