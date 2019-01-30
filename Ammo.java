import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.util.ArrayList;

public class Ammo extends Collectable
{
    public Ammo(JPanel jp, int x, int y){
        super(jp,"images/throwingKnifeAmmo.png",x,y,50,50);
    }
}