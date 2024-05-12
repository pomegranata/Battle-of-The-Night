import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class bullet extends Actor
{   
    private boolean kill;
    
    public void bullet(){
        if (Greenfoot.isKeyDown("space")){
            setLocation(getX(), getY());
            Greenfoot.playSound("laser.wav");
        }
    }
    public void act()
    {
        Stuff();
        setRotation(90);
        move(-15);
        
        if (isTouching(enemy_plane.class)){
            getWorld().removeObject(this);
        } else if (isAtEdge()){
            getWorld().removeObject(this);
        }
    }
    public void Stuff()
    {
        kill = true;
        if(kill)
            if (isTouching(enemy_plane.class))
            {
                kill = true;
                removeTouching(enemy_plane.class);
                MyWorld world = (MyWorld)getWorld();
                Greenfoot.playSound("tembakan.mp3");
            }
    }
}
