package Testes;


import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Polygon;

public class Poligono2D extends Applet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    int pontoXInicial = 30;
    int pontoYInicial = 100;

    int distanciaX = 15 + 30;
    int distanciaY = 25 + 30;
    int larguraQuadradoInterno = 12;

    int[] x = {pontoXInicial, pontoXInicial + distanciaX,pontoXInicial + distanciaX, pontoXInicial};
    int[] y = {pontoYInicial, pontoYInicial,pontoYInicial - distanciaY,pontoYInicial - distanciaY};
    
    
    int[] x1 = {x[0] + larguraQuadradoInterno, x[1] - larguraQuadradoInterno, x[2] - larguraQuadradoInterno, x[3] + larguraQuadradoInterno};
    int[] y1 = {y[0] - larguraQuadradoInterno, y[1] - larguraQuadradoInterno, y[2] + larguraQuadradoInterno, y[3] + larguraQuadradoInterno};
   
           int[] x2 = { x[3], x1[3], x1[2], x[2] };
           int[] y2 = { y[3], y1[3], y1[2], y[2] };
           
           int[] x3 = { x[0], x[1], x1[1], x1[0] };
           int[] y3 = { y[0], y[1], y1[1], y1[0] };
           
           int[] x4 = { x[1], x1[1], x1[2], x[2] };
           int[] y4 = { y[1], y1[1], y1[2], y[2] };
           
           int[] x5 = { x[0], x1[0], x1[3], x[3] };
           int[] y5 = { y[0], y1[0], y1[3], y[3] };
   
           Polygon quadrado = new Polygon(x, y, 4);
           Polygon face1 = new Polygon(x1, y1, 4);
           Polygon face2 = new Polygon(x2, y2, 4);
           Polygon face3 = new Polygon(x3, y3, 4);
           
           Polygon face4 = new Polygon(x4, y4, 4);
           Polygon face5 = new Polygon(x5, y5, 4);
   
           @Override
        public void init() {
                     this.setSize(300, 300);
           }
   
           @Override
        public void paint(Graphics g) {
                     super.paint(g);
                     g.drawPolygon(quadrado);
                     g.drawPolygon(face1);
                     g.drawPolygon(face2);
                     g.drawPolygon(face3);
                     g.drawPolygon(face4);
                     g.drawPolygon(face5);
                     g.drawString("100",x1[0], y[0]+15);
           }
   
  }
