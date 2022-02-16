import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class BlockBreakerPanel extends JPanel implements KeyListener {
    ArrayList<Block> blocks = new ArrayList<Block>();
    ArrayList<Block> ball = new ArrayList<Block>();
    Block paddle;
    Thread thread;
    Animate animate;
    int size = 25;
    BlockBreakerPanel() {
        paddle = new Block(175, 480, 150, 25, new ResourcePath("paddle").png().getPath());
        for(int i = 0; i<8; i ++) {
            blocks.add(new Block(i*60+2, 0, 60, 25, new ResourcePath("green.png").getPath()));
        }
        for(int i = 0; i<8; i ++) {
            blocks.add(new Block(i*60+2, 25, 60, 25, new ResourcePath("yellow.png").getPath()));
        }
        for(int i = 0; i<8; i ++) {
            blocks.add(new Block(i*60+2, 50, 60, 25, new ResourcePath("blue.png").getPath()));
        }
        for(int i = 0; i<8; i ++) {
            blocks.add(new Block(i*60+2, 75, 60, 25, new ResourcePath("red.png").getPath()));
        }
        ball.add(new Block(237, 437, 25, 25, new ResourcePath("ball.png").getPath()));
        addKeyListener(this);
        setFocusable(true);
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Block b : blocks)
            b.draw(g, this);
        for (Block b : ball)
            b.draw(g, this);
        paddle.draw(g, this);
    }

    public void update() {
        for (Block ba : ball) {
            ba.x += ba.dx;
            if (ba.x >(getWidth() - ba.width) && ba.x > 0 || ba.x < 0)
                ba.dx *= -1;
            if (ba.y < 0 || ba.intersects(paddle))
                ba.dy *= -1;
            ba.y += ba.dy;
            for (Block b : blocks) {
                if(ba.intersects(b) && !b.destroyed) {
                    b.destroyed = true;
                    ba.dy *= -1;
                }
            }
        }
        repaint();
    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            animate = new Animate(this);
            thread = new Thread(animate);
            thread.start();
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT && paddle.x > 0) {
            paddle.x -= 15;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT && paddle.x < (getWidth()-paddle.width)) {
            paddle.x += 15;
        }
    }

    public void keyReleased(KeyEvent e) {

    }
}
