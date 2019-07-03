import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pointer here.
 * 
 * @author (Devon Lucey) 
 * @version (v1.9)
 */
public class Pointer extends SelfDefense
{
    /**
     * Act - do whatever the Pointer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        movement();
        playerPicker();
    }    
    
    private void movement() 
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
    }
    
    public void playerPicker()
    {
        if (isTouching(SelectPlayer1.class))
        {
            Greenfoot.setWorld(new myWorld());
        }
        else if (isTouching(SelectPlayer2.class))
        {
            Greenfoot.setWorld(new myWorld2());
        }
        
    }
}
