public class RegZ extends Sprite {

//    private int level;

    public RegZ() {
        super(100, 100, EAST);
        setPic("regZ.png", WEST);
    }

    @Override
    public void update() {
        setSpeed(3);
    }

}
