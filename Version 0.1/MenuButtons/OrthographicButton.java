package PhysicsEngine3D.MenuButtons;

import PhysicsEngine3D.DCube;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class OrthographicButton extends JLabel implements MouseListener {
    // Components
    DCube c;
    JColorChooser colorChooser;
    ImageIcon icon;
    Color defaultColor = new Color(73, 73, 73);
    Color hoverColor = new Color(97, 97, 97);

    // Settings
    final int width = 37;
    final int height = 37;

    public OrthographicButton(DCube c) {
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.BLACK);
        this.setFocusable(false);;
        this.c = c;

        this.setBackground(defaultColor);
        this.setOpaque(true);

        icon = new ImageIcon("src/PhysicsEngine3D/ImageIcons/p-Orthographic.png");
        this.convertImage();

        this.setIcon(icon);
        this.addMouseListener(this);
        this.setVisible(true);
    }

    public void convertImage() {
        Image image = icon.getImage();
        Image newImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        icon = new ImageIcon(newImage);
    }

    /// ===== Mouse Listener =====
    @Override
    public void mousePressed(MouseEvent e) {
        c.orthographic = true;
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
