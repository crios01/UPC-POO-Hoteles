package adminhoteles;

import Controladoras.AdmDefinicion;
import Controladoras.datosPrueba;
import Modelos.Habitacion;
import java.util.ArrayList;

public class AdminHoteles {

  public static void main(String[] args) {
    datosPrueba datos = new datosPrueba();
    ArrayList<Habitacion> dbHabitacion = datos.llenarTablaHabitacion();
    System.out.println(dbHabitacion.size());
    System.out.println();
    for (Habitacion hab : dbHabitacion){
      System.out.println(dbHabitacion.indexOf(hab));
    }
    
    Habitacion hab = null;
    
    System.out.println();
    hab = dbHabitacion.get(25);
    System.out.println(hab.getItem() + ", " + hab.getCorreo() + ", " + hab.getNombre() + ", " + hab.getTipHabitacion() + ", " + hab.getPrecio());
    
    Habitacion habNueva = new Habitacion(26, "mfernandez@hotmail.com", "226", "Single", 50.00);
    System.out.println("Index: " + dbHabitacion.indexOf(hab));
    dbHabitacion.set(25, habNueva);
    
    System.out.println();
    hab = dbHabitacion.get(25);
    System.out.println(hab.getItem() + ", " + hab.getCorreo() + ", " + hab.getNombre() + ", " + hab.getTipHabitacion() + ", " + hab.getPrecio());
    
  }
}