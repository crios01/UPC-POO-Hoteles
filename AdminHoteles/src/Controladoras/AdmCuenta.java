package Controladoras;

import Modelos.Cuenta;
import Modelos.Hotel;
import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

  public boolean verificaCheck(boolean check) {
    if (check) {
      return true;
    }
    System.out.println("Debe aceptar los Términos y Condiciones.");
    return false;
  }

  public boolean buscaCuenta(String correo) {
    leerTabla();
    for (Cuenta cuenta : dbCuentas) {
      if (cuenta.getCorreo().equals(correo)) {
        return false;
      }
    }
    return true;
  }

  public ArrayList<Hotel> listaHoteles(String hotel) {
    FileReader fr = null;
    BufferedReader br = null;
    ArrayList<Hotel> lista = new ArrayList<Hotel>();
    String linea;
    try {
      fr = new FileReader(new File(miDir.getCanonicalPath() + "/Hoteles.txt"));
      br = new BufferedReader(fr);
      int cont = 0;
      while ((linea = br.readLine()) != null) {
        if (hotel.equals(linea.substring(0, hotel.length()))) {
          lista.add(new Hotel(linea));
          cont++;
        }
        if (cont == 5) {
          break;
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

  public boolean escribirCuenta(Cuenta cuenta) {
    if (!buscaCuenta(cuenta.getCorreo())) {
      System.out.println("Cuenta de Correo ya existe. Verifique ... !!!");
      return false;
    }
    FileWriter fw = null;
    PrintWriter pw = null;
    boolean log = false;
    try {
      fw = new FileWriter(new File(miDir.getCanonicalPath() + "/Archivo.txt"), true);
      pw = new PrintWriter(fw);
      char acepta = cuenta.getCheck() ? '1' : '0' ;
      pw.print(cuenta.getCorreo().trim() + "," + cuenta.getClave().trim() + ","
              + cuenta.getNomHotel().trim() + "," + cuenta.getDirClerk().trim() + "," + acepta + "\n");
      log = true;
      System.out.println("Cuenta Registrada correctamente.");
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

  public boolean registrarCuenta(String correo, String clave1, String clave2, String nomHotel, String dirClerk, boolean check) {
    if (!verificaCadena(correo, "Correo Electrónico") && !verificaCorreo(correo)) {
      return false;
    }
    if (!verificaCadena(clave1, "Contraseña") && !verificaCadena(clave2, "Verifica Contraseña") && !comparaClaves(clave1, clave2)) {
      return false;
    }
    if (!verificaCadena(nomHotel, "Nombre Hotel") && !verificaCheck(check)) {

      return false;
    }
    if (!buscaCuenta(correo)) {
      System.out.println("Cuenta de Correo ya existe y se no puede registrar. Verifique ... !!!");
      return false;
    }
    Cuenta cuenta = new Cuenta(correo, clave1, nomHotel, dirClerk, check);
    if (escribirCuenta(cuenta)) {
      System.out.println("Registro finalizado satisfactoriamente");
      System.out.println("Le llegara un correo a la dirección consignada y tiene");
      System.out.println("48 horas para realizar la confirmación. Adicionalmente");
      System.out.println("se le asigna un Plan gratuito hasta que cambie a un plan");
      System.out.println("con costo.");
    }
    return false;
  }
}
