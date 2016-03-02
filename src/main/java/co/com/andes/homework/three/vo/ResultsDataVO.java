/*
 * @(#)ResultsDataVO.java
 *
 * Copyright (c) All rights reserved.
 *
 * Este software es información confidencial y de propiedad de Tigo Une
 * Inc. ("Información Confidencial"). Queda prohibido revelar dicha 
 * información confidencial y deberá utilizarlo sólo conforme a los 
 * términos del acuerdo de licencia que ha firmado con Tigo Une.
 */
package co.com.andes.homework.three.vo;

import java.text.DecimalFormat;

/**
 * Class representing a virtual object
 * @version 1.0
 * @author Juan Miguel Barreto Díaz
 * @since 01/02/2016
 */
public class ResultsDataVO {
    
    DecimalFormat decFor = new DecimalFormat("#.####");
    
    double betaZero;
    double betaOne; 
    double coeffRxy;
    double coeffRPow;
    double coeffYk;

    public double getBetaZero() {
        String formate = decFor.format(betaZero);
        betaZero = Double.parseDouble(formate.replace(',', '.'));
        return betaZero;
    }

    public void setBetaZero(double betaZero) {
        this.betaZero = betaZero;
    }

    public double getBetaOne() {
        String formate = decFor.format(betaOne);
        betaOne = Double.parseDouble(formate.replace(',', '.'));
        return betaOne;
    }

    public void setBetaOne(double betaOne) {
        this.betaOne = betaOne;
    }

    public double getCoeffRxy() {
        String formate = decFor.format(coeffRxy);
        coeffRxy = Double.parseDouble(formate.replace(',', '.'));
        return coeffRxy;
    }

    public void setCoeffRxy(double coeffRxy) {
        this.coeffRxy = coeffRxy;
    }

    public double getCoeffRPow() {
        String formate = decFor.format(coeffRPow);
        coeffRPow = Double.parseDouble(formate.replace(',', '.'));
        return coeffRPow;
    }

    public void setCoeffRPow(double coeffRPow) {
        String formate = decFor.format(coeffRPow);
        coeffRPow = Double.parseDouble(formate.replace(',', '.'));
        
        this.coeffRPow = coeffRPow;
    }

    public double getCoeffYk() {
        String formate = decFor.format(coeffYk);
        coeffYk = Double.parseDouble(formate.replace(',', '.'));
        return coeffYk;
    }

    public void setCoeffYk(double coeffYk) {
        String formate = decFor.format(coeffYk);
        coeffYk = Double.parseDouble(formate.replace(',', '.'));
        this.coeffYk = coeffYk;
    }

    @Override
    public String toString() {
        return "ResultsDataVO{" + "betaZero=" + betaZero + ", betaOne=" + betaOne + ", coeffRxy=" + coeffRxy + ", coeffRPow=" + coeffRPow + ", coeffYk=" + coeffYk + '}';
    }
    
}
