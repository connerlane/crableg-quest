import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class VictoryScoreDisplay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class VictoryScoreDisplay extends AnimatedText
{
    /**
     * Act - do whatever the VictoryScoreDisplay wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int digit;
    private int value = 0;
    public VictoryScoreDisplay(int digitIn){
       digit = digitIn;
    }
    public void act() 
    {
        List<VictoryScore> group = getObjectsInRange(3000, VictoryScore.class);
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
