package edu.escuelaing.arep.calculator.services;

import edu.escuelaing.arep.calculator.model.Operation;
import edu.escuelaing.arep.calculator.model.OperationType;

public class CalculatorWebServices {

	public Operation getOperationTrig(String num, String func) {
        Double number = Double.parseDouble(num);
        OperationType opType = OperationType.NONE;
        if (func.toUpperCase().equals("SIN")){
            opType = OperationType.SIN;
        }else if (func.toUpperCase().equals("COS")){
            opType = OperationType.COS;
        }else if (func.toUpperCase().equals("TAN")){
            opType = OperationType.TAN;
        }
        Operation op = new Operation(opType, number);
        op.operate();
		return op;
	}
    
    
}
