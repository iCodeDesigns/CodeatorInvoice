/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._0_3_CodeatorLib.GeneralOperations;

/**
 *
 * @author Eng_MahmoudAhmed
 */
public class MathOp {
    private double Add(double num1 , double num2){
        double result = 0.0;
        result = num1 + num2 ;
        return result;
    }
    
    private double Sub(double num1 , double num2){
        double result = 0.0;
        result = num1 - num2 ;
        return result;
    }
    
    private double Mul(double num1 , double num2){
        double result = 0.0;
        result = num1 * num2 ;
        return result;
    }
    
    private double Div(double num1 , double num2){
        double result = 0.0;
        result = num1 / num2 ;
        return result;
    }
    
    public double Inverse(double num1){
        double result = 0.0;
        result = num1 * (-1);
        return result;
    }
    
    private double Mode(double num1 , double num2){
        double result = 0.0;
        result = num1 % num2 ;
        return result;
    }
    
    public double Math(double num1 , double num2 , char operation){
        double result =0.0;
        switch (operation){
            case '+':  result=Add (num1, num2); break;
            case '-':  result=Sub (num1, num2); break;
            case '*':  result=Mul (num1, num2); break;
            case '/':  result=Div (num1, num2); break;
            case '%':  result=Mode(num1, num2); break; 
        }        
        return result;
    }
}
