/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validacion;

/**
 *
 * @author felix
 */
public class ValidadorExpReg implements IValidador {
//Estable los parámetros para ingreso de usuarios
    public static final String ENTERO_SIN_SIGNO = "[1-9]*";
    public static final String SOLO_LETRAS = "[ñÑüÜáéíóúÁÉÍÓÚA-Za-z]+";
    public static final String CADENA_TEXTO = "[ñÑáéíóúÁÉÍÓÚA-Za-z1-9].+";
    String exprReg;

    public ValidadorExpReg(String exprReg) {
        this.exprReg = exprReg;
    }

    @Override
    public boolean validar(String dato) {
        return dato.matches(exprReg);
    }
    
}
