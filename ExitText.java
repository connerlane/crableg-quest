import greenfoot.*;

/**
 * Write a description of class Exit here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ExitText extends AnimatedText
{
    private int counter = 1;
    GreenfootImage img1 = new GreenfootImage("exit.png");
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
