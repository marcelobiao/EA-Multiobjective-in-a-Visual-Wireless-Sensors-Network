/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.awt.Point;

/**
 *
 * @author elive
 */
public class Sensors {
    
    private int id;
    private Point ponto;
    private int angulo;
    private int alcance;
    
    public Sensors(int id, Point ponto, int angulo, int alcance){
        this.id = id;
        this.ponto = ponto;
        this.angulo = angulo;
        this.alcance = alcance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Point getPonto() {
        return ponto;
    }

    public void setPonto(Point ponto) {
        this.ponto = ponto;
    }

    public int getAngulo() {
        return angulo;
    }

    public void setAngulo(int angulo) {
        this.angulo = angulo;
    }

    public int getAlcance() {
        return alcance;
    }

    public void setAlcance(int alcance) {
        this.alcance = alcance;
    }
    
    
}
