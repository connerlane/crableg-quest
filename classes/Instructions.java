import greenfoot.*;

/**
 * Write a description of class Instructions here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Instructions extends World
{
    String[] imageNames = {"instructions1.jpg", "instructions2.jpg", "instructions3.jpg", "instructions4.jpg",
            "instructions5.jpg", "instructions6.jpg","instructions7.jpg"};
    private int i = 0;
    /**
     * Constructor for objects of class Instructions.
     * 
     */
    public Instructions()
    {    
        super(880, 560, 1, false);
        setBackground(imageNames[0]);
        Greenfoot.delay(30);
    }

    public void act() {

        if(Greenfoot.isKeyDown("enter")){
            Greenfoot.delay(20);
            i++;
            if(i > 6)Greenfoot.setWorld(new StartScreen());
            else setBackground(imageNames[i]);
        }
    }
}
