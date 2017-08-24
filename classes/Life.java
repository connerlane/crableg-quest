import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Life here.
 * 
 * @author Conner
 * @version 4-8-2015
 */
public class Life extends HUDMenu
{
    int id;
    GreenfootImage img1 = new GreenfootImage("lifeheadresized.png");
    GreenfootImage img2 = new GreenfootImage("pushStartempty.png");
    private int counter = 19;

    public Life(int number) {

        id = number;
  
    }

    public void act() 
    {
        
        Publix asd = (Publix) getWorld();
        Jameis pal = asd.getJameis();

        if (Jameis.getLives() < id) {

            getWorld().removeObject(this);

        }
        if(pal.getIsDead()) {
            
            if(counter % 20 == 0 && id == Jameis.getLives()) {
                blink();
            }
            counter++;
        }
        checkForStop();
    }

    public void blink(){
        if( this.getImage() == img1) {
            setImage(img2);
        }
        else {
            setImage(img1);
        }
        
    } 
    
    public void checkForStop() {
        
        if (counter > 170) {
            
            getWorld().removeObject(this);
        }
        
    }
}
