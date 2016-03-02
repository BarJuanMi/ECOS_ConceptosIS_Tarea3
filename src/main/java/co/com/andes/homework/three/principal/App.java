/*
 * @(#)App.java
 *
 * Copyright (c) All rights reserved.
 *
 * Este software es información confidencial y de propiedad de Tigo Une
 * Inc. ("Información Confidencial"). Queda prohibido revelar dicha 
 * información confidencial y deberá utilizarlo sólo conforme a los 
 * términos del acuerdo de licencia que ha firmado con Tigo Une.
 */
package co.com.andes.homework.three.principal;

import co.com.andes.homework.three.validation.ValidationObject;
import co.com.andes.homework.three.business.ReadDataFile;
import co.com.andes.homework.three.exception.BusinessException;
import co.com.andes.homework.three.business.BusinessDelegate;
import co.com.andes.homework.three.vo.ResultsDataVO;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import static spark.Spark.*;
import spark.template.freemarker.FreeMarkerEngine;
import spark.ModelAndView;
import static spark.Spark.get;

/**
 * Clase principal que ejecuta el programa.
 * @version 1.0
 * @author Juan Miguel Barreto Díaz
 * @since 01/02/2016
 */
public class App 
{   
    private static double[][] matrixDataFile;
    BusinessDelegate delegate = new BusinessDelegate();
    static List<ResultsDataVO> listResult = new ArrayList<>();
    
    /**
     * Metodo main de la aplicacion
     * @param args 
     */
    public static void main( String[] args ) {
        try {
            port(Integer.valueOf(System.getenv("PORT")));
            staticFileLocation("/public");

            App appExecute = new App();
            appExecute.readFile();
            appExecute.processOperateAns();
                        
            get("/calculate", (req, res) -> "Hola Juan M");
            
            
        } catch (BusinessException | IOException | URISyntaxException e) {
            e.getMessage();
        }
    }
    
    /**
     * Metodo que se encarga de hacer el llamado a la 
     * respectiva clase que leera el archivo de texto.
     * 
     * Convierte los datos dle archivo en una mattris 
     * de tipo numerica
     * @return
     * @throws IOException
     * @throws FileNotFoundException
     * @throws URISyntaxException
     * @throws BusinessException 
     */
    private void readFile() throws IOException, FileNotFoundException, URISyntaxException, BusinessException {
        ReadDataFile rdf = new ReadDataFile();
        matrixDataFile = rdf.get_read_File();
        
        if(ValidationObject.isEmpty(matrixDataFile)){
            throw new BusinessException("Error, No hay datos provenientes del archivo");
        }
    }
    
    /**
     * Metodo que obteiene la matriz de datos numeicos y se encatga de 
     * gestionar el orden en que las columnas seran procesadas, sigue lineamientos de
     * orden dadas por el requerimiento.
     * @throws BusinessException 
     */
    private void processOperateAns() throws BusinessException{
        List<String> listColumns = new ArrayList<>();
        listColumns.add("0-2");
        listColumns.add("0-3");
        listColumns.add("1-2");
        listColumns.add("1-3");
        
        for (String pairColm : listColumns) {
            listResult.add(delegate.operateListColumns(
                            Integer.parseInt(pairColm.split("-")[0]), 
                            Integer.parseInt(pairColm.split("-")[1]), 
                            matrixDataFile));
        }
    }
}
