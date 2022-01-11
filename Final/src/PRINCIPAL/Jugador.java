/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PRINCIPAL;

/**
 *
 * @author DELLWIN10
 */
public class Jugador {

    String nombre;
    int lado;
    int cantAciertos;
    int cantErrores;

    public Jugador(String nombre, int lado, int cantAciertos, int cantErrores) {
        this.nombre = nombre;
        this.lado = lado;
        this.cantAciertos = cantAciertos;
        this.cantErrores = cantErrores;
    }
    
    public Jugador(String nombre) {
        this.nombre = nombre;
    }
    
}
