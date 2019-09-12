import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class Main extends JPanel{

    public static final int WIDTH=1000, HEIGHT=800;
    private Timer timer;
    private ArrayList<Sprite> zombies;
    private ArrayList <Sprite> plants;
    private int selectedPlant = 0;
    private int j,x,sunTimer, sunTot;
    private BufferedImage sun,peashoot,sunflower,snowpea,doublep;


    public Main(){
        //force commit
        plants = new ArrayList<Sprite>();

        //set sun image for sun counter
        try {
            sun = ImageIO.read(new File("./res/sun.png"));
        }catch (Exception e){
            e.printStackTrace();
        }
        //set peashooter image for 2
        try {
            peashoot = ImageIO.read(new File("./res/peashooter.png"));
        }catch (Exception e){
            e.printStackTrace();
        }
        //set sunflower image for 1
        try {
            sunflower = ImageIO.read(new File("./res/sunflower.png"));
        }catch (Exception e){
            e.printStackTrace();
        }
        //set snowpea image for 3
        try {
            snowpea = ImageIO.read(new File("./res/snowpea.png"));
        }catch (Exception e){
            e.printStackTrace();
        }

        //set double peashooter for 4
        try {
            doublep = ImageIO.read(new File("./res/doublep.png"));
        }catch (Exception e){
            e.printStackTrace();
        }


        sunTot = 50;

        timer = new Timer(1000 / 60, e -> update());
        timer.start();
        setKeyListener();
        mouseListener();

        j = 0;
        zombies = new ArrayList<Sprite>();


        while(j<5){
            x = j*100;
            zombies.add(new RegZ(x));

            j += 1;
        }




    }
    public static final int SUNFLOWER =1,PEASHOOTER =2, SNOWPEA = 3, DOUBLE =4, SHOVEL =0 ;

    public void update() {
        //60 per second
        sunTimer ++;


        if(sunTimer % 300 ==0){
            sunTot += 25;
        }

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        g2.setColor(new Color(30,145,80));
        g2.fillRect(0,110,1000,690);

        for (int r = 0; r <5 ; r++) {
            for (int c = 0; c < 9; c++) {
                if ((r+c) % 2 == 0){
                    g2.setColor(Color.green);
                    g2.fillRect(c*110,(r*125) + 125, 110,125);
                }

            }

        }

        for(Sprite z: zombies){

            z.draw(g2);
            z.update();

        }

        for (Sprite plant : plants) {
            plant.draw(g2);
        }
        // SUN
        g2.setColor(Color.BLACK);
        Font f = new Font(Font.SANS_SERIF, Font.BOLD, 20);
        g2.setFont(f);
        g2.drawString("Sun" + " " + sunTot, 20, 20);
        g2.drawImage(sun,15,25,null);

       //SUNFLOWER
        g2.setColor(Color.BLACK);
        g2.setFont(f);
        g2.drawString("1" , 180, 100);
        g2.drawImage(sunflower,115,15,null);

        //PEASHOOTER
        g2.setColor(Color.BLACK);
        g2.setFont(f);
        g2.drawString("2" , 290, 100);
        g2.drawImage(peashoot,225,22,null);

        //SNOWPEA
        g2.setColor(Color.BLACK);
        g2.setFont(f);
        g2.drawString("3" , 400, 100);
        g2.drawImage(snowpea,335,12,null);

        //DOUBLE
        g2.setColor(Color.BLACK);
        g2.setFont(f);
        g2.drawString("4" , 510, 100);
        g2.drawImage(doublep,435,10,null);


    }

    public void mouseListener(){
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                int c = e.getX()/110;
                int r = e.getY()/125;

                boolean isFull = true;

                for (Sprite plant : plants) {
                    if (r == plant.getLoc().y/125 && c== plant.getLoc().x/110){
                        isFull = false;
                    }
                }

                if (r>0 && isFull == true) {
                    if (selectedPlant == SUNFLOWER) {
                        plants.add(new Sunflower(r, c, Sprite.EAST));
                    }

                    if (selectedPlant == PEASHOOTER) {
                        plants.add(new PeaShooter(r, c, Sprite.EAST));
                    }

                    if (selectedPlant == SNOWPEA) {
                        plants.add(new SnowPea(r, c, Sprite.EAST));
                    }

                    if (selectedPlant == DOUBLE) {
                        plants.add(new DoublePea(r, c, Sprite.EAST));
                    }
                }

                    if (selectedPlant == SHOVEL) {
                        for (int i = 0; i <plants.size() ; i++) {
                            if (plants.get(i).getLoc().y/125 == r && plants.get(i).getLoc().x/110 == c){
                                plants.remove(i);
                            }

                        }
                    }


                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    public void setKeyListener(){
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_1) {
                    selectedPlant = SUNFLOWER;
                }
                if(e.getKeyCode() == KeyEvent.VK_2) {
                    selectedPlant = PEASHOOTER;
                }

                if(e.getKeyCode() == KeyEvent.VK_3) {
                    selectedPlant = SNOWPEA;
                }

                if(e.getKeyCode() == KeyEvent.VK_4) {
                    selectedPlant = DOUBLE;
                }

                if(e.getKeyCode() == KeyEvent.VK_0) {
                    selectedPlant = SHOVEL;
                }



            }
            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }



    public static void main(String[] args) {

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        window.setBounds(0, 0, WIDTH, HEIGHT + 22); //(x, y, w, h) 22 due to title bar.

        Main panel = new Main();

        panel.setFocusable(true);
        panel.grabFocus();

        window.add(panel);
        window.setVisible(true);
        window.setResizable(false);
    }

}

