/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.Random;
import javax.swing.JCheckBox;

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

}
