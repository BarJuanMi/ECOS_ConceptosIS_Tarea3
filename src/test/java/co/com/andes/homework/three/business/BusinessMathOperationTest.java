/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.andes.homework.three.business;

import java.text.DecimalFormat;
import junit.framework.TestCase;

/**
 *
 * @author JuanMi-Ingeneo
 */
public class BusinessMathOperationTest extends TestCase {
    
    public BusinessMathOperationTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of sumColumn method, of class BusinessMathOperation.
     */
    public void testSumColumn() {
        System.out.println("sumColumn");
        double[] column = {130, 650, 99, 150, 128, 302, 95, 945, 368, 961};
        BusinessMathOperation instance = new BusinessMathOperation();
        double expResult = 3828;
        double result = instance.sumColumn(column);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of averageColumn method, of class BusinessMathOperation.
     */
    public void testAverageColumn() {
        System.out.println("averageColumn");
        double[] column = {130, 650, 99, 150, 128, 302, 95, 945, 368, 961};
        BusinessMathOperation instance = new BusinessMathOperation();
        double expResult = 382.8;
        double result = instance.averageColumn(column);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of sumPowColumn method, of class BusinessMathOperation.
     */
    public void testSumPowColumn() {
        System.out.println("sumPowColumn");
        double[] column = {130, 650, 99, 150, 128, 302, 95, 945, 368, 961};
        BusinessMathOperation instance = new BusinessMathOperation();
        double expResult = 2540284;
        double result = instance.sumPowColumn(column);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of multiColumns method, of class BusinessMathOperation.
     */
    public void testMultiColumns() throws Exception {
        System.out.println("multiColumns");
        double[] columnA = {130, 650, 99, 150, 128, 302, 95, 945, 368, 961};
        double[] columnB = {186, 699, 132, 272, 291, 331, 199, 1890, 788, 1601};;
        BusinessMathOperation instance = new BusinessMathOperation();
        double expResult = 4303108;
        double result = instance.multiColumns(columnA, columnB);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of calculateBeta1 method, of class BusinessMathOperation.
     */
    public void testCalculateBeta1() {
        System.out.println("calculateBeta1");
        int numRows = 10;
        double sum2Col = 4303108;
        double aveCol1 = 382.8;
        double aveCol2 = 638.9;
        double sumPowCol = 2540284;
        BusinessMathOperation instance = new BusinessMathOperation();
        double expResult = 1.727932426206986;
        double result = instance.calculateBeta1(numRows, sum2Col, aveCol1, aveCol2, sumPowCol);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of calculateCoeffRxy method, of class BusinessMathOperation.
     */
    public void testCalculateCoeffRxy() {
        System.out.println("calculateCoeffRxy");
        int numRows = 10;
        double sumMult2Col = 4303108;
        double sumCol1 = 3828;
        double sumCol2 = 6389;
        double sumPowCol1 = 2540284;
        double sumPowCol2 = 7604693;
        BusinessMathOperation instance = new BusinessMathOperation();
        double expResult = 0.9544965741046826;
        double result = instance.calculateCoeffRxy(numRows, sumMult2Col, sumCol1, sumCol2, sumPowCol1, sumPowCol2);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of calculateBeta0 method, of class BusinessMathOperation.
     */
    public void testCalculateBeta0() {
        System.out.println("calculateBeta0");
        double sumY = 638.9;
        double betaOne = 1.727932426206986;
        double sumX = 382.8;
        BusinessMathOperation instance = new BusinessMathOperation();
        double expResult = -22.552532752034267;
        double result = instance.calculateBeta0(sumY, betaOne, sumX);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of calculateYk method, of class BusinessMathOperation.
     */
    public void testCalculateYk() {
        System.out.println("calculateYk");
        double beta0 = -22.5525;
        double beta1 = 1.727932;
        BusinessMathOperation instance = new BusinessMathOperation();
        double expResult = 644.429252;
        double result = instance.calculateYk(beta0, beta1);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
