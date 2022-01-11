/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PRINCIPAL;

import java.util.Scanner;
import consola.Consola;
import validacion.ValidadorExpReg;

/**
 *
 * @author DELLWIN10
 */
public class Menu {

    public static void menuPrincipal(GestorJugadores g1) {
        int opcion;
        System.out.println("\033[31;47mJUEGO DEL MEJOR MECANÓGRAFO\n");
        do {
            Menu.imprimirMenuPrincipal();
            opcion = Integer.parseInt(Consola.ingresarDato(Mensajes.INGRESO.OPCION.tx(),
                     Mensajes.ERROR.OPCION.tx(),
                     new ValidadorExpReg("[0-2]")));
            System.out.println("");

            switch (opcion) {
                case 1:Menu.registrarParametros();
                    break;
                case 2:Menu.menuTorneo(g1);
                    break;
                default:
                    System.out.println("Gracias por jugar :)");
            }
        } while (opcion != 0);
    }

    public static void imprimirMenuPrincipal() {
        System.out.println(Mensajes.MENUPRINCIPAL.ENCABEZADO.tx());
        System.out.println(Mensajes.MENUPRINCIPAL.OPCION1.tx());
        System.out.println(Mensajes.MENUPRINCIPAL.OPCION2.tx());
        System.out.println(Mensajes.MENUPRINCIPAL.OPCION3.tx());
    }

    public static void menuTorneo(GestorJugadores g) {
        System.out.println("");
        int opcion;
        do {
            Menu.imprimirMenuTorneo();
            opcion = Integer.parseInt(Consola.ingresarDato(Mensajes.INGRESO.OPCION.tx(),
                     Mensajes.ERROR.OPCION.tx(),
                     new ValidadorExpReg("[0-3]")));
            switch (opcion) {
                case 1:configuracionJugadores(g);
                    break;
                case 2:configuracionParametros(g);
                    break;
                case 3:System.out.println("Próximamente...");
                    break;
            }
        } while (opcion != 0);
    }

    public static void configuracionJugadores(GestorJugadores g) {
        System.out.println("");
        int opcion;
        do {
            Menu.imprimirMenuConfiguracion();
            opcion = Integer.parseInt(Consola.ingresarDato(Mensajes.INGRESO.OPCION.tx(),
                     Mensajes.ERROR.OPCION.tx(),
                     new ValidadorExpReg("[0-4]")));

            switch (opcion) {
                case 1:
                    if (!g.jugadores.isEmpty()) {Consola.notificarError(Mensajes.ERROR.NO_HAY_JUGADORES.tx());} else {registrarGrupos(g);}
                    break;
                case 2:
                    if (g.jugadores.isEmpty()) {Consola.notificarError(Mensajes.ERROR.NO_HAY_JUGADORES.tx());} else {modificarJugador(g);}
                    break;
                case 3:
                    if (g.jugadores.isEmpty()) {Consola.notificarError(Mensajes.ERROR.NO_HAY_JUGADORES.tx());} else {eliminarjugador(g);}
                    break;
                case 4:
                    if (g.jugadores.isEmpty()) {Consola.notificarError(Mensajes.ERROR.NO_HAY_JUGADORES.tx());} else {g.imprimirJugadores();}
                    break;
            }
        } while (opcion != 0);
    }

    public static void configuracionParametros(GestorJugadores g) {
        System.out.println("");
        int opcion;
        do {
            Menu.imprimirMenuParametro();
            opcion = Integer.parseInt(Consola.ingresarDato(Mensajes.INGRESO.OPCION.tx(),
                     Mensajes.ERROR.OPCION.tx(),
                     new ValidadorExpReg("[0-2]")));
            switch (opcion) {
                case 1:
                    ingresarParametrosLon(g);
                    break;
                case 2:
                    ingresarParametrosTiempo(g);
                    break;
            }
        } while (opcion != 0);
    }

    private static void imprimirMenuTorneo() {
        System.out.println(Mensajes.MENU.ENCABEZADO_TORNEO.tx());
        System.out.println(Mensajes.MENU.CONFIGURACION_JUGADORES.tx());
        System.out.println(Mensajes.MENU.CONFIGURACION_PARAMETROS.tx());
        System.out.println(Mensajes.MENU.JUGAR.tx());
        System.out.println(Mensajes.MENU.SALIR.tx());
    }

    private static void imprimirMenuConfiguracion() {
        System.out.println(Mensajes.MENU.ENCABEZADO_CONFIGURACION.tx());
        System.out.println(Mensajes.MENU.REGISTRAR_JUGADOR.tx());
        System.out.println(Mensajes.MENU.MODIFICAR_NOMBRE.tx());
        System.out.println(Mensajes.MENU.ELIMINAR_JUGADOR.tx());
        System.out.println(Mensajes.MENU.IMPRIMIR_JUGADORES.tx());
        System.out.println(Mensajes.MENU.SALIR.tx());
    }

    private static void imprimirMenuParametro() {
        System.out.println(Mensajes.MENU.ENCABEZADO_PARAMETROS.tx());
        System.out.println(Mensajes.MENU.REGISTRAR_LONGITUD_SECUENCIA.tx());
        System.out.println(Mensajes.MENU.REGISTRAR_LIMITE_TIEMPO.tx());
        System.out.println(Mensajes.MENU.SALIR.tx());
    }

