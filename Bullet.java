import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (Devon Lucey) 
 * @version (v1.7)
 */
public class Bullet extends SelfDefense
{
    //Damage the bullet deals
    public int damage = 15;
    
    //Life of bullet. After life is 0 bullet is gone.
    private int life = 35;
    
    
    myWorld world = (myWorld)getWorld();
    
    public Bullet(Vector speed, int rotation)
    {
        super(speed);
        setRotation(rotation);
        addToVelocity(new Vector(rotation, 15));
        //Greenfoot.playSound("bullet-sound.wav");
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
        Zombie zombie = new Zombie();
        Player player = new Player();
        
        if (player.getWorld() != null && isTouching(Zombie.class)) 
        {
            getWorld().removeObject(this);
            zombie.checkForDeath();
        }
    }
}