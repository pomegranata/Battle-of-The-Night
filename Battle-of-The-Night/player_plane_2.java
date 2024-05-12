import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class player_plane_2 extends player_plane
{
    private boolean canShoot;
    
    @Override
     void shoot(){
        boolean canShoot = true;
        if (Greenfoot.isKeyDown("space") && canShoot && ammo > 0){
            ammo--;
            laser laser = new laser();
            laser.setRotation(getRotation());
            getWorld().addObject(new laser(), getX(), getY());
            Greenfoot.delay(1);
            
            MyWorld.setAmmo(MyWorld.getAmmo());
            if (ammo == 0){
                canShoot = false;
            }
        }
    }
    
    void position(){
        setLocation(getX() + 20, getY() -20);
    }

}
