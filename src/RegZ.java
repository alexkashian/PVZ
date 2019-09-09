import javax.swing.*;
import java.net.URL;
import java.util.WeakHashMap;

public class RegZ extends Sprite {

//    private int level;

    public RegZ(int x) {
        super(1200, 100, WEST);
        setPic("regZ.png",WEST);

    }

    @Override
    public void update() {
        setSpeed(1);
        super.update();
    }




}
