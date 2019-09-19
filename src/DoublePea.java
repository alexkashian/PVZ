public class DoublePea extends Sprite{

    public DoublePea(int r, int c, int direction) {
        super((c*110)+15, (r*125)+20, direction,5);
        setPic("doublep.png", EAST);
        setSpeed(0); //GUESS?!
        setType("reg");
//force commit

    }

    @Override
    public void update() {
        super.update();

    }

    public String type() {
        return "reg";
    }

}
