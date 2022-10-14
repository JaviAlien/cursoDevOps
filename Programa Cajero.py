import datetime

#Clase Wrapper para los registros que se mostrarán en el Hístorico
class registro_historico:
    def __init__(self, fecha_hora, importe_retiro, saldo_anterior, saldo_actual):
        self.fecha_hora = fecha_hora
        self.importe_retiro = importe_retiro
        self.saldo_anterior = saldo_anterior
        self.saldo_actual = saldo_actual

#Menú Principal
def menu():
    print("MENU")
    print("1.- Consultar Saldo")
    print("2.- Retirar Saldo")
    print("3.- Histórico de Movimientos")

    try:
        input_opcion = int(input("Selecciona una opción del Menu:\t"))

        if input_opcion == 1:
            consultar_saldo()
        elif input_opcion == 2:
            print("Su saldo actual es de:\t$", saldo)
            retirar_saldo()
        elif input_opcion == 3:
            consulta_historicos()
        else:
            print("Por favor seleccione una de las opciones del Menú")
            menu()

    except:
        print("Por favor ingrese una opción númerica del Menú")

def consultar_saldo() :
    print("Su saldo actual es de: $", saldo)
    opciones_salida()

def retirar_saldo() :
    global saldo
    global listHistorico

    try:
        input_importeretiro = float(input("Por favor ingrese la cantidad que desea retirar:\t$"))

        if(input_importeretiro <= saldo) :
            saldo_anterior = saldo
            saldo -= input_importeretiro
            listHistorico.append(registro_historico(datetime.datetime.now(), input_importeretiro, saldo_anterior, saldo))
            print("Transacción exitosa, su saldo actual es de: $", saldo)

        else :
            print("Fondos insuficientes")

        opciones_salida()
    except:
        retirar_saldo()

def consulta_historicos():
    global listHistorico

    if not listHistorico :
        print("No existe registro de operaciones realizadas")
    else :
        for registro_historico in listHistorico :
            print("Hora:\t", registro_historico.fecha_hora.strftime("%m/%d/%Y %H:%M:%S"))
            print("Importe Retirado:\t$", registro_historico.importe_retiro)
            print("Saldo anterior al retiro:\t", registro_historico.saldo_anterior )

    opciones_salida()

def opciones_salida() :

    try:
        print("OPCIONES")
        print("4.- Menú Principal")
        print("5.- Salir")
        input_opcion = int(input("Selecciona una opción:\t"))
        if input_opcion == 4:
            menu()
        elif input_opcion == 5:
            inicio()
        else:
            print("Por favor seleccione una de las opciones listadas")
            opciones_salida()
    except:
            print("Por favor ingrese una opción númerica")
            opciones_salida()

#Login para acceder al Cajero
def inicio() :
    print("\nBienvenido a su cajero automático")

    password = "1235"
    intentos_vencidos = False
    numero_intento = 0
    ingreso_correcto = False

    while intentos_vencidos == False :

        if ingreso_correcto == False:
            input_password = input("Ingrese su contraseña:\t")

            if input_password == password :
                ingreso_correcto = True
                print("Bienvenido Javier\n")
                menu()
            else :
                if numero_intento == 2:
                    intentos_vencidos = True
                    print("Se ha excedido el número de intentos para ingresar a tu cuenta.")
                else :
                    print("Contraseña incorrecta, por favor intentalo nuevamente.")
                    numero_intento += 1

        else:
            menu()


#Variables globales de la Operación
saldo = 1000.00
listHistorico = []

#Inicio del Programa
inicio()

