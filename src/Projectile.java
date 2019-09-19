public class Projectile extends Sprite{

    public Projectile(String type, int x, int y) {
        super(x+10, y+10, EAST,0);

        if (type=="snow"){
            setPic("snowProj.png",EAST);

        }

        else if (type=="reg"){
            setPic("regProj.png",EAST);

        }
    }

    @Override
    public void update() {
        setSpeed(10);
        super.update();
    }


}
