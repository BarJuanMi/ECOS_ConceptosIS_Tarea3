/*
 * @(#)BusinessMathOperation.java
 *
 * Copyright (c) All rights reserved.
 *
 * Este software es información confidencial y de propiedad de Tigo Une
 * Inc. ("Información Confidencial"). Queda prohibido revelar dicha 
 * información confidencial y deberá utilizarlo sólo conforme a los 
 * términos del acuerdo de licencia que ha firmado con Tigo Une.
 */
package co.com.andes.homework.three.business;

import co.com.andes.homework.three.exception.BusinessException;
import java.text.DecimalFormat;

/**
 * Clase que realiza las operaciones matematicas 
 * que se requiere para obtener los datos con los caules se hara
 * la regresiom lineal
 * @version 1.0
 * @author Juan Miguel Barreto Díaz
 * @since 01/02/2016
 */
public class BusinessMathOperation{
    
    static final int proxy = 386;
    
    /**
     * Metodo que suma todos los datos numericos de una columna
     * @param column arreglo de datos para obtener la suma de terminos
     * @return 0 - infinito
     */
    public double sumColumn(double[] column){
        double sum = 0;
        for (double elem : column) {
            sum = sum + elem;
        }
        return sum;
    }
    
    /**
     * Metodo que obtiene el promedio de los datos numericos 
     * de una columna
     * @param column arreglo de datos para obtener el promedio
     * @return double 0 - infinito
     */
    public double averageColumn(double[] column){
        double ave = 0;
        ave = sumColumn(column)/column.length;
        return ave;
    }
    
    /**
     * Metodo que eleva al cuadrado cada digito de una 
     * lista de datos nuemricos y luego obtiene la suma 
     * de todos los terminos
     * @param column arreglo de datos para elevar al cuadrado cada termino
     * @return double 0 - infinito
     */
    public double sumPowColumn(double[] column){
        double[] aux = new double[column.length];
        double sumPow = 0;
        
        for (int i = 0; i < column.length; i++) {
            aux[i] = Math.pow(column[i], 2);
        }
        
        sumPow = sumColumn(aux);
        return sumPow;
    }
    
    /**
     * Metodo que multiplica los datos numericos de dos columnas 
     * y luego hace la sumatoria de los datos resultantes
     * @param columnA arreglo de datos para columna x
     * @param columnB arreglo de datos para columna y
     * @return double 0 - infinito
     * @throws BusinessException 
     */
    public double multiColumns(double[] columnA, double[] columnB) throws BusinessException{
        double[] aux = new double[columnA.length];
        double sumTwoCols = 0;
        
        if(columnA.length == columnB.length){
            for(int i = 0; i < columnA.length; i++ ){
                aux[i] = columnA[i]*columnB[i];
            }
        }else{
            throw new BusinessException("Error durante la multiplicacion de las columnas x*y");
        }
        
        sumTwoCols = sumColumn(aux);
        return sumTwoCols;
    }
    
    /**
     * Metodo que calcula el coeficiente B1
     * @param numRows cantidad de terminos
     * @param sum2Col sumatoria de las dos columnas multiplicadas
     * @param aveCol1 promedio de la columna 1
     * @param aveCol2 promedio de la columna 2
     * @param sumPowCol sumatoria de la columna 1 con terminos elevados al cuadrado
     * @return 0 - infinito
     */  
    public double calculateBeta1 (int numRows, double sum2Col, double aveCol1, 
            double aveCol2, double sumPowCol){
        double betaOne = 0;
        
        double numerator = sum2Col - (numRows * aveCol1 * aveCol2);
        double denominator = sumPowCol - (numRows * Math.pow(aveCol1,2));
        
        betaOne = (numerator/denominator);
        return betaOne;
    }
    
    /**
     * Metodo que calcula el coeficiente Rxy
     * @param numRows cantidad de terminos
     * @param sumMult2Col sumatoria de las dos columnas multiplicadas 
     * @param sumCol1 sumatoria de la columna 1
     * @param sumCol2 sumatoria de la columna 2
     * @param sumPowCol1 sumatora de los datos de la columna 1 elevados al cuadrado
     * @param sumPowCol2 sumatora de los datos de la columna 2 elevados al cuadrado
     * @return 0 - infinito
     */
    public double calculateCoeffRxy(int numRows, double sumMult2Col, double sumCol1, 
            double sumCol2, double sumPowCol1, double sumPowCol2) {
        double coefficientRxy = 0;
        
        double numerator = ((numRows*sumMult2Col)) - (sumCol1 * sumCol2);
        double denomLeft = (numRows*(sumPowCol1) - (Math.pow(sumCol1, 2)));
        double denomRight = (numRows*(sumPowCol2) - (Math.pow(sumCol2, 2)));
        double denominator = Math.sqrt((denomLeft)*(denomRight));
        
        coefficientRxy = (numerator / denominator);
        
        return coefficientRxy;
    }
    
    /**
     * Metodo que calcula el coeficiente B0
     * @param sumY
     * @param betaOne
     * @param sumX
     * @return 0 - infinito
     */
    public double calculateBeta0(double sumY, double betaOne, double sumX) {
        double betaZero = 0;
        
        betaZero = sumY -(betaOne * sumX);
        
        return betaZero;
    }
    
    /**
     * Metodo que calcula el coeficiente Yk
     * @param beta0
     * @param beta1
     * @return 0 - infinito
     */
    public double calculateYk (double beta0, double beta1) {
        double yK = 0;
        
        yK = beta0 + (beta1 * proxy);
        
        return yK;
    }
    
}
