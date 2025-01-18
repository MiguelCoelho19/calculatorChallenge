package com.challenge.rest;

public class PayloadHandler {
    private double a;
    private double b;
    private int precision;
    public PayloadHandler(){}
    public PayloadHandler(double a, double b, int precision){
        this.a = a;
        this.b = b;
        this.precision = precision;
    }
    public String toString(){
        return this.a + "," + this.b + "," + this.precision;
    }
}
