package dev.emii.betterjson.components;

import dev.emii.betterjson.data.Data;
import dev.emii.betterjson.data.IData;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public abstract class DataModel extends HashMap<String, HashMap<String, StringModel>> implements IData {

    private final File parent;

    public DataModel() {
        this.parent = new File("Z:\\BetterJSON");
    }

    @Override
    public IData save() {
        try {
            Data.toJSON(this, this.parent);
            return this;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public IData load() {
        try {
            return (IData) Data.toClass(this, this.parent);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void reload() {
        load();
        save();
    }

    @Override
    public void add(StringModel... models) {
        Arrays.stream(models).forEach(stringModel -> {
            String[] modelSplit = stringModel.toString().split("\\.");
            try {
                IData dm = add(modelSplit[0], modelSplit[1], stringModel);
                if (dm == null) {
                    throw new Exception("IData can't be null");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        });

    }

    @Override
    public IData add(String parent, String path, StringModel message) {

        String[] pathSplit = parent.split("\\.");

        for (int i = 0; i < pathSplit.length; i++) {

        }

        HashMap<String, StringModel> parentMap = this.getOrDefault(parent, new HashMap<String, StringModel>());

        if (!parentMap.containsKey(path)) {
            parentMap.put(path, message);
        } else {
            parentMap.replace(path, message);
        }
        if (!this.containsKey(parent)) {
            this.put(parent, parentMap);
        } else {
            this.replace(parent, parentMap);
        }

        return this;
    }

    @Override
    public String getString(String path) {
        return null;
    }

    @Override
    public int getInt(String path) {
        return 0;
    }

    @Override
    public double getDouble(String path) {
        return 0;
    }

    @Override
    public float getFloat(String path) {
        return 0;
    }

    @Override
    public boolean getBoolean(String path) {
        return false;
    }

    @Override
    public char getChat(String path) {
        return 0;
    }

    @Override
    public ArrayList getList(String path) {
        return null;
    }

    @Override
    public <T> ArrayList<T> getArrayList(String path, Class<T> listType) {
        return null;
    }
}
