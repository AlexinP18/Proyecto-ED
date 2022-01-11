/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PRINCIPAL;

/**
 *
 * @author USUARIO
 */
public class Mensajes {

    public enum INGRESO {
        OPCION("Opción: "),
        NOMBRE("Nombre del jugador "),
        NOMBRE_NUEVO("Nuevo nombre: "),
        NOMBRE_ELIMINAR("Nombre a Eliminar: "),
        CANT_GRUPOS("Ingrese la cantidad de grupos: "),
        TIEMPO("Tiempo Límite: "),
        LONGITUD("Longitud de caracteres: "),
        SECUENCIA("Ingrese la secuencia: "),
        INGRESO_OTRA_VEZ("Desea volver a ingresar(s/n) ?"),
        ;
        private String valor;

        private INGRESO(String v) {
            valor = v;
        }

        public String tx() {
            return valor;
        }
    }

    public enum ERROR {
        OPCION("Opción no válida!!"),
        ENTERO_SIN_SIGNO("No se admite texto o Números menores a cero"),
        MEMORIA("No hay memoria suficiente para el registro solicitado!!"),
        PAR("El número de jugadores ingresado no es par!!"),
        
        NO_HAY_JUGADOR("No existe el jugador!!"),
        USUARIO_YA_INGRESADO("Usuario ya ingresado!!"),
        VOLVER_A_INGRESAR_USUARIO("Vuelva a ingresar el usuario...\n"),
        
        NO_HAY_JUGADORES("Todavía no se han ingresado jugadores!!"),
        YA_HAY_JUGADORES("Ya se han ingresado jugadores..."),
        ;

        private String valor;

        private ERROR(String v) {
            valor = v;
        }

        public String tx() {
            return valor;
        }
        //
    }

    public enum NOTIF {
        DESPEDIDA("Gracias por Jugar a \"Mecanografo\" "),
        INGRESO_JUGADORES("Nombre de Jugadores Ingresados Satisfactoriamente :)"),
        JUGADOR("Nombre de Jugador ingresado con éxito :)"),
        COMIENZO_JUEGO("A jugar!!"),
        CORRECTO("Trasnscripción Correcta :)"),
        INCORRECTO("Transcripción Incorrecta"),
        ELIMINAR("Nombre del jugador eliminado con exito")
        ;
        private String valor;

        private NOTIF(String v) {
            valor = v;
        }

        public String tx() {
            return valor;
        }
    }
    
    public enum MENU{
        SALIR ("0. SALIR"),
        ENCABEZADO_TORNEO("****TORNEO****"),
        
        CONFIGURACION_JUGADORES("1. Configuración Jugadores"),
        CONFIGURACION_PARAMETROS("2. Configuración Parametros"),
        JUGAR("3. Jugar"),
        
        ENCABEZADO_CONFIGURACION ("****CONFIGURACIÓN JUGADORES****"),
        
        REGISTRAR_JUGADOR ("1. Registrar Jugadores"),
        MODIFICAR_NOMBRE ("2. Modificar Nombre de Jugador"),
        ELIMINAR_JUGADOR ("3. Eliminar Jugador"),
        IMPRIMIR_JUGADORES ("4. Imprimir Jugadores"),
        
        ENCABEZADO_PARAMETROS("***CONFIGURACIÓN PARAMETROS***"),
        
        REGISTRAR_LONGITUD_SECUENCIA("1. Ingresar Longitud Secuencia"),
        REGISTRAR_LIMITE_TIEMPO("2. Ingresar Limite de Tiempo"),
                
        
        ;
        private String valor;

        private MENU(String v) {
            valor = v;
        }

        public String tx() {
            return valor;
        }
    }
    
    public enum MENUPRINCIPAL{
 
        
        ENCABEZADO ("\033[36;46mMENÚ PRINCIPAL"),

        
        OPCION1 ("\033[34;47m1.Jugar 1 VS 1"),
        OPCION2 ("\033[34;47m2.Jugar Torneo"),
        OPCION3 ("\033[34;47m0.Salir       "),

        
        ;
        private String valor;

        private MENUPRINCIPAL(String v) {
            valor = v;
        }

        public String tx() {
            return valor;
        }
    }

    //   
}
