package com.example.appmudanza.CamionetaAdapter;

public class Camioneta1 {
    private int perfil;
    private String nombre;
    private String contenido;



    public Camioneta1(int perfil, String nombre, String contenido) {
        this.perfil = perfil;
        this.nombre = nombre;
        this.contenido = contenido;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public int getPerfil() {
        return perfil;
    }

    public void setPerfil(int perfil) {
        this.perfil = perfil;
    }
}
