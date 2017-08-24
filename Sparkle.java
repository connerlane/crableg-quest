import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sparkle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sparkle extends Invincibility
{
    int time = 0;
    int runSpeed = Greenfoot.getRandomNumber(2) + 1;
    int rotation = Greenfoot.getRandomNumber(360);
    /**
     * Act - do whatever the Sparkle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (time == 0) {
            setSize();
            setRotation(rotation);
        }
        move();
        delete();

        time++;
    }    

    public void move() {
        move(runSpeed);
    }

    public void delete() {

        if (time > 40) {
            
            getWorld().removeObject(this);

        }

    }

    public void setSize() {

        double scaleFactor = Greenfoot.getRandomNumber(220) / 100 + 2;

        GreenfootImage img = getImage();
        int width = (int)(img.getWidth() * scaleFactor);
        int height = (int)(img.getHeight() * scaleFactor);
        img.scale(width, height);
        setImage(img);

    }
}
