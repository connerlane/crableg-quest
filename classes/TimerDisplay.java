import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class TimerDisplay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TimerDisplay extends HUDMenu
{
    /**
     * Act - do whatever the TimerDisplay wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int digit;
    private int value = 0;
    String[] images = {"score0.png", "score1.png", "score2.png", "score3.png", "score4.png",
                        "score5.png", "score6.png", "score7.png", "score8.png", "score9.png"};
    public TimerDisplay(int digitIn){
       digit = digitIn;
    }
    public void act() 
    {
        List<Timer> group = getObjectsInRange(3000, Timer.class);
        if(group.size() == 0) return;
        else{
            String temp = (" " + group.get(0).getTime()).trim();
            if(temp.length() - 1 >= digit){
                value = Character.getNumericValue(temp.charAt(temp.length() - digit - 1));
            }
        }
        setImage("score" + value + ".png");
    } 
}
