package co.edu.unicauca.proyectosegundoparcial.test;
import java.util.Calendar;
import java.util.Scanner;
import co.edu.unicauca.proyectosegundoparcial.modelos.Bahia;
import co.edu.unicauca.proyectosegundoparcial.modelos.Conductor;
import co.edu.unicauca.proyectosegundoparcial.modelos.Entrada;
import co.edu.unicauca.proyectosegundoparcial.modelos.EnumAreaTrabajo;
import co.edu.unicauca.proyectosegundoparcial.modelos.EnumTipoVehiculo;
import co.edu.unicauca.proyectosegundoparcial.modelos.EnumZona;
import co.edu.unicauca.proyectosegundoparcial.modelos.Parqueadero;
import co.edu.unicauca.proyectosegundoparcial.modelos.Persona;
import co.edu.unicauca.proyectosegundoparcial.modelos.Vehiculo;
import co.edu.unicauca.proyectosegundoparcial.modelos.VehiculoNoEncontradoException;
import co.edu.unicauca.proyectosegundoparcial.modelos.Vigilante;

//Codigo presentado por Jose David Arteaga Fernandez

public class test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        //Paso a) Crear vigilante
        Vigilante objVigilante1 = new Vigilante("123456", "Pedro", "Arteaga", 1950, 06, 28, EnumZona.NORTE);
        
        //Paso b) Crear parqueadero
        Parqueadero objParqueadero = new Parqueadero("Colanta, parqueadero norte");
        
        //Paso c) Añadir 5 bahias
        objParqueadero.registrarBahia(12345, false);
        objParqueadero.registrarBahia(54321, false);
        objParqueadero.registrarBahia(78912, false);
        objParqueadero.registrarBahia(32198, false);
        objParqueadero.registrarBahia(45612, true);
        Bahia objBahia1 = objParqueadero.getBahias(0);
        Bahia objBahia2 = objParqueadero.getBahias(1);
        Bahia objBahia3 = objParqueadero.getBahias(2);
        Bahia objBahia4 = objParqueadero.getBahias(3);
        Bahia objBahia5 = objParqueadero.getBahias(4);
        
        //Paso d) Consultar bahia
        System.out.println("Metodo Consultar bahia ejecutandose...");
        boolean banderaBahia = false;
        Bahia objBahiaObt1 = objParqueadero.consultarBahia(12345);
        banderaBahia = objBahiaObt1.getEstado();
        if(banderaBahia==false){
            System.out.println("Bahia ocupada");
            System.out.println("");
        }else{
            System.out.println("Bahia disponible");
            System.out.println("");
        }
        
        //Paso e) Crear conductor
        Conductor objConductor1 = new Conductor("1002961156", "Daniel", "Alonso", 1999, 11, 03, EnumAreaTrabajo.CONTABLE);
        Conductor objConductor2 = new Conductor("1002961165", "Milena", "Ramirez", 1966, 07, 03, EnumAreaTrabajo.DESARROLLO);
        Conductor objConductor3 = new Conductor("1009162263", "Julian", "Alvarez", 2002, 03, 05, EnumAreaTrabajo.ATENCION);
        
        //Paso f) Crear vehiculo
        Vehiculo objVehiculo1 = new Vehiculo("KYP80", EnumTipoVehiculo.MOTO);
        Vehiculo objVehiculo2 = new Vehiculo("TUS551", EnumTipoVehiculo.CARRO);
        Vehiculo objVehiculo3 = new Vehiculo("AYK666", EnumTipoVehiculo.CARRO);
        
        //Paso g) Creación de entradas
        Entrada objEntrada1 = new Entrada(16, 2023, 5, 5, objBahia1, objVehiculo1, objConductor1);
        Entrada objEntrada2 = new Entrada(17, 2023, 5, 5, objBahia2, objVehiculo2, objConductor2);
        Entrada objEntrada3 = new Entrada(18, 2023, 5, 5, objBahia5, objVehiculo3, objConductor3);
        
        //Paso h) Agregar entradas al parqueadero
        objParqueadero.agregarEntrada(objEntrada1);
        objParqueadero.agregarEntrada(objEntrada2);
        objParqueadero.agregarEntrada(objEntrada3);
        
        //Mensaje de bienvenida
        System.out.println("Bienvenido a "+ objParqueadero.getNombre());
        System.out.println("");
        
        //Paso i) Consultar vehiculo por placa
        System.out.print("Ingrese la placa del vehiculo a consultar: ");
        String placa = scanner.nextLine();
        
        Entrada objEntradaEncontrada = null;
        try {
            objEntradaEncontrada = objParqueadero.consultarEntradaVehiculo(placa);
        }catch (VehiculoNoEncontradoException e) {
            System.out.println("Mensaje de error:  " + e.getMessage());
            System.out.println("");
        }
        
        if(objEntradaEncontrada != null){
            System.out.println("El vehiculo de placa "+objEntradaEncontrada.getObjVehiculo().getPlaca()+ " esta en la bahia "+objEntradaEncontrada.getObjBahia().getNoBahia() );
            imprimirEntradaVehiculoCOnsultado(objEntradaEncontrada);
        }
        
        
        //Paso j) Generar informe
        
        System.out.println("Nombre del parqueadero: "+ objParqueadero.getNombre());
        
        System.out.println("Datos del vigilante: ");
        imprimirPersona(objVigilante1);
        System.out.println("");
        
        int cantidadBahiasOcupadas = objParqueadero.consultarCantidadBahiasOcupadas();
        System.out.println("Cantidad bahias ocupadas: "+ cantidadBahiasOcupadas);
        
        //Imprimir entradas
        System.out.println("Datos de las entradas: ");
        for (int i = 0; i < objParqueadero.getEntradas().size(); i++) {
            System.out.println(" ");
            System.out.println("Entrada Numero "+(i+1)+":");
            imprimirEntrada(objParqueadero.getEntradas().get(i));
        }
              
    }
    public static void imprimirEntradaVehiculoCOnsultado(Entrada objEntradaMIA){
        System.out.println("*******************************************");
        int anio = objEntradaMIA.getFechaEntrada().get(Calendar.YEAR);
        int mes = objEntradaMIA.getFechaEntrada().get(Calendar.MONTH)+1;
        int dia = objEntradaMIA.getFechaEntrada().get(Calendar.DATE);
        int anioNac = objEntradaMIA.getObjConductor().getFechaNac().get(Calendar.YEAR);
        int mesNac = objEntradaMIA.getObjConductor().getFechaNac().get(Calendar.MONTH)+1;
        int diaNac = objEntradaMIA.getObjConductor().getFechaNac().get(Calendar.DATE);
        int hora = objEntradaMIA.getFechaEntrada().get(Calendar.HOUR);
        int minutos = objEntradaMIA.getFechaEntrada().get(Calendar.MINUTE);
        int segundos = objEntradaMIA.getFechaEntrada().get(Calendar.SECOND);
        
        System.out.println("Fecha de entrada: "+dia+"/"+mes+"/"+anio+" - "+"Hora entrada: "+hora+":"+minutos+":"+segundos);
        System.out.println("Placa: "+objEntradaMIA.getObjVehiculo().getPlaca()+" - "+"Tipo  vehiculo: "+objEntradaMIA.getObjVehiculo().getTipo());
        System.out.println("No bahia: " + objEntradaMIA.getObjBahia().getNoBahia());
        System.out.println("Conductor: No Identificacion: "+objEntradaMIA.getObjConductor().getNoIdentificacion()+" - Nombres: "+ objEntradaMIA.getObjConductor().getNombres() +" Apellidos: "+ objEntradaMIA.getObjConductor().getApellidos() + " Fecha: "+ diaNac+"/"+mesNac+"/"+anioNac);
        System.out.println("");
    }
    public static void imprimirEntrada(Entrada objEntrada) {
        System.out.println("*******************************************");
        int anio = objEntrada.getFechaEntrada().get(Calendar.YEAR);
        int mes = objEntrada.getFechaEntrada().get(Calendar.MONTH)+1;
        int dia = objEntrada.getFechaEntrada().get(Calendar.DATE);
        int anioNac = objEntrada.getObjConductor().getFechaNac().get(Calendar.YEAR);
        int mesNac = objEntrada.getObjConductor().getFechaNac().get(Calendar.MONTH)+1;
        int diaNac = objEntrada.getObjConductor().getFechaNac().get(Calendar.DATE);
        int hora = objEntrada.getFechaEntrada().get(Calendar.HOUR);
        int minutos = objEntrada.getFechaEntrada().get(Calendar.MINUTE);
        int segundos = objEntrada.getFechaEntrada().get(Calendar.SECOND);
        
        System.out.println("Fecha de entrada: "+dia+"/"+mes+"/"+anio+" - "+"Hora entrada: "+hora+":"+minutos+":"+segundos);
        System.out.println("************** INFO VEHICULOS *************");
        imprimirVehiculo(objEntrada.getObjVehiculo());
        System.out.println("**************** INFO BAHIAS **************");
        System.out.println("No bahia: " + objEntrada.getObjBahia().getNoBahia());
        System.out.println("*************** INFO CONDUCTOR ************");
        System.out.println("Conductor: No Identificacion: "+objEntrada.getObjConductor().getNoIdentificacion()+" - Nombres: "+ objEntrada.getObjConductor().getNombres() +" Apellidos: "+ objEntrada.getObjConductor().getApellidos() + " Fecha: "+ diaNac+"/"+mesNac+"/"+anioNac);
        System.out.println("Area de trabajo: "+objEntrada.getObjConductor().getAreaTrabaja());
    }

    public static void imprimirVehiculo(Vehiculo objVehiculo) {
        System.out.println("Placa: " + objVehiculo.getPlaca());
        System.out.println("Tipo de vehiculo: " + objVehiculo.getTipo());
    }

    public static void imprimirPersona(Persona objPersona) {
        int anio = objPersona.getFechaNac().get(Calendar.YEAR);
        int mes = objPersona.getFechaNac().get(Calendar.MONTH) + 1;
        int dia = objPersona.getFechaNac().get(Calendar.DATE);
        System.out.println("Numero de identificacion: " + objPersona.getNoIdentificacion());
        System.out.println("Nombres: " + objPersona.getNombres());
        System.out.println("Apellidos: " + objPersona.getApellidos());
        System.out.println("Fecha de nacimiento: ");
        System.out.println(anio+"/"+mes+"/"+dia);
        if(objPersona instanceof Conductor){
            System.out.println("Area de trabajo: " + ((Conductor) objPersona).getAreaTrabaja());
        }
        if(objPersona instanceof Vigilante){
            System.out.println("Zona de trabajo: " + ((Vigilante) objPersona).getZonaTrabajo());
        }
    }
}
