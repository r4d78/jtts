/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author dni
 */
public class Secure {
    public static String encodePassword(String origPassword){
        String returnValue = "";
        try{
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] digest = md.digest(origPassword.getBytes());
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < digest.length; i++){
                String tmp = Integer.toHexString(digest[i] & 0xff);
                if (tmp.length() == 1){
                    builder.append('0').append(tmp);
                }else{
                    builder.append(tmp);
                }
            }
            returnValue = builder.toString();
        }catch(NoSuchAlgorithmException ex){
            System.out.println("error");
        }
        return returnValue;
    }
}
