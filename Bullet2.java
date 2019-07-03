import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet2 here.
 * 
 * @author (Devon Lucey) 
 * @version (v1.9)
 */
public class Bullet2 extends SelfDefense
{
    //Damage the bullet deals
    public int damage = 100;
    
    //Life of bullet. After life is 0 bullet is gone.
    private int life = 25;
    
    
    myWorld2 world = (myWorld2)getWorld();
    
    public Bullet2(Vector speed, int rotation)
    {
        super(speed);
        setRotation(rotation);
        addToVelocity(new Vector(rotation, 15));
        
    }
    
    //Slowly kills the bullet and checks if zombie is hit.
    public void act()
    {
        if(life <= 0) {
            getWorld().removeObject(this);
        } 
        else {
            life--;
            move();
            checkZombieHit();
        }
    }
    
    //Check whether we have hit a zombie.
    private void checkZombieHit()
    {
        Zombie2 zombie = new Zombie2();
        Player2 player = new Player2();
        
        if (player.getWorld() != null && isTouching(Zombie.class)) 
        {
            getWorld().removeObject(this);
            zombie.checkForDeath();
        }
    }
}