public class DoublePea extends Sprite{

    public DoublePea(int r, int c, int direction) {
        super((c*110)+15, (r*125)+20, direction);
        setPic("doublep.png", EAST);
        setSpeed(0); //GUESS?!
//force commit

    }

    @Override
    public void update() {
        super.update();

    }
}
