package PhysicsEngine3D.CustomEngine;

import java.awt.*;

public class PVector {

    public int x;
    public int y;
    public int z;

    public PVector(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public PVector(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void drawPoint(int x, int y, Graphics2D g2d) {
        int size = 12;
        int center = (int) size / 2;
        g2d.fillOval((int)x-center, (int)y-center, size, size);
    }
}
