/*
 * @(#)BusinessDelegate.java
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
import co.com.andes.homework.three.vo.OperationsAuxVO;
import co.com.andes.homework.three.vo.ResultsDataVO;

/**
 * Clase que se encarga de entregar a la calse que realiza las operaciones
 * matematicas los datos necesarios y se encarga de armar la respuesta
 * necesaria que el usuario necesita.
 * @version 1.0
 * @author Juan Miguel Barreto Díaz
 * @since 01/02/2016
 */
public class BusinessDelegate {
    BusinessMathOperation busMath = new BusinessMathOperation();
    
    /**
     * Metodo que realiza la distincion de las columnas de la matriz de double
     * y sobre cada pareja de columnas se realizan los calculos de promedio, sumatorias
     * @param colX
     * @param colY
     * @param matrixRes
     * @return 
     * @throws co.com.andes.homework.three.exception.BusinessException
     */
    public ResultsDataVO operateListColumns(int colX, int colY, double[][]  matrixRes) throws BusinessException{
        
        double[] x = this.getDataOfColumn(colX, matrixRes);
        double[] y = this.getDataOfColumn(colY, matrixRes);
        
        OperationsAuxVO operVO = new OperationsAuxVO(
                busMath.sumColumn(x), busMath.sumColumn(y), 
                busMath.averageColumn(x), busMath.averageColumn(y),
                busMath.sumPowColumn(x), busMath.multiColumns(x, y),
                busMath.sumPowColumn(y));
        
        return calculateCoeffcients(matrixRes.length, operVO);
    }
    
    /**
     * Metodo que invoca los llamados a las operaciones matematicas que calculan los ceficientes
     * por cada pareja se arma un objeto VO
     * @param numRows
     * @param operVO 
     */
    private ResultsDataVO calculateCoeffcients(int numRows, OperationsAuxVO operVO){
        ResultsDataVO resVO = new ResultsDataVO();
        
        resVO.setBetaOne(busMath.calculateBeta1(numRows, operVO.getxMulty(), 
                operVO.getAverageX(), operVO.getAverageY(), 
                operVO.getSumXPow2()));
        
        resVO.setCoeffRxy(busMath.calculateCoeffRxy(numRows, operVO.getxMulty(), operVO.getSumX(), 
                operVO.getSumY(), operVO.getSumXPow2(), operVO.getSumYPow2()));
        
        resVO.setCoeffRPow(Math.pow(resVO.getCoeffRxy(),2));
        
        resVO.setBetaZero(busMath.calculateBeta0(operVO.getAverageY(), resVO.getBetaOne(), operVO.getAverageX()));
        
        resVO.setCoeffYk(busMath.calculateYk(resVO.getBetaZero(), resVO.getBetaOne()));
        
        System.out.println("ResVO:" + resVO.toString());
        return resVO;
    }
    
    /**
     * 
     * @return 
     */
    private  double[] getDataOfColumn(int column, double[][] matr){
        double[] aux = new double[matr.length];
        
        for(int i = 0; i < matr.length; i++){
            aux[i] = matr[i][column];
        }
        return aux;
    }
}
