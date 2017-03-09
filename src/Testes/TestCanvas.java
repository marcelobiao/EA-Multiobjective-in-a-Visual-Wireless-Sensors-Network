/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testes;

import control.CalculateAreaSectors;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JFrame;

/**
 *
 * @author elive
 */
public class TestCanvas {

    public static void main(String[] args) {
        JFrame frmMain = new JFrame();
        frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmMain.setSize(400, 400);

        Canvas cnvs = new Canvas();
        cnvs.setSize(300, 300);

        frmMain.add(cnvs);
        frmMain.setVisible(true);

        Graphics g = cnvs.getGraphics();
        g.setColor(new Color(255, 0, 0));

        g.setColor(Color.red);

        CalculateAreaSectors cas = new CalculateAreaSectors();

        double countTrue = 0;
        double countFalse = 0;
        double count = 5000;
        int angulo = 56;
        int alcance = 300;

        Point sectorStart = new Point(200, 150);
        Point c = new Point(200, 200);
        //Point sectorEnd = new Point(150, 200);
        Point sectorEnd = new Point((int) (sectorStart.x + alcance * Math.sin(angulo)), (int) (sectorStart.y + alcance * Math.sin(angulo)));
        double radiusSquared = 400 * 400 / 8;
        //double radiusSquared = alcance;

        int startX = sectorStart.x;
        int startY = sectorStart.y;
        int endX = sectorEnd.x;
        int endY = sectorEnd.y;

        double deltaX = (startY - endY) / 2;
        double deltaY = (endX - startX) / 2;

        int[] polygonX = new int[3];
        int[] polygonY = new int[3];

        polygonX[0] = (int) startX;
        polygonY[0] = (int) startY;

        polygonX[1] = (int) endX - (int) deltaX;
        polygonY[1] = (int) endY - (int) deltaY;

        polygonX[2] = (int) endX + (int) deltaX;
        polygonY[2] = (int) endY + (int) deltaY;

        for (int i = 0; i < count; i++) {
            double x = Math.random() * 400;
            double y = Math.random() * 400;

            Point p = new Point((int) x, (int) y);

            boolean isInside1 = cas.isInsideSector(p, c,sectorStart, sectorEnd, radiusSquared);

            if (isInside1 == true) {
                //System.out.println(isInside);
                g.setColor(Color.green);
                countTrue++;
            } else {
                g.setColor(Color.red);
                countFalse++;
            }

            g.fillOval((int) x, (int) y, 5, 5);

        }
        System.out.println("IN: " + countTrue + ", OUT: " + countFalse);
        double mediaT = Math.abs((countTrue * 100) / count);
        double mediaF = Math.abs((countFalse * 100) / count);
        System.out.println("Percentage IN: " + String.format("%.2f", mediaT) + " %, Percentage OUT: " + String.format("%.2f", mediaF) + " %.");

        g.setColor(Color.blue);
        //g.fillOval((int) startX - 5, (int) startY - 5, 10, 10);
        //g.drawPolygon(polygonX, polygonY, 3);

    }

}
