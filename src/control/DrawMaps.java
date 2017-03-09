package control;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.util.ArrayList;
import javax.swing.JPanel;
import models.Sensors;
import models.Targets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author elive
 */
public class DrawMaps extends Canvas {

    private JPanel panel;
    private int wdtT = 5;
    private int hgtT = 5;
    private int wdtS = 10;
    private int hgtS = 10;

    public DrawMaps(JPanel panel) {
        this.panel = panel;
    }

    private Color getColor() {
        FuncoesDiversas fd = new FuncoesDiversas(0, 255);
        int r = fd.gerarNumeroAleatorio();
        int g = fd.gerarNumeroAleatorio();
        int b = fd.gerarNumeroAleatorio();

        return new Color(r, g, b);
    }

    public void paintTargets(ArrayList<Targets> target) {
        Graphics g = panel.getGraphics();
        g.setColor(new Color(60, 63, 65));
        g.fillRect(2, 2, panel.getWidth() - 4, panel.getHeight() - 4);
        g.setColor(Color.red);

        for (Targets t : target) {
            g.fillOval(t.getPonto().x, t.getPonto().y, wdtT, hgtT);
        }
    }

    public void paintSingleTargets(Targets target) {
        Graphics g = panel.getGraphics();
        g.setColor(Color.red);

        g.fillOval(target.getPonto().x - (wdtT / 2), target.getPonto().y - (hgtT / 2), wdtT, hgtT);

    }

    public void paintSingleSensor(Sensors sensor) {
        Graphics g = panel.getGraphics();

        int[] x = new int[3];
        int[] y = new int[3];

        double distance = sensor.getAlcance();
        double halfDistance = distance / 2;
        //double angle = s.getAngulo();
        int startX = (int) sensor.getPonto().x;
        int startY = (int) sensor.getPonto().y;
        double endX = startX + sensor.getAlcance() * Math.sin(sensor.getAngulo());
        double endY = startY + sensor.getAlcance() * Math.cos(sensor.getAngulo());

        double angle = -Math.atan2(endY - startY, endX - startX);

        System.out.println(angle);

        x[0] = startX;
        y[0] = startY;

        x[1] = (int) ((Math.sin(angle) * halfDistance) + endX);
        y[1] = (int) ((Math.cos(angle) * halfDistance) + endY);

        x[2] = (int) (endX - (Math.sin(angle) * halfDistance));
        y[2] = (int) (endY - (Math.cos(angle) * halfDistance));

        g.setColor(getColor());
        g.fillOval((int) startX - (wdtS / 2), (int) startY - (hgtS / 2), wdtS, hgtS);
        g.drawPolygon(x, y, 3);
    }

    public void paintSensors(ArrayList<Sensors> sensor) {

        Graphics g = panel.getGraphics();

        for (Sensors s : sensor) {

            int startX = s.getPonto().x;
            int startY = s.getPonto().y;
            double endX = startX + s.getAlcance() * Math.sin(s.getAngulo());
            double endY = startY + s.getAlcance() * Math.cos(s.getAngulo());

            double deltaX = (startY - endY) / 2;
            double deltaY = (endX - startX) / 2;

            int[] polygonX = new int[3];
            int[] polygonY = new int[3];

            polygonX[0] = startX;
            polygonY[0] = startY;

            polygonX[1] = (int) endX - (int) deltaX;
            polygonY[1] = (int) endY - (int) deltaY;

            polygonX[2] = (int) endX + (int) deltaX;
            polygonY[2] = (int) endY + (int) deltaY;

            g.setColor(getColor());
            g.fillOval((int) startX - (wdtS / 2), (int) startY - (hgtS / 2), wdtS, hgtS);
            //g.fillRect((int) startX - (wdt / 2), (int) startY - (hgt / 2), wdt, hgt);
            g.drawPolygon(polygonX, polygonY, 3);
        }

    }
    
    public void paintSingleSensorAlternative(Sensors sensor) {
        Graphics g = panel.getGraphics();

        int startX = sensor.getPonto().x;
        int startY = sensor.getPonto().y;
        double endX = startX + sensor.getAlcance() * Math.sin(sensor.getAngulo());
        double endY = startY + sensor.getAlcance() * Math.cos(sensor.getAngulo());

        double deltaX = (startY - endY) / 2;
        double deltaY = (endX - startX) / 2;

        int[] polygonX = new int[3];
        int[] polygonY = new int[3];

        polygonX[0] = startX;
        polygonY[0] = startY;

        polygonX[1] = (int) endX - (int) deltaX;
        polygonY[1] = (int) endY - (int) deltaY;

        polygonX[2] = (int) endX + (int) deltaX;
        polygonY[2] = (int) endY + (int) deltaY;

        g.setColor(getColor());
        g.fillOval((int) startX - (wdtS / 2), (int) startY - (hgtS / 2), wdtS, hgtS);
        //g.fillRect((int) startX - (wdt / 2), (int) startY - (hgt / 2), wdt, hgt);
        g.drawPolygon(polygonX, polygonY, 3);
    }

    public void paintSensorsAlternative(ArrayList<Sensors> sensor) {

        Graphics g = panel.getGraphics();

        for (Sensors s : sensor) {

            int[] x = new int[3];
            int[] y = new int[3];

            double distance = s.getAlcance();
            double halfDistance = distance / 2;
            int startX = s.getPonto().x;
            int startY = s.getPonto().y;
            double endX = startX + s.getAlcance() * Math.sin(s.getAngulo());
            double endY = startY + s.getAlcance() * Math.cos(s.getAngulo());

            double angle = -Math.atan2(endY - startY, endX - startX);

            x[0] = startX;
            y[0] = startY;

            x[1] = (int) ((Math.sin(angle) * halfDistance) + endX);
            y[1] = (int) ((Math.cos(angle) * halfDistance) + endY);

            x[2] = (int) (endX - (Math.sin(angle) * halfDistance));
            y[2] = (int) (endY - (Math.cos(angle) * halfDistance));

            g.setColor(getColor());
            g.fillOval((int) startX - (wdtS / 2), (int) startY - (hgtS / 2), wdtS, hgtS);
            g.drawPolygon(x, y, 3);
        }
    }

}
