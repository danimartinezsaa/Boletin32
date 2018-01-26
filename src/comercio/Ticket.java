/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comercio;

/**
 *
 * @author dani
 */
public class Ticket{
    private String numeroVenta,nombre;
    private float precioTotal;

    public Ticket(){
    }

    public Ticket(String numeroVenta, String nombre, float precioTotal){
        this.numeroVenta=numeroVenta;
        this.nombre=nombre;
        this.precioTotal=precioTotal;
    }

    public String getNumeroVenta(){
        return numeroVenta;
    }

    public void setNumeroVenta(String numeroVenta){
        this.numeroVenta=numeroVenta;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public float getPrecioTotal(){
        return precioTotal;
    }

    public void setPrecioTotal(float precioTotal){
        this.precioTotal=precioTotal;
    }

    @Override
    public String toString(){
        return "numeroVenta="+numeroVenta+", nombre="+nombre+", precioTotal="+precioTotal;
    }
    
    
}
