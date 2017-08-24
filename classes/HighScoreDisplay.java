import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HighScoreDisplay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HighScoreDisplay extends AnimatedText
{
    private int digit;
    private int value = 0;
    String[] images = {"score0.png", "score1.png", "score2.png", "score3.png", "score4.png",
            "score5.png", "score6.png", "score7.png", "score8.png", "score9.png"};
    public HighScoreDisplay(int digitIn){
        digit = digitIn;
    }

    public void act() 
    {

        String temp = (" " + Publix.getHighScore()).trim();
        if(temp.length() - 1 >= digit){
            value = Character.getNumericValue(temp.charAt(temp.length() - digit - 1));

        }
        setImage("score" + value + ".png");
    }  
}
