/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.janneck.krypto.ciphers.symetric;

import it.janneck.krypto.ModulInterface;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Janna
 */
public class EinfacheSymetrischeKrypto implements ModulInterface{
    ArrayList<String> commands;
    AffineVerschluesselung av;
    public EinfacheSymetrischeKrypto(){
        av = new AffineVerschluesselung();
        commands = new ArrayList<>();
        commands.add("Affine decrypt mod 26");
        commands.add("Affine bruteforce");
    }

    @Override
    public String getName() {
        return "Einfache Sym. Krypto";
    }

    @Override
    public ArrayList<String> getFunktions() {
        return commands;
    }

    @Override
    public void executeCommand(int command, Scanner in) {
        if(command == 1){

            System.out.println("Bitte gebe a an :");
            int a = in.nextInt();
            System.out.println("Bitte gebe b an :");
            int b = in.nextInt();
            in.nextLine();
            System.out.println("Bitte gebe den ciphertext ein :");
            String cipherText =  in.nextLine();
            System.out.println("k=("+a+","+b+") Ciphertext: "+ cipherText);
            System.out.println("Decrypted : " + av.decryptString(cipherText, a, b));
            in.nextLine();
        }else if(command == 2){
            in.nextLine();
            System.out.println("Bitte gebe den ciphertext ein :");
            String cipherText =  in.nextLine();
            System.out.println("Bitte gebe den knownPlaintext ein :");
            String known =  in.nextLine();
            System.out.println("Key : " + av.getKeyByBruteForceKnownString(cipherText, known));
            in.nextLine();
        }
    }
    
}
