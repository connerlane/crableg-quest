import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class storytext here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class storytext extends AnimatedText
{
    /**
     * Act - do whatever the storytext wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        fadeInAndOutAndMove();
    }
    public void setSpriteImage(String imageIn){
        this.setImage(imageIn);
    }
}
