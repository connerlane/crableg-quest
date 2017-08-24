import greenfoot.*;

/**
 * Write a description of class YouWin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class YouWin extends AnimatedText
{
    /**
     * Act - do whatever the YouWin wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
       private int counter = 1;
       private static GreenfootSound ding = new GreenfootSound("PickUp.wav");
       
    GreenfootImage img1 = new GreenfootImage("YouWin.png");
    GreenfootImage img2 = new GreenfootImage("pushStartempty.png");

    public void act() {
        counter++;
        if(counter % 30 == 0){
            blink();
            counter = 1;
        }
    }

    public void blink(){
        if( this.getImage() == img1) {
            setImage(img2);
        }
        else {
            setImage(img1);
            ding.play();
            ding.setVolume(80);
        }
    }  
}
