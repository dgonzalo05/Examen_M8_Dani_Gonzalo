package org.dgonzalo.examen_m8_dani_gonzalo;

public class Plato {
    @Override

    public String toString() {
        return "Plato{" +
                "nombre='" + nombre + '\'' +
                ", ingredientes='" + ingredientes + '\'' +
                ", precio='" + precio + '\'' +
                '}';
    }

    public Plato(String nombre, String ingredientes, String precio) {
        this.nombre = nombre;
        this.ingredientes = ingredientes;
        this.precio = precio;
    }

    String nombre;
    String ingredientes;
    String precio;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }


}
