package com.mwr.businesslogic;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;


public class TokenGenerator {
    
    public String generateToken(String mac,String uid, String serial,String password) throws NoSuchAlgorithmException
    {
        String composite =mac+uid+serial;
        MessageDigest digester = MessageDigest.getInstance("MD5");
        byte[] hash = digester.digest(composite.getBytes());
        StringBuilder builder = new StringBuilder(2*hash.length);
        for (byte b : hash)
        {
            builder.append(String.format("%02x",b&0xff));
        }
        String hashkeyComposite = builder.toString();
        Logger.getLogger(TokenGenerator.class.getName()).info("Haskkey=" + hashkeyComposite);

        String finalHash = hashkeyComposite + password;        
        byte[] hash3 = digester.digest(finalHash.getBytes());
        builder = new StringBuilder(2*hash3.length);
        for (byte b : hash3)
        {
            builder.append(String.format("%02x",b&0xff));
        }
        String hashkeyFinal = builder.toString();
         Logger.getLogger(TokenGenerator.class.getName()).info("haskey2=" + hashkeyFinal);
        int skip = Math.round((float)hashkeyFinal.length()/5);
        int index = 0;
        String token = "";
        for (int i=0;i<5;i++)
        {
                token += hashkeyFinal.charAt(index);
                index += skip;
        }
        return token;
    }
    
}
