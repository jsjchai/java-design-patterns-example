package com.github.jsjchai;

/**
 * @author jsjchai.
 */
public class OperationFactory {

    public static AbstractOperation createOperation(String operate){

        AbstractOperation oper = null;

        switch (operate){
            case "+":
                oper = new OperationAdd();
                break;
            case "-":
                oper = new OperationSub();
                break;
            case "*":
                oper = new OperationMul();
                break;
            case "/":
                oper = new OperationDiv();
                break;
            default: new IllegalArgumentException("Operate the unknown");
        }

        return oper;

    }
}
