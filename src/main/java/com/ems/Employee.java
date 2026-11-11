package com.ems;

public class Employee {
    private int id;
    private String nombre;
    private double sueldo;

    public Employee(int id, String nombre, double sueldo){
        if(id <= 00){
            throw new IllegalArgumentException("Ingresa un id valido");
        }
        if(nombre == null || nombre.isBlank()){
            throw new IllegalArgumentException("Ingresa un nombre");
        }
        if(sueldo < 0){
            throw new IllegalArgumentException("El sueldo no puede ser negativo");
        }
        this.id = id;
        this.nombre = nombre;
        this.sueldo = sueldo;

    }
    public String getNombre(){
        return nombre;
    }
    public double getSueldo(){
        return sueldo;
    }
    public int getId(){
        return id;
    }
    public void setSueldo(double nuevosueldo){
        if(nuevosueldo < 0){
            throw new IllegalArgumentException("No puedes modificar el sueldo para que sea negativo! ");
        }
        this.sueldo = nuevosueldo;
    }
    @Override 
    public String toString(){
        return " Employee {id=" + id
        + ", nombre = " + nombre 
        + ", sueldo = " + sueldo
        + "}";
    }
}
