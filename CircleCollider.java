import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
public class CircleCollider extends Collider
{
    private int radius;
    public CircleCollider(GameObject parent, int x_, int y_, int r){
        super(parent,x_,y_);
        radius = r;
    }    
    
    public boolean hit(Collider c){
        if(c instanceof BoxCollider){
                return hit((BoxCollider)c);
            } else {
                return hit((CircleCollider)c);
            }
    }
    public boolean hit(GameObject g){
        ArrayList<Collider> c = g.getColliders();
        for(Collider co : c){
            if(hit(co)){return true;};
        }
        return false;
    }
    public boolean hit(CircleCollider c){
        int X1 = this.getX() + (radius);
        int Y1 = this.getY() + (radius);
        int X2 = c.getX() + (((CircleCollider)c).getRadius());
        int Y2 = c.getY() + (((CircleCollider)c).getRadius());
        
        int dBX = X2 - X1;
        int dBY = Y2 - Y1;
        double dist = Math.hypot(dBX, dBY);
        return dist <= (radius + c.getRadius());
                
    }
    
    public boolean hit(BoxCollider b){
        //making a box collider that runs a line through the middle of circle horizontally
        b = (BoxCollider)b;
        BoxCollider horizontCircle = new BoxCollider(getGameObject(),0,getGameObject().getWidth()/2, (getRadius()*2),1);
        BoxCollider vertCircle = new BoxCollider(getGameObject(),getGameObject().getHeight()/2,0, 1,(getRadius()*2));
        
        if(horizontCircle.hit(b) || vertCircle.hit(b)){
            return true;
        }
        
        //code to check if dist between 4 points of circle are less than radius of circle
        int ccR = getRadius();
        int ccX = getX() + ccR;
        int ccY = getY() + ccR;
        int tlX = b.getX();
        int tlY = b.getY();
        int blX = tlX;
        int blY = tlY + b.getHeight();
        int trX = tlX + b.getWidth();
        int trY = tlY;
        int brX = blX + b.getWidth();
        int brY = blY;
        //System.out.println(ccR+" ; "+ccX+" ; "+ccY+" ; "+tlX+" ; "+tlY+" ; "+blX+" ; "+blY+" ; "+trX+" ; "+trY+" ; "+brX+" ; "+brY);
        
        int dBX1 = Math.abs(ccX - tlX);
        int dBY1 = Math.abs(ccY - tlY);
        double dist1 = Math.hypot(dBX1, dBY1);
        if(dist1 <= ccR){
            //System.out.println("1");
            return true;
        }
        
        int dBX2 = Math.abs(ccX - blX);
        int dBY2 = Math.abs(ccY - blY);
        double dist2 = Math.hypot(dBX2, dBY2);
        if(dist2 <= ccR){
            //System.out.println("2");
            return true;
        }
        
        int dBX3 = Math.abs(ccX - trX);
        int dBY3 = Math.abs(trY - ccY);
        double dist3 = Math.hypot(dBX3, dBY3);
        if(dist3 <= ccR){
            //System.out.println("3");
            return true;
        }
        
        int dBX4 = Math.abs(ccX - brX);
        int dBY4 = Math.abs(ccY - brY);
        double dist4 = Math.hypot(dBX4, dBY4);
        if(dist4 <= ccR){
            //System.out.println("4" + Math.random()*10);
            return true;
        }
        
        return false;
    }
    
    public int getRadius(){
        return this.radius;
    }
    public void draw(Graphics g){
        if(isVisible()){
            g.setColor(new Color(100,100,100,100));
            g.fillOval(getX(),getY(), this.radius*2, this.radius*2);
            //g.fillRect(getX() - radius,getY()-radius, this.radius*2, this.radius*2);
        }
    }
}