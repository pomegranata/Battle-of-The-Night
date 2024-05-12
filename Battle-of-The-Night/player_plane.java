import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class player_plane extends Actor
{
    int ammo = 10;
    private boolean canShoot;
    private Crack ledakan;
    private boolean hasCrack = false;

    public void act()
    {
        up();
        left();
        down();
        right();
        shoot();
        reload();
        damage();
        if (hasCrack) {
            ledakan.setLocation(getX(), getY());
        }
    }
    void up(){
        if (Greenfoot.isKeyDown("w")){
            setLocation(getX(),getY()-5);
        }
    }

    void left(){
        if (Greenfoot.isKeyDown("a")){
            setLocation(getX()-5,getY());
        }
    }

    void down(){
        if (Greenfoot.isKeyDown("s")){
            setLocation(getX(),getY()+5);
        }
    }

    void right(){
        if (Greenfoot.isKeyDown("d")){
            setLocation(getX()+5,getY());
        }
    }
    
    void shoot(){
        if (Greenfoot.isKeyDown("space") && canShoot && ammo > 0){
            ammo--;
            bullet bullet = new bullet();
            bullet.setRotation(getRotation());
            getWorld().addObject(new bullet(), getX(), getY()-40);
            Greenfoot.delay(3);
            Greenfoot.playSound("laser.wav");
            
            MyWorld.setAmmo(MyWorld.getAmmo()-1);
            if (ammo == 0){
                canShoot = false;
            }
        }
    }
    
    void reload(){
        if (Greenfoot.isKeyDown("r")){
            MyWorld.ammo = 10;
            ammo = 10;
            canShoot = true;
            
            MyWorld.setAmmo(MyWorld.getAmmo());
        }
    }
    
    public void damage() {
        if (isTouching(enemy_plane.class)) {
            if (!hasCrack) {
                ledakan = new Crack();
                getWorld().addObject(ledakan, getX(), getY());
                hasCrack = true;
            }

            MyWorld.setHealth(MyWorld.getHealth() - 1);
        }
    }
    
    public class Crack extends Actor {
        public Crack() {
            GreenfootImage image = new GreenfootImage("ledakan.png");
            setImage(image);
        }
    }
}
