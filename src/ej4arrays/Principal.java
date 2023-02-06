/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ej4arrays;

import utilidades.Numeros;

/**
 *
 * @author dam
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Empresa miEmpresa;
        int nempleados;
        nempleados=Numeros.pedirNumeroEntero
        ("Introduce el numero de empleados", 1);
        miEmpresa=new Empresa(nempleados);
      //  miEmpresa.inicializar();
      miEmpresa.introducirEmpleados();
      miEmpresa.informe();
    }
    
}
