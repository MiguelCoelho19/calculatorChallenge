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
    public double getA(){
        return a;
    }
    public double getB(){
        return b;
    }
    public int getPrecision(){
        return precision;
    }
    public void setA(double a){
        this.a = a;
    }
    public void setB(double b){
        this.b = b;
    }
    public void setPrecision(int precision){
        this.precision = precision;
    }
}
