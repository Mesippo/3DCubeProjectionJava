package PhysicsEngine3D;

import PhysicsEngine3D.CustomEngine.InputControls;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel implements Runnable {

    // Variable
    public static int width = 750;
    public static int height = 600;
    boolean engineLoopOn = false;

    // Components
    DCube cube;
    Thread engineLoop;

    // KeyListener
    public InputControls ic;

    // ===== CONSTRUCTOR =====
    Panel(DCube cube) {
        // WindowPanel Settings
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.BLACK);
        this.setLayout(null);
        this.setFocusable(true);
        this.setDoubleBuffered(true);

        // Instantiation
        this.cube = cube;
        engineLoop = new Thread(this);
        ic = new InputControls(cube);

        // Finalization
        this.addKeyListener(ic);
        this.addMouseListener(ic);

        this.engineLoopOn = true;
        engineLoop.start();

        this.repaint();
        this.setVisible(true);
    }

    // ===== PAINT COMPONENT =====
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        cube.drawCube(g2d);
    }

    // ===== ENGINE LOOP =====
    @Override
    public void run() {
        while (engineLoopOn) { // -- Loop Start
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            // Variables
            width = this.getWidth();
            height = this.getHeight();

            // Methods
            this.repaint();
            ic.mouseCheck();
        } // -- Loop End
    }
}
