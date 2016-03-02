/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.andes.homework.three.validation;

/**
 *
 * @author JuanMi-Ingeneo
 */
public class ValidationObject {
    
    /**
     * Metodo para identificar si el campo es o no vacio
     *
     * @param value
     * @return
     */
    public static boolean isEmpty(String value) {
        if (value == null || "".equals(value.trim())) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Metodo para identificar si el objeto es o no vacio
     *
     * @param value
     * @return
     */
    public static boolean isEmpty(Object value) {
        if (value == null) {
            return true;
        } else {
            return false;
        }
    }
}
