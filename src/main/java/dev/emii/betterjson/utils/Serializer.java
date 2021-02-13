package dev.emii.betterjson.utils;

import dev.emii.betterjson.components.StringModel;

import java.util.*;
import java.util.stream.Collectors;

public class Serializer {

    public static StringModel unserializer(String control, Object value) {
        List<String> controlSplit = Arrays.asList(control.split("\\."));
        try {
            HashMap<String, StringModel> contentMap = new HashMap<String, StringModel>();

            System.out.println(control);

            StringModel model = unserializer(String.join(".", controlSplit.subList(1, controlSplit.size())), value);
            if(model.getContent().size() > 2){
                contentMap.put(controlSplit.get(0), model);
            }else if(model.getContent().size() == 2){
                System.out.println("ACA");
            }

            StringModel result = new StringModel<StringModel>(contentMap);

            return result;

        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T> String serialize(StringModel<T> model) {

        System.out.println(model.getContent().toString()); //[sexo, [asd, asd]];
        String result = "";

        HashMap<String, T> in = model.getContent();

        for (String key : in.keySet())
            result += key + in.get(key) + ".";
        result = result.substring(0, result.length() - 1);
        System.out.println(result.replace("{", ".").split("=")[0]);

        return result.replace("{", ".").split("=")[0];
    }
}
