import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class enemy_plane extends Actor
{
    /**
     * Act - do whatever the enemy_plane wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        setLocation(getX(),getY()+5);

        hit();
    }
    
    void hit(){
        if (isTouching(bullet.class)){
            getWorld().removeObject(this);
            MyWorld.setScore(MyWorld.getScore()+10);
        }else if (isAtEdge()){
            getWorld().removeObject(this);
            MyWorld.setHealth(MyWorld.getHealth()-1);
        }
    }
}
