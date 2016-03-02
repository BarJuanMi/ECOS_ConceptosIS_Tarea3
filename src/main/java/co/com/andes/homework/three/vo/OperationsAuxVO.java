/*
 * @(#)OperationsAuxVO.java
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
public class OperationsAuxVO{
    double sumX;
    double sumY;
    double averageX;
    double averageY;
    double sumXPow2;
    double xMulty;
    double sumYPow2;
    
    public OperationsAuxVO(double sumX, double sumY, double averageX, double averageY, double sumXPow2, double xMulty, double sumYPow2) {
        this.sumX = sumX;
        this.sumY = sumY;
        this.averageX = averageX;
        this.averageY = averageY;
        this.sumXPow2 = sumXPow2;
        this.xMulty = xMulty;
        this.sumYPow2 = sumYPow2;
    }

    public double getSumX() {
        return sumX;
    }

    public void setSumX(double sumX) {
        this.sumX = sumX;
    }

    public double getSumY() {
        return sumY;
    }

    public void setSumY(double sumY) {
        this.sumY = sumY;
    }

    public double getAverageX() {
        return averageX;
    }

    public void setAverageX(double averageX) {
        this.averageX = averageX;
    }

    public double getAverageY() {
        return averageY;
    }

    public void setAverageY(double averageY) {
        this.averageY = averageY;
    }

    public double getSumXPow2() {
        return sumXPow2;
    }

    public void setSumXPow2(double sumXPow2) {
        this.sumXPow2 = sumXPow2;
    }

    public double getxMulty() {
        return xMulty;
    }

    public void setxMulty(double xMulty) {
        this.xMulty = xMulty;
    }

    public double getSumYPow2() {
        return sumYPow2;
    }

    public void setSumYPow2(double sumYPow2) {
        this.sumYPow2 = sumYPow2;
    }

    @Override
    public String toString() {
        return "OperationsAuxVO{" + "sumX=" + sumX + ", sumY=" + sumY + ", averageX=" + averageX + ", averageY=" + averageY + ", sumXPow2=" + sumXPow2 + ", xMulty=" + xMulty + ", sumYPow2=" + sumYPow2 + '}';
    }
    
}
