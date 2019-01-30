import java.awt.Graphics;
import javax.swing.JPanel;
import java.util.ArrayList;
public abstract class Rigidbody extends GameObject
{
    private static int GRAVITY = 1;
    private static int MOVESPEED = 1;
    private static final int MAX_FALL_SPEED = 20;
    private int fallSpeed, moveSpeed;
    protected int speed = 0;
    private boolean inAir = true;
    public Rigidbody(JPanel jpanel, int x, int y,int w, int h){
        super(jpanel, x, y, w, h);
        fallSpeed = 0;
    }
    
    public abstract void draw(Graphics g);
    public int getGravity(){
        return GRAVITY;
    }
    public void fall(ArrayList<GameObject> gameObjects){
        
        int movement = 0;       //magnitude of movement progress
        int unit = 1;          //direction of movement - up, + down
        if(getFallSpeed() < 0) unit = -1;
        
        if(getFallSpeed() > GRAVITY) inAir = true;
        
        while(movement < Math.abs(getFallSpeed())){
            movement++;
            setY(getY() + unit);
            
            for(GameObject go: gameObjects){
                if( go instanceof Platform && hit(go)){
                    
                    setY(getY() - unit);
                    if(getFallSpeed() > 0){
                        inAir = false;
                    }
                    setFallSpeed(0);
                    return;
                }
            }
        }
        applyGravity();
    }
    public void move(ArrayList<GameObject> gameObjects){
        int movement = 0;       //magnitude of movement progress
        int unit = 1;          //direction of movement - left, + right
        if(speed < 0) unit = -1;
        
        while(movement < Math.abs(speed)){
            movement++;
            setX(getX() + unit);
            
            for(GameObject go: gameObjects){
                if( go instanceof Platform && hit(go)){
                    setX(getX() - unit);
                    speed = 0;
                    return;
                }
            }
        }
    }
    public void applyGravity(){
        setFallSpeed(fallSpeed + GRAVITY);
    }
    public void setFallSpeed(int amt){
        if(amt > MAX_FALL_SPEED){
            fallSpeed = MAX_FALL_SPEED;
        } else {
            fallSpeed = amt;
        }
    }
    public void setInAir(boolean v){
        inAir = v;
    }
    public boolean isInAir(){
        return inAir;
    }
    public int getFallSpeed(){
        return this.fallSpeed;
    }
    public int getMoveSpeed(){
        return this.moveSpeed;
    }
    public void setMoveSpeed(int s){
        this.speed = s;
    }
}