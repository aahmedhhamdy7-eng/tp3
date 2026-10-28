package common;

import  java.io.Serializable;

public class Operation implements Serializable {
    public double a, b, resultat;
    public char op;

    public Operation(double a, char op, double b) {
        this.a = a;
        this.op = op;
        this.b = b;
    }
}
