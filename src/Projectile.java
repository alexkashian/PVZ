public class Projectile extends Sprite{

    private String type;

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    public Projectile(String type, int x, int y) {
        super(x+10, y+10, EAST,0);
        this.type = type;

        if (type=="snow"){
            setPic("snowProj.png",EAST);

        }

        else if (type=="reg"){
            setPic("regProj.png",EAST);

        }

    }

    @Override
    public void update() {
        setSpeed(20);
        super.update();
    }


}
