import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Zombie here.
 * 
 * @author (Devon Lucey) 
 * @version (v1.8)
 */
public class Zombie extends SelfDefense
{
    //Initialize zombie health and speed.
    public int health;
    private int speed;
    private int damage = 15;
    

    
    public Zombie()
    {
        //Set zombie health
        health = 500;
    }
    
    public void act() 
    {
        /**  Slowly move to the edge of the world. 
         *   If edge is reached remove 1 point and zombie.
         */
        
        move(1);
        
        Player player1 = new Player();
        Player2 player2 = new Player2();
        myWorld world = (myWorld)getWorld();
        
        
        checkForDeath();
    }
    
    public void checkForDeath()
    {
        //Check for zombie death, if dead and removed, add 2 points.
        
        Bullet bullet = new Bullet(getVelocity(), getRotation());
        
        myWorld world = (myWorld)getWorld();
                
        if (isTouching(Bullet.class))
        {
            health -= bullet.damage;
            if(health < 0)
            {
                world.score(2);
                getWorld().removeObject(this);
            }
        }
        else if (getX() == 900)
        {
            world.score(-1);
            world.removeObject(this);
        }
        
        
    }
    
}
