package Controladoras;

import Modelos.Cuenta;
import Modelos.Habitacion;
import Modelos.Hotel;
import Modelos.TipoHabitacion;
import java.io.*;
import java.util.ArrayList;

public class AdmDefinicion {

  private File miDir = new File(".");

  public boolean verificaNumero(int numero) {
    if (numero <= 0) {
      System.out.println("Debe ingresar un Número valido. Verifique !!!");
      return false;
    }
    return true;
  }

  public String verificaTiposHabitaciones(Habitacion habitacion) {
    if (habitacion.getTipHabitacion() != null || habitacion.getTipHabitacion().equals("")) {
      habitacion.setTipHabitacion("Single");
    }
    return habitacion.getTipHabitacion();
  }

  public int recalculaNumHab(ArrayList habitaciones) {
    return habitaciones.size();
  }

  public ArrayList<Habitacion> listaHabitaciones(String correo) {
    ArrayList<Habitacion> lista = new ArrayList<Habitacion>();
    FileReader fr = null;
    BufferedReader br = null;
    String linea, cadena1, cadena2, cadena3;
    int ini = 0, fin = 0;
    try {
      fr = new FileReader(new File(miDir.getCanonicalPath() + "/Habitaciones.txt"));
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
        if (cadena1.equals(correo)) {
          lista.add(new Habitacion(cadena1, cadena2, cadena3));
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
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

  public boolean buscarHabitacion(String correo, String nombre) {
    ArrayList<Habitacion> dbHabitacion = new ArrayList<Habitacion>();
    dbHabitacion = listaHabitaciones(correo);
    for (Habitacion hab : dbHabitacion) {
      if (hab.getCorreo().equals(correo) && hab.getNombre().equals(nombre)) {
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
      pw.print(hab.getCorreo().trim() + "," + hab.getNombre().trim() + "," + hab.getTipHabitacion().trim());
      log = true;
    } catch (Exception e) {
      e.printStackTrace();
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
      e.printStackTrace();
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
      e.printStackTrace();
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