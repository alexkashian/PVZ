public class Sunflower extends Sprite{
    public Sunflower(int r, int c, int direction) {
        super(c*110, r*125, direction);
        setPic("sun.png", EAST);
        setSpeed(0); //GUESS?!
    }

    @Override
    public void update() {
        super.update();

    }
}