    public static void registrarParametros() {
        GestorJugadores g1 = new GestorJugadores();

        System.out.println("\033[36;46mParametros de juego");
        System.out.print("\033[34;40m");
        g1.insertarJugadores1vs1();
        int tiempoLim = Integer.valueOf(Consola.ingresarDato(Mensajes.INGRESO.TIEMPO.tx(), Mensajes.ERROR.ENTERO_SIN_SIGNO.tx(), new ValidadorExpReg(ValidadorExpReg.ENTERO_SIN_SIGNO)));
        int longitud = Integer.valueOf(Consola.ingresarDato(Mensajes.INGRESO.LONGITUD.tx(), Mensajes.ERROR.ENTERO_SIN_SIGNO.tx(), new ValidadorExpReg(ValidadorExpReg.ENTERO_SIN_SIGNO)));
        g1.imprimirJugadores();
        g1.parametrosSecuencia(tiempoLim, longitud);

    }

    private static void registrarGrupos(GestorJugadores g) {
        int i = 0;
        int cantGrupos = Integer.valueOf(Consola.ingresarDato(Mensajes.INGRESO.CANT_GRUPOS.tx(), Mensajes.ERROR.ENTERO_SIN_SIGNO.tx(), new ValidadorExpReg(ValidadorExpReg.ENTERO_SIN_SIGNO)));
        do {
            System.out.println("\nGrupo " + (i + 1) + ":");
            registrarJugadores(g);
            i++;
        } while (i < cantGrupos);
    }

    private static void registrarJugadores(GestorJugadores g) {

        int i = 0;
        String nombre;
        do {
            nombre = ingresoDatos(Mensajes.INGRESO.NOMBRE.tx() + (i + 1) + ":");
            if (g.insertarJugador(nombre)) {
                Consola.notificarÉxito(Mensajes.NOTIF.INGRESO_JUGADORES.tx());
            } else {
                do {
                    System.out.println(Mensajes.ERROR.VOLVER_A_INGRESAR_USUARIO.tx());
                    nombre = ingresoDatos(Mensajes.INGRESO.NOMBRE.tx() + (i + 1) + ":");
                } while (!g.insertarJugador(nombre));
            }
            i++;
        } while (i < 2);
        System.out.println("");
        //
    }

    private static void modificarJugador(GestorJugadores g) {
        String nombreA, nombreN;
        g.imprimirJugadores();
        do {
            nombreA = ingresoDatos(Mensajes.INGRESO.NOMBRE.tx());
            if (g.validarJugador(nombreA)) {
                nombreN = ingresoDatos(Mensajes.INGRESO.NOMBRE_NUEVO.tx());
                if (g.modificarJugador(nombreA, nombreN)) {
                    Consola.notificarÉxito(Mensajes.NOTIF.JUGADOR.tx());
                } else {
                    do {
                        nombreN = ingresoDatos(Mensajes.INGRESO.NOMBRE_NUEVO.tx());
                    } while (!g.modificarJugador(nombreA, nombreN));
                }
            } else {
                System.out.println(Mensajes.ERROR.NO_HAY_JUGADOR.tx());
            }
        } while (ingresoDatos(Mensajes.INGRESO.INGRESO_OTRA_VEZ.tx()).equalsIgnoreCase("s"));
        System.out.println("");
    }

    private static void eliminarjugador(GestorJugadores g) {
        do {
            String nombreA = ingresoDatos(Mensajes.INGRESO.NOMBRE_ELIMINAR.tx());
            if (g.eliminarjugador(nombreA)) {
                Consola.notificarÉxito(Mensajes.NOTIF.ELIMINAR.tx());
            } else {
                System.out.println(Mensajes.ERROR.NO_HAY_JUGADOR.tx());
            }
        } while (ingresoDatos(Mensajes.INGRESO.INGRESO_OTRA_VEZ.tx()).equalsIgnoreCase("s"));
        System.out.println("");
    }

    private static void ingresarParametrosTiempo(GestorJugadores g) {

        System.out.println("\033[36;46mParametros de juego");
        System.out.print("\033[34;40m");

        int tiempoLim = Integer.valueOf(Consola.ingresarDato(Mensajes.INGRESO.TIEMPO.tx(), Mensajes.ERROR.ENTERO_SIN_SIGNO.tx(), new ValidadorExpReg(ValidadorExpReg.ENTERO_SIN_SIGNO)));
    }

    private static void ingresarParametrosLon(GestorJugadores g) {

        System.out.println("\033[36;46mParametros de juego");
        System.out.print("\033[34;40m");

        int secuencia = Integer.valueOf(Consola.ingresarDato(Mensajes.INGRESO.LONGITUD.tx(), Mensajes.ERROR.ENTERO_SIN_SIGNO.tx(), new ValidadorExpReg(ValidadorExpReg.ENTERO_SIN_SIGNO)));

    }

    public static String ingresoDatos(String mensajeEntrada) {
        Scanner tec = new Scanner(System.in);
        System.out.print(mensajeEntrada);
        String dato = tec.nextLine();
        return dato;
    }

}
