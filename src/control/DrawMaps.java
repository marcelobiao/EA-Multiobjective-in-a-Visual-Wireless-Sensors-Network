package control;

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
public class DrawMaps {

    private Color getColor() {
        FuncoesDiversas fd = new FuncoesDiversas(0, 255);
        int r = fd.gerarNumeroAleatorio();
        int g = fd.gerarNumeroAleatorio();
        int b = fd.gerarNumeroAleatorio();

        return new Color(r, g, b);
    }

    public void paintTargets(JPanel panel, ArrayList<Targets> target) {
        Graphics g = panel.getGraphics();
        //g.setColor(new Color(60, 63, 65));
        //g.fillRect(2, 2, 496, 496);

        g.setColor(Color.red);
        int wdt = 5;
        int hgt = 5;
        for (Targets t : target) {
            g.fillOval(t.getPonto().x, t.getPonto().y, wdt, hgt);
        }
    }

    public void paintSingleTargets(JPanel panel, Targets target) {
        Graphics g = panel.getGraphics();

        g.setColor(Color.red);
        int wdt = 7;
        int hgt = 7;
        g.fillOval(target.getPonto().x, target.getPonto().y, wdt, hgt);

    }

    public void paintSingleSensor(JPanel panel, Sensors sensor) {
        Graphics g = panel.getGraphics();

        int[] x = new int[3];
        int[] y = new int[3];
        int wdt = 12;
        int hgt = 12;

        double distance = sensor.getAlcance();
        double halfDistance = distance / 2;
        //double angle = s.getAngulo();
        int startX = (int) sensor.getPonto().x;
        int startY = (int) sensor.getPonto().y;
        double endX = startX + sensor.getAlcance() * Math.sin(sensor.getAngulo());
        double endY = startY + sensor.getAlcance() * Math.cos(sensor.getAngulo());

        double angle = -Math.atan2(endY - startY, endX - startX);

        System.out.println(angle);

        x[0] = (int) endX;
        y[0] = (int) endY;

        x[1] = (int) ((Math.sin(angle) * halfDistance) + startX);
        y[1] = (int) ((Math.cos(angle) * halfDistance) + startY);

        x[2] = (int) (startX - (Math.sin(angle) * halfDistance));
        y[2] = (int) (startY - (Math.cos(angle) * halfDistance));

        //g.setColor(Color.blue);
        g.setColor(getColor());
        //g.fillPolygon(x, y, 3);
        g.fillOval((int) endX, (int) endY, wdt, hgt);
        g.drawPolygon(x, y, 3);
    }

    public void paintSensorsWitchAngles(JPanel panel, ArrayList<Sensors> sensor) {

        Graphics g = panel.getGraphics();
        int wdt = 12;
        int hgt = 12;

        for (Sensors s : sensor) {

            int[] x = new int[3];
            int[] y = new int[3];

            double distance = s.getAlcance();
            double halfDistance = distance / 2;
            //double angle = s.getAngulo();
            int startX = (int) s.getPonto().x;
            int startY = (int) s.getPonto().y;
            double endX = startX + s.getAlcance() * Math.sin(s.getAngulo());
            double endY = startY + s.getAlcance() * Math.cos(s.getAngulo());

            double angle = -Math.atan2(endY - startY, endX - startX);

            System.out.println(angle);

            x[0] = (int) endX;
            y[0] = (int) endY;

            x[1] = (int) ((Math.sin(angle) * halfDistance) + startX);
            y[1] = (int) ((Math.cos(angle) * halfDistance) + startY);

            x[2] = (int) (startX - (Math.sin(angle) * halfDistance));
            y[2] = (int) (startY - (Math.cos(angle) * halfDistance));

            g.setColor(Color.blue);
            //g.fillPolygon(x, y, 3);
            g.fillOval((int) endX, (int) endY, wdt, hgt);
            g.drawPolygon(x, y, 3);

            //g.fillArc(startX, startY, s.getAlcance(), s.getAlcance(), (int) endX, (int) endY);
        }

    }

}
