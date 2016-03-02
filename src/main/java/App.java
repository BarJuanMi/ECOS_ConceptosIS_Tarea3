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
                        
            get("/calculate", (req, res) ->
                "<table>"
                   + "<tr>"
                       + "<td>"
                           + "<table border=\"1\">"
                                + "<tr>"+ "<td colspan =\"6\"><strong>Expected Values</strong></td>"+ "</tr>"
                                + "<tr>"+ "<td scope=\"col\">Test</td>"+ "<td>B0</td>"+ "<td>B1</td>"+ "<td>rx,y</td>"+ "<td>r2</td>"+ "<td>yk</td>"+ "</tr>"
                                + "<tr>"+ "<td scope=\"col\">Test1</td>"+ "<td>-22.55</td>"+ "<td>1.7279 </td>"+ "<td>0.9545</td>"+ "<td>0.9111</td>"+ "<td>644.429</td>"+ "</tr>"
                                + "<tr>"+ "<td scope=\"col\">Test2</td>"+ "<td>-4.035</td>"+ "<td>0.1681</td>"+ "<td>0.9333</td>"+ "<td>0.8711</td>"+ "<td>60.858 </td>"+ "</tr>"
                                + "<tr>"+ "<td scope=\"col\">Test3</td>"+ "<td>-23.92</td>"+ "<td>1.43097</td>"+ "<td>0.9631</td>"+ "<td>0.9276</td>"+ "<td>528.4294</td>"+ "</tr>"
                                + "<tr>"+ "<td scope=\"col\">Test4</td>"+ "<td>-4.604</td>"+ "<td>0.140164</td>"+ "<td>0.9480</td>"+ "<td>0.8988</td>"+ "<td>49.4994</td>"+ "</tr>"
                            + "</table>"
                       + "</td>"
            
                       + "<td>"
                            + "<table border=\"1\">"
                                + "<tr>"+ "<td colspan =\"6\"><strong>Actual Values</strong></td>"+ "</tr>"
                                + "<tr>"+ "<td>B0</td>"+ "<td>B1</td>"+ "<td>rx,y</td>"+ "<td>r2</td>"+ "<td>yk</td>"+ "</tr>"
                                + "<tr>"+ "<td>"+ listResult.get(0).getBetaZero() +"</td>"+ "<td>"+ listResult.get(0).getBetaOne() +"</td>"+ "<td>"+ listResult.get(0).getCoeffRxy() +"</td>"+ "<td>"+ listResult.get(0).getCoeffRPow() +"</td>"+ "<td>"+ listResult.get(0).getCoeffYk() +"</td>"+ "</tr>"
                                + "<tr>"+ "<td>"+ listResult.get(1).getBetaZero() +"</td>"+ "<td>"+ listResult.get(1).getBetaOne() +"</td>"+ "<td>"+ listResult.get(1).getCoeffRxy() +"</td>"+ "<td>"+ listResult.get(1).getCoeffRPow() +"</td>"+ "<td>"+ listResult.get(1).getCoeffYk() +"</td>"+ "</tr>"
                                + "<tr>"+ "<td>"+ listResult.get(2).getBetaZero() +"</td>"+ "<td>"+ listResult.get(2).getBetaOne() +"</td>"+ "<td>"+ listResult.get(2).getCoeffRxy() +"</td>"+ "<td>"+ listResult.get(2).getCoeffRPow() +"</td>"+ "<td>"+ listResult.get(2).getCoeffYk() +"</td>"+ "</tr>"
                                + "<tr>"+ "<td>"+ listResult.get(3).getBetaZero() +"</td>"+ "<td>"+ listResult.get(3).getBetaOne() +"</td>"+ "<td>"+ listResult.get(3).getCoeffRxy() +"</td>"+ "<td>"+ listResult.get(3).getCoeffRPow() +"</td>"+ "<td>"+ listResult.get(3).getCoeffYk() +"</td>"+ "</tr>"
                            + "</table>"
                       + "</td>"
                   + "</tr>"
                + "</table>"
            );
            
        } catch (BusinessException | IOException | URISyntaxException e) {
            System.out.println(e.getMessage());
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
