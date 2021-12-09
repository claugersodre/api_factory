package com.enterprise.config;

import java.util.Base64;
//Return if token is from admin or not
public class GetParamtersToken{

    public static Boolean getparameterAdmin(String token) {
        String[] chunks1 = token.split(" ");
        String[] chunks = chunks1[1].split("\\.");
        Base64.Decoder decoder = Base64.getDecoder();

        String header = new String(decoder.decode(chunks[0]));
        String payload = new String(decoder.decode(chunks[1]));
       // System.out.println((payload));
        String[] admim = payload.split(",");
       // System.out.println(admim[1]);
        String[] value = admim[1].split(":");
      //  System.out.println(value[1]);
        if (value[1].equals("true")){
            return true;
        }         else{
            return false;
        }
    }


}
