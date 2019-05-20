package com.badsoft.android.log2db.entityservice;

import android.content.Context;

import com.badsoft.android.log2db.entity.DaoSession;
import com.badsoft.android.log2db.entity.LOG;

public class Logger {
    private volatile static Logger instance;
    private DaoSession daoSession;
    private Context context;

    private Logger(){};

    static synchronized Logger getInstance() {
        if (instance == null)
            synchronized (LogService.class) {
                if (instance == null)
                    instance = new Logger();
            }
        return instance;
    }

    void setContext(Context context) {
        this.context = context;
    }

    public void setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
    }

    public void inserLog(LOG log) {
        daoSession.getLOGDao().insert(log);
    }
}
