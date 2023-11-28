package Vista;

import Controlador.ControladorVeterinaria;

import java.sql.SQLOutput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class UIVeterinaria {
    private static UIVeterinaria instance = null;
    private Scanner tec = new Scanner(System.in);

    private UIVeterinaria(){

    }
     public static UIVeterinaria getInstance(){
        if (instance==null){
            instance=new UIVeterinaria();
        }
        return instance;
     }
     int validacion=0;
     public void inicioSesion(){
         int ciclo=0;
         String user;
         String contraseña;
         String contraseñaD;
         String usuarioV="Vet";
         String usuarioD="Dueno";
         String contraV="1234";
         String contraD="0000";



        System.out.println("**** Veterinaria PetLove ****");
        System.out.println("         Menu principal       ");
        System.out.println("1. Iniciar sesion como Veterinario");
        System.out.println("2. Iniciar sesion como dueño");
        System.out.println("3. Salir");
        validacion= tec.nextInt();
       do{
           switch (validacion){
               case 1:
                   System.out.println("Inicio sesion Veterinario");
                   System.out.println("Ingrese su usuario:");
                   user=tec.next();
                   if(user.equals(usuarioV)){
                       System.out.println("Ingrese su contraseña:");
                       contraseña=tec.next();
                       if(contraV.equals(contraseña)){
                           System.out.println("sesion iniciada con exito");
                           ciclo=1;
                           menuVeterinario();
                       }else{

                           System.out.println("Contraseña incorrecta volver a intentar");
                       }
                   }else{
                       System.out.println("Usuario incorrecto volver a intentar");
                   }


                   break;
               case 2:
                   System.out.println("Inicio sesion Dueño");
                   System.out.println("Ingrese su usuario:");
                   user=tec.next();
                   if(user.equals(usuarioD)){
                       System.out.println("Ingrese su contraseña:");
                       contraseñaD=tec.next();
                       if(contraseñaD.equals(contraD)){
                           System.out.println("sesion iniciada con exito");
                           ciclo=1;
                            menuDueño();
                       }else{
                           System.out.println("Contraseña incorrecta volver a intentar");
                       }
                   }else{
                       System.out.println("Usuario incorrecto volver a intentar");
                   }
                   break;
               case 3: System.exit(1);
                   break;
               default:
                   System.out.println("opcion ingresada invalida");
                   inicioSesion();
           }
       }while (ciclo==0);
    }
     public void menuVeterinario(){
        int op, masc = 0;
        do {
            System.out.println("**** Veterinaria PetLove ****");
            System.out.println("       **** Menu ****        ");
            System.out.println("1. agregar mascota al sistema");
            System.out.println("2. listar mascotas");
            System.out.println("3. Dar de alta");
            System.out.println("4. volver al menu principal");
            op=tec.nextInt();
            if(op==1 ||op==2||op==3){
                System.out.println("Escoja la mascota");
                System.out.println("1. gato");
                System.out.println("2. perro");
                System.out.println("3. conejo");
                masc= tec.nextInt();
            }
            switch (op){
                case 1 : agregarMascota(masc);
                break;
                case 2 : listarMascota(masc);
                break;
                case 3 : eliminarMascota(masc);
                break;
                case 4 : System.out.println("Saliendo....");
                inicioSesion();
                break;
                default : System.out.println("incorrecto");
            }

        }while (op!=4);


     }
     public void menuDueño(){
         int op, masc = 0;
         do {
             System.out.println("**** Veterinaria PetLove ****");
             System.out.println("       **** Menu ****        ");
             System.out.println("1. agregar mascota al sistema");
             System.out.println("2. volver al menu principal");
             op=tec.nextInt();
             if(op==1 ||op==2||op==3){
                 System.out.println("Escoja la mascota");
                 System.out.println("1. gato");
                 System.out.println("2. perro");
                 System.out.println("3. conejo");
                 masc= tec.nextInt();
             }
             switch (op){
                 case 1 : agregarMascota(masc);
                 break;
                 case 2 : System.out.println("Saliendo....");
                 inicioSesion();
                 break;
                 default : System.out.println("incorrecto");
             }

         }while (op!=2);
     }
      public void agregarMascota(int mascota){
          System.out.println("Agregando Mascota");
          System.out.println("Nombre del dueño: ");
          tec.nextLine();
          String dueño = tec.nextLine();
          System.out.println("Nombre de la Mascota");
          String nombre = tec.nextLine();
          System.out.println("color: ");
          String color = tec.nextLine();
          int edad =0;
          do {
              System.out.println("edad (en años): ");
              edad = tec.nextInt();
              if (edad==0){
                  edad=1;
              }
          }while (edad<0);
          int fec=0;
          do {
              System.out.println("fecha de nacimiento (dd/MM/yyyy): ");
              String nacimiento = tec.next();
              SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
              try {
                  Date fecha = df.parse(nacimiento);
                  Date actual = new Date(123,7,28);
                  if (fecha.after(actual)) {
                      fec = 0;
                      System.out.println("la fecha de nacimiento no puede ser despues de la fecha actual");
                  } else{
                  if (fecha.before(actual)) {
                      fec=1;
                      switch (mascota) {
                          case 1 -> ControladorVeterinaria.getInstance().agregarGato(dueño, nombre, color, edad, fecha);
                          case 2 -> ControladorVeterinaria.getInstance().agregarPerro(dueño, nombre, color, edad, fecha);
                          case 3 -> ControladorVeterinaria.getInstance().agregarConejo(dueño, nombre, color, edad, fecha);
                      }
                  }else {
                      System.out.println("la fecha de nacimiento no puede ser igual a la fecha actual");
                      fec = 0;
                      }
                  }
              } catch (ParseException e) {
                  throw new RuntimeException(e);
              }
          }while (fec==0);
      }

      public void listarMascota(int mascota){
          String[][] lista;
        switch (mascota){
            case 1 -> lista=ControladorVeterinaria.getInstance().listaGatos();
            case 2 -> lista=ControladorVeterinaria.getInstance().listaPerros();
            case 3 -> lista= ControladorVeterinaria.getInstance().listaConejos();
            default -> throw new IllegalStateException("Unexpected value: " + mascota);
        }
        if (lista.length>0){
            System.out.println("listaaaa");
            System.out.println("--------------");
            System.out.printf("%-15s%-15s%-15s%-15s%-15s%n","Nombre dueño","nombre Mascota","Color","Edad","fecha de nacimiento");
            for (String[] linea : lista) {
                System.out.printf("%-15s%-15s%-15s%-15s%-15s%n", linea[0], linea[1], linea[2], linea[3], linea[4]);
            }
        }else {
            System.out.println("\nNo hay mascotas");
        }
      }

      public void eliminarMascota(int mascota){
          System.out.println("eliminando Mascota");
          System.out.println("Ingrese el nombre del dueño: ");
          tec.nextLine();
          String dueño = tec.nextLine();
          System.out.println("Ingrese el nombre de la mascota: ");
          String nombre = tec.nextLine();
          switch (mascota){
              case 1 -> ControladorVeterinaria.getInstance().eliminarGato(dueño,nombre);
              case 2 -> ControladorVeterinaria.getInstance().eliminarPerro(dueño,nombre);
              case 3 -> ControladorVeterinaria.getInstance().eliminarConejo(dueño,nombre);
          }

      }
}
