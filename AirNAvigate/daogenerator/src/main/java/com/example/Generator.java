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

    private static void addDeputy(Schema schema) {
        Entity topic = schema.addEntity("Deputy");
        topic.addIdProperty().notNull();//autoincrement();
        topic.addStringProperty("name");
        topic.addStringProperty("family");
        topic.addStringProperty("patronymic");
        topic.addStringProperty("birthdate");
        topic.addStringProperty("credentialsStart");
        topic.addStringProperty("credentialsEnd");
        topic.addStringProperty("factionId");
        topic.addStringProperty("factionName");
        topic.addStringProperty("factionRole");
        topic.addStringProperty("partyNameInstr");
        topic.addBooleanProperty("isActual").notNull();
        topic.addStringProperty("homePage");
        topic.addStringProperty("factionRegion");
        topic.addStringProperty("nameGenitive");
        topic.addStringProperty("familyAndInitials");
        topic.addStringProperty("voteLink");
        topic.addStringProperty("transcriptLink");
        topic.addIntProperty("lawcount");
        topic.addIntProperty("speachCount");
    }

    private static void addActivity(Schema schema) {
        Entity topic = schema.addEntity("Topic");
        topic.addIdProperty().notNull();//autoincrement();
        topic.addStringProperty("name");
    }
}
