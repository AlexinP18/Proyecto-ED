/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PRINCIPAL;

import java.util.Scanner;
import consola.Consola;
import java.util.LinkedList;
import validacion.ValidadorExpReg;

/**
 *
 * @author DELLWIN10
 */
class GestorJugadores {

    LinkedList<Jugador> jugadores;
    Secuencia secuencia;
    int cantGrupos;

    static int cantGestorJugadores = 0;

    public GestorJugadores() {
        this.jugadores = new LinkedList<>();
    }

    //Primera versión del Juego
    void insertarJugadores1vs1() {
        String nombre;
        int lado;
        for (int i = 0; i < 2; i++) {
            System.out.print("\033[30;40mIngrese el nombre del jugador " + (i + 1) + " : ");
            nombre = ingresoDatos();
            if (i % 2 == 0) {
                lado = 1;
            } else {
                lado = 2;
            }
            this.jugadores.add(new Jugador(nombre, lado, 0, 0));
        }
    }

    //Inserta Jugador con validación de Usuario
    boolean insertarJugador(String nombre) {
        if (this.jugadores.isEmpty()) {
            this.jugadores.add(new Jugador(nombre));
            return true;
        }

        if (this.jugadores.size() > 0) {
            if (this.validarJugador(nombre)) {
                Consola.notificarError(Mensajes.ERROR.USUARIO_YA_INGRESADO.tx());
                this.cantGrupos = this.cantGrupos + 1;
                return false;
            } else {
                this.jugadores.add(new Jugador(nombre));
                return true;
            }
        }
        return false;
    }

    //Valida que no se repita el jugador
    boolean validarJugador(String nombre) {
        int i = 0;
        while (i < this.jugadores.size()) {
            if (this.jugadores.get(i) != null && this.jugadores.get(i).nombre.equals(nombre)) {
                return true;
            }
            i++;
        }
        return false;
        //
    }

    //Modifica el jugador 
    boolean modificarJugador(String nombreA, String nombreN) {
        int i = 0;
        while (i < this.jugadores.size()) {
            if (this.validarJugador(nombreA) && !this.validarJugador(nombreN)) {
                this.jugadores.get(i).nombre = nombreN;
                return true;
            }
            i++;
        }
        return false;
        //
    }

    //Elimina el jugador
    boolean eliminarjugador(String nombre) {
        int i = 0;
        while (i < this.jugadores.size()) {
            if (this.validarJugador(nombre)) {
                this.jugadores.remove(i);
                return true;
            }
            i++;
        }
        return false;
        //
    }

    public void parametrosSecuencia(int min, int longitud) {

        System.out.println("\033[34;47mJugador 1");
        this.secuencia = new Secuencia(min, longitud);
        this.secuencia.generarSecuencia(1);
        System.out.println("\033[34;47mJugador 2");
        this.secuencia = new Secuencia(min, longitud);
        this.secuencia.generarSecuencia(2);
    }

    public void ingresarCant() {
        int cantJuga;
        cantJuga = Integer.valueOf(Consola.ingresarDato(Mensajes.INGRESO.CANT_GRUPOS.tx(), Mensajes.ERROR.ENTERO_SIN_SIGNO.tx(), new ValidadorExpReg(ValidadorExpReg.ENTERO_SIN_SIGNO)));
        this.cantGrupos = cantJuga;
    }

    public void imprimirJugadores() {
        int i = 0;
                int j = 0;
        while (i < this.jugadores.size()/2) {
            int k = 0;
            System.out.println("\nGrupo " + (i + 1));
            while (k < 2) {
                System.out.println("Jugador " + (k + 1) + ": " + this.jugadores.get(j).nombre);
                j++;
                k++;
            }
            i++;
        }
        System.out.println("");
    }

    public static String ingresoDatos() {
        Scanner tec = new Scanner(System.in);
        String dato = tec.nextLine();
        return dato;
    }

}
