package dev.emii.betterjson.data;

import dev.emii.betterjson.components.StringModel;

import java.util.ArrayList;

public interface IData {

    public IData save();

    public IData load();

    public void reload();

    public String getString(String path);

    public int getInt(String path);

    public double getDouble(String path);

    public float getFloat(String path);

    public boolean getBoolean(String path);

    public char getChat(String path);

    public ArrayList getList(String path);

    public <T extends Object> ArrayList<T> getArrayList(String path, Class<T> listType);

    public void add(StringModel... models);

    public IData add(String parent, String path, StringModel message);


}