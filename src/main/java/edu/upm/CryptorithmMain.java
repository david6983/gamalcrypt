package edu.upm;

import edu.upm.security.cryptography.Cryptorithm;

import javax.swing.*;
import java.util.Scanner;

/**
 * Simple interface tester for the cryptorithm algorithm.
 *
 * @author David Haioum
 */
public class CryptorithmMain {

    public static void main(String[] args) {
        /*
        String plaintext = JOptionPane.showInputDialog(new JFrame(),
                "Please enter a message for encryption",
                "Input",
                JOptionPane.QUESTION_MESSAGE);

        System.out.println(Cryptorithm.encrypt(plaintext));
        JOptionPane.showMessageDialog(new JFrame(),
                "The ciphertext for the message (Hexadecimal Form): \n" + Cryptorithm.encrypt(plaintext),
                "Output",
                JOptionPane.INFORMATION_MESSAGE);

        String ciphertext = JOptionPane.showInputDialog(new JFrame(),
                "Please enter a ciphertext for decryption",
                "Input",
                JOptionPane.QUESTION_MESSAGE);

        JOptionPane.showMessageDialog(new JFrame(),
                "The original message for the ciphertext is : " + Cryptorithm.decrypt(ciphertext),
                "Output",
                JOptionPane.INFORMATION_MESSAGE);

         */
        Scanner sc = new Scanner(System.in);
        System.out.println("Message to ecrypt: ");
        String msg = sc.next();
        System.out.print("Encrypted message : ");
        String cypher = Cryptorithm.encrypt(msg);
        System.out.println(cypher);
        System.out.print("Decryption of the message : ");
        System.out.println(Cryptorithm.decrypt(cypher));
    }
}
