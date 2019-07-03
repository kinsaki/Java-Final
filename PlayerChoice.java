import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerChoice here.
 * 
 * @author (Devon Lucey) 
 * @version (v1.9)
 */
public class PlayerChoice extends World
{
    //public static String choice;

    /**
     * Constructor for objects of class PlayerChoice.
     * 
     */
    public PlayerChoice()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        showText("Select your player.", 300, 150);
        Player1();
        Player2();
        addObject(new Pointer(), 300, 200);
        
        
    }
    
    public void Player1()
    {
        addObject(new SelectPlayer1(), 150, 250);
    }
    
    public void Player2()
    {
        addObject(new SelectPlayer2(), 450, 250);  
    }
}
