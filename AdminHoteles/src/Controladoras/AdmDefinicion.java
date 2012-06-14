package Controladoras;

import Modelos.*;
import java.io.*;
import java.util.ArrayList;

public class AdmDefinicion {

  private File miDir = new File(".");

  public boolean verificaNumero(int numero) {
    if (numero <= 0) {
      System.out.println("Debe ingresar un Cantidad valida. Verifique !!!");
      return false;
    }
    return true;
  }

  public String verificaTiposHabitaciones(String tipoHabitacion) {
    if (tipoHabitacion == null || tipoHabitacion.equals("")) {
      tipoHabitacion = "Single";
    }
    return tipoHabitacion;
  }

  // Habitaciones (En base al archivo Habitaciones.txt)
  public ArrayList<Habitacion> listaHabitaciones(String correo) {
    ArrayList<Habitacion> lista = new ArrayList<Habitacion>();
    FileReader fr = null;
    BufferedReader br = null;
    String linea, cadena1, cadena2, cadena3, cadena4;
    int item;
    int ini = 0, fin = 0;
    try {
      fr = new FileReader(new File(miDir.getCanonicalPath() + "/Habitaciones.txt"));
      br = new BufferedReader(fr);
      while ((linea = br.readLine()) != null) {
        ini = 0;
        fin = linea.indexOf(",");
        cadena1 = linea.substring(ini, fin);
        item = Integer.parseInt(cadena1);
        ini = fin + 1;
        fin = linea.indexOf(",", ini);
        cadena2 = linea.substring(ini, fin);
        ini = fin + 1;
        fin = linea.indexOf(",", ini);
        cadena3 = linea.substring(ini, fin);
        ini = fin + 1;
        fin = ini + 1;
        cadena4 = linea.substring(ini, fin);
        if (cadena1.equals(correo)) {
          lista.add(new Habitacion(item, cadena2, cadena3, cadena4));
        }
      }
    } catch (Exception e) {
      e.printStackTrace(); // Escribe la misma línea del texto de error, además del número exacto de línea de código.
    } finally {
      try {
        if (null != fr) {
          fr.close();
        }
      } catch (Exception e2) {
        e2.printStackTrace();
      }
    }
    return lista;
  }

  public boolean buscarHabitacion(int item, String correo) {
    ArrayList<Habitacion> dbHabitacion = new ArrayList<Habitacion>();
    dbHabitacion = listaHabitaciones(correo);
    for (Habitacion hab : dbHabitacion) {
      if (hab.getCorreo().equals(correo) && hab.getItem() == item) {
        return false;
      }
    }
    return true;
  }

  public boolean escribirHabitacion(Habitacion hab) {
    FileWriter fw = null;
    PrintWriter pw = null;
    boolean log = false;
    try {
      fw = new FileWriter(new File(miDir.getCanonicalPath() + "/Habitaciones.txt"), true);
      pw = new PrintWriter(fw);
      pw.print(String.valueOf(hab.getItem()).trim() + ","
              + hab.getCorreo().trim() + ","
              + hab.getNombre().trim() + ","
              + hab.getTipHabitacion().trim());
      log = true;
    } catch (Exception e) {
      e.printStackTrace(); // Escribe la misma línea del texto de error, además del número exacto de línea de código.
    } finally {
      try {
        if (null != fw) {
          fw.close();
        }
      } catch (Exception e2) {
        e2.printStackTrace();
      }
    }
    return log;
  }

  // Habitaciones (En base a los datos en Pantalla)
  public ArrayList<Habitacion> borrarHabitacion(ArrayList<Habitacion> dbHabitacion, int item) {
    ArrayList<Habitacion> dbHab = null;
    try {
      for (int i = 0; i < dbHabitacion.size(); i++) {
        if (dbHabitacion.get(i).getItem() == item) {
          dbHabitacion.remove(i);
          break;
        }
      }
      dbHab = dbHabitacion;
    } catch (Exception e) {
      e.printStackTrace(); // Escribe la misma línea del texto de error, además del número exacto de línea de código.
    }
    return dbHab;
  }

  public ArrayList<Habitacion> insertarHabitacion(ArrayList<Habitacion> dbHabitacion, Habitacion habitacion) {
    ArrayList<Habitacion> dbHab = null;
    try {
      dbHabitacion.add(habitacion);
      dbHab = dbHabitacion;
    } catch (Exception e) {
      e.printStackTrace(); // Escribe la misma línea del texto de error, además del número exacto de línea de código.
    }
    return dbHab;
  }

  public ArrayList<Habitacion> modificarHabitacion(ArrayList<Habitacion> dbHabitacion, Habitacion habitacion) {
    try {
      dbHabitacion.set(dbHabitacion.indexOf(habitacion), habitacion);
    } catch (Exception e) {
      e.printStackTrace(); // Escribe la misma línea del texto de error, además del número exacto de línea de código.
    }
    return dbHabitacion;
  }

  // Precios
  public boolean verificarPrecio(double precio) {
    if (precio > 0) {
      return true;
    }
    System.out.println("Debe ingresar un Precio valido. Verifique !!!");
    return false;
  }

