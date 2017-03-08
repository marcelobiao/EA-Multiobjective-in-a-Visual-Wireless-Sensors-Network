/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import models.Sensors;
import models.Targets;

/**
 *
 * @author elive
 */
public class ImportExportFile {

    private File file;

    public ImportExportFile(File file) {
        this.file = file;
    }

    public void openFile(ArrayList<Sensors> sensor, ArrayList<Targets> target) {

        FileReader fr = null;
        sensor.clear();
        target.clear();
        int countSensors = 0;
        int countTargets = 0;

        try {

            fr = new FileReader(file);
            BufferedReader bfr = new BufferedReader(fr);
            String line = "";

            while ((line = bfr.readLine()) != null) {
                String[] lines = line.split(" ");
                if ("SENSORES".equals(line)) {
                    line.split(" ");
                    //line = bfr.readLine();
                    while (!"ALVOS".equals(line = bfr.readLine())) {
                        lines = line.split(";");
                        int x = Integer.parseInt(lines[0]);
                        int y = Integer.parseInt(lines[1]);
                        int angulo = Integer.parseInt(lines[2]);
                        int alcance = Integer.parseInt(lines[3]);
                        Sensors s = new Sensors(countSensors, new Point(x, y), angulo, alcance);
                        sensor.add(s);
                        countSensors++;
                        //line = bfr.readLine();
                    }
                }
                if ("ALVOS".equals(line)) {
                    //line = bfr.readLine();
                    while (!"END".equals(line = bfr.readLine())) {
                        lines = line.split(";");
                        int x = Integer.parseInt(lines[0]);
                        int y = Integer.parseInt(lines[1]);
                        Targets t = new Targets(countTargets, new Point(x, y));
                        target.add(t);
                        countTargets++;
                        //line = bfr.readLine();
                    }
                }

            }

            JOptionPane.showMessageDialog(null, "Dados importados com êxito!", "Informação.", javax.swing.JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            System.out.println("Erro na importação: " + e.getMessage());
            e.printStackTrace();
        }

    }

    public void saveFile(ArrayList<Sensors> sensor, ArrayList<Targets> target) {

        FileWriter fw = null;

        try {
            fw = new FileWriter(file);

            if (fw == null) {
                JOptionPane.showMessageDialog(null, "Nome de Arquivo Inválido", "Erro.", javax.swing.JOptionPane.ERROR_MESSAGE);
            } else {
                PrintWriter pw = new PrintWriter(fw);
                pw.println("SENSORES");
                for (Sensors s : sensor) {
                    pw.println(s.getPonto().x + ";" + s.getPonto().y + ";" + s.getAngulo() + ";" + s.getAlcance());
                }

                pw.println("ALVOS");
                for (Targets t : target) {
                    pw.println(t.getPonto().x + ";" + t.getPonto().y);
                }
                pw.println("END");
                fw.close();
                pw.close();
                JOptionPane.showMessageDialog(null, "Dados exportados com êxito!", "Informação.", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (Exception e) {
            System.out.println("Erro na exportação: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
