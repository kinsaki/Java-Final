import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Zombie2 here.
 * 
 * @author (Devon Lucey) 
 * @version (v1.9)
 */
public class Zombie2 extends SelfDefense
{
    //Initialize zombie health and speed.
    public int health;
    private int speed;
    private int damage = 15;
    

    
    public Zombie2()
    {
        //Set zombie health
        health = 50;
    }
    
    public void act() 
    {
        /**  Slowly move to the edge of the world. 
         *   If edge is reached remove 1 point and zombie.
         */
        
        move(1);
        
        Player2 player2 = new Player2();
        myWorld2 world = (myWorld2)getWorld();
        
        
        checkForDeath();
    }
    
    //Checks if Zombie2 has died or reached the edge.
    public void checkForDeath()
    {
        Bullet2 bullet2 = new Bullet2(getVelocity(), getRotation());
        myWorld2 world = (myWorld2)getWorld();
        Zombie2 zombie = new Zombie2();
        
        if (isTouching(Bullet2.class))
        {
            health -= bullet2.damage;
            
            if(health < 0)
            {
                world.score(2);
                world.removeObject(this);
            }          
        }
        else if (getX() == 900) 
        {
            world.score(-1);
            world.removeObject(this);
        }        
    }
    
}
