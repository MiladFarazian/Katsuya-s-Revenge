import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

public abstract class Collider extends ScreenObject
{
    private GameObject go;
    private boolean visible;
    private static final Color color = new Color(100,100,100,100);
    private int x, y;
    
    public Collider(GameObject gameObject, int x_, int y_){
        super(gameObject.getPanel(),x_,y_);
        go = gameObject;
    }
    public Color getColor(){
        return this.color;
    }
    public int getY(){
        return getGameObject().getY() + getLocalY();
    }
    public int getX(){
        return getGameObject().getX() + getLocalX();
    }
    public int getLocalX(){
        return super.getX();
    }
    public int getLocalY(){
        return super.getY();
    }
    public abstract boolean hit(GameObject go);
    public abstract boolean hit(Collider obj);
    public abstract boolean hit(CircleCollider obj);
    public abstract boolean hit(BoxCollider obj);
    public GameObject getGameObject(){
        return go;
    }
}