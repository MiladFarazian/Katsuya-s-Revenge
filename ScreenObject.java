import java.awt.Graphics;
import javax.swing.JPanel;

public abstract class ScreenObject
{
    private boolean visible;
    private JPanel jp;
    private int x,y;
    private int hspeed, vspeed;
    public ScreenObject(JPanel panel, int x_, int y_)
    {
        this(panel, x_, y_, true);
    }
    public ScreenObject(JPanel panel, int x_, int y_, boolean v)
    {
        this.x = x_;
        this.y = y_;
        jp = panel;
        visible = v;
    }
    public void setPosition(int x_, int y_){
        setX(x_);
        setY(y_);
    }
    public JPanel getPanel(){
        return jp;
    }
    public void setVisible(boolean foo){
        visible = foo;
    }
    public boolean isVisible(){
        return visible;
    }
    public void setX(int amt) {
        //this.x = getX() + amt;
        this.x = amt;
    }
    
    public void setY(int amt) {
        //this.y = getY() + amt;
        this.y = amt;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public abstract void draw(Graphics g);
}