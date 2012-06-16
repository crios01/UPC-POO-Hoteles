package Menus;

import Controladoras.*;
import Modelos.*;
import java.io.*;
import java.util.*;
import java.text.*;

public class MDefinicion {

  private String nCorreo;
  private AdmDefinicion admDefinicion = new AdmDefinicion();
  private ArrayList<Habitacion> habitacion = new ArrayList<Habitacion>();
  private ArrayList<TipoHabitacion> dbTipHab;
  private ArrayList<Precio> dbPrecios = new ArrayList<Precio>();

  public String getnCorreo() {
    return nCorreo;
  }

  public void setnCorreo(String nCorreo) {
    this.nCorreo = nCorreo;
  }

  public boolean menuDefinicion() {
    try {
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      String sNumHab = null;
      int iNumHab = 0;
      // Numero de Habitaciones
      while (true) {
        System.out.println("Cuantas Habitaciones tiene su Hotel ? ");
        sNumHab = in.readLine();
        if (admDefinicion.verificaNumero(sNumHab)) {
          iNumHab = Integer.parseInt(sNumHab);
          break;
        }
      }
      // Tipos de Habitaciones
      for (int i = 1; i <= iNumHab; i++) {
        habitacion.add(new Habitacion(i, this.nCorreo, "", "Single"));
      }
      // Mantenimiento de Habitaciones
      String opcion = "";
      Habitacion habita = null;
      int iItem = 0;
      String nombre = null;
      String tipHab = null;
      while (opcion != "S") {
        muestraDatosHab();
        while (true) {
          System.out.println("Ingrese su opción: (A)gregar, (M)odificar, (E)liminar, (S)alir > ");
          opcion = in.readLine().toUpperCase();
          if (opcion.equals("A") || opcion.equals("M") || opcion.equals("E") || opcion.equals("S")){
            break;
          }
        }
        // Agregar
        if (opcion.equals("A")) {
          iItem = habitacion.size() + 1;
          nombre = inNombre();
          tipHab = inTipHab();
          habitacion.add(new Habitacion(iItem, nCorreo, nombre, tipHab));
          iNumHab = habitacion.size();
        }
        // Modificar
        if (opcion.equals("M")) {
          iItem = inItem(habitacion.size(), "Modificar");
          nombre = inNombre();
          tipHab = inTipHab();
          habita = new Habitacion(iItem, nCorreo, nombre, tipHab);
          habitacion.set(iItem-1, habita);
        }
        // Eliminar
        if (opcion.equals("E")) {
          iItem = inItem(habitacion.size(), "Eliminar");
          habitacion.remove(iItem - 1);
          for (int i = 1; i <= habitacion.size(); i++) {
            habita = habitacion.get(i - 1);
            habita.setItem(i);
            habitacion.set(i - 1, habita);
          }
          iNumHab = habitacion.size();
        }
        // Si es (S) ==> Salir
        if (opcion.equals("S")){
          System.out.println("Esta seguro de salir ?");
          opcion = in.readLine().toUpperCase();
          if (opcion.equals("S")){
            admDefinicion.escribirHabitacion(habitacion);
            break;
          }
        }
      }
      // Mantenimiento de Precios
      dbTipHab = admDefinicion.listaTipHabs();
      int cont = 1;
      for (TipoHabitacion tipoHabita : dbTipHab) {
        dbPrecios.add(new Precio(cont, nCorreo, tipoHabita.getTipHabitacion(), "NS", 0.0, "US", 0.0, "EU", 0.0));
        cont++;
      }
      // Precios
      String iMone = null;
      Precio precio = null;
      double iPrecio1 = 0.0;
      double iPrecio2 = 0.0;
      double iPrecio3 = 0.0;
      while (true) {
        muestraDatosPre();
        iItem = inItem(dbPrecios.size(), "Modificar");
        iMone = inMoneda();
        iPrecio1 = inPrecio("Soles");
        iPrecio2 = inPrecio("Dólare");
        iPrecio3 = inPrecio("Euros");
        precio = dbPrecios.get(iItem - 1);
        dbPrecios.set(iItem - 1, precio);
        System.out.println();
        System.out.println("Presione cualquier tecla para continuar o (S) para salir y grabar: ");
        opcion = in.readLine().toUpperCase();
        if (opcion.equals("S")){
          if (verificaPrecios()){
            admDefinicion.escribirPrecios(dbPrecios);
            System.out.println("Se grabaron los datos satisfactoriamente.");
            break;
          }
        }
      }
      return true;
    } catch (Exception e) {
      e.printStackTrace(); // Escribe la misma línea del texto de error, además del número exacto de línea de código.
      return false;
    }
  }

