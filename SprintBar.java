import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class SprintBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SprintBar extends HUDMenu
{
    /**
     * Act - do whatever the SprintBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int time;
    public int energy = 70;
    private int HEIGHT;
    private int delay = 0;
    private GreenfootImage green = new GreenfootImage("juice.jpg");
    private GreenfootImage rainbow = new GreenfootImage("turntJuice.jpg");
    List<Jameis> group;
    public SprintBar() {
        setInitialLength();
    }

    public void act() 
    {
        List<Jameis> group = getObjectsInRange(3000,Jameis.class);
        
        handleKeyPress();
        if(group.size() == 0) return;
        if(group.get(0).getIsDead() == false){
            setLength();
            restoration();
        }
        if(group.get(0).turnt()){
            energy = 70;
            setImage(rainbow);
            
        }
        else{
            setImage(green);
        }

    }
    public void setLength() {
        GreenfootImage img = getImage();
        int proposedHeight = (int) (HEIGHT * (energy * 0.01));
        if (proposedHeight > 1) {
            int height = (int)(proposedHeight);

            img.scale(img.getWidth(), height);
            setImage(img);
        }
    }

    public void handleKeyPress() {
        List<Jameis> group = getObjectsInRange(3000,Jameis.class);
        if(group.size() == 0) return;
        if (Greenfoot.isKeyDown("shift")  && energy > 1 && group.get(0).isStandingStill() == false){
            if(group.get(0).turnt() == false){
                energy --;
            }
            if(group.get(0).turnt()){
                energy = 70;
            }

        
        }

    }

    private void setInitialLength() {
        if (time == 0) {
            GreenfootImage img = getImage();

            HEIGHT = (img.getHeight() * 1);
            time++;
        }

    }

    public void restoration() {
        if (Greenfoot.isKeyDown("shift") ) {
            delay = 0;
        }
        else  {
            if(energy != 70){
                delay++;
                if( delay >= 50){
                    energy++;
                }
            }
        }
    }

    public int getEnergy() {
        return energy;
    }
}