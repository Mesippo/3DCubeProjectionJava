package PhysicsEngine3D.MenuButtons;

import PhysicsEngine3D.DCube;

import javax.swing.*;
import java.awt.*;

public class ZSlider extends JSlider {
    // Components
    DCube cube;

    // Variables
    int min = 0;
    int max = 63;
    int initialValue = 0;

    public ZSlider(DCube cube) {

        this.setMinimum(min);
        this.setMaximum(max);
        this.setValue(initialValue);
        this.setFocusable(false);
        this.cube = cube;

        this.setPreferredSize(new Dimension(200, 40));
        this.setOrientation(JSlider.HORIZONTAL);

        this.setPaintTicks(true);
        this.setMajorTickSpacing(10);

        this.setForeground(new Color(200, 200, 200));
        this.setFont(new Font("MonoSpaced", Font.PLAIN, 10));
        this.setPaintLabels(true);
        this.setVisible(true);

        this.update();
    }

    public void update(){
        Timer updateTimer = new Timer(10,
            e->
            cube.angleZ = this.getValue()*0.1
        );
        updateTimer.start();
    }
}