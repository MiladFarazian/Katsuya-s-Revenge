import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.util.ArrayList;

public class Health extends Collectable
{
    public Health(JPanel jp, int x, int y){
        super(jp,"images/health.png",x,y,50,50);
    }
}