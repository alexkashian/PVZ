import javax.swing.*;
import java.net.URL;
import java.util.WeakHashMap;

public class RegZ extends Sprite {
//force commit
//    private int level;
    private int attackTimer = 0;

    public RegZ(int x) {
        super(1200, 120+(x*125), WEST,5);
        setPic("regZ.png",WEST);
        setSpeed(1.5);

    }

    public int getAttackTimer() {
        return attackTimer;
    }

    public void setAttackTimer(int attackTimer) {
        this.attackTimer = attackTimer;
    }

    public void increaseTimer(){
        attackTimer ++;

    }





}
