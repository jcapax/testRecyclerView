package com.jcapax.jcarlosporcel.testrecyclerview;

/**
 * Created by jcarlos.porcel on 14/11/2016.
 */

public class Persona {
    private String nombre;
    private int edad;

    public Persona(int edad, String nombre) {
        this.edad = edad;
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
