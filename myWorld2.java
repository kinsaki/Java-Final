import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class myWorld2 here.
 * 
 * @author (Devon Lucey) 
 * @version (v1.9)
 */
public class myWorld2 extends World
{
    //Set the time of the battle and score to 0
    private int time = 3000;
    public int score = 0;
    
    //Set a local player call
    PlayerChoice choice = new PlayerChoice();
    //Player player = new Player();
    Player2 player2 = new Player2();
    
    
    public myWorld2()
    {    
        //World size, spawn some zombies, player, and score board.
        super(1000, 528, 1); 
        
        
        spawnPlayer2();
        addZombies(3);
        scoreDisplay();
        timeDisplay();

        
    }
    
    public void act()
    {
               
        //Calls time and if the time is divisible by 100 spawn 2 zombies.
        time();
        score(0);
        if(time % 100 == 0)
        {
            addZombies(2);
        }
    }
    
    private void addZombies(int count) 
    { 
        //Spawn zombies in the left 10% of the map.
        for(int i = 0; i < count; i++) 
        {
            int x = Greenfoot.getRandomNumber(getWidth()/10);
            int y = Greenfoot.getRandomNumber(getHeight());
            addObject(new Zombie2(), x, y);
        }
        
    }
    
    private void time()
    {
        //Counts down until 0 and then stops the program with victory.
        time--;
        timeDisplay();
        if (time == 0)
        {
            victory();
            Greenfoot.stop();
        }
    }
    
    //Shows time
    private void timeDisplay()
    {
        showText("Time: " + time, 700, 45);
    }
    
    public int score(int points)
    {
        //Shows score. If score hits 0 then plays game over.
        
        score += points;
        
        if(score < 0)
        {
            gameOver();
            Greenfoot.stop();
        }
        scoreDisplay();

        return score;
    }
    
    private void scoreDisplay()
    {
        //Display score.
        showText("Score: " + score, 900, 45);
    }
    
    private void spawnPlayer2()
    {
            addObject(new Player2(), 850, 250);    
    }
    
    private void victory()
    {
        //If time is 0 player wins.
        showText("You survived! Congratulations!", 500, 300);
        showText("Your Score is: " + score, 500, 320);
    }
    
    public void gameOver()
    {
        //If player is touched or score is less than 0 player loses.
        showText("You let the zombies swarm you! You have died.", 500, 300);
        showText("Your Score is: " + score, 500, 320);
    }
    
    
    
}
