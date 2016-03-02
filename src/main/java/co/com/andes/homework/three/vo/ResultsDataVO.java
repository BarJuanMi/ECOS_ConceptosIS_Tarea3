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

/**
 * Class representing a virtual object
 * @version 1.0
 * @author Juan Miguel Barreto Díaz
 * @since 01/02/2016
 */
public class ResultsDataVO {
    
    double betaZero;
    double betaOne; 
    double coeffRxy;
    double coeffRPow;
    double coeffYk;

    public double getBetaZero() {
        return betaZero;
    }

    public void setBetaZero(double betaZero) {
        this.betaZero = betaZero;
    }

    public double getBetaOne() {
        return betaOne;
    }

    public void setBetaOne(double betaOne) {
        this.betaOne = betaOne;
    }

    public double getCoeffRxy() {
        return coeffRxy;
    }

    public void setCoeffRxy(double coeffRxy) {
        this.coeffRxy = coeffRxy;
    }

    public double getCoeffRPow() {
        return coeffRPow;
    }

    public void setCoeffRPow(double coeffRPow) {
        this.coeffRPow = coeffRPow;
    }

    public double getCoeffYk() {
        return coeffYk;
    }

    public void setCoeffYk(double coeffYk) {
        this.coeffYk = coeffYk;
    }

    @Override
    public String toString() {
        return "ResultsDataVO{" + "betaZero=" + betaZero + ", betaOne=" + betaOne + ", coeffRxy=" + coeffRxy + ", coeffRPow=" + coeffRPow + ", coeffYk=" + coeffYk + '}';
    }
    
}
