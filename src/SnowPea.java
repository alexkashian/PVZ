public class SnowPea extends Sprite {

    public SnowPea(int r, int c, int direction) {
        super((c*110)+15, (r*125)+20, direction);
        setPic("snowpea.png", EAST);
        setSpeed(0); //GUESS?!

    }

    @Override
    public void update() {
        super.update();

    }
}