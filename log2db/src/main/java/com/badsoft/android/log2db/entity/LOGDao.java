package com.badsoft.android.log2db.entity;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "LOG".
*/
public class LOGDao extends AbstractDao<LOG, Long> {

    public static final String TABLENAME = "LOG";

    /**
     * Properties of entity LOG.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property CODE = new Property(1, String.class, "CODE", false, "CODE");
        public final static Property CREATEDATE = new Property(2, java.util.Date.class, "CREATEDATE", false, "CREATEDATE");
        public final static Property MESSAGE = new Property(3, String.class, "MESSAGE", false, "MESSAGE");
        public final static Property STACKTRACE = new Property(4, String.class, "STACKTRACE", false, "STACKTRACE");
        public final static Property TYPE = new Property(5, String.class, "TYPE", false, "TYPE");
    }


    public LOGDao(DaoConfig config) {
        super(config);
    }
    
    public LOGDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"LOG\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"CODE\" TEXT," + // 1: CODE
                "\"CREATEDATE\" INTEGER NOT NULL ," + // 2: CREATEDATE
                "\"MESSAGE\" TEXT," + // 3: MESSAGE
                "\"STACKTRACE\" TEXT," + // 4: STACKTRACE
                "\"TYPE\" TEXT);"); // 5: TYPE
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"LOG\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, LOG entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String CODE = entity.getCODE();
        if (CODE != null) {
            stmt.bindString(2, CODE);
        }
        stmt.bindLong(3, entity.getCREATEDATE().getTime());
 
        String MESSAGE = entity.getMESSAGE();
        if (MESSAGE != null) {
            stmt.bindString(4, MESSAGE);
        }
 
        String STACKTRACE = entity.getSTACKTRACE();
        if (STACKTRACE != null) {
            stmt.bindString(5, STACKTRACE);
        }
 
        String TYPE = entity.getTYPE();
        if (TYPE != null) {
            stmt.bindString(6, TYPE);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, LOG entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String CODE = entity.getCODE();
        if (CODE != null) {
            stmt.bindString(2, CODE);
        }
        stmt.bindLong(3, entity.getCREATEDATE().getTime());
 
        String MESSAGE = entity.getMESSAGE();
        if (MESSAGE != null) {
            stmt.bindString(4, MESSAGE);
        }
 
        String STACKTRACE = entity.getSTACKTRACE();
        if (STACKTRACE != null) {
            stmt.bindString(5, STACKTRACE);
        }
 
        String TYPE = entity.getTYPE();
        if (TYPE != null) {
            stmt.bindString(6, TYPE);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public LOG readEntity(Cursor cursor, int offset) {
        LOG entity = new LOG( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // CODE
            new java.util.Date(cursor.getLong(offset + 2)), // CREATEDATE
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // MESSAGE
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // STACKTRACE
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5) // TYPE
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, LOG entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setCODE(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setCREATEDATE(new java.util.Date(cursor.getLong(offset + 2)));
        entity.setMESSAGE(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setSTACKTRACE(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setTYPE(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(LOG entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(LOG entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(LOG entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}