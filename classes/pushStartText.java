import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Text for start screen
 * 
 * @author  Erich 
 * @version 4-9-2015
 */
public class pushStartText extends AnimatedText
{
    private int counter = 1;
    GreenfootImage img1 = new GreenfootImage("pushStart.png");
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
        }
    }
}
