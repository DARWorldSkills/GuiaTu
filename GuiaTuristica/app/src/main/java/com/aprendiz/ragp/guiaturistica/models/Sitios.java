package com.aprendiz.ragp.guiaturistica.models;

public class Sitios {
    private int imagen;
    private String nombre;
    private String descripcion_c;
    private String ubicacion;
    private String descripcion;
    private float lat;
    private float lon;

    public Sitios() {
    }

    public Sitios(int imagen, String nombre, String descripcion_c, String ubicacion, String descripcion, float lat, float lon) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.descripcion_c = descripcion_c;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
        this.lat = lat;
        this.lon = lon;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion_c() {
        return descripcion_c;
    }

    public void setDescripcion_c(String descripcion_c) {
        this.descripcion_c = descripcion_c;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLon() {
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }
}
