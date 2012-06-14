package Controladoras;

import Modelos.*;
import java.util.ArrayList;

public class datosPrueba {

  public ArrayList<Habitacion> llenarTablaHabitacion() {
    ArrayList<Habitacion> dbHabitacion = new ArrayList<Habitacion>();
    dbHabitacion.add(new Habitacion(1, "mfernandez@hotmail.com", "101", "Single"));
    dbHabitacion.add(new Habitacion(2, "mfernandez@hotmail.com", "102", "Single"));
    dbHabitacion.add(new Habitacion(3, "mfernandez@hotmail.com", "103", "Single"));
    dbHabitacion.add(new Habitacion(4, "mfernandez@hotmail.com", "104", "Single"));
    dbHabitacion.add(new Habitacion(5, "mfernandez@hotmail.com", "105", "Single"));
    dbHabitacion.add(new Habitacion(6, "mfernandez@hotmail.com", "106", "Single"));
    dbHabitacion.add(new Habitacion(7, "mfernandez@hotmail.com", "107", "Doble"));
    dbHabitacion.add(new Habitacion(8, "mfernandez@hotmail.com", "108", "Doble"));
    dbHabitacion.add(new Habitacion(9, "mfernandez@hotmail.com", "109", "Doble"));
    dbHabitacion.add(new Habitacion(10, "mfernandez@hotmail.com", "110", "Doble"));
    dbHabitacion.add(new Habitacion(11, "mfernandez@hotmail.com", "111", "Doble"));
    dbHabitacion.add(new Habitacion(12, "mfernandez@hotmail.com", "112", "Doble"));
    dbHabitacion.add(new Habitacion(13, "mfernandez@hotmail.com", "113", "Suite"));
    dbHabitacion.add(new Habitacion(14, "mfernandez@hotmail.com", "114", "Suite"));
    dbHabitacion.add(new Habitacion(15, "mfernandez@hotmail.com", "115", "Suite"));
    dbHabitacion.add(new Habitacion(16, "mfernandez@hotmail.com", "116", "Suite"));
    dbHabitacion.add(new Habitacion(17, "mfernandez@hotmail.com", "117", "Suite"));
    dbHabitacion.add(new Habitacion(18, "mfernandez@hotmail.com", "118", "Suite"));
    dbHabitacion.add(new Habitacion(19, "mfernandez@hotmail.com", "119", "Departament"));
    dbHabitacion.add(new Habitacion(20, "mfernandez@hotmail.com", "120", "Departament"));
    dbHabitacion.add(new Habitacion(21, "mfernandez@hotmail.com", "121", "Departament"));
    dbHabitacion.add(new Habitacion(22, "mfernandez@hotmail.com", "122", "Departament"));
    dbHabitacion.add(new Habitacion(23, "mfernandez@hotmail.com", "123", "Departament"));
    dbHabitacion.add(new Habitacion(24, "mfernandez@hotmail.com", "124", "Departament"));
    dbHabitacion.add(new Habitacion(25, "mfernandez@hotmail.com", "125", "Cabin"));
    dbHabitacion.add(new Habitacion(26, "mfernandez@hotmail.com", "126", "Cabin"));
    dbHabitacion.add(new Habitacion(27, "mfernandez@hotmail.com", "127", "Cabin"));
    dbHabitacion.add(new Habitacion(28, "mfernandez@hotmail.com", "128", "Cabin"));
    dbHabitacion.add(new Habitacion(29, "mfernandez@hotmail.com", "129", "Cabin"));
    dbHabitacion.add(new Habitacion(30, "mfernandez@hotmail.com", "130", "Cabin"));
    dbHabitacion.add(new Habitacion(31, "mfernandez@hotmail.com", "131", "Meeting Room"));
    dbHabitacion.add(new Habitacion(32, "mfernandez@hotmail.com", "132", "Meeting Room"));
    dbHabitacion.add(new Habitacion(33, "mfernandez@hotmail.com", "133", "Meeting Room"));
    dbHabitacion.add(new Habitacion(34, "mfernandez@hotmail.com", "134", "Meeting Room"));
    dbHabitacion.add(new Habitacion(35, "mfernandez@hotmail.com", "135", "Meeting Room"));
    dbHabitacion.add(new Habitacion(36, "mfernandez@hotmail.com", "136", "Meeting Room"));
    return dbHabitacion;
  }

  public ArrayList<Precio> llenarTablaPrecios() {
    ArrayList<Precio> dbPrecio = new ArrayList<Precio>();
    dbPrecio.add(new Precio("mfernandez@hotmail.com", "Single", "NS", 100.00, "US", 37.00, "EU", 25.00));
    dbPrecio.add(new Precio("mfernandez@hotmail.com", "Doble", "NS", 200.00, "US", 74.00, "EU", 50.00));
    dbPrecio.add(new Precio("mfernandez@hotmail.com", "Suite", "NS", 300.00, "US", 112.00, "EU", 75.00));
    dbPrecio.add(new Precio("mfernandez@hotmail.com", "Departament", "NS", 400.00, "US", 150.00, "EU", 100.00));
    dbPrecio.add(new Precio("mfernandez@hotmail.com", "Cabin", "NS", 500.00, "US", 185.00, "EU", 125.00));
    dbPrecio.add(new Precio("mfernandez@hotmail.com", "Meeting Room", "NS", 600.00, "US", 225.00, "EU", 150.00));
    return dbPrecio;
  }
}