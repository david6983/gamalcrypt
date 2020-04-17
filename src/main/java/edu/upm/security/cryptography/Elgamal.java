package edu.upm.security.cryptography;

import java.util.List;
import java.util.Random;

import static java.lang.Math.pow;

/**
 * ElGamal cryptography algorithm.
 *
 * @author Mathias Boillot
 */
public class Elgamal {

    private int Random_k;
    private int Ya;
    private int C1;
    private int C2;

    public int FindOutYa(int a, int Xa, int p) {
        Ya = (int) pow(a, Xa) % p;
        return Ya;
    }

    public List<Integer> GeneratePublicKey(int p, int a, int Ya) {
        return List.of(p, a, Ya);
    }

    public int GeneratePrivateKey(int Xa) {
        return Xa;
    }

    private int GenerateRandomK(int p) {
        Random r = new Random();
        return r.nextInt(p-1) + 1;
    }

    private int CalculK(int p) {
        return (int) pow(Ya,Random_k) % p;
    }

    private int CalculC1(int a, int p, int K) {
        return (int) pow(a,K) % p;
    }

    private int CalculC2(int M, int p, int K) {
        return (K*M) % p;
    }

    public List<Integer> EncryptM(int a, int M, int p) {
        Random_k = GenerateRandomK(p);
        C1 = CalculC1(a,p,Random_k);
        C2 = CalculC2(M,p,CalculK(p));
        return List.of(C1,C2);
    }

    private int FindOutK(int a, int p, int Xa){
        return (int) pow(C1,Xa) % p;
    }

    public int DecryptM(int a, int p, int Xa, int M) {
       float result = -1;
       int i = 1;
       int tampon = 0;
       while(result != 0) {
           result = ((p*i) + 1);
           tampon = (int) result;
           result %= FindOutK(a,p,Xa);
           i++;
       }

       return (C2 * i) % p;
    }



}
