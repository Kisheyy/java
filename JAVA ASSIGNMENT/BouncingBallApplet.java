import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BouncingBallApplet extends Applet implements MouseListener, Runnable {
    private int x, y;          
    private int xSpeed = 2;     
    private int ySpeed = 2;     
    private int ballSize = 20;  

    private boolean isRunning = false; 

    public void init() {
        setSize(400, 400);
        setBackground(Color.white);
        addMouseListener(this);
    }

    public void mouseClicked(MouseEvent e) {}

    public void mousePressed(MouseEvent e) {
        if (!isRunning) {
            x = e.getX();
            y = e.getY();
            isRunning = true;
            Thread t = new Thread(this);
            t.start();
        }
    }

    public void mouseReleased(MouseEvent e) {}

    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}

    public void run() {
        while (isRunning) {
          
            x += xSpeed;
            y += ySpeed;

          
            if (x <= 0 || x + ballSize >= getWidth()) {
                xSpeed = -xSpeed;
            }
            if (y <= 0 || y + ballSize >= getHeight()) {
                ySpeed = -ySpeed; 
            }

            repaint();

           
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void paint(Graphics g) {
        g.setColor(Color.blue);
        g.fillOval(x, y, ballSize, ballSize);
    }
}
