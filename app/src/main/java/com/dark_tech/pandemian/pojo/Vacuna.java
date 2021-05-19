package com.dark_tech.pandemian.pojo;

public class Vacuna {

    private String Marca;
    private String Nombre;
    private String tipo;

    public Vacuna() {
    }

    public Vacuna(String marca, String nombre, String tipo) {
        Marca = marca;
        Nombre = nombre;
        this.tipo = tipo;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        Marca = marca;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
