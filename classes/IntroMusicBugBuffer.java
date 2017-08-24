import greenfoot.*;

/**
 * Write a description of class IntroMusicBugBuffer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IntroMusicBugBuffer extends World
{

    /**
     * Constructor for objects of class IntroMusicBugBuffer.
     * 
     */
    public IntroMusicBugBuffer()
    {    
        
        super(880, 560, 1, false); 
        Intro.stopMusic();
    }
    public void act() {
        Intro.stopMusic();
        Greenfoot.setWorld(new Intro());
    }
}
