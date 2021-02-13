package dev.emii.betterjson.components;

import dev.emii.betterjson.utils.Serializer;

import java.util.ArrayList;
import java.util.HashMap;

public class StringModel<T>{

    HashMap<String, T> content;


    public StringModel(HashMap<String, T> content) {
        this.content = content;
    }

    public HashMap<String, T> getContent() {
        return content;
    }

    @Override
    public String toString() {
        return Serializer.serialize(this);
    }
}
