package org.dgonzalo.examen_m8_dani_gonzalo;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Date;

public class Platos_helper extends SQLiteOpenHelper {

    private static final int VERSION = 2;
    private static final String DATABASE_NAME = "exemple_recycler.db";


    public Platos_helper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(ListaPlatoDiseny.SQL_CREATE_ENTRIES);

        ContentValues values = new ContentValues();
        values.put(ListaPlatoDiseny.InsertPlato.COLUMNA_1,new Date().toString());
        values.put(ListaPlatoDiseny.InsertPlato.COLUMNA_2, "SuperChampion");
        values.put(ListaPlatoDiseny.InsertPlato.COLUMNA_3,"100");
        db.insert(ListaPlatoDiseny.InsertPlato.TABLE_NAME, null, values);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(ListaPlatoDiseny.SQL_DELETE_ENTRIES);
        onCreate(db);
    }
}