  public ArrayList<Precio> listaPrecios(String correo) {
    ArrayList<Precio> precios = new ArrayList<Precio>();
    FileReader fr = null;
    BufferedReader br = null;
    String linea, cadena1, cadena2, cadena3, cadena4, cadena5, cadena6, cadena7, cadena8;
    int ini = 0, fin = 0;
    double precio4, precio6, precio8;
    try {
      fr = new FileReader(new File(miDir.getCanonicalPath() + "/Precios.txt"));
      br = new BufferedReader(fr);
      while ((linea = br.readLine()) != null) {
        ini = 0;
        fin = linea.indexOf(",");
        cadena1 = linea.substring(ini, fin);    // Correo
        ini = fin + 1;
        fin = linea.indexOf(",", ini);
        cadena2 = linea.substring(ini, fin);    // Tipo de Habitaciín
        ini = fin + 1;
        fin = linea.indexOf(",", ini);
        cadena3 = linea.substring(ini, fin);    // Moneda 1
        ini = fin + 1;
        fin = linea.indexOf(",", ini);
        cadena4 = linea.substring(ini, fin);    // Precio 4 - String
        precio4 = Double.parseDouble(cadena4);  // Precio 4 - Double
        ini = fin + 1;
        fin = linea.indexOf(",", ini);
        cadena5 = linea.substring(ini, fin);    // Moneda 2
        ini = fin + 1;
        fin = linea.indexOf(",", ini);
        cadena6 = linea.substring(ini, fin);    // Precio 6 - String
        precio6 = Double.parseDouble(cadena6);  // Precio 6 - Double
        ini = fin + 1;
        fin = linea.indexOf(",", ini);
        cadena7 = linea.substring(ini, fin);    // Moneda 3
        ini = fin + 1;
        fin = ini + 1;
        cadena8 = linea.substring(ini, fin);    // Precio 8 - String
        precio8 = Double.parseDouble(cadena8);  // Precio 8 - Double
        if (cadena1.equals(correo)) {
          precios.add(new Precio(cadena1, cadena2, cadena3, precio4, cadena5, precio6, cadena7, precio8));
        }
      }
    } catch (Exception e) {
      e.printStackTrace(); // Escribe la misma línea del texto de error, además del número exacto de línea de código.
    } finally {
      try {
        if (null != fr) {
          fr.close();
        }
      } catch (Exception e2) {
        e2.printStackTrace();
      }
    }
    return precios;
  }

  public double buscarPrecio(String correo, String tipHab, String moneda) {
    ArrayList<Precio> dbPrecios = new ArrayList<Precio>();
    dbPrecios = listaPrecios(correo);
    double precio = 0;
    for (Precio pre : dbPrecios) {
      if (pre.getTipHabitacion().equals(tipHab) && pre.getMoneda1().equals(moneda)) {
        precio = pre.getPrecio1();
        break;
      }
      if (pre.getTipHabitacion().equals(tipHab) && pre.getMoneda2().equals(moneda)) {
        precio = pre.getPrecio2();
        break;
      }
      if (pre.getTipHabitacion().equals(tipHab) && pre.getMoneda3().equals(moneda)) {
        precio = pre.getPrecio3();
        break;
      }
    }
    return precio;
  }

  public boolean escribirPrecios(Precio precio) {
    FileWriter fw = null;
    PrintWriter pw = null;
    boolean log = false;
    try {
      fw = new FileWriter(new File(miDir.getCanonicalPath() + "/Precios.txt"), true);
      pw = new PrintWriter(fw);

      pw.print(precio.getCorreo() + "," + precio.getTipHabitacion() + "," + 
              precio.getMoneda1() + "," + precio.getPrecio1() + "," + 
              precio.getMoneda2() + "," + precio.getPrecio2()+ "," + 
              precio.getMoneda3() + "," + precio.getPrecio3());
      log = true;
    } catch (Exception e) {
      e.printStackTrace(); // Escribe la misma línea del texto de error, además del número exacto de línea de código.
    } finally {
      try {
        if (null != fw) {
          fw.close();
        }
      } catch (Exception e2) {
        e2.printStackTrace();
      }
    }
    return log;
  }

  // Tipo de Habitaciones
  public ArrayList<TipoHabitacion> listaTipHabs() {
    ArrayList<TipoHabitacion> dbTipoHab = new ArrayList<TipoHabitacion>();
    FileReader fr = null;
    BufferedReader br = null;
    try {
      fr = new FileReader(new File(miDir.getCanonicalPath() + "/tipoHabitacioness.txt"));
      br = new BufferedReader(fr);
      String linea;
      while ((linea = br.readLine()) != null) {
        dbTipoHab.add(new TipoHabitacion(linea));
      }
    } catch (Exception e) {
      e.printStackTrace(); // Escribe la misma línea del texto de error, además del número exacto de línea de código.
    } finally {
      try {
        if (null != fr) {
          fr.close();
        }
      } catch (Exception e2) {
        e2.printStackTrace();
      }
    }
    return dbTipoHab;
  }

  public boolean buscarTipHab(String tipHab) {
    ArrayList<TipoHabitacion> dbTipoHab = new ArrayList<TipoHabitacion>();
    dbTipoHab = listaTipHabs();
    for (TipoHabitacion tipo : dbTipoHab) {
      if (tipo.getTipHabitacion().equals(tipHab)) {
        return false;
      }
    }
    return true;
  }

  public boolean escribirTipHab(TipoHabitacion tipHab) {
    if (!buscarTipHab(tipHab.getTipHabitacion())) {
      System.out.println("Tipo de Habitación ya existe. Verifique !!!");
      return false;
    }
    FileWriter fw = null;
    PrintWriter pw = null;
    boolean log = false;
    try {
      fw = new FileWriter(new File(miDir.getCanonicalPath() + "/tipoHabitaciones.txt"), true);
      pw = new PrintWriter(fw);
      pw.print(tipHab.getTipHabitacion() + "\n");
      log = true;
      System.out.println("Tipo de Habitación Registrada correctamente.");
    } catch (Exception e) {
      e.printStackTrace(); // Escribe la misma línea del texto de error, además del número exacto de línea de código.
    } finally {
      try {
        if (null != fw) {
          fw.close();
        }
      } catch (Exception e2) {
        e2.printStackTrace();
      }
    }
    return log;
  }
}