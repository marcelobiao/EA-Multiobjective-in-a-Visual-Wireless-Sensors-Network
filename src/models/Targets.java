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
public class Targets {
    
    private int id;
    private Point ponto;
    
    public Targets(int id, Point ponto){
        this.id = id;
        this.ponto = ponto;
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
    
    
    
}
