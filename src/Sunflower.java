public class Sunflower extends Sprite{
    public Sunflower(int r, int c, int direction) {
        super((c*110)+15, (r*125)+20, direction,5);
        setPic("sunflower.png", EAST);
        setSpeed(0); //GUESS?!
    }
    //force commit
    @Override
    public void update() {
        super.update();

    }

}
