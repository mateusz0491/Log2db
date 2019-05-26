package com.badsoft.android.log2db.entityservice;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.badsoft.android.log2db.entity.DaoMaster;
import com.badsoft.android.log2db.entity.LOG;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.greenrobot.greendao.database.Database;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogService {
    static final String DBNAME = "LOGDB";

    private static String ERROR = "ERROR";
    private static String INFO = "INFO";
    private static String DEBUG = "DEBUG";

    /**
     * Init logger and create SQLite database
     *
     * @param context application Context
     */
    public static void init(Context context) {
        File dbFile = context.getDatabasePath(DBNAME);
        Database db;
        if (dbFile.exists()) {
            SQLiteDatabase sqlDb = SQLiteDatabase.openDatabase(
                    context.getDatabasePath(DBNAME).getAbsolutePath(), null,
                    SQLiteDatabase.OPEN_READONLY);
            int oldVersion = sqlDb.getVersion();
            sqlDb.close();
            DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, DBNAME);
            db = helper.getWritableDb();
            int newVersion = new DaoMaster(db).getSchemaVersion();
            if (oldVersion != newVersion) {
                helper.onUpgrade(db, oldVersion, newVersion);
            }
        } else {
            DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, DBNAME);
            db = helper.getWritableDb();
        }

        Logger logger = Logger.getInstance();

        logger.setContext(context);
        logger.setDaoSession(new DaoMaster(db).newSession());

    }
    public static void dropAllTables(Context context) {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, DBNAME);
        DaoMaster.dropAllTables(helper.getWritableDb(), true);
    }

    /**
     * Write exception to log with type ERROR
     *
     * @param code message code from app or server exception (example: EXC12345, SOAPERROR).
     *             Can be null.
     * @param e    exception do insert in database
     */
    public static void e(@Nullable String code, Exception e) {
        LOG log = initLog(code);

        log.setSTACKTRACE(ExceptionUtils.getStackTrace(e));
        log.setMESSAGE(ExceptionUtils.getMessage(e));
        log.setTYPE(ERROR);
        Logger.getInstance().inserLog(log);
    }


    /**
     * Write message to log with type INFO
     *
     * @param message message do insert in database
     */
    public static void i(String message) {
        LOG log = initLog(null);
        log.setMESSAGE(message);
        log.setTYPE(INFO);
        Logger.getInstance().inserLog(log);
    }

    /**
     * Write message to log with type DEBUG
     *
     * @param message message do insert in database
     */
    public static void d(String message) {
        LOG log = initLog(null);
        log.setMESSAGE(message);
        log.setTYPE(DEBUG);
        Logger.getInstance().inserLog(log);
    }

    private static LOG initLog(String code) {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

        LOG log = new LOG();
        log.setCREATEDATE(date);
        log.setPREETYDATE(dateFormat.format(date));
        log.setCODE(code);
        return log;
    }
}
