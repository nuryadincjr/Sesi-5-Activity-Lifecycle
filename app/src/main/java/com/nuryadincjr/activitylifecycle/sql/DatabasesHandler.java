package com.nuryadincjr.activitylifecycle.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.nuryadincjr.activitylifecycle.pojo.Hiros;

import java.util.ArrayList;
import java.util.List;

public class DatabasesHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Hiro.db";
    private static final String TABLE_NAME = "tb_hiros";
    private static final String _ID = "id";
    private static final String _NAME = "name";

    public SQLiteDatabase db;
    public ContentValues values;

    public DatabasesHandler(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        final String CRATE_TABLE_ENTRIES = "CREATE TABLE " + TABLE_NAME + " (" +
                _ID + " INTEGER PRIMARY KEY, " +
                _NAME + " TEXT)";

        sqLiteDatabase.execSQL(CRATE_TABLE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        final String DELETE_TABLE_ENTRIES = "DROP TABLE IF EXISTS " + TABLE_NAME;

        sqLiteDatabase.execSQL(DELETE_TABLE_ENTRIES);
        onCreate(sqLiteDatabase);
    }

    public void insert(Hiros hiros) {
        db = this.getWritableDatabase();
        values = new ContentValues();

        values.put(_ID, hiros.getId());
        values.put(_NAME, hiros.getNama());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public void delete(String id) {
        db = this.getWritableDatabase();
        db.delete(TABLE_NAME, _ID + "=?",
                new String[] {id});
        db.close();
    }

    public void update(Hiros hiros) {
        db = this.getWritableDatabase();
        values = new ContentValues();

        values.put(_NAME, hiros.getNama());
        db.update(TABLE_NAME, values, _ID + "=?",
                new String[] {String.valueOf(hiros.getId())
        });
        db.close();
    }
//
    public ArrayList<Hiros> retrive() {
        ArrayList<Hiros> list = new ArrayList<>();
        String quary = "SELECT * FROM " + TABLE_NAME;
        db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(quary, null);
        if ((cursor.moveToFirst())) {
            do{
                Hiros hiros = new Hiros();
                hiros.setId(cursor.getString(0));
                hiros.setNama(cursor.getString(1));
                list.add(hiros);
            } while (cursor.moveToNext());
        }
        return list;
    }
}
