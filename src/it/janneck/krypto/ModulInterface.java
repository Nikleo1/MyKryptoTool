/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.janneck.krypto;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Janna
 */
public interface ModulInterface {
    public String getName();
    public ArrayList<String> getFunktions();
    public void executeCommand(int command, Scanner in);
    
}
