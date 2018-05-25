package com.aprendiz.ragp.guiaturistica.models;

public class Constants {
    public static final String DATABASE_NAME="Sitios.db";
    public static final int DATABASE_VERSION=1;
    public static final String script="CREATE TABLE DATOS(IMAGE TEXT,NOMBRE TEXT, DESCRIPCIONC TEXT, UBICACION TEXT, DESCRIPCION TEXT, LAT INTEGER, LON INTEGER);";


    public static final int mode_list=1;
    public static final int mode_grid=2;
    public static final int mode_land=3;

    public static int mode_listener=mode_list;

}
