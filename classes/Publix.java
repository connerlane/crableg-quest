import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Actual level of the game.
 * 
 * All music created by Conner Lane. 
 * All SFX created using Bfxr Standalone V1.4.1
 * @author Conner Lane, Erich Wu, Haven Barnes, Noah Labier
 * @version FINAL
 */
public class Publix extends World
{
    Worker w1 = new Worker(1);
    Worker w2 = new Worker(2);
    Worker w3 = new Worker(3);
    Worker w4 = new Worker(4);
    public static final GreenfootSound theme = new GreenfootSound("game_theme_full.mp3");
    public static final GreenfootSound levelChange = new GreenfootSound("LevelUp.wav");
    Jameis Wameis = new Jameis();
    Life l1 = new Life(1);
    Life l2 = new Life(2);
    Life l3 = new Life(3);

    EndShelf s1 = new EndShelf();
    EndShelf s2 = new EndShelf();
    EndShelf s3 = new EndShelf();
    EndShelf s4 = new EndShelf();
    EndShelf s5 = new EndShelf();
    EndShelf s6 = new EndShelf();

    Timer t1 = new Timer();
    Score scoreObject = new Score();
    ScoreDisplay scoreDigit0 = new ScoreDisplay(0);
    ScoreDisplay scoreDigit1 = new ScoreDisplay(1);
    ScoreDisplay scoreDigit2 = new ScoreDisplay(2);
    ScoreDisplay scoreDigit3 = new ScoreDisplay(3);
    ScoreDisplay scoreDigit4 = new ScoreDisplay(4);
    TimerDisplay timeDigit0 = new TimerDisplay(0);
    TimerDisplay timeDigit1 = new TimerDisplay(1);
    private int counter = 1;
    public static int levelCount = 1;
    JinstonJuiceBottle j1 = new JinstonJuiceBottle();
    private boolean started = false;
    private boolean hasSpawned = false;
    LevelStartTimer countdown = new LevelStartTimer();
    static int[] initialScoreValues = {0,0,0,0};
    private static int livesLeft = 3;
    private static int highScore = 0;

    /**
     * Constructor for objects of class Publix.
     * 
     */
    public Publix(int levelCount)
    {    
        super(880, 560, 1, true);
        stopOtherMusic();
        playMusic();
        levelChange.play();
        setPaintOrder(IndicatorCover.class, IndicatorBar.class, Sparkle.class, Jameis.class, Dust.class, Aggro.class, Question.class, stars.class,
            Worker.class, Life.class, JinstonJuiceBottle.class, SprintBar.class,
            GameOverText.class, RIPJameis.class);

        if(livesLeft == 3){
            addObject(l3, 40, 215);
            addObject(l2, 40, 290);
            addObject(l1, 40, 365);
        }
        if(livesLeft == 2){
            addObject(l2, 40, 290);
            addObject(l1, 40, 365);
        }
        if(livesLeft == 1){
            addObject(l1, 40, 365);
        }

        //HUD BARRIER:
        addObject(new HUD(), 40, 280);
        addObject(j1, 40, 530);
        counter = 1;
        addObject(countdown, 440, 280);

    }

    public void playMusic()
    {
        if (!theme.isPlaying())
        {
            theme.setVolume(70);
            theme.playLoop();
        }
    }

    public void stopOtherMusic() 
    {
        if (Intro.full.isPlaying())
        {
            Intro.full.stop();
        }
        if (StartScreen.loop.isPlaying())
        {
            StartScreen.loop.stop();
        }
    }

    public void stopMusic() {

        theme.stop();
    }

    public void act() {
        if(countdown.isCountdownDone()){
            started = true;
        }
        if(started && !hasSpawned){
            removeObject(countdown);
            spawnLevel(levelCount);
            hasSpawned = true;
        }
        if(started){
            gameOver();
        }
    }

