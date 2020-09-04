package edu.escuelaing.arep.calculator.controllers;

import static spark.Spark.*;

import com.google.gson.Gson;

import edu.escuelaing.arep.calculator.model.Operation;
import edu.escuelaing.arep.calculator.services.CalculatorWebServices;
import spark.Request;
import spark.Response;

/**
 * @author Ricar8o
 * @version 1.0
 */
public class CalculatorWebController {

    private CalculatorWebServices cws;

    public CalculatorWebController() {
        this.cws = new CalculatorWebServices();
    }

	public void loadAPI() {
        get("/api/hello", (req, res) -> "Hello Heroku");
        get("/api/func/trig",(req, res) -> calculateTrig(req, res) ) ;
    }
    
     /**
     * Este metodo recibe una peticion con los datos a los cuales les va a sacar la media.
     * @param req Request
     * @param res Response
     * @return El valor de la media y la desviacion estandar de los datos, separados por una linea.
     */
    private String calculateTrig(Request req, Response res) {
        res.type("application/json");
        Operation operation = cws.getOperationTrig(req.queryParams("number"),req.queryParams("function"));
        String cadena = new Gson().toJson(operation);
        return cadena;
    }

    
    
}
