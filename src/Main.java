import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main extends JPanel{

    public static final int WIDTH=1000, HEIGHT=800;
    private Timer timer;
    private ArrayList <Sprite> plants;
    private int selectedPlant = 0;



    public Main(){

        plants = new ArrayList<Sprite>();

        timer = new Timer(1000 / 60, e -> update());
        timer.start();
        setKeyListener();
        mouseListener();



    }
    public static final int SUNFLOWER =1,PEASHOOTER =2, SHOVEL =0 ;

    public void update() {

//hi
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


        for (Sprite plant : plants) {
            plant.draw(g2);
        }




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

