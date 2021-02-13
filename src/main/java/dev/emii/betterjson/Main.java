package dev.emii.betterjson;

import dev.emii.betterjson.components.StringModel;
import dev.emii.betterjson.test.Message;
import dev.emii.betterjson.utils.Serializer;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        //StringModel<String> ad = Serializer.unserializer("ho.la.ja.lo.ll", "HOLA");
        //System.out.println(ad.getContent().toString());

        String value = "ho.la.ja.lo.ll";
        value = value.substring(1, value.length() - 1);           //remove curly brackets
        String[] keyValuePairs = value.split("\\.");              //split the string to creat key-value pairs
        Map<String, HashMap> map = new HashMap<>();

        for (int i = 0; i < keyValuePairs.length; i++) {
            String pair = keyValuePairs[i];
            HashMap<String, Object> map2 = new HashMap<>();
            if(i < keyValuePairs.length - 1){
                String pair2 = keyValuePairs[i+=1];
                if(i < keyValuePairs.length - 2){
                    String pair3 = keyValuePairs[(i+=2)];
                    map2.put(pair2, pair3);
                }else{
                    map2.put(pair2, "hola");
                }
            }
            map.put(pair, map2);
        }
        System.out.println(map.toString());
    }

}
