package com.example;

import java.io.File;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Property;
import de.greenrobot.daogenerator.Schema;
import de.greenrobot.daogenerator.ToMany;

public class Generator {
    public static void main(String[] args) throws Exception {
        Schema schema = new Schema(8, "com.example.airnavigate.Dao");
        schema.enableKeepSectionsByDefault();
        addTopic(schema);
        addDeputy(schema);

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
        Entity deputy = schema.addEntity("Deputy");
        deputy.addIdProperty().notNull();//autoincrement();
        deputy.addStringProperty("name");
        deputy.addStringProperty("family");
        deputy.addStringProperty("patronymic");
        deputy.addStringProperty("birthdate");
        deputy.addStringProperty("credentialsStart");
        deputy.addStringProperty("credentialsEnd");
        deputy.addStringProperty("factionId");
        deputy.addStringProperty("factionName");
        deputy.addStringProperty("factionRole");
        deputy.addStringProperty("partyNameInstr");
        deputy.addBooleanProperty("isActual").notNull();
        deputy.addStringProperty("homePage");
        deputy.addStringProperty("factionRegion");
        deputy.addStringProperty("nameGenitive");
        deputy.addStringProperty("familyAndInitials");
        deputy.addStringProperty("voteLink");
        deputy.addStringProperty("transcriptLink");
        deputy.addIntProperty("lawcount");
        deputy.addIntProperty("speachCount");
       // Property deputyIdForDeputy = deputy.addLongProperty("deputyId").notNull().getProperty();

        Entity education = schema.addEntity("Education");
        //education.setTableName("EDUCATIONS");
        education.addStringProperty("institution");
        education.addStringProperty("year");
        Property educationId = education.addLongProperty("deputyId").notNull().getProperty();
//        education.addToOne(deputy, educationId);

        Entity activity = schema.addEntity("Activity");
       // activity.setTableName("ACTIVITIES");
        activity.addStringProperty("name");
        activity.addStringProperty("subdivisionNameGenitive");
        activity.addIntProperty("subdivisionId");
//        Property activityId = activity.addLongProperty("activityId").notNull().getProperty();
//        activity.addToOne(deputy, activityId);

        ToMany deputyToEducations = deputy.addToMany(education, educationId);
        deputyToEducations.setName("educations");
    }
}
