package edu.upm.security.cryptography;

import javax.swing.*;

/**
 * Utility class to encrypt and decrypt a text.
 *
 * @author David Haioum
 */
public class Cryptorithm {
    /**
     * Encrypt a plaintext string with a custom cryptographic algorithm.
     *
     * @param plaintext text to encipher
     * @return ciphertext of the plaintext
     */
    public static String encrypt(final String plaintext) {
        // each character is represented by a binary string
        String[] asciiArray = new String[plaintext.length()];
        // use a string builder to join the result of each character
        StringBuilder builder = new StringBuilder();

        // for each characters
        for (int i = 0; i < asciiArray.length; i++) {
            // replace each alphabet with its equivalent 7-bit ASCII code
            asciiArray[i] = Integer.toBinaryString(plaintext.charAt(i));

            // Add a 0 bit at the leftmost bit to make each of the above bit patterns 8 position long.
            asciiArray[i] = "0".repeat(8 - asciiArray[i].length()) + asciiArray[i];

            // Swap the first four bits with the last four bits for each alphabet.
            asciiArray[i] = asciiArray[i].substring(4, 8) + asciiArray[i].substring(0, 4);

            // Write the hexadecimal equivalent of every for bits
            asciiArray[i] = Integer.toString(Integer.parseInt(asciiArray[i], 2), 16);

            // Add a 0 bit at the leftmost bit to make each of the above hex patterns 2 position long.
            asciiArray[i] = "0".repeat(2 - asciiArray[i].length()) + asciiArray[i];

            // add the string to the builder for joining
            builder.append(asciiArray[i].toUpperCase());
        }

        // join the resulted characters
        return builder.toString();
    }

    /**
     * Decrypt a ciphertext string with a custom cryptographic algorithm.
     *
     * @param ciphertext text to decipher
     * @return plaintext
     */
    public static String decrypt(final String ciphertext) {
        // use a string builder to join the result of each character
        StringBuilder builder = new StringBuilder();
        // string array for the dialog view
        StringBuilder hexList = new StringBuilder();
        hexList.append("Convert the Hexadecimal to Binary Number :\n");

        //separate the text in 2-position long hexadecimal number
        String[] hexArray = ciphertext.split("(?<=\\G..)");

        // for every hexadecimal numbers
        for (String str : hexArray) {
            String viewString = str;

            //get the binary string from hexadecimal string
            str = Integer.toBinaryString(Integer.parseInt(str, 16));

            // Add a 0 bit at the leftmost bit to make each of the above bit patterns 8 position long.
            str = "0".repeat(8 - str.length()) + str;

            //add the binary string to the view string
            viewString = viewString + ": " + str + "\n";

            // Swap the first four bits with the last four bits for each alphabet.
            str = str.substring(4, 8) + str.substring(0, 4);

            //retrieve ascii code of the binary string and convert it to plaintext
            str = Character.toString((char) Integer.parseInt(str, 2));

            // add the string to the builder for joining
            builder.append(str);

            hexList.append(viewString);
        }

        JOptionPane.showMessageDialog(new JFrame(),
                hexList.toString(),
                "Decryption Algorithm",
                JOptionPane.INFORMATION_MESSAGE);

        // join the resulted characters
        return builder.toString();
    }
}
