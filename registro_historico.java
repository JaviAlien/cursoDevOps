/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package com.mycompany.cajeroautomatico;

import java.util.Date;

/**
 *
 * @author gener
 */
public class registro_historico {
    
    private String fecha_hora;
    private double importe_retiro;
    private double saldo_anterior;
    private double saldo_actual;
    
    public String getfecha_hora() {
        return fecha_hora;
    }

    public void setfecha_hora(String fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public double getimporte_retiro() {
        return importe_retiro;
    }

    public void setimporte_retiro(double importe_retiro) {
        this.importe_retiro = importe_retiro;
    }
    
        public double getsaldo_anterior() {
        return saldo_anterior;
    }

    public void setsaldo_anterior(double saldo_anterior) {
        this.saldo_anterior = saldo_anterior;
    }
    
        public double getsaldo_actual() {
        return saldo_actual;
    }

    public void setsaldo_actual(double saldo_actual) {
        this.saldo_actual = saldo_actual;
    }
    
    public registro_historico(String fecha_hora, double importe_retiro, double saldo_anterior, double saldo_actual ){
    
        this.fecha_hora = fecha_hora;
        this.importe_retiro = importe_retiro;
        this.saldo_anterior = saldo_anterior;
        this.saldo_actual = saldo_actual;
    
    }
    
}
