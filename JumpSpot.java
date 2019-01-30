import java.awt.Graphics;
import java.awt.Color;
public class JumpSpot extends GameObject
{
    public JumpSpot(GameObject parent, int x_, int y_, int w_, int h_)
    {
        super(parent.getPanel(),x_,y_, w_, h_);
        getColliders().add(new BoxCollider(this,0,0,w_,h_));
    }
    public void draw(Graphics g){
        g.setColor(new Color(100,100,100,100));
        g.fillRect(getX(), getY(), getWidth(), getHeight());
    }
    public String toString(){
        String str = "JumpSpot(X: " + getX() + ", Y: " + getY() + ", Width: " + getWidth() + ", Height: " + getHeight()+")";
        return str;
    }
}