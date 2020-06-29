package fram;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TankFrame extends Frame {
    private Tank tank1;
    private Tank tank2;
    public TankFrame(){
        this.tank1 = new Tank(100,100,Dir.R);
        this.tank2 = new Tank(200,100,Dir.L);
        super.setTitle("tank war");
        super.setVisible(true);
        super.setBounds(400,100,800,600);
        super.addKeyListener(new TankKeyListener());
    }
    // 窗口大小改变后事件
    @Override
    public void paint(Graphics g) {
        tank1.paint(g);
        tank2.paint(g);
    }
    private class TankKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            tank1.keyPressed(e);
        }
        @Override
        public void keyReleased(KeyEvent e) {
            tank1.keyReleased(e);
        }
    }
}
