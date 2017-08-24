import greenfoot.*;

/**
 * Write a description of class StartScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartScreen extends World
{
    pushStartText start = new pushStartText();
    TitleText title = new TitleText();
    cloud c1 = new cloud();
    cloud c2 = new cloud();
    int time = 1;
    public final static GreenfootSound loop = new GreenfootSound("intro_loop.mp3");
    int randomSpawner = 0;
    boolean crabTime = false;
    private static boolean hasPlayed = false;
    BlackWall black1 = new BlackWall();
    HighScoreDisplay highScoreDigit0 = new HighScoreDisplay(0);
    HighScoreDisplay highScoreDigit1 = new HighScoreDisplay(1);
    HighScoreDisplay highScoreDigit2 = new HighScoreDisplay(2);
    HighScoreDisplay highScoreDigit3 = new HighScoreDisplay(3);
    public StartScreen(){
        super(880, 560, 1, false);
        setPaintOrder(BlackWall.class, Highscore.class, HighscoreText.class, InstructionsButton.class, TitleText.class, pushStartText.class, cloud.class);
        addObject(start, 440, 155);
        addObject(title, 440, 80);
        addObject(black1, 440, 280);

        addObject(c1, -100, Greenfoot.getRandomNumber(80));
        addObject(new InstructionsButton(), 788, 546);
        Jameis.setLives(3);
        if(hasPlayed){

            addObject(highScoreDigit0, 511, 403);
            addObject(highScoreDigit1, 500, 403);
            addObject(highScoreDigit2, 489, 403);
            addObject(highScoreDigit3, 478, 403);
            addObject(new HighscoreText(), 413, 403);

        }
        Greenfoot.delay(30);
        Publix.setLevelCount(1);
        if(Intro.full.isPlaying()) {
            //donothing
        }
        else if (Publix.theme.isPlaying()) {
            Publix.theme.stop();
            loop.playLoop();
        }
        else {
            loop.playLoop();
        }
    }

    public void act() {
        if (time < 128) fadeIn();
        else {
            removeObject(black1);
        }
        if (Greenfoot.isKeyDown("enter")) {
            hasPlayed = true;
            Intro.stopMusic();
            Greenfoot.setWorld(new Publix(1));
        }
        randomSpawner = Greenfoot.getRandomNumber(120);
        if (time % 1000 == 0){
            removeObject(c1);
            addObject(c1, -100, randomSpawner);
            if(crabTime){
                removeObject(c2);
                addObject(c2, -70, randomSpawner + 10);
            }

            if(time > 4000) {
                c1.setSpriteImage("lifehead.png");
            }

            if(time > 5000) {
                addObject(c2, -50, randomSpawner + 10);
                c2.setSpriteImage("crableg.png");
                c2.getImage().rotate(45);
                crabTime = true;
            }

        }
        time++;
    }

    public void fadeIn() {

        black1.getImage().setTransparency(256 - time*2);
    }
}
