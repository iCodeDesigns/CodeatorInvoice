/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._0_1_CodeatorLib.Hashing;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author cdc
 */
public class hashing_algorithm_class {

    //Available algorithms are : MD2 , MD5 , SHA-1 , SHA-224 , SHA-256 , SHA-384 , SHA-512 
    private final String algorithm;

    /**
     *
     * @param algorithm : Available algorithms are : Hash_Algorithm.MD2 ,
     * Hash_Algorithm.MD5 , Hash_Algorithm.SHA_1 , Hash_Algorithm.SHA_224 ,
     * Hash_Algorithm.SHA_256 , Hash_Algorithm.SHA_384 , Hash_Algorithm.SHA_512
     */
    public hashing_algorithm_class(String algorithm) {
        this.algorithm = algorithm;
    }

    public String getHash(byte[] inputBytes) {
        String hashValue = "123";
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(this.algorithm);
            byte[] digestedBytes = messageDigest.digest(inputBytes);
            hashValue = DatatypeConverter.printHexBinary(digestedBytes);
        } catch (Exception e) {

        }
        return hashValue;
    }

    /**
     * For Testing The Hashing Algorithm
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            String text = "123";
            hashing_algorithm_class h = new hashing_algorithm_class("SHA-256");
            String hash_of_json = h.getHash(text.getBytes(StandardCharsets.UTF_8));
            System.out.println(hash_of_json);
            System.out.println(hash_of_json.length());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
