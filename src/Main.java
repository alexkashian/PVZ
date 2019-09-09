import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main extends JPanel{

    public static final int WIDTH=1100, HEIGHT=800;
    private Timer timer;
    private ArrayList<Sprite> zombies;
    private ArrayList <Sprite> plants;
    private int j,x,sunTimer, sunTot;


    public Main(){

        plants = new ArrayList<Sprite>();

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

        for(Sprite z: zombies){

            z.draw(g2);
            z.update();

        }

        for (Sprite plant : plants) {
            plant.draw(g2);
        }

        g2.setColor(Color.BLACK);
        Font f = new Font(Font.SANS_SERIF, Font.BOLD, 20);
        g2.setFont(f);
        g2.drawString("Sun" + " " + sunTot, 20, 20);



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

                plants.add(new PeaShooter(r,c,Sprite.EAST));

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

