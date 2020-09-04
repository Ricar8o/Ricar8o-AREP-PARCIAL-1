package edu.escuelaing.arep.calculator;

import static spark.Spark.*;

import java.io.*;
import java.net.*;

import spark.Request;
import spark.Response;

public class CalculatorWebFacade {
    private static boolean running = true;
    private static String ruta = "https://warm-ravine-42413.herokuapp.com/api/";

    public static void main(String[] args) throws Exception {
        staticFileLocation("/public2/");
        port(5001);
        get("/api/calculate", (req, res) -> calculate(req, res));
        // while (running) {
        //
        // }
    }

    private static String calculate(Request req, Response res) {
        URL url;
        try {
            res.type("application/json");
            String cadena = "func/trig?number=%s&function=%s";
            String nuevaRuta = ruta + String.format(cadena, req.queryParams("number"),req.queryParams("function"));
            url = new URL(nuevaRuta);
            URLConnection conn = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String consulta = "";
            String inputLine;

            while ((inputLine = in.readLine()) != null) 
                consulta+= inputLine ;
            in.close();
            return consulta;
        } catch (Exception e) {
            e.printStackTrace();
            return "Consulta fallida";
        }
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
