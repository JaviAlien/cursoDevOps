/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.cajeroautomatico;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Cambio realizado en branch Develop
 * @author gener
 */
public class CajeroAutomatico {

    private static Double saldo = 1000.00;
    static List<registro_historico> listaHistoricos = new ArrayList<>(); 
    static Scanner entradaTeclado = new Scanner(System.in);  // Create a Scanner object
    
    public static void main(String[] args) {
        login();
    }
    
    public static void login(){
        
        String password = "1235";
        Boolean intentos_vencidos = false;
        Integer numero_intento = 0;
        Boolean ingreso_correcto = false;

        System.out.println("Bienvenido a su Cajero Automatico");

        while(!intentos_vencidos){
            if (!ingreso_correcto){
                System.out.println("Ingrese su contraseña númerica.");
                
                Integer opcion_seleccionada;
                String input_password = entradaTeclado.nextLine();
                if (!input_password.matches("[0-9]+")) {
                    if(numero_intento == 2){
                        intentos_vencidos = true;
                        System.out.println("Se ha excedido el número de intentos para ingresar a tu cuenta.");
                    }else{
                        System.out.println("Contraseña incorrecta, por favor intentalo nuevamente.");
                        numero_intento += 1;
                    }
                }else{                     
                    opcion_seleccionada = Integer.parseInt(input_password);
                    //String input_password = entradaTeclado.nextLine();
                    if(input_password.equals(password)){
                        ingreso_correcto = true;
                        System.out.println("Bienvenido Javier");
                        menu();
                    }else{
                        if(numero_intento == 2){
                            intentos_vencidos = true;
                            System.out.println("Se ha excedido el número de intentos para ingresar a tu cuenta.");
                        }else{
                            System.out.println("Contraseña incorrecta, por favor intentalo nuevamente.");
                            numero_intento += 1;
                        }
                    }
                }
            }
        }                      

    
    }
    
    public static void menu(){
                        
        System.out.println("MENU");
        System.out.println("1.- Consultar Saldo");
        System.out.println("2.- Retirar Saldo");
        System.out.println("3.- Histórico de Movimientos");
        System.out.println("Selecciona una opción del Menu:");  
        
            Integer opcion_seleccionada;
            String input_opcion = entradaTeclado.nextLine();
            if (!input_opcion.matches("[0-9]+")) {
                System.out.println("Por favor ingrese una opción númerica");
                menu();
            }else{
                opcion_seleccionada = Integer.parseInt(input_opcion);

                switch(opcion_seleccionada){
                    case 1:
                        consultar_saldo();
                        break;
                    case 2: 
                        System.out.println("Su saldo actual es de:\t$" + saldo);
                        retirar_saldo();                   
                        break;
                    case 3:
                        consulta_historicos();
                        break;
                    default:
                        System.out.println("Por favor seleccione una de las opciones del Menú");
                        menu();
                        break;

                }
            }

    }
    
    public static void consultar_saldo(){
        System.out.println("Su saldo actual es de: $" +  saldo);
        opciones_salida();
    }
    
    public static void retirar_saldo(){
        System.out.println("Por favor ingrese la cantidad exacta que desea retirar (incluir decimales)):\t$");
        //double input_importeretiro = entradaTeclado.nextDouble();
        
            Double cantidadRetiro;
            String input_importeretiro = entradaTeclado.nextLine();
            if (!input_importeretiro.matches("[0-9]+[.]+[0-9]")) {
                retirar_saldo();
            }else{
                cantidadRetiro = Double.parseDouble(input_importeretiro);
                if(cantidadRetiro <= saldo) {
                    double saldo_anterior = saldo;
                    saldo -= cantidadRetiro;

                    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                    Date date = new Date();

                    listaHistoricos.add(new registro_historico(dateFormat.format(date), cantidadRetiro, saldo_anterior, saldo));
                    System.out.println("Transacción exitosa, su saldo actual es de: $" + saldo);
                }else{
                     System.out.println("Fondos insuficientes");
                }
            }

        opciones_salida();
    }
 
    public static void consulta_historicos(){
        if(listaHistoricos.isEmpty()){
            System.out.println("No existe registro de operaciones realizadas");
        }else{
                for(registro_historico registro : listaHistoricos){
                    System.out.println("Hora:\t" + registro.getfecha_hora());
                    System.out.println("Importe Retirado:\t$" + registro.getimporte_retiro());
                    System.out.println("Saldo anterior al retiro:\t" + registro.getsaldo_anterior());
                    System.out.println("-----------------------------------------------------------");
                }

        }
        opciones_salida();
    }
    
    public static void opciones_salida(){
    
        System.out.println("OPCIONES");
        System.out.println("4.- Menú Principal");
        System.out.println("5.- Salir");

        Integer opcion_seleccionada;
        String input_opcion = entradaTeclado.nextLine();
        if (!input_opcion.matches("[0-9]+")) {
            System.out.println("Por favor ingrese una opción númerica");
            opciones_salida();
        }else{     
            opcion_seleccionada = Integer.parseInt(input_opcion);
            switch(opcion_seleccionada){
                case 4:
                    menu();
                    break;
                case 5 :
                    login();
                    break;
                default:
                    System.out.println("Por favor seleccione una de las opciones listadas");
                    opciones_salida();
                    break;
            }
        }        
    }
    
}
