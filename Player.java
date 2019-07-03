import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (Devon Lucey) 
 * @version (v1.7)
 */
public class Player extends SelfDefense
{
    //reload time for player's gun
    private static final int gunReloadTime = 20;

    private int reloadDelayCount;
    
    public Player()
    {
        reloadDelayCount = 20;
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
            setLocation(getX(), getY()-4);
        }
        if (Greenfoot.isKeyDown("down")) 
        {
            setLocation(getX(), getY()+4);
        }
        if (Greenfoot.isKeyDown("left")) 
        {
            setLocation(getX()-4, getY());
        }
        if (Greenfoot.isKeyDown("right")) 
        {
            setLocation(getX()+4, getY());
        }
        if (Greenfoot.isKeyDown("space"))
        {
            fire();
        }
        
    }
    
    //Check if player and zombie are touching. If so end game.
    private void checkForDeath()
    {
        if(isTouching(Zombie.class))
        {
            removeTouching(Zombie.class);
            myWorld world = (myWorld)getWorld();
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
            //Greenfoot.playSound("bullet-sound.wav");;
        }
        
        if (reloadDelayCount >= gunReloadTime) 
        {
            Bullet bullet = new Bullet (getVelocity(), getRotation());
            getWorld().addObject (bullet, getX(), getY());
            bullet.move ();
            reloadDelayCount = 0;

        }
    }
}
