package PhysicsEngine3D;

import PhysicsEngine3D.MenuButtons.ConfigMenuBar;

import javax.swing.*;
import java.awt.*;

public class WindowFrame extends JFrame {
    WindowFrame() {
        // WindowFrame Settings
        this.setTitle("Physics Engine 3D");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.getContentPane().setBackground(Color.WHITE);
        this.setMinimumSize(new Dimension(550, 550));
        this.setLayout(new BorderLayout());

        DCube cube = new DCube();
        Panel enginePanel = new Panel(cube);
        ConfigMenuBar configMenuBar = new ConfigMenuBar(cube);

        // Finalization
        this.add(configMenuBar, BorderLayout.NORTH);
        this.add(enginePanel, BorderLayout.CENTER);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
