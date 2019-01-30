import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.ImageIcon;
public class Platform extends GameObject{
    private boolean visible = true;
    private static Color color = new Color(150,170,15, 100);
    private static boolean isOscelating = false;
    private static boolean right = true;
    private int dir = 0;
    private String tag;
    private String source;
    public Platform(JPanel jp, int x_,  int y_, int w_, int h_){
        this(jp,x_,y_,w_,h_, color, false, "");
    }
    
    public Platform(JPanel jp, int x_,  int y_, int w_, int h_, Color c, boolean o, String t){
        super(jp,x_,y_,w_,h_);
        color = c;
        BoxCollider bc = new BoxCollider(this,0,0,w_,h_);
        bc.setVisible(true);
        getColliders().add(bc);
        isOscelating = o;
        this.tag = t;
    }
    
    public void setOscelate(boolean v){
        isOscelating = v;
    }
    
    public boolean willOscelate(){
        return isOscelating;
    }
    
    public String getTag(){
        return this.tag;
    }
    
    public void oscelate(int minx, int maxx, PlayerCharacter p){
        isOscelating = true;
        if(right && getX() <= maxx){
            moveRight(1);
            dir = 1;
            for(Collider c : p.getColliders()){
                if(c.hit(this)){
                    p.setX(p.getX() + 1);
                    
                }
            }
            if(getX() >= maxx){
                moveLeft(1);
                right = false;
            }
        } else if(!right && getX() >= minx){
            moveLeft(1);
            dir = -1;
            for(Collider c : p.getColliders()){
                if(c.hit(this)){
                    p.setX(p.getX() - 1);
                }
            }
            if(getX() <= minx){
                moveRight(1);
                right = true;
            }
        }
    }
    public int getSpeed(){
        return dir;
    }
    public void moveRight(int amt){
        setX(getX() + amt);
    }
    public void setSource(String src){
        this.source = src;
    }
    
    public void moveLeft(int amt){
        setX(getX() - amt);
    }
    
    public void draw(Graphics g){
        if(isVisible()){
            ImageIcon imgPC = new ImageIcon(this.source);
            imgPC.paintIcon(getPanel() , g, getX(), getY());
        }
        for(Collider c: getColliders()){
            //c.draw(g);
        }
    }
    public String toString(){
        String str = "Platform(X: " + getX() + ", Y: " + getY() + ", Width: " + getWidth() + ", Height: " + getHeight()+")";
        return str;
    }
}