/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consola;

import java.util.Scanner;
import validacion.IValidador;

/**
 *
 * @author USUARIO
 */
public class Consola {
    private static final String ANSI_COLOR_POR_DEFECTO = "\u001B[0m";
    private static final String ANSI_COLOR_ERROR = "\u001B[31m";
    private static final String ANSI_COLOR_NOTIF = "\u001B[32m";
    
    private static Consola instancia = null; 
    public Scanner entrada; 
  
    private Consola( ) 
    { 
        entrada = new Scanner( System.in );
    } 
  
    public static Consola get_( ) 
    { 
        if (instancia == null) 
            instancia = new Consola( ); 
        return instancia; 
    } 
    
    //Valida datos y devuelve boolean
    public static String ingresarDato(String mensajeEntrada, String mensajeError, IValidador validador){
        boolean datoValido;
        String dato;
        do{
            System.out.print( mensajeEntrada );
            dato = Consola.get_().entrada.nextLine();  
            datoValido = validador.validar( dato);
            if ( !datoValido )
                Consola.notificarError(mensajeError);
        } while ( !datoValido );
        return dato;        
    }
    
    
    public static void notificar(String mensaje){
        System.out.println(mensaje);
    }

    public static void notificarÉxito(String mensaje){
        System.out.println(Consola.ANSI_COLOR_NOTIF + mensaje + Consola.ANSI_COLOR_POR_DEFECTO );
    }
    
    public static void notificarError(String mensajeError){
        System.out.println(Consola.ANSI_COLOR_ERROR + mensajeError + Consola.ANSI_COLOR_POR_DEFECTO );
    }
}
