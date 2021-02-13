package dev.emii.betterjson.test;

import dev.emii.betterjson.components.DataModel;
import dev.emii.betterjson.components.StringModel;
import dev.emii.betterjson.data.IData;
import dev.emii.betterjson.utils.Serializer;

import java.io.File;;

public class Message extends DataModel {


    public Message() {
        super();
    }

    @Override
    public IData save() {
        StringModel<String> ad = Serializer.unserializer("ho.la.ja.lo.ll", "HOLA");
        System.out.println(ad.getContent().toString());
        this.add(ad);
        return super.save();
    }
}
