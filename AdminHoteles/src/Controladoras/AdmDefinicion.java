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

  public int recalculaNumHab(ArrayList habitaciones) {
    return habitaciones.size();
  }

  // Habitaciones
  public ArrayList<Habitacion> listaHabitaciones(String correo) {
    ArrayList<Habitacion> lista = new ArrayList<Habitacion>();
    FileReader fr = null;
    BufferedReader br = null;
    String linea, cadena1, cadena2, cadena3, cadena4, cadena5;
    int item;
    double precio;
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
        fin = linea.indexOf(",", ini);
        cadena4 = linea.substring(ini, fin);
        ini = fin + 1;
        fin = ini + 1;
        cadena5 = linea.substring(ini, fin);
        precio = Double.parseDouble(cadena5);
        if (cadena1.equals(correo)) {
          lista.add(new Habitacion(item, cadena2, cadena3, cadena4, precio));
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
              + hab.getTipHabitacion().trim() + ","
              + String.valueOf(hab.getPrecio()).trim());
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

  // Precios
  public ArrayList<Precio> listaPrecios(String correo) {
    ArrayList<Precio> precios = new ArrayList<Precio>();
    FileReader fr = null;
    BufferedReader br = null;
    String linea, cadena1, cadena2, cadena3;
    int ini = 0, fin = 0;
    try {
      fr = new FileReader(new File(miDir.getCanonicalPath() + "/Precios.txt"));
      br = new BufferedReader(fr);
      while ((linea = br.readLine()) != null) {
        ini = 0;
        fin = linea.indexOf(",");
        cadena1 = linea.substring(ini, fin);
        ini = fin + 1;
        fin = linea.indexOf(",", ini);
        cadena2 = linea.substring(ini, fin);
        ini = fin + 1;
        fin = ini + 1;
        cadena3 = linea.substring(ini, fin);
        double precio = Double.parseDouble(cadena3);
        if (cadena1.equals(correo)) {
          precios.add(new Precio(cadena1, cadena2, precio));
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

  public double buscarPrecio(String correo, String tipHab) {
    ArrayList<Precio> dbPrecios = new ArrayList<Precio>();
    dbPrecios = listaPrecios(correo);
    double precio = 0;
    for (Precio pre : dbPrecios) {
      if (pre.getTipHabitacion().equals(tipHab)) {
        precio = pre.getPrecio();
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

      //pw.print(pre.getCorreo() + "," + pre.getTipHabitacion() + "," + pre.getPrecio());
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
        dbTipoHab.add(new TipoHabitacion(linea, 0));
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

  public boolean borrarHabitacion(ArrayList<Habitacion> dbHabitacion, int item) {
    boolean log = false;
    try {
      for (int i = 0; i < dbHabitacion.size(); i++) {
        if (dbHabitacion.get(i).getItem() == item) {
          dbHabitacion.remove(i);
          log = true;
          break;
        }
      }
    } catch (Exception e) {
      e.printStackTrace(); // Escribe la misma línea del texto de error, además del número exacto de línea de código.
    }
    return log;
  }

  public boolean agregarHabitacion(ArrayList<Habitacion> dbhabitacion, Habitacion habitacion) {
    boolean log = false;
    try {
      dbhabitacion.add(habitacion);
      log = true;
    } catch (Exception e) {
      e.printStackTrace(); // Escribe la misma línea del texto de error, además del número exacto de línea de código.
    }
    return true;
  }
}
