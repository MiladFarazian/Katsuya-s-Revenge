import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.util.ArrayList;

public class Collectable extends GameObject
{
    private CircleCollider c;
    private String src;
    public Collectable(JPanel jp, String s, int x, int y, int w, int h){
        super(jp, x, y, w, h);
        this.src = s;
        c = new CircleCollider(this,0,0,w/2);
        getColliders().add(c);
    }
    @Override
    public void draw(Graphics g) {
        if(isVisible()){
            ImageIcon imgPC = new ImageIcon(src);
            imgPC.paintIcon(getPanel() , g, getX(), getY());
        }
        for(Collider c: getColliders()){
            //c.draw(g);
        }
    }
    public String toString(){
        String str = "Collectable(X: " + getX() + ", Y: " + getY() + ", Width: " + getWidth() + ", Height: " + getHeight()+")";
        return str;
    }
}