  public boolean verificaPrecios(){
    for (Precio pre : dbPrecios){
      if (!(pre.getPrecio1() > 0 && pre.getPrecio2() > 0) ||
          !(pre.getPrecio2() > 0 && pre.getPrecio3() > 0) |
          !(pre.getPrecio3() > 0 && pre.getPrecio1() > 0)){
        System.out.println("Debe ingresar al menos 2 precios.");
        return false;
      }
    }
    return true;
  }
  
  public double inPrecio(String cadena) {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String opcion = null;
    double iPrecio = 0.0;
    try {
      while (true) {
        System.out.println("Ingrese Precio " + cadena + ": ");
        opcion = in.readLine();
        if (verificaDoble(opcion)) {
          iPrecio = Double.parseDouble(opcion);
          break;
        } else {
          System.out.println("Ingrese un precio valido ...");
          System.out.println();
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return iPrecio;
  }

  public String inMoneda() {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String opcion = null;
    try {
      while (opcion != "1" && opcion != "2" && opcion != "3") {
        System.out.println("Ingrese Moneda a Modificar: (1) Sóles, (2) Dólares, (3) Euros > ");
        opcion = in.readLine();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return opcion;
  }

  public void muestraDatosPre() {
    Formatter fmt;
    Formatter fItem = new Formatter();
    DecimalFormat frmt = new DecimalFormat("####.##");
    System.out.println();
    System.out.println();
    System.out.println("Item     Tipo      Soles  Dólares  Euros ");
    System.out.println("==== ============ ======= ======= =======");
    for (Precio precio : dbPrecios) {
      fmt = new Formatter();
      fmt.format("%04d", precio.getItem());
      System.out.println(fmt + " " + precio.getTipHabitacion() + " " + precio.getPrecio1()
              + frmt.format(precio.getPrecio1()) + " "
              + frmt.format(precio.getPrecio2()) + " "
              + frmt.format(precio.getPrecio3()));
//      fItem.format("%04d", precio.getItem());
//      System.out.println(fItem + " " + String.format("%1$-12", precio.getTipHabitacion()) + " "
//              + frmt.format(precio.getPrecio1()) + " "
//              + frmt.format(precio.getPrecio2()) + " "
//              + frmt.format(precio.getPrecio3()));
      System.out.println();
    }
  }

  public void muestraDatosHab() {
    Formatter fmt;
    System.out.println();
    System.out.println("Item   Nombre       Tipo    ");
    System.out.println("==== ========== ============");
    for (Habitacion hab : habitacion) {
      fmt = new Formatter();
      fmt.format("%04d", hab.getItem());
      System.out.println(fmt + " " + String.format("%1$-10s", hab.getNombre()) + " " + hab.getTipHabitacion());
    }
    System.out.println();
  }

  public int inItem(int numTotal, String tipo) {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String sItem = null;
    int iItem = 0;
    try {
      while (true) {
        System.out.println("Ingrese número de Item a " + tipo + ": ");
        sItem = in.readLine();
        if (admDefinicion.verificaNumero(sItem)) {
          iItem = Integer.parseInt(sItem);
          if (iItem > numTotal) {
            System.out.println("Item no existe. Verifique !!!");
          } else {
            break;
          }
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return iItem;
  }

  public String inNombre() {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String nombre = null;
    try {
      System.out.print(" Ingrese Nombre: ");
      nombre = in.readLine();
    } catch (Exception e) {
      e.printStackTrace(); // Escribe la misma línea del texto de error, además del número exacto de línea de código.
    }
    return nombre;
  }

  public String inTipHab() {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String tipHab = null;
    try {
      System.out.println();
      System.out.println("Tipo de Habitación");
      System.out.println("==================");
      System.out.println("1 - Single");
      System.out.println("2 - Doble");
      System.out.println("3 - Suite");
      System.out.println("4 - Departament");
      System.out.println("5 - Cabin");
      System.out.println("6 - Meeting Room");
      System.out.println();
      String opcion = in.readLine();
      if (opcion.equals("2")) {
        tipHab = "Doble";
      } else if (opcion.equals("3")) {
        tipHab = "Suite";
      } else if (opcion.equals("4")) {
        tipHab = "Departament";
      } else if (opcion.equals("5")) {
        tipHab = "Cabin";
      } else if (opcion.equals("6")) {
        tipHab = "Meeting Room";
      } else {
        tipHab = "Single";
      }
      System.out.println();
      System.out.println("Tipo de Habitación: " + tipHab);
    } catch (Exception e) {
      e.printStackTrace(); // Escribe la misma línea del texto de error, además del número exacto de línea de código.
    }
    return tipHab;
  }

  public boolean verificaDoble(String cadena) {
    try {
      Double.parseDouble(cadena);
      return true;
    } catch (NumberFormatException nfe) {
      return false;
    }
  }
} // System.out.println();