package com.aprendiz.ragp.guiaturistica.models;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class GestorDB extends SQLiteOpenHelper {
    public GestorDB(Context context) {
        super(context, Constants.DATABASE_NAME, null, Constants.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Constants.script);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public  void inputdata(Sitios sitios){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("IMAGE", sitios.getImagen());
        values.put("NOMBRE", sitios.getNombre());
        values.put("DESCRIPCIONC", sitios.getUbicacion());
        values.put("UBICACION", sitios.getDescripcion_c());
        values.put("DESCRIPCION", sitios.getDescripcion());
        values.put("LAT", sitios.getLat());
        values.put("LON", sitios.getLon());
        db.insert("DATOS",null,values);

    }

}
