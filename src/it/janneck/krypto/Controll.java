/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.janneck.krypto;

import it.janneck.krypto.ciphers.symetric.EinfacheSymetrischeKrypto;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Janna
 */
public class Controll {

    private ArrayList<ModulInterface> moduls;
    private Scanner in = new Scanner(System.in);
    private int lastInput;
    private int currentMod = 0;

    public Controll() {
        moduls = new ArrayList<>();
        initModuls();
        while (true) {
            mainConsole();
        }
    }

    private void mainConsole() {
        System.out.println("Wilkommen");
        System.out.println("Bitte Wählen sie eines der Folgenden Module");
        int i = 1;
        for (ModulInterface m : this.moduls) {
            System.out.println("[" + i + "] " + m.getName());
            i++;
        }
        this.getInputInRange(this.moduls.size());
        this.currentMod = this.lastInput - 1;
        System.out.println();
        System.out.println("Bitte Wählen sie eine der Folgenden Funktionen");
        i = 1;
        for (String s : moduls.get(this.lastInput - 1).getFunktions()) {
            System.out.println("[" + i + "] " + s);
            i++;
        }
        this.getInputInRange(moduls.get(this.currentMod).getFunktions().size());
        moduls.get(this.currentMod).executeCommand(this.lastInput, in);
        System.out.println();

    }

    private void getInputInRange(int max) {
        this.lastInput = in.nextInt();
        while (lastInput > max || lastInput < 0) {
            System.out.println("Bitte Wählen sie eine Option zwischen 1 und " + max);
            this.lastInput = in.nextInt();
        }
    }

    private void initModuls() {
        moduls.add(new EinfacheSymetrischeKrypto());
    }

}
