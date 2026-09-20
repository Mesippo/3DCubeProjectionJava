package PhysicsEngine3D.MenuButtons;

import PhysicsEngine3D.DCube;
import PhysicsEngine3D.Panel;
import javax.swing.*;
import java.awt.*;

public class ConfigMenuBar extends JPanel {
    // Components
    JLabel sizeSliderLabel;
    JLabel zSliderLabel;
    SizeSlider ss;
    ZSlider zs;
    PerspectiveButton pb;
    OrthographicButton ob;
    ColorChooser cc;

    // Variables
    String sizeSliderLabelTextValue;
    String zSliderLabelTextValue;

    public ConfigMenuBar(DCube cube) {
        // Settings
        this.setPreferredSize(new Dimension(Panel.width, 50));
        this.setBackground(new Color(57, 57, 57));
        this.setLayout(new FlowLayout(FlowLayout.LEADING));
        this.setDoubleBuffered(true);

        // Instantiation
        ss = new SizeSlider(cube);
        zs = new ZSlider(cube);
        pb = new PerspectiveButton(cube);
        ob = new OrthographicButton(cube);
        cc = new ColorChooser(cube);
        this.createSizeSliderLabel();
        this.createZSliderLabel();

        // Finalization
        this.add(sizeSliderLabel);
        this.add(ss);
        this.add(zSliderLabel);
        this.add(zs);

        this.add(cc);

        this.add(pb);
        this.add(ob);

        Timer update = new Timer(10, e -> {this.updateMenuBar();});
        update.start();
    }

    public void updateMenuBar() {
        sizeSliderLabelTextValue =
                "<HTML>" +
                "Ø: " +
                "<br>" +
                ss.getValue() +
                "</HTML>";
        this.sizeSliderLabel.setText(sizeSliderLabelTextValue);

        zSliderLabelTextValue =
                "<HTML>" +
                "Z: " +
                "<br>" +
                zs.getValue() +
                "</HTML>";
        this.zSliderLabel.setText(zSliderLabelTextValue);
    }

    public void createSizeSliderLabel() {
        this.sizeSliderLabel = new JLabel();
        this.sizeSliderLabel.setFont(new Font("Monospaced", Font.BOLD, 15));
        this.sizeSliderLabel.setHorizontalAlignment(JLabel.CENTER);
        this.sizeSliderLabel.setForeground(new Color(200, 200, 200));
    }

    public void createZSliderLabel() {
        this.zSliderLabel = new JLabel();
        this.zSliderLabel.setFont(new Font("Monospaced", Font.BOLD, 15));
        this.zSliderLabel.setHorizontalAlignment(JLabel.CENTER);
        this.zSliderLabel.setForeground(new Color(200, 200, 200));
    }
}
