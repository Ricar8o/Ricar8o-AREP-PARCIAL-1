package edu.escuelaing.arep.calculator.model;
/**
 * @author Ricar8o
 * @version 1.0
 */
public class Operation {
    private OperationType operationType;
    private double radians;
    private double result;

    /**
     * Constructor
     * @param oType tipo de operacion
     * @param value calor numerico de la operacion.
     */
    public Operation(OperationType oType, double value) {
        this.operationType = oType;
        this.radians = value;
    }
    /**
     * Metodo para hacer la operacion.
     */
    public void operate() {
        if (operationType == OperationType.COS) {
            coseno();
        } else if (operationType == OperationType.SIN) {
            seno();
        } else if (operationType == OperationType.TAN) {
            tangente();
        }
    }
    /**
     * Realizar coseno
     */
    private void coseno() {
        this.result  = Math.cos(this.radians);
    }
    /**
     * Realizar seno
     */
    private void seno() {
        this.result  = Math.sin(this.radians);
    }
    /**
     * Realizar tangente
     */
    private void tangente() {
        this.result  = Math.tan(this.radians);
    }
}
