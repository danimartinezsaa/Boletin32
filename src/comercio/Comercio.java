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
public class Comercio{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        
        Ventas[] array_ventas={new Ventas("1","rpro1",7),new Ventas("2","rpro2",9),new Ventas("3","rpro3",4)};
        MetodosArray.anadirVentas(array_ventas);
        Producto[] array_productos={new Producto("rpro3","uvas","rpre1"),new Producto("rpro1","peras","rpre3"),new Producto("rpro2","patatas","rpre2")};
        MetodosArray.anadirProducto(array_productos);
        Precio[] array_precios={new Precio("rpre2",2),new Precio("rpre1",5),new Precio("rpre3",7)};
        MetodosArray.anadirPrecio(array_precios);
        Ticket[] array_ticket=new Ticket[3];
        
        for(int i=0;i<array_ticket.length;i++){
            array_ticket[i]= new Ticket();
        }
        
        MetodosArray.anadirTicket(array_ticket);
        
        MetodosArray.crear(array_ventas, array_productos, array_precios, array_ticket);
        MetodosArray.nombrePrecio(array_ventas, array_productos, array_precios);
        System.out.println("Número venta: "+MetodosArray.numeroVenta+", "+"Nombre: "+MetodosArray.nombre+", "+"Precio: "+MetodosArray.precio);
    }
    
}
