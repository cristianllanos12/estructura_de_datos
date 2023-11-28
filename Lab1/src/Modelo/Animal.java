package Modelo;

import java.util.Date;

public class Animal {
    protected String nombreDueño;
    protected String nombre;
    protected String color;
    protected int edad;
    protected Date fechaNacimiento;

    public Animal(String nombreDueño, String nombre, String color, int edad, Date fechaNacimiento) {
        this.nombreDueño = nombreDueño;
        this.nombre = nombre;
        this.color = color;
        this.edad = edad;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombreDueño() {
        return nombreDueño;
    }

    public void setNombreDueño(String nombreDueño) {
        this.nombreDueño = nombreDueño;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }


}
