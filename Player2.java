import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player2 here.
 * 
 * @author (Devon Lucey) 
 * @version (v1.9)
 */
public class Player2 extends SelfDefense
{
    //reload time for player's gun
    private static final int gunReloadTime = 40;

    private int reloadDelayCount;
    
    public Player2()
    {
        reloadDelayCount = 30;
    }
    /**
     * Call player movement, player death, and counts up for reload.
     */
    public void act() 
    {
        playerMovement();
        checkForDeath();
        reloadDelayCount++;
    }   
    
    //Allows the player to move in 2 space and fire gun.
    private void playerMovement()
    {
        if (Greenfoot.isKeyDown("up")) 
        {
            setLocation(getX(), getY()-2);
        }
        if (Greenfoot.isKeyDown("down")) 
        {
            setLocation(getX(), getY()+2);
        }
        if (Greenfoot.isKeyDown("left")) 
        {
            setLocation(getX()-2, getY());
        }
        if (Greenfoot.isKeyDown("right")) 
        {
            setLocation(getX()+2, getY());
        }
        if (Greenfoot.isKeyDown("space"))
        {
            fire();
        }
        
    }
    
    //Check if player and zombie are touching. If so end game.
    private void checkForDeath()
    {
        if(isTouching(Zombie2.class))
        {
            removeTouching(Zombie2.class);
            myWorld2 world = (myWorld2)getWorld();
            world.gameOver();
            Greenfoot.stop();
        }   
    }
    
    //Fire the gun
    private void fire() 
    {
        String key = Greenfoot.getKey();
        if (key != null && key.equals("space"))
        {
            Greenfoot.playSound("energy-gun.wav");;
        }
        
        if (reloadDelayCount >= gunReloadTime) 
        {
            Bullet2 bullet2 = new Bullet2 (getVelocity(), getRotation());
            getWorld().addObject (bullet2, getX(), getY());
            bullet2.move ();
            reloadDelayCount = 0;
        }
    }
}
