/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.Point;
import java.awt.image.SampleModel;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JCheckBox;
import models.Sensors;
import models.Targets;

/**
 *
 * @author elive
 */
public class FuncoesDiversas {

    private int maximo;
    private int minimo;

    public FuncoesDiversas(int minimo, int maximo) {
        this.minimo = minimo;
        this.maximo = maximo;
    }

    public int gerarNumeroAleatorio() {
        Random random = new Random();
        return random.nextInt((maximo - minimo) + 1) + minimo;
    }

    public int randomGenerateWitchCheckbox(JCheckBox chk, int num) {

        if (chk.isSelected()) {
            Random random = new Random();
            return random.nextInt((maximo - minimo) + 1) + minimo;
        } else {
            return num;
        }
    }

    public ArrayList generateRandomSensors(ArrayList<Sensors> sensor, ArrayList<Integer> vars, JCheckBox chk) {
        int numSensors = vars.get(0);
        int angulo = vars.get(1);
        int distancia = vars.get(2);

        for (int i = 0; i < numSensors; i++) {
            //FuncoesDiversas fdPosition = new FuncoesDiversas(distA, distB);
            FuncoesDiversas fdAngles = new FuncoesDiversas(-angulo, angulo);
            Sensors s = new Sensors(i, new Point(gerarNumeroAleatorio(), gerarNumeroAleatorio()),
                    fdAngles.randomGenerateWitchCheckbox(chk, angulo), distancia);
            sensor.add(s);
        }

        return sensor;
    }

    public ArrayList generateRandomTargets(ArrayList<Targets> target, int numTarget) {
        for (int i = 0; i < numTarget; i++) {

            int nx = gerarNumeroAleatorio();
            int ny = gerarNumeroAleatorio();
            Targets t = new Targets(i, new Point(nx, ny));
            target.add(t);

        }
        return target;
    }
}
