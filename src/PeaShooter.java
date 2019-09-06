public class PeaShooter extends Sprite{
    public PeaShooter(int r, int c, int direction) {
        super(c*110, r*125, direction);
        setPic("P.png", WEST);
        setSpeed(0); //GUESS?!
    }

    @Override
    public void update() {
        super.update();

    }
}
