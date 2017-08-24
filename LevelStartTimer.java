import greenfoot.*;

/**
 * Write a description of class LevelStartTimer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelStartTimer extends AnimatedText
{
    /**
     * Act - do whatever the LevelStartTimer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int time = 5;
    private int count = 300;
    String level;
    public void act() 
    {
        if(time == 0)
        {
            return;
        }

        if(count > 0)
        {
            count--;
            if (count % 60 == 0){
                time--;
            }
        }
        display();

    }

    private void display()
    {
        switch (time){
            case 5:
            if(Publix.getLevelCount() == 1){
                setImage("levelone.png");
            }
            if(Publix.getLevelCount() == 2){
                setImage("leveltwo.png");
            }
            if(Publix.getLevelCount() == 3){
                setImage("levelthree.png");
            }
            break;
            case 4:
            setImage("number3.png");
            break;
            case 3:
            setImage("number2.png");
            break;
            case 2:
            setImage("number1.png");
            break;
            case 1:
            setImage("go.png");
            break;
            case 0:
            break;
            default: 
            setImage("PushStartTextEmpty.png");
        }
    }

    public boolean isCountdownDone()
    {
        return time == 0;
    }
}
