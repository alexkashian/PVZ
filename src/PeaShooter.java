public class PeaShooter extends Sprite{

    private int r,c;

    public PeaShooter(int r, int c, int direction) {
        super(c*110, r*125, direction);
        setPic("P.png", EAST);
        setSpeed(0); //GUESS?!

        this.r = r;
        this.c = c;

    }

    @Override
    public void update() {
        super.update();

    }

    public int getR() {
        return r;
    }

    public int getC() {
        return c;
    }
}
