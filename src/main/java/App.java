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
                    "|---------------------------------------------------------------|"
                  + "|   Test   |             Expected  Values                       |"
                  + "|---------------------------------------------------------------|"
                  + "|          |   B0   |   B1       |   rx,y   |   r2   |   yk     |"
                  + "|---------------------------------------------------------------|"
                  + "|   Test1  | -22.55 |  1.7279    |  0.9545  | 0.9111 | 644.429  |"
                  + "|   Test2  | -4.035 |  0.1681    |  0.9333  | 0.8711 | 60.858   |"
                  + "|   Test3  | -23.92 |  1.43097   |  0.9631  | 0.9276 | 528.4294 |"
                  + "|   Test4  | -4.604 |  0.140164  |  0.9480  | 0.8988 | 49.4994  |"
                  + "\n"
                  + "\n"
                  + "|-----------------------------------------------------------------------------------|"
                  + "|                                  Actual  Values                                   |"
                  + "|-----------------------------------------------------------------------------------|"
                  + "|       B0     |        B1       |       rx,y      |       r2     |        yk       |"
                  + "|-----------------------------------------------------------------------------------|"
                  + "|"+listResult.get(0).getBetaZero()+" | "+listResult.get(0).getBetaOne()+" | "+listResult.get(0).getCoeffRxy()+" | "+Math.pow(listResult.get(0).getBetaZero(),2)+" | "+listResult.get(0).getCoeffYk()+" |"
                  + "|"+listResult.get(1).getBetaZero()+" | "+listResult.get(1).getBetaOne()+" | "+listResult.get(1).getCoeffRxy()+" | "+Math.pow(listResult.get(1).getBetaZero(),2)+" | "+listResult.get(1).getCoeffYk()+" |"
                  + "|"+listResult.get(2).getBetaZero()+" | "+listResult.get(2).getBetaOne()+" | "+listResult.get(2).getCoeffRxy()+" | "+Math.pow(listResult.get(2).getBetaZero(),2)+" | "+listResult.get(2).getCoeffYk()+" |"
                  + "|"+listResult.get(3).getBetaZero()+" | "+listResult.get(3).getBetaOne()+" | "+listResult.get(3).getCoeffRxy()+" | "+Math.pow(listResult.get(3).getBetaZero(),2)+" | "+listResult.get(3).getCoeffYk()+" |"
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
