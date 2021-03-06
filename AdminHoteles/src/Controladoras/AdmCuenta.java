package Controladoras;

import Modelos.*;
import java.io.*;
import java.util.ArrayList;
import java.util.regex.*;

public class AdmCuenta {

  private ArrayList<Cuenta> dbCuentas = new ArrayList<Cuenta>();
  private File miDir = new File(".");

  public void leerTabla() {
    FileReader fr = null;
    BufferedReader br = null;
    try {
      fr = new FileReader(new File(miDir.getCanonicalPath() + "/Cuentas.txt"));
      br = new BufferedReader(fr);
      String linea, cadena1, cadena2, cadena3, cadena4, cadena5;
      boolean check5;
      int ini = 0, fin = 0;
      while ((linea = br.readLine()) != null) {
        ini = 0;
        fin = linea.indexOf(",");
        cadena1 = linea.substring(ini, fin);
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
        check5 = linea.equals('1') ? true : false;
        this.dbCuentas.add(new Cuenta(cadena1, cadena2, cadena3, cadena4, check5));
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
  }

  public boolean verificaCadena(String cadena, String tipo) {
    if (cadena != null) {
      return true;
    }
    System.out.println("Debe ingresar el campo " + tipo + ".");
    return false;
  }

  public boolean verificaCorreo(String correo) {
    Pattern pat = null;
    Matcher mat = null;
    pat = Pattern.compile("^([0-9a-zA-Z]([_.w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-w]*[0-9a-zA-Z].)+([a-zA-Z]{2,9}.)+[a-zA-Z]{2,3})$");
    mat = pat.matcher(correo);
    if (mat.find()) {
      return true;
    }
    System.out.println("Debe ingresar un Correo Electrónico valido.");
    return false;
  }

  public boolean comparaClaves(String clave1, String clave2) {
    if (clave1.equals(clave2)) {
      return true;
    }
    System.out.println("Las Claves son diferentes. Verifique ... !!!");
    return false;
  }

  public String generaDirClerk(String nomHotel) {
    nomHotel = "http://" + nomHotel.replaceAll(" ", "") + ".clerk.im";
    String nombre = nomHotel.toLowerCase().trim().toString();
    return nombre;
  }

  public boolean verificaCheck(String check) {
    if (check.equals("S")) {
      return true;
    }
    System.out.println("Debe aceptar los Términos y Condiciones.");
    return false;
  }

  public ArrayList<Hotel> listaHoteles(String hotel, int opcion) {  // 0-Todos, 1-Cinco coincidencias
    FileReader fr = null;
    BufferedReader br = null;
    ArrayList<Hotel> lista = new ArrayList<Hotel>();
    String linea;
    try {
      fr = new FileReader(new File(miDir.getCanonicalPath() + "/Hoteles.txt"));
      br = new BufferedReader(fr);
      int cont = 0;
      while ((linea = br.readLine()) != null) {
        if (hotel.equals(linea.substring(0, 2)) && opcion == 1) {
          lista.add(new Hotel(linea));
          cont++;
        } else {
          lista.add(new Hotel(linea));
        }
        if (cont == 5 && opcion == 1) {
          break;
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

  public boolean buscaHotel(String nomHotel) {
    ArrayList<Hotel> lista = listaHoteles("", 0);
    for (Hotel hotel : lista) {
      if (hotel.getNomHotel().trim().equals(nomHotel)) {
        return false;
      }
    }
    return true;
  }

  public boolean buscarCuenta(String correo) {
    leerTabla();
    for (Cuenta cuenta : dbCuentas) {
      if (cuenta.getCorreo().equals(correo)) {
        return false;
      }
    }
    return true;
  }

  public boolean escribirCuenta(Cuenta cuenta) {
    if (!buscarCuenta(cuenta.getCorreo())) {
      System.out.println("Cuenta de Correo ya existe. Verifique ... !!!");
      return false;
    }
    FileWriter fw = null;
    PrintWriter pw = null;
    boolean log = false;
    try {
      fw = new FileWriter(new File(miDir.getCanonicalPath() + "/Cuentas.txt"), true);
      pw = new PrintWriter(fw);
      char acepta = cuenta.getCheck() ? '1' : '0';
      pw.print(cuenta.getCorreo().trim() + "," + cuenta.getClave().trim() + ","
              + cuenta.getNomHotel().trim() + "," + cuenta.getDirClerk().trim() + "," + acepta + "\n");
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
}