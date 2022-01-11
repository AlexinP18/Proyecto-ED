/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PRINCIPAL;

import java.util.Scanner;

/**
 *
 * @author DELLWIN10
 */
public class Secuencia {

    int tiempolim;
    int longitud;

    public Secuencia(int tiempolim, int longitud) {
        this.tiempolim = tiempolim;
        this.longitud = longitud;
    }

    public void generarSecuencia(int lado) {
        //this.cuentaregresiva(tiempolim);
        int aciertos=0;

        char teclado1[] = {'Q', 'W', 'E', 'R', 'T', 'A', 'S', 'D', 'F', 'Z', 'X', 'C', 'V'};
        char teclado2[] = {'Y', 'U', 'I', 'O', 'P', 'G', 'H', 'J', 'K', 'L', 'B', 'N', 'M'};

        int pos;
        int tiemp=0;
        boolean resp;

        do {
            if (lado == 1) {
                String secuenciaj1 = "";
                for (int i = 0; i < longitud; i++) {
                    pos = (int) (Math.random() * (13));
                    secuenciaj1 = secuenciaj1 + teclado1[pos];
                }
                System.out.println("");
                System.out.println(secuenciaj1);
                resp = Secuencia.ingresarsecuencia(secuenciaj1);
                if(resp == true){
                    aciertos++;
                }
            }

            if (lado == 2) {
                String secuenciaj2 = "";
                for (int i = 0; i < longitud; i++) {
                    pos = (int) (Math.random() * (13));
                    secuenciaj2 = secuenciaj2 + teclado2[pos];
                }
                System.out.println("");
                System.out.println(secuenciaj2);
                resp = Secuencia.ingresarsecuencia(secuenciaj2);
                if(resp == true){
                    aciertos++;
                }
            }
            tiemp++;
            
        } while (tiemp < tiempolim);
        this.resultados(aciertos,tiempolim);

    }

    public static boolean ingresarsecuencia(String secuencia) {
        boolean resul = false;

        System.out.print("Ingrese la secuencia: ");
        String ingreso = Secuencia.ingresoDatos();
        if (secuencia.equalsIgnoreCase(ingreso)) {
            System.out.println("            _  _\n"
                    + "           (^)(^)\n"
                    + "          /  ()  \\       Transcripción Correcta\n"
                    + "        _ \\  <>  / _\n"
                    + "       { '-`\"\"\"\"`-' }\n"
                    + "        `\"/      \\\"`\n"
                    + "          \\      /\n"
                    + "         _/  /\\  \\_\n"
                    + "        {   /  \\   }\n"
                    + "         `\"`    `\"`");
            resul = true;
        } else {
            System.out.println("            _  _\n"
                    + "           (.)(.)\n"
                    + "          /  ()  \\     Transcripción Incorrecta\n"
                    + "        _ \\   ~  / _\n"
                    + "       { '-`\"\"\"\"`-' }\n"
                    + "        `\"/      \\\"`\n"
                    + "          \\      /\n"
                    + "         _/  /\\  \\_\n"
                    + "        {   /  \\   }\n"
                    + "         `\"`    `\"`");

        }
        return resul;
    }

    public void resultados(int cantAciertos, int tiempolim) {

        System.out.println("Aciertos: " + cantAciertos);
        System.out.println("Errores: " + (tiempolim-cantAciertos)+"\n");

    }

    public static String ingresoDatos() {
        Scanner tec = new Scanner(System.in);
        String dato = tec.nextLine();
        return dato;
    }

    public boolean cuentaregresiva(int min) {
        boolean tiempoter = false;
        int minutos = -1;
        int segundos = -1;
        for (minutos = min - 1; minutos >= 0; minutos--) {
            for (segundos = 59; segundos >= 0; segundos--) {
                System.out.println(minutos + ":" + segundos);
                delaySegundo();

            }
        }
        if (minutos == 0 || segundos == 0) {
            tiempoter = true;
        }
        return tiempoter;
    }

    private static void delaySegundo() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }
    }

}
