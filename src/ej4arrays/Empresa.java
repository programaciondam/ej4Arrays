/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej4arrays;

import utilidades.Alfanumericos;
import utilidades.Numeros;

/**
 *
 * @author dam
 */
public class Empresa {

    Empleado[] empleados;
    Provincia[] provincias;
    Comision[] comisiones;

    public Empresa(int nempleados) {
        empleados = new Empleado[nempleados];
        provincias = new Provincia[]{
            new Provincia("Burgos", 1000f),
            new Provincia("Soria", 900f),
            new Provincia("Segovia", 1000f),
            new Provincia("Avila", 800f),
            new Provincia("Valladolid", 1200f),
            new Provincia("Palencia", 850f),
            new Provincia("Leon", 1100f)
        };
        comisiones = new Comision[]{
            new Comision(10000f, 0.05f),
            new Comision(15000f, 0.1f),
            new Comision(20000f, 0.15f),
            new Comision(25000f, 0.2f),
            new Comision(Float.MAX_VALUE, 0.25f)
        };
    }

    public void inicializar() {
        for (int nemple = 0; nemple < empleados.length; nemple++) {
            empleados[nemple] = new Empleado();
        }
    }

    public void introducirEmpleados() {
        String nombre;
        int codProvincia;
        float ventas;

        for (int nemple = 0; nemple < empleados.length; nemple++) {
            nombre = Alfanumericos.pedirString("Nombre del empleado");
           // codProvincia = pedirProvincia();
          nombreProvincias();
           codProvincia=Numeros.pedirNumeroEntero("",0, provincias.length-1);
            ventas = Numeros.pedirNumeroReal("VENTAS", 0);
            empleados[nemple] = new Empleado(nombre, codProvincia, ventas);

        }
    }

    private int pedirProvincia() {
        int codProvincia;
        String nombreProvincia;

        nombreProvincia = Alfanumericos.pedirString("Provincia");
        codProvincia = buscarProvincia(nombreProvincia);
        while (codProvincia == -1) {
            System.out.println("error , esa provincia no existe");
            nombreProvincia = Alfanumericos.pedirString("Provincia");
            codProvincia = buscarProvincia(nombreProvincia);
        }
        return codProvincia;
    }

    private int buscarProvincia(String nombreProvincia) {
        int codigo = 0;
        boolean encontrado = false;
        while (!encontrado && codigo < provincias.length) {
            if (nombreProvincia.
                    equalsIgnoreCase(provincias[codigo]
                            .getDenominacion())) {
                encontrado = true;
            } else {
                codigo++;
            }
        }
        if (!encontrado) {
            codigo = -1;
        }
        return codigo;
    }

    private void nombreProvincias(){
        System.out.println("codigo---Nombre");
        for ( int p=0; p< provincias.length; p++)
        {
            System.out.println(p + "--"+provincias[p].getDenominacion());
        }
    }
    
    public void informe(){
        int codPro;
        float importe,importeComision;
        int posicion;
        System.out.println("NOMBRE PROVINCIA IMPORTE"
                + " SUELDOBASE IMPORTE COMISION SUELDO");
        for( int nemple=0; nemple<empleados.length; nemple++)
        {
            codPro=empleados[nemple].getCodProvincia();
            posicion=buscarComision(empleados[nemple].getVentas());
            if (posicion !=-1){
                importeComision=
                        comisiones[posicion].getPorcentaje()*
                        empleados[nemple].getVentas();
            }
            else{
                importeComision=0;
            }
            importe=provincias[codPro].getsBase()+importeComision;
            System.out.print(empleados[nemple].getNombre());
            System.out.print("\t"+provincias[codPro].getDenominacion());
            System.out.print("\t"+ empleados[nemple].getVentas());
            System.out.print("\t"+provincias[codPro].getsBase());
             System.out.print("\t"+ importeComision);
              System.out.println("\t"+importe);
        }
    }
     private int buscarComision(float ventas) {
        int posicion = 0;
        boolean encontrado = false;
        while (!encontrado && posicion < comisiones.length) {

            if (ventas > comisiones[posicion].getImporte()) {
                posicion++;
            } else {
                encontrado = true;
            }
        }
        if (!encontrado) {
            posicion = -1;
        }
        return posicion;
    }
}
