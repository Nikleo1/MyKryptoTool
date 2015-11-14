/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.janneck.krypto.ciphers.symetric;

import it.janneck.krypto.tools.Stringtools;
import java.math.BigInteger;
import java.util.ArrayList;

/**
 *
 * @author Nikals
 */
public class AffineVerschluesselung {

    private BigInteger modulus;
    
    public String getKeyByBruteForceKnownString(String enc,  String dec){
        
        return this.getKeyByBruteForceWithKnownPlaintext(Stringtools.StringToIntOnlyLetters26(enc), Stringtools.StringToIntOnlyLetters26(dec), 26);
    }
    
    public String getKeyByBruteForceWithKnownPlaintext(ArrayList<Integer> enc, ArrayList<Integer> dec, int mod) {
        
        if (enc.size() != dec.size()) {
            return "Unterschiedliche Länge";
        }
        modulus = new BigInteger("" + mod);
        ArrayList<BigInteger> aSpace = new ArrayList();
        //Get all possible As
        for (int i = 1; i < mod; i++) {
            BigInteger h = new BigInteger("" + i);
            if (h.gcd(modulus).intValue() == 1) {
                aSpace.add(h);
            }
        }
        for (BigInteger a : aSpace) {
            for (int i = 1; i < mod; i++) {
                boolean match = true;
                for (int j = 0; j < enc.size() && match; j++) {
                    if (enc.get(j) >= 0) {
                        if (this.decrypt(enc.get(j), a, i) != dec.get(j)) {
                            match = false;
                        }
                    }
                }
                if (match) {
                    return "a = " + a.toString() + " b = " + i;
                }
            }

        }

        return "Kein Ergebniss gefunden";
    }

    public String decryptString(String string, int a, int b) {
        this.modulus = new BigInteger("" + 26);
        BigInteger a1 = new BigInteger("" + a);
        ArrayList<Integer> decrypted = new ArrayList<>();
        for (int enc : Stringtools.StringToIntOnlyLetters26(string)) {
            decrypted.add(this.decrypt(enc, a1, b));
        }

        return Stringtools.IntToStringOnlyLetters26(decrypted);
    }

    private int decrypt(int enc, BigInteger a, int b) {
        if (enc >= 0) {
            int res = (enc - b);
            BigInteger result = new BigInteger("" + res);
            result = result.multiply(a.modInverse(modulus));
            return result.mod(modulus).intValue();
        } else {
            return enc;
        }
    }

    public void setModulus(BigInteger modulus) {
        this.modulus = modulus;
    }

}
