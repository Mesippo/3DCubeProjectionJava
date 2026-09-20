package PhysicsEngine3D.CustomEngine;

import PhysicsEngine3D.DCube;

import java.awt.*;

public class Calculations {

    static public PVector matmul(float[][] matrix, PVector v) {

        int newX = (int) (
                matrix[0][0] * v.x +
                matrix[0][1] * v.y +
                matrix[0][2] * v.z
        );

        int newY = (int) (
                matrix[1][0] * v.x +
                matrix[1][1] * v.y +
                matrix[1][2] * v.z
        );

        int newZ = (int) (
                matrix[2][0] * v.x +
                matrix[2][1] * v.y +
                matrix[2][2] * v.z
                );

        return new PVector(newX, newY, newZ);
    }

    static public void mult(int multiplier, PVector[] points) {
        for (PVector p : points) {
            p.x *= multiplier;
            p.y *= multiplier;
            p.z *= multiplier;
        }
    }

    static public void setPerspectiveProjection(PVector rotated, DCube c) {
        if(!c.orthographic) {
            float cameraDistance = 200;

            float z = c.zoom * cameraDistance / (cameraDistance + rotated.z);

            c.projection = new float[][]{
                    {z, 0, 0},
                    {0, z, 0},
                    {0, 0, 0}
            };
        } else {
            c.projection = new float[][]{
                    {1, 0, 0},
                    {0, 1, 0},
                    {0, 0, 0}
            };
        }
    }

    static public void connect(int i, int j, PVector[] points, Graphics2D g2d) {
        PVector a =  points[i];
        PVector b = points[j];

        g2d.setStroke(new BasicStroke(2));
        g2d.drawLine((int)a.x, (int)a.y, (int)b.x, (int)b.y);
    }

    static public void updateRotation(DCube c) {
        if (InputControls.leftRotate) {
            if (Math.cos(c.angleX) >= 0)
                c.angleY -= c.angleSpeed;
            else
                c.angleY += c.angleSpeed;
        }

        if (InputControls.rightRotate) {
            if (Math.cos(c.angleX) >= 0)
                c.angleY += c.angleSpeed;
            else
                c.angleY -= c.angleSpeed;
        }

        if(InputControls.upRotate) {
            c.angleX -= c.angleSpeed;
        }
        if(InputControls.downRotate) {
            c.angleX += c.angleSpeed;
        }
    }
}