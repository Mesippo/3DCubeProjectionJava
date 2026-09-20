package PhysicsEngine3D;
import PhysicsEngine3D.CustomEngine.Calculations;
import PhysicsEngine3D.CustomEngine.PVector;

import javax.swing.*;
import java.awt.*;

public class DCube {
    // Components
    PVector[] points;
    PVector[] projected;
    public PVector rotated;
    public float[][] projection;
    public Color cubeColor = new Color(20, 135, 227, 199);

    // Variables
    public float zoom = 1f;
    public int size = 55;

    public boolean orthographic = false;

    public double angleSpeed = 0.0055;
    public double angleX = -34;
    public double angleY = 45;
    public double angleZ = 0;

    DCube() {
        this.updateCubeSize();
    }

    void drawCube(Graphics2D g2d) {
        this.updateCubeSize();

        g2d.translate((int)Panel.width/2, (int)Panel.height/2);
        g2d.setColor(cubeColor);

        float[][] rotationZ = new float[][]{
                {(float) Math.cos(angleZ), (float) -Math.sin(angleZ), 0},
                {(float) Math.sin(angleZ), (float) Math.cos(angleZ), 0},
                {0, 0, 1}
        };

        float[][] rotationX = new float[][]{
                {1, 0, 0},
                {0, (float) Math.cos(angleX), (float) -Math.sin(angleX)},
                {0, (float) Math.sin(angleX), (float) Math.cos(angleX)}
        };

        float[][] rotationY = new float[][]{
                {(float) Math.cos(angleY), 0, (float) -Math.sin(angleY)},
                {0, 1, 0},
                {(float) Math.sin(angleY), 0, (float) Math.cos(angleY)}
        };

        projected = new PVector[8];

        int index = 0;

        for (PVector v : points) {

            rotated = Calculations.matmul(rotationY, v);
            rotated = Calculations.matmul(rotationZ, rotated);
            rotated = Calculations.matmul(rotationX, rotated);

            Calculations.setPerspectiveProjection(rotated, this);

            PVector projected2d = Calculations.matmul(projection, rotated);

            projected2d.drawPoint(projected2d.x, projected2d.y, g2d); // -- Vertices

            // Rotation
            Calculations.updateRotation(this);

            projected[index] = projected2d;
            index++;
        }

        // Connecting
        for (int i = 0; i < 4; i++) {
            Calculations.connect(i, (i+1) % 4, projected, g2d);
            Calculations.connect(i+4, ((i+1) % 4)+4, projected, g2d);
            Calculations.connect(i, i+4, projected, g2d);
        }
    }
    public void updateCubeSize() {
        points = new PVector[] {
                new PVector(-size, -size, -size),  // 0
                new PVector(size, -size, -size),   // 1
                new PVector(size, size, -size),    // 2
                new PVector(-size, size, -size),   // 3

                new PVector(-size, -size, size),   // 4
                new PVector(size, -size, size),    // 5
                new PVector(size, size, size),     // 6
                new PVector(-size, size, size),    // 7
        };
    }
}