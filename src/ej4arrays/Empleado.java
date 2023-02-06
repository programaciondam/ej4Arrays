/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej4arrays;

/**
 *
 * @author dam
 */
public class Empleado {
    private String nombre;
    private int codProvincia;
    private float ventas;

    public Empleado() {
    }

    public Empleado(String nombre, int codProvincia, float ventas) {
        this.nombre = nombre;
        this.codProvincia = codProvincia;
        this.ventas = ventas;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCodProvincia() {
        return codProvincia;
    }

    public float getVentas() {
        return ventas;
    }
    
    
    
    
}
