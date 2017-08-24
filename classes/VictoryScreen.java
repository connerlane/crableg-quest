import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class VictoryScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class VictoryScreen extends World
{
    private int count = 0;
    private boolean hasAddedFadeIn = false;
    private int score = 0;
    VictoryScoreDisplay digit0 = new VictoryScoreDisplay(0);
    VictoryScoreDisplay digit1 = new VictoryScoreDisplay(1);
    VictoryScoreDisplay digit2 = new VictoryScoreDisplay(2);
    VictoryScoreDisplay digit3 = new VictoryScoreDisplay(3);
    /**
     * Constructor for objects of class VictoryScreen.
     * 
     */
    public VictoryScreen(int scoreIn)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(880, 560, 1, false);
        setPaintOrder(WhiteWall.class, JameisVictory.class, 
                       YouWin.class, YourScoreText.class,
                       VictoryScoreDisplay.class,
                       VictoryScore.class, VictoryLegs.class,
                       Rays.class);
        for (int i = 0; i < 100; i++) {
            addObject(new VictoryLegs(), Greenfoot.getRandomNumber(860)+10, Greenfoot.getRandomNumber(560));
            
        }
        addObject(new WhiteWall(255), 440, 280);
        addObject(new JameisVictory(), 700, 280);
        addObject(new Rays(), 880, 560);
        score = scoreIn;
    }
    
    public void act() {
       if(getObjects(WhiteWall.class).size() == 0 && !hasAddedFadeIn){
           addObject(new WhiteWall(0), 440, 280);
           addObject(new YouWin(), 440, 80);
           addObject(new YourScoreText(), 417, 155);
           addObject(new VictoryScore(score), 501, 155);
           addObject(digit3, 480, 155);
           addObject(digit2, 491, 155);
           addObject(digit1, 502, 155);
           addObject(digit0, 513, 155);
           hasAddedFadeIn = true;
        }
       count++;
       if (Greenfoot.getRandomNumber(100) < 9) {
            addObject(new VictoryLegs(), Greenfoot.getRandomNumber(860)+ 10, -20);
        }
       
        if(count > 900){
            Greenfoot.setWorld(new StartScreen());
        }
    }
}