    public void spawnLevel(int levelCount)
    {
        if(levelCount == 1) {
            Wameis.setStuffCollected(new int[]{0,0,0,0});
            addObject(Wameis, 480, 530);
            livesLeft = 3;

            addObject(w1, 615, 300);
            addObject(w2, 615, 40);
            addObject(w3, 100, 300);

            addObject(new EndShelf(), 700, 246);
            addObject(new EndShelf(), 475, 246);        
            addObject(new EndShelf(), 250, 246);
            addObject(new Shelf(), 700, 400);
            addObject(new Shelf(), 475, 400);        
            addObject(new Shelf(), 250, 400);

            addObject(new CrabLeg(), 125, 50);
            addObject(new CrabLeg(), 125, 520);
            addObject(new CrabLeg(), 365, 300);
            addObject(new CrabLeg(), 588, 300);
            addObject(new CrabLeg(), 475, 60);
            addObject(new CrabLeg(), 830, 525);

            addObject(new Heisman(), 295, 130);
            addObject(new Trophy(), 830, 300);

            addObject(t1, 37, 58);//timer - we have to add a new one each level because its image is dependent upon a jameis class existing in the world.
            addObject(timeDigit0, 45, 58);
            addObject(timeDigit1, 34, 58);
            addObject(new SprintBar(), 40, 527); //the juice - same reason as the timer
            
            addObject(scoreObject, 37, 126);
            addObject(scoreDigit0, 56, 126);
            addObject(scoreDigit1, 45, 126);
            addObject(scoreDigit2, 34, 126);
            addObject(scoreDigit3, 23, 126);
            

        }
        else if(levelCount == 2) {
            Wameis.setStuffCollected(initialScoreValues);
            addObject(Wameis, 480, 540);

            addObject(w1, 840, 515);
            addObject(w2, 840, 71);
            addObject(w3, 137, 71);
            addObject(w4, 137, 515);

            addObject(s1, 480, 115);
            addObject(s2, 480, 410);        
            addObject(s3, 690, 260);
            addObject(s4, 275, 260);
            s1.setRotation(90);
            s2.setRotation(-90);
            s3.setRotation(180);

            addObject(new CrabLeg(), 345, 140);
            addObject(new CrabLeg(), 345, 390);
            addObject(new CrabLeg(), 620, 390);
            addObject(new CrabLeg(), 620, 140);
            addObject(new CrabLeg(), 845, 260);
            addObject(new CrabLeg(), 128, 260);

            addObject(new Heisman(), 480, 260);
            addObject(new Trophy(), 770, 63);

            addObject(t1, 37, 58);//timer
            addObject(timeDigit0, 45, 58);
            addObject(timeDigit1, 34, 58);
            
            addObject(new SprintBar(), 40, 527);//the juice
            
            addObject(scoreObject, 37, 126);
            addObject(scoreDigit0, 56, 126);
            addObject(scoreDigit1, 45, 126);
            addObject(scoreDigit2, 34, 126);
            addObject(scoreDigit3, 23, 126);
        }
        else if(levelCount == 3) {
            Wameis.setStuffCollected(initialScoreValues);
            addObject(Wameis, 490, 540);

            addObject(w1, 140, 60);
            addObject(w2, 140, 450);
            addObject(w3, 820, 60);
            addObject(w4, 820, 450);

            addObject(s1, 286, 115);
            addObject(s2, 289, 398);        
            addObject(s3, 145, 255);
            addObject(s4, 815, 255);
            addObject(s5, 675, 114);
            addObject(s6, 675, 398);            

            s1.setRotation(90);
            s2.setRotation(-90);
            s3.setRotation(180);
            s4.setRotation(-180);
            s5.setRotation(90);
            s6.setRotation(-90);

            addObject(new CrabLeg(), 140, 130);
            addObject(new CrabLeg(), 140, 390);
            addObject(new CrabLeg(), 820, 390);
            addObject(new CrabLeg(), 820, 140);
            addObject(new CrabLeg(), 680, 260);
            addObject(new CrabLeg(), 290, 260);

            addObject(new Heisman(), 490, 420);
            addObject(new Heisman(), 490, 95);
            addObject(new Trophy(), 770, 60);

            addObject(t1, 37, 58);//timer
            addObject(timeDigit0, 45, 58);
            addObject(timeDigit1, 34, 58);
            
            addObject(new SprintBar(), 40, 527);//the juice
            
            addObject(scoreObject, 37, 126);
            addObject(scoreObject, 37, 126);
            addObject(scoreDigit0, 56, 126);
            addObject(scoreDigit1, 45, 126);
            addObject(scoreDigit2, 34, 126);
            addObject(scoreDigit3, 23, 126);
        }

    }

    public static int getLivesLeft() {
        return livesLeft;
    }

    public static int getHighScore() {
        return highScore;   
    }

    public Worker getw1() {
        return w1;
    }

    public void newJameis (Jameis j) {

        addObject(j, 420, 320);;

    }

    public Worker getw2() {
        return w2;
    }

    public Worker getw3() {

        return w3;
    }

    public Jameis getJameis() {

        return Wameis;
    }

    public static int getLevelCount() {
        return levelCount;
    }

    public static void setLevelCount(int levelIn){
        levelCount = levelIn;
    }

    private void gameOver() {

        if ( getObjects(Life.class).size() == 0){
            counter ++;
            stopMusic();
            if (counter == 30){//after some time the level goes black and spawns a RIPjameis and the game over text.
                setBackground("backdrop.png");
                removeObjects(getObjects(Shelf.class));
                removeObjects(getObjects(Tokens.class));
                removeObjects(getObjects(Worker.class));
                removeObjects(getObjects(SprintBar.class));
                removeObjects(getObjects(Timer.class));
                removeObjects(getObjects(JinstonJuiceBottle.class));
                removeObjects(getObjects(ExitText.class));
                removeObjects(getObjects(Score.class));
                removeObjects(getObjects(ScoreDisplay.class));
                removeObjects(getObjects(TimerDisplay.class));
                initialScoreValues = new int[]{0,0,0,0};
                int deadX = Wameis.getX();
                int deadY = Wameis.getY();
                removeObjects(getObjects(Jameis.class));
                RIPJameis rip = new RIPJameis();
                addObject(rip, deadX, deadY);
                addObject(new GameOverText(), 440, 280);

                //PUT GAME OVER SCREEN HERE

            }
            if (counter == 500){//change that number to increase length of gameover screen
                Wameis.stopSadMusic();
                Greenfoot.setWorld(new StartScreen());
            }
        }
        else if ( getObjects(CrabLeg.class).size() == 0){
            if( getObjects(ExitText.class).size() == 0){
                addObject(new ExitText(), 440, 50);
            }
            else {}
            if (getObjectsAt( 440, 0, Jameis.class).size() == 1){
                livesLeft = Wameis.getLives();
                Wameis.timeBonus = t1.getTime();
                initialScoreValues = Wameis.getStuffCollected();
                removeObjects(getObjects(Jameis.class));
                stopMusic();
                levelCount++;
                levelChange.play();
                if(scoreObject.getScore() > highScore)highScore = scoreObject.getScore();
                if(levelCount == 4){
                    livesLeft = 3;
                    Greenfoot.setWorld(new VictoryScreen(scoreObject.getScore()));
                }
                else{
                    Greenfoot.setWorld(new Publix(levelCount));
                }
                //NEXT LEVEL CODE
            }
        }

    }
}