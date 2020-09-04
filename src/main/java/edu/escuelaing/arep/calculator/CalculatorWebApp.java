package edu.escuelaing.arep.calculator;

import static spark.Spark.*;

import edu.escuelaing.arep.calculator.controllers.CalculatorWebController;

/**
 * CalculatorWebApp provee la API para consultar funciones a partir de un conjunto de datos.
 * @author Ricardo Martinez
 * @version 1.0
 */ 
public class CalculatorWebApp 
{
    public static void main(String[] args) {
        staticFileLocation("/public");
        port(getPort());
        CalculatorWebController cwc = new CalculatorWebController();
        cwc.loadAPI();
    }

    /**
     * This method reads the default port as specified by the PORT variable in the
     * environment.
     *
     * Heroku provides the port automatically so you need this to run the project on
     * Heroku.
     */
    static int getPort() {
        if (System.getenv("PORT") != null) {
        return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set (i.e. on localhost)
    }
    
}
