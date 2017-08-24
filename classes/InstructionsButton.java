import greenfoot.*;

/**
 * Write a description of class InstructionsButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InstructionsButton extends AnimatedText
{
    /**
     * Act - do whatever the InstructionsButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    private GreenfootImage button_1 = new GreenfootImage("InstructionsButton.png");
    private GreenfootImage button_2 = new GreenfootImage("InstructionsButton2.png");
    MouseInfo mouse;

    public InstructionsButton() {
        setImage(button_1);
    }

    public void act() 
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (Greenfoot.mouseMoved(this)) {
            setImage(button_2);
        }
        else if(mouse == null || mouse.getX() >=  878 || mouse.getX() <= 702|| mouse.getY() <= 522 || mouse.getY() >= 562) {
            setImage(button_1);
        }
        if (Greenfoot.mousePressed(this)) {
            setImage(button_1);
            Greenfoot.setWorld(new Instructions());
        }
    }    
}
