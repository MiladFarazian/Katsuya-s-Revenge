import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;

import java.awt.geom.Point2D;
public class BoxCollider extends Collider
{
    private int w, h;
    
    public BoxCollider(GameObject parent, int x_, int y_, int w_, int h_){
        super(parent,x_,y_);
        this.w = w_;
        this.h = h_;
    }    
    public boolean hit(BoxCollider b){
        int ax1 = getX();
        int ay1 = getY();
        int ax2 = ax1 + w;
        int ay2 = ay1 + h;
        
        int bx1 = b.getX();
        int by1 = b.getY();
        int bx2 = bx1 + b.getWidth();
        int by2 = by1 + b.getHeight();
        
        boolean hlap = true;
        if(ax2 < bx1) hlap = false;
        if(ax1 > bx2) hlap = false;
        
        boolean vlap = true;
        if(ay2 < by1) vlap = false;
        if(ay1 > by2) vlap = false;
        
        return hlap && vlap;
    }
    public boolean hit(CircleCollider c){
        //making a box collider that runs a line through the middle of circle horizontally
        c = (CircleCollider)c;
        BoxCollider horizontCircle = new BoxCollider(c.getGameObject(),0,c.getGameObject().getWidth()/2, (c).getRadius()*2,1);
        BoxCollider vertCircle = new BoxCollider(c.getGameObject(),c.getGameObject().getHeight()/2,0, 1,((c).getRadius()*2));
        
        //if(hit(horizontCircle) || hit(vertCircle)){return true;}
        
        int ccR = c.getRadius();
        int ccX = getX() + ccR;
        int ccY = getY() + ccR;
        int tlX = getX();
        int tlY = getY();
        int blX = tlX;
        int blY = tlY + getHeight();
        int trX = tlX + getWidth();
        int trY = tlY;
        int brX = blX + getWidth();
        int brY = blY;
        
        int dBX1 = ccX - tlX;
        int dBY1 = ccY - tlY;
        double dist1 = Math.hypot(dBX1, dBY1);
        if(dist1 <= ccR){return true;}
        
        int dBX2 = Math.abs(ccX - blX);
        int dBY2 = Math.abs(ccY - blY);
        double dist2 = Math.hypot(dBX2, dBY2);
        if(dist2 <= ccR){return true;}
        
        int dBX3 = Math.abs(ccX - trX);
        int dBY3 = Math.abs(trY - ccY);
        double dist3 = Math.hypot(dBX3, dBY3);
        if(dist3 <= ccR){return true;}
        
        int dBX4 = ccX - brX;
        int dBY4 = ccY - brY;
        double dist4 = Math.hypot(dBX4, dBY4);
        if(dist4 <= ccR){return true;}
        
        return false;
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
    public int getWidth() {
        return this.w;
    }
    
    public int getHeight() {
        return this.h;
    }
    
    public void draw(Graphics g){
        //if(isVisible()){
            g.setColor(new Color(100,100,100,100));
            g.fillRect(getX(), getY(), w, h);
        //}
    }
}