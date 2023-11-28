package Controlador;

import Modelo.Conejo;
import Modelo.Gato;
import Modelo.Perro;

import java.net.CookieHandler;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ControladorVeterinaria {
    private ArrayList<Gato> michis;
    private ArrayList<Perro> perritos;
    private ArrayList<Conejo> conejitos;
    private static ControladorVeterinaria instance = null;

    private ControladorVeterinaria(){
        michis= new ArrayList<>();
        perritos= new ArrayList<>();
        conejitos= new ArrayList<>();
    }

    public static ControladorVeterinaria getInstance(){
        if(instance==null){
            instance= new ControladorVeterinaria();
        }
        return instance;
    }

    public void agregarGato(String dueño, String nombre, String color, int edad, Date fechaNac){
        Gato gatito = buscaGato(dueño,nombre);
        if (gatito==null){
            michis.add(new Gato(dueño,nombre,color,edad,fechaNac));
        }else {
            System.out.println("no se pudo agregar");
        }

    }

    public void agregarPerro(String dueño, String nombre, String color, int edad, Date fechaNac){
        Perro perrito = buscaPerro(dueño,nombre);
        if (perrito==null){
            perritos.add(new Perro(dueño,nombre,color,edad,fechaNac));
        } else {
            System.out.println("no se pudo agregar");
        }

    }

    public void agregarConejo(String dueño, String nombre, String color, int edad, Date fechaNac){
        Conejo conejito = buscaConejo(dueño,nombre);
        if (conejito==null){
            conejitos.add(new Conejo(dueño,nombre,color,edad,fechaNac));
        }else {
            System.out.println("no se pudo agregar");
        }
    }

    public String[][] listaGatos(){
        if(michis.size()!=0){
            String [][] gatitos = new String[michis.size()][5];
            int i =0;
            for (Gato gato : michis){
                gatitos[i][0]= gato.getNombreDueño();
                gatitos[i][1]= gato.getNombre() ;
                gatitos[i][2]= gato.getColor();
                gatitos[i][3]= String.valueOf(gato.getEdad()) ;
                String format="dd MMMM yyyy";
                SimpleDateFormat simpleDateFormat=new SimpleDateFormat(format);
                gatitos[i][4]= simpleDateFormat.format(gato.getFechaNacimiento());
                i++;
            }
            return gatitos;
        }
        return new String[0][0];
    }

    public String[][] listaPerros(){
        if(perritos.size()!=0){
            String [][] misPerritos = new String[perritos.size()][5];
            int i =0;
            for (Perro perro : perritos){
                misPerritos[i][0]= perro.getNombreDueño();
                misPerritos[i][1]= perro.getNombre() ;
                misPerritos[i][2]= perro.getColor();
                misPerritos[i][3]= String.valueOf(perro.getEdad()) ;
                String format="dd MMMM yyyy";
                SimpleDateFormat simpleDateFormat=new SimpleDateFormat(format);
                misPerritos[i][4]= simpleDateFormat.format(perro.getFechaNacimiento());
                i++;
            }
            return misPerritos;
        }
        return new String[0][0];
    }

    public String[][] listaConejos(){
        if(conejitos.size()!=0){
            String [][] misConejitos = new String[conejitos.size()][5];
            int i =0;
            for (Conejo conejo : conejitos){
                misConejitos[i][0]= conejo.getNombreDueño();
                misConejitos[i][1]= conejo.getNombre() ;
                misConejitos[i][2]= conejo.getColor();
                misConejitos[i][3]= String.valueOf(conejo.getEdad()) ;
                String format="dd MMMM yyyy";
                SimpleDateFormat simpleDateFormat=new SimpleDateFormat(format);
                misConejitos[i][4]= simpleDateFormat.format(conejo.getFechaNacimiento());
                i++;
            }
            return misConejitos;
        }
        return new String[0][0];
    }

    public void eliminarGato(String dueño, String nombre) {
        Gato gatito = buscaGato(dueño,nombre);
        if(gatito!=null){
            michis.remove(gatito);
            System.out.println("dado de alta con exito");
        }else {
            System.out.println("no existe");
        }
    }

    public void eliminarPerro(String dueño, String nombre){
        Perro perrito = buscaPerro(dueño,nombre);
        if(perrito!=null){
            perritos.remove(perrito);
            System.out.println("dado de alta con exito");
        }else {
            System.out.println("no existe");
        }
    }

    public void eliminarConejo(String dueño, String nombre){
        Conejo conejito = buscaConejo(dueño,nombre);
        if(conejito!=null){
            conejitos.remove(conejito);
            System.out.println("dado de alta con exito");
        }else {
            System.out.println("no existe");
        }
    }
    private Gato buscaGato(String dueño, String nombre){
        for (Gato gato : michis){
            if (gato.getNombreDueño().equalsIgnoreCase(dueño)&&gato.getNombre().equalsIgnoreCase(nombre)){
                return gato;
            }
        }
        return null;
    }

    private Perro buscaPerro(String dueño, String nombre){
        for (Perro perro : perritos){
            if (perro.getNombreDueño().equalsIgnoreCase(dueño)&&perro.getNombre().equalsIgnoreCase(nombre)){
                return perro;
            }
        }
        return null;
    }

    private Conejo buscaConejo(String dueño, String nombre){
        for (Conejo conejo : conejitos){
            if (conejo.getNombreDueño().equalsIgnoreCase(dueño)&&conejo.getNombre().equalsIgnoreCase(nombre)){
                return conejo;
            }
        }
        return null;
    }
}
