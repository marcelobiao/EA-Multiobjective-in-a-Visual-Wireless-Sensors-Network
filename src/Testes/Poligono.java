package Testes;

                              /* Projeto 37: Transformação Interativa de Polígonos Controlada por uma Curva de Bezier
*  Cristiano Campos (ccc2)
*  Daniel Agra (dmav)
*/

import java.awt.*;
import java.lang.Math;
import java.awt.Graphics;

public class Poligono
{
	protected Point[] vertices;
	private static final int RAIO = 50;
        Point pCentral;
	int quantLados;


	public Poligono(int x, int y, int vQuantLados, Graphics g) {
		this.pCentral = new Point(x, y);
		this.quantLados = vQuantLados;
		vertices = new Point[vQuantLados];

                Point pInicial = new Point(0,RAIO);
                //Point pInicial = new Point(0,100);
                defineVertices(pInicial,0,g);
	}

	/*public Poligono(Point pCentral, int quantLados) {
		vertices = new Point[quantLados];

		constroiPoligono(pCentral);
	}  */

        /*private void constroiPoligono(Point pInicial){

                Point point0 = new Point(pInicial.x, pInicial.y);
                defineVertices(point0, 0);
        }       */

        private void defineVertices(Point pp, int pIndex, Graphics g){
                 double alfa,beta,m,angulo;
                 double parcial1, parcial2, parcial3, parcial4;
                 int vX,vY;



                if(pIndex < quantLados){

                  if(quantLados != 4) {
                    vertices[pIndex] = new Point((pp.x + pCentral.x), (pp.y + pCentral.y));

                    alfa = grausToRadianos((360/quantLados));
                    beta = (alfa * (pIndex + 1)) + grausToRadianos(90);

                    if( (beta == grausToRadianos(270)) || (beta == grausToRadianos(90)) ) {
                           m = 0;
                    } else {
                           m = Math.tan(beta);
                    }

                    parcial1 = Math.cos(alfa) * Math.pow(RAIO,2);
                    parcial4 = pp.x + (m * pp.y);

                  //calcula novo ponto
                    vX = (int) ((parcial1) / parcial4);

                    if( beta == grausToRadianos(270) ){
                           vY = (int) -(RAIO);
                           vX = 0;
                    } else {
                           vY = (int) (m * vX);
                    }

                    Point novoPonto = new Point(vX, vY);

                    defineVertices(novoPonto, pIndex + 1, g);

                  } else {
                    vertices[0] = new Point(pCentral.x, (RAIO + pCentral.y));
                    vertices[1] = new Point((pCentral.x - RAIO), pCentral.y);
                    vertices[2] = new Point(pCentral.x, (pCentral.y - RAIO));
                    vertices[3] = new Point((RAIO + pCentral.x), pCentral.y);
                  }

                }
        }

        private double grausToRadianos(double graus){
                return Math.PI*graus/180;
        }

        public void paint(Graphics g) {

             int[] xs = new int[vertices.length];
             int[] ys = new int[vertices.length];

             String xBla, yBla;

             for(int i = 0; i < vertices.length; i++) {
                xs[i] = vertices[i].x;
                ys[i] = vertices[i].y;

                //xBla = (vertices[i].x).toString();
                //yBla = (vertices[i].y).toString();

                //g.drawString(vertices[i].x + ", " + vertices[i].y, 10, (i+1) * 10);
             }
             g.drawPolygon(xs, ys, vertices.length);
        }
}