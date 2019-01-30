import java.awt.Graphics;
import javax.swing.JPanel;
import java.util.ArrayList;
public abstract class GameObject extends ScreenObject{

    private int width, height;
    private ArrayList<Collider> colliders = new ArrayList<Collider>();
    
    
    public GameObject(JPanel jp, int x, int y, int w, int h) {
        super(jp, x, y);
        width = w;
        height = h;
    }
    public ArrayList<Collider> getColliders(){
        return this.colliders;
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public abstract void draw(Graphics g);
    public boolean hit(GameObject g){
        for(Collider co : colliders){
            if(co.hit(g)){return true;};
        }
        return false;
    }
    
}