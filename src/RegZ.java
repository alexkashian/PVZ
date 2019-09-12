import javax.swing.*;
import java.net.URL;
import java.util.WeakHashMap;

public class RegZ extends Sprite {
//force commit
//    private int level;

    public RegZ(int x) {
        super(1200, 120+(x*125), WEST);
        setPic("regZ.png",WEST);

    }

    @Override
    public void update() {
        setSpeed(1);
        super.update();
    }




}
