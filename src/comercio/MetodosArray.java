/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comercio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class MetodosArray{

    static Connection conexion;
    static PreparedStatement st;
    static ResultSet resulado;

    static String numeroVenta, referenciaProducto, referenciaPrecio, nombre;
    static float precio, cantidad;

    public static void connect(){
        try{
            conexion=DriverManager.getConnection("jdbc:sqlite:"+"Comercio");
            if(conexion!=null){
                System.out.println("conectado");
            }
        }catch(SQLException ex){
            System.out.println("Error al conectarse a la base.");
        }
    }

    public static void close(){
        try{
            conexion.close();
        }catch(SQLException ex){
            System.out.println("Error al cerrar la base");
        }
    }

    public static void anadirPrecio(Precio[] precio){
        connect();

        try{
            for(int i=0; i<precio.length; i++){
                conexion.prepareStatement("insert into Ticket values('"+precio[i].getReferenciaPrecio()+"'"
                        +","+"'"+precio[i].getPrecio()+"'"+");");
            }
        }catch(SQLException ex){
            System.out.println("Error: "+ex.getMessage());
        }

        close();
    }

    public static void anadirProducto(Producto[] prod){
        connect();

        try{
            for(int i=0; i<prod.length; i++){
                conexion.prepareStatement("insert into Ticket values('"+prod[i].getReferenciaProducto()+"'"
                        +","+"'"+prod[i].getNombreProducto()+"'"+","+"'"+prod[i].getReferenciaPrecio()+"'"+");");
            }
        }catch(SQLException ex){
            System.out.println("Error: "+ex.getMessage());
        }

        close();
    }

    public static void anadirVentas(Ventas[] ven){
        connect();

        try{
            for(int i=0; i<ven.length; i++){
                conexion.prepareStatement("insert into Ticket values('"+ven[i].getNumeroVenta()+"'"
                        +","+"'"+ven[i].getReferenciaProducto()+"'"+","+"'"+ven[i].getCantidade()+"'"+");");
            }
        }catch(SQLException ex){
            System.out.println("Error: "+ex.getMessage());
        }

        close();
    }

    public static void anadirTicket(Ticket[] array_ticket){
        connect();
        try{
            for(int i=0;i<array_ticket.length;i++){
            st=conexion.prepareStatement("insert into Ticket values('"+array_ticket[i].getNumeroVenta()+"'"
                    +","+"'"+array_ticket[i].getNombre()+"'"
                    +","+"'"+array_ticket[i].getPrecioTotal()+"'"+");");
            st.execute();
            }
        }catch(SQLException ex){
            System.out.println("Error:"+ex.getMessage());
        }
        close();
    }

    public static void crear(Ventas array_ventas[], Producto array_productos[], Precio array_precios[], Ticket array_ticket[]){

        for(int i=0; i<array_ventas.length; i++){
            numeroVenta=array_ventas[i].getNumeroVenta();
            array_ticket[i].setNumeroVenta(numeroVenta);
            referenciaProducto=array_ventas[i].getReferenciaProducto();
            cantidad=array_ventas[i].getCantidade();
            for(int u=0; u<array_productos.length; u++){
                if(referenciaProducto.equals(array_productos[u].getReferenciaProducto())){
                    nombre=array_productos[u].getNombreProducto();
                    referenciaPrecio=array_productos[u].getReferenciaPrecio();
                    array_ticket[i].setNombre(nombre);
                    for(int x=0; x<array_precios.length; x++){
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

    public static void nombrePrecio(Ventas array_ventas[], Producto array_productos[], Precio array_precios[]){

        numeroVenta=JOptionPane.showInputDialog("inserte número venta:");

        for(int i=0; i<array_ventas.length; i++){
            if(numeroVenta.equals(array_ventas[i].getNumeroVenta())){
                referenciaProducto=array_ventas[i].getReferenciaProducto();
                for(int u=0; u<array_productos.length; u++){
                    if(referenciaProducto.equals(array_productos[u].getReferenciaProducto())){
                        nombre=array_productos[u].getNombreProducto();
                        referenciaPrecio=array_productos[u].getReferenciaPrecio();
                        for(int x=0; x<array_precios.length; x++){
                            if(referenciaPrecio.equals(array_precios[x].getReferenciaPrecio())){
                                precio=array_precios[x].getPrecio();
                            }
                        }
                    }
                }
            }
        }
    }
}
