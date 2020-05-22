package com.badsoft.android.badgenerator;

import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Schema;
public class MainClass {

    private static int SCHEMAVERSON = 2;

    public static void main(String[] args) {
        // Your app package name and the (.db) is the folder where the DAO files will be generated into.
        Schema schema = new Schema(SCHEMAVERSON, "com.badsoft.android.log2db.entity");
        schema.enableKeepSectionsByDefault();

        addTables(schema);

        try {
            new DaoGenerator().generateAll(schema,"./log2db/src/main/java");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addTables(final Schema schema) {
        addUserEntities(schema);
        // addPhonesEntities(schema);
    }

    // This is use to describe the colums of your table
    private static Entity addUserEntities(final Schema schema) {
        Entity log = schema.addEntity("LOG");
        log.addIdProperty().primaryKey().autoincrement();
        log.addStringProperty("CODE");
        log.addDateProperty("CREATEDATE").notNull();
        log.addStringProperty("PREETYDATE");
        log.addStringProperty("MESSAGE");
        log.addStringProperty("STACKTRACE");
        log.addStringProperty("TYPE");
        log.implementsSerializable();
        return log;
    }
}
