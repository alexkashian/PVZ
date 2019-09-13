public class Projectile extends Sprite{

    public Projectile(String type, int x, int y) {
        super(x+15, y+10, EAST);

        if (type=="snow"){
            setPic("snowProj.png",EAST);

        }

        else if (type=="reg"){
            setPic("regProj.png",EAST);

        }
    }

    @Override
    public void update() {
        setSpeed(4);
        super.update();
    }


}
