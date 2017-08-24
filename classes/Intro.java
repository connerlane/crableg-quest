import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Intro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Intro extends World
{
    public static GreenfootSound full = new GreenfootSound("intro_full.mp3");
    storytext text = new storytext();
    String[] images = {"storytext1.png", "storytext2.png", "storytext3.png", "storytext4.png","pushStartempty.png"};
    private int i = 0;
    private int count = 1;
    private int time = 1;
    public Intro()
    {    
        super(880, 560, 1, false);
        addObject(text, 380, 220);
        full.stop();
        addObject(new Disclaimer(), 440, 540); 

    }

    public void playMusic()
    {
        if (!full.isPlaying())
        {
            full.setVolume(80);
            full.playLoop();
        }
    }

    public static void stopMusic() {

        full.stop();
    }

    public void act() { 
        time++;
        if (time == 4) {
            full = new GreenfootSound("intro_full.mp3");
            playMusic();

            
        }
        if(text.getTransparency() == 2){
            text.setSpriteImage(images[i]);
            text.setLocation(380, 220);
            count++;
            if(count % 2 == 0){
                i++;
            }
            if(i > 4){
                Greenfoot.setWorld(new StartScreen());
            }
        }
        if(Greenfoot.isKeyDown("enter")){
            Greenfoot.setWorld(new StartScreen());
        }
    }
}
