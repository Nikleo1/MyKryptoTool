/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.janneck.krypto.tools;

import java.util.ArrayList;

/**
 *
 * @author Janna
 */
public class Stringtools {

    public static ArrayList<Integer> StringToIntOnlyLetters26(String toConvert) {
        toConvert = toConvert.toLowerCase();
        ArrayList<Integer> toInt = new ArrayList();
        for (char b : toConvert.toCharArray()) {
            int c = (char) b;
            if (c < 123) {
                toInt.add(c - 97);
            }
        }
  
        return toInt;
    }

    public static String IntToStringOnlyLetters26(ArrayList<Integer> ints) {
        String s = "";
        for (int b : ints) {
            if (b < 26) {
                char c = Character.toChars(b + 97)[0];
                s = s + c;
            }
        }
        return s;
    }

}
