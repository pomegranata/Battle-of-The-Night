import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author
 * Shinta Rachma Yulianti (F11.2022.00049)
 * Imelda Maretta Putri   (F11.2022.00053)
 * Mark Arvid Sutrisno    (F11.2022.00055)
 * 
 * @version 1.1
 */
public class MyWorld extends World
{
    int delay = 0;
    static int score = 0;
    static int health;
    static int ammo = 0;
    
    public MyWorld()
    {    
        super(525, 700, 1); 
        prepare();
    }
    
    static void setScore(int iScore){
           score = iScore;
       }
       
    static int getScore(){
           return score;
       }
       
    static void setHealth(int iHealth){
        health = iHealth;
    }
    
    static int getHealth(){
        return health;
    }
    
    static void setAmmo(int iAmmo){
        ammo = iAmmo;
    }
    
    static int getAmmo(){
        return ammo;
    }

    public void act(){
        wave();
        
        showText("Score : " + score, 77, 25);
        showText("Health : " + +health, 450, 25);
        showText("Ammo : " + ammo, 77, 500);
        
        if(getHealth()<0){
            gameover over = new gameover();
            Greenfoot.setWorld(over);
        }
    }
    
    private void prepare()
    {
        player_plane player_plane = new player_plane();
        addObject(player_plane,250,612);
        setScore(0);
        setHealth(100);
        
        if (score >= 0 && score < 100){
            setAmmo(10);    
        } else {
            setAmmo(20);
        }
    }
    
    private void wave(){
        if (delay == 0){
            if (score >= 0 && score < 100){
                int rand = Greenfoot.getRandomNumber(3);
                
                if (rand == 0){
                    enemy_plane enemy_plane = new enemy_plane();
                    addObject(enemy_plane,97,80);
                } else if (rand == 1){
                    enemy_plane enemy_plane2 = new enemy_plane();
                    addObject(enemy_plane2,264,81);
                } else {
                    enemy_plane enemy_plane3 = new enemy_plane();
                    addObject(enemy_plane3,433,82);
                }
            } else if (score >= 100 && score <200){
                if (score == 100){
                    player_plane_2 player_2 = new player_plane_2();
                    addObject(player_2,400,612);
                }
                
                for (int i = 0; i < 2; i++){
                    if (i == 0){
                        addObject(new enemy_plane(), 201,176);
                    } else if (i == 1){
                        addObject(new enemy_plane(), 344,176);
                    }
                }
            } else if (score >= 200 && score < 300){
                for (int i = 0; i < 3; i++){
                    if (i == 0){
                        addObject(new enemy_plane(), 97, 80);
                    } else if (i == 1){
                        addObject(new enemy_plane(), 264, 81);
                    } else {
                        addObject(new enemy_plane(), 433, 82);
                    }
                }
            } else if (score >= 300){
                win win = new win();
                Greenfoot.setWorld(win);
            }
            delay = 100;
        } else {
            delay--;
        }
    }
}
