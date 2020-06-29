package fram;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Tank {
    private int x, y;
    private Dir dir;
    private static final int SPEED = 5;
    private boolean bL, bR, bU, bD;
    private boolean moving = false;

    public void paint(Graphics g) {
        g.fillRect(x, y, 50, 50);
        this.move();
    }

    public Tank(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                bU = true;
                break;
            case KeyEvent.VK_LEFT:
                bL = true;
                break;
            case KeyEvent.VK_RIGHT:
                bR = true;
                break;
            case KeyEvent.VK_DOWN:
                bD = true;
                break;
        }
        this.setMainDir();
    }

    private void setMainDir() {
        if (!bL && !bR && !bD && !bU)
            moving = false;
        else
            moving = true;
        if (bL && !bR && !bD && !bU)
            dir = Dir.L;
        if (!bL && bR && !bD && !bU)
            dir = Dir.R;
        if (!bL && !bR && bD && !bU)
            dir = Dir.D;
        if (!bL && !bR && !bD && bU)
            dir = Dir.U;
    }

    private void move() {
        if (!moving) return;
        switch (dir) {
            case L:
                x -= SPEED;
                break;
            case U:
                y -= SPEED;
                break;
            case R:
                x += SPEED;
                break;
            case D:
                y += SPEED;
                break;
        }
    }

    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                bU = false;
                break;
            case KeyEvent.VK_LEFT:
                bL = false;
                break;
            case KeyEvent.VK_RIGHT:
                bR = false;
                break;
            case KeyEvent.VK_DOWN:
                bD = false;
                break;
        }
        this.setMainDir();
    }
}
