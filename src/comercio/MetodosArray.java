/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comercio;

import java.util.Arrays;

/**
 *
 * @author dani
 */
public class MetodosArray{
    
public static void crear(Ventas array_ventas[], Producto array_productos[], Precio array_precios[], Ticket array_ticket[]){
    
  
    String numeroVenta,referenciaProducto,referenciaPrecio,nombre;
    float precio,cantidad;
        
        for(int i=0;i<array_ventas.length;i++){
            numeroVenta=array_ventas[i].getNumeroVenta();
            array_ticket[i].setNumeroVenta(numeroVenta);
            referenciaProducto=array_ventas[i].getReferenciaProducto();
            cantidad=array_ventas[i].getCantidade();
            for(int u=0;u<array_productos.length;u++){
                if(referenciaProducto.equals(array_productos[u].getReferenciaProducto())){
                    nombre=array_productos[u].getNombreProducto();
                    referenciaPrecio=array_productos[u].getReferenciaPrecio();
                    array_ticket[i].setNombre(nombre);
                    for(int x=0;x<array_precios.length;x++){
                        if(referenciaPrecio.equals(array_precios[x].getReferenciaPrecio())){
                            precio=array_precios[x].getPrecio();
                            array_ticket[i].setPrecioTotal(precio*cantidad);
                        }
                    }
                }
            }
            System.out.println("Ticket "+(i+1)+": "+(array_ticket[i].toString()));
        }
    }  
}