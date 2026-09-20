package PhysicsEngine3D.MenuButtons;

import PhysicsEngine3D.DCube;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ColorChooser extends JLabel implements MouseListener {
    // Components
    DCube c;
    JColorChooser colorChooser;
    ImageIcon icon;
    Color cubeInitialColor = new Color(20, 135, 227, 199);
    Color defaultColor = new Color(73, 73, 73);
    Color hoverColor = new Color(97, 97, 97);

    // Settings
    final int width = 37;
    final int height = 37;

    public ColorChooser(DCube c) {
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.BLACK);
        this.setFocusable(false);;
        this.c = c;

        this.setBackground(defaultColor);
        this.setOpaque(true);

        icon = new ImageIcon("src/PhysicsEngine3D/ImageIcons/paintBrushIcon.png");
        this.convertImage();

        this.setIcon(icon);
        this.addMouseListener(this);
        this.setVisible(true);
    }

    public void convertImage() {
        Image image = icon.getImage();
        Image newImage = image.getScaledInstance(width-3, height-3, Image.SCALE_SMOOTH);
        icon = new ImageIcon(newImage);
    }

    /// ===== Mouse Listener =====
    @Override
    public void mousePressed(MouseEvent e) {
        colorChooser = new JColorChooser();
        c.cubeColor = JColorChooser.showDialog(
                this,
                "Choose Color",
                c.cubeColor);

        if (c.cubeColor == null) {
            c.cubeColor = cubeInitialColor;
        }
    }
    @Override
    public void mouseReleased(MouseEvent e) {

    }
    @Override
    public void mouseEntered(MouseEvent e) {
        this.setBackground(hoverColor);
    }
    @Override
    public void mouseExited(MouseEvent e) {
        this.setBackground(defaultColor);
    }
    @Override
    public void mouseClicked(MouseEvent e) {}
}
