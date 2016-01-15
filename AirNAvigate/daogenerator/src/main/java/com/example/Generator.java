package com.example;

import java.io.File;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class Generator {
    public static void main(String[] args) throws Exception {
        Schema schema = new Schema(8, "com.example.airnavigate.Dao");
        schema.enableKeepSectionsByDefault();
        addTopic(schema);

        File outDir = null;
        String[] paths = {"../app/src/main/java", "app/src/main/java"};

        for (String path : paths) {
            outDir = new File(path);
            if (outDir.exists()) {
                break;
            }
        }
        if (outDir == null) {
            throw new IllegalStateException();
        }

        new DaoGenerator().generateAll(schema, outDir.getPath());
    }

    private static void addTopic(Schema schema) {
        Entity topic = schema.addEntity("Topic");
        topic.addIdProperty().notNull();//autoincrement();
        topic.addStringProperty("name");
    }
}
