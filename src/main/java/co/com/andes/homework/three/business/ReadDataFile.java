/*
 * @(#)ReadDataFile.java
 *
 * Copyright (c) All rights reserved.
 *
 * Este software es información confidencial y de propiedad de Tigo Une
 * Inc. ("Información Confidencial"). Queda prohibido revelar dicha 
 * información confidencial y deberá utilizarlo sólo conforme a los 
 * términos del acuerdo de licencia que ha firmado con Tigo Une.
 */
package co.com.andes.homework.three.business;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Clase encargada de la lectura del archivo y tratamiento 
 * de los datos que se encuentran al interior, conversion 
 * de datos en objetos utiles y comprensibles
 * @version 1.0
 * @author Juan Miguel Barreto Díaz
 * @since 01/02/2016
 */
public class ReadDataFile {
    
    private final String fileURL = "/fileNumbers.txt";
    private File file;
    private double[][] matrixData;
    
    /**
     * Metodo encargado de la lectura del archivo de datos
     * @throws FileNotFoundException
     * @throws IOException
     * @throws java.net.URISyntaxException
     * @return array 2D type double
     */
    public double[][] get_read_File() throws FileNotFoundException, IOException, URISyntaxException {
        file = new File(this.getClass().getResource(fileURL).toURI());
        
        FileReader f = new FileReader(file.getAbsolutePath());
        BufferedReader b = new BufferedReader(f);
        buildFileToMatrix(b);
        
        b.close();
        return matrixData;
    }
    
    /**
     * Metodo que esta encargado de construir una matrix de doubles 
     * con ancho y largo fijo segun la lectura del archivo de texto. 
     * Largo 10 y ancho 4
     * @param buffer
     */        
    private void buildFileToMatrix(BufferedReader buffer) throws IOException{
        String lines;
        int row = 0;
        
        while ((lines = buffer.readLine()) != null) {
            String[] vals = lines.trim().split("\\s+");
            
            // Lazy instantiation.
            if (matrixData == null) {
                matrixData = new double[10][4];
            }

            for (int col = 0; col < 4; col++) {
                matrixData[row][col] = Double.parseDouble(vals[col]);
            }
            row++;
        }
    }
}
