package dev.emii.betterjson.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Data {

    public static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static boolean exists(File file) {
        if (file.exists()) return true;
        else return file.mkdirs();
    }

    public static boolean exists(File path, boolean create) {
        if (path.exists()) return true;
        else {
            if (create) {
                try {
                    if(!path.getParentFile().exists())path.getParentFile().mkdirs();
                    return ( path.createNewFile());
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
        }
        return false;
    }

    public static void toJSON(IData source, File sourceFile) throws IOException {
        OutputStreamWriter fileWriter;
        BufferedWriter buffWritter;
        File file = new File(sourceFile, source.getClass().getSimpleName().concat(".json"));
        boolean created = exists(file, true);
        System.out.println("has created: " + created);
        if(created){
            fileWriter = new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8);
            buffWritter = new BufferedWriter(fileWriter);
            buffWritter.write(gson.toJson(source));

            buffWritter.close();
            fileWriter.close();
        }
    }

    public static IData toClass(IData source, File sourceFile) throws IOException {
        BufferedReader bufferLectura;
        FileReader flujoLectura;
        String linea;
        File file = new File(sourceFile, source.getClass().getSimpleName().concat(".json"));
        if (file.exists() && exists(sourceFile)) {
            flujoLectura = new FileReader(file);
            bufferLectura = new BufferedReader(flujoLectura);
            StringBuilder ss = new StringBuilder();
            linea = bufferLectura.readLine();
            while (linea != null) {
                ss.append(linea);
                linea = bufferLectura.readLine();
            }

            IData dataModel = gson.fromJson(ss.toString(), source.getClass());

            return dataModel;
        }else{
            source.add();
            source.save();
            return toClass(source, sourceFile);
        }
    }

    public boolean save(File file) {
        return true;
    }

}
