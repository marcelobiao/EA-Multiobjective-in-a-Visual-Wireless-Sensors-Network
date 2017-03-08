/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.Point;

/**
 *
 * @author elive
 */
public class CalculateAreaSectors {

    public boolean isInsideSector(Point p, Point sectorStart, Point sectorEnd, double radiusSquared) {

        Point relPoint = new Point(p.x - sectorStart.x, p.y - sectorStart.y);

        if (!areClockwise(sectorStart, relPoint) && areClockwise(sectorEnd, relPoint) && isWithinRadius(relPoint, radiusSquared)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean areClockwise(Point p1, Point p2) {

        double r = -p1.x * p2.y + p1.y * p2.x;

        if (r > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isWithinRadius(Point p, double radiusSquared) {

        double r = Math.pow(p.x, 2) + Math.pow(p.y, 2);

        if (r <= radiusSquared) {
            return true;
        } else {
            return false;
        }
    }

}
