package com.badsoft.android.log2db.entityservice;

import android.content.Context;

import com.badsoft.android.log2db.entity.DaoMaster;
import com.badsoft.android.log2db.entity.LOG;

import org.greenrobot.greendao.database.Database;

import java.util.Date;

public class LogService {
    static final String DBNAME = "LOGDB";

    public static void init(Context context) {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, DBNAME);
        Database db = helper.getWritableDb();
        Logger logger = Logger.getInstance();
        logger.setContext(context);
        logger.setDaoSession(new DaoMaster(db).newSession());
    }
    public static void dropAllTables(Context context) {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, DBNAME);
        DaoMaster.dropAllTables(helper.getWritableDb(), true);
    }

    public static void e(Exception e) {
        LOG log = new LOG();
        log.setCREATEDATE(new Date());
        log.setMESSAGE(e.getStackTrace().toString());
        log.setMESSAGE(e.getMessage());
        Logger.getInstance().inserLog(log);
    }
}
