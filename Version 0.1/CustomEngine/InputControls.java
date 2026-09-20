package PhysicsEngine3D.CustomEngine;

import PhysicsEngine3D.DCube;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class InputControls implements KeyListener, MouseListener {
    // Components
    DCube cube;
    Point mouseOrigin;
    Point currentMousePosition;

    // Variables
    public static boolean
            leftRotate = false,
            rightRotate = false,
            upRotate = false,
            downRotate = false,

            mousePressed = false,
            keyPressed = false;

    //  Constructor
    public InputControls(DCube cube) {
        this.cube = cube;
    }

    /// ====== KEY LISTENER ======
    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {}


    /// ===== MOUSE LISTENER =====
    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {
        mouseOrigin = MouseInfo.getPointerInfo().getLocation();
        mousePressed = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mousePressed = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {
        mousePressed = false;
    }

    public void mouseCheck() {
        currentMousePosition = MouseInfo.getPointerInfo().getLocation();

        int sensitivity = 30;

        if (mousePressed) {

            leftRotate = mouseOrigin.x - currentMousePosition.x > sensitivity;
            rightRotate = currentMousePosition.x - mouseOrigin.x > sensitivity;

            upRotate = mouseOrigin.y - currentMousePosition.y > sensitivity;
            downRotate = currentMousePosition.y - mouseOrigin.y > sensitivity;

        } else {

            leftRotate = false;
            rightRotate = false;
            upRotate = false;
            downRotate = false;

        }
    }
}