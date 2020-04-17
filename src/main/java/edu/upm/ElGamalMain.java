package edu.upm;

import edu.upm.security.cryptography.Elgamal;

/**
 * Simple test function for ElGamal algorithm.
 *
 * @author Mathias Boillot
 */
public class ElGamalMain {

    public static void main(String[] args) {
        Elgamal key = new Elgamal();
        int a = 10;
        int p = 19;
        int M = 17;
        int Ya = key.FindOutYa(a,5, p);
        System.out.println("Public Key " + key.GeneratePublicKey(p,a, Ya ));
        System.out.println("Private Key " + key.GeneratePrivateKey(5));
        System.out.println("M Encrypted " + key.EncryptM(a,M,p));
        System.out.println("Ciphertext Decripted " + key.DecryptM(a,p,5, M));
    }
}
