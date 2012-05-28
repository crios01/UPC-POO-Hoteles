package Controladoras;

import Modelos.Cuenta;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class admCuenta {

  private ArrayList<Cuenta> dbCuentas = new ArrayList<Cuenta>();
  private File miDir = new File(".");

  public void leerTabla() {
    FileReader fr = null;
    BufferedReader br = null;

    try {
      fr = new FileReader(new File(miDir.getCanonicalPath() + "/Archivo.txt"));
      br = new BufferedReader(fr);
      String linea, cadena1, cadena2, cadena3, cadena4, cadena5;
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
        this.dbCuentas.add(new Cuenta(cadena1, cadena2, cadena3, cadena4, cadena5));
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

  public boolean verificaCadena(String cadena) {
    if (cadena != null) {
      return true;
    }
    return false;
  }

  public boolean verificaCorreo(String correo) {
    Pattern pat = null;
    Matcher mat = null;
    pat = Pattern.compile("^([0-9a-zA-Z]([_.w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-w]*[0-9a-zA-Z].)+([a-zA-Z]{2,9}.)+[a-zA-Z]{2,3})$");
    mat = pat.matcher(correo);
    if (mat.find()) {
      System.out.println("[" + mat.group() + "]");
      return true;
    }
    return false;
  }

  public boolean comparaClaves(String clave1, String clave2) {
    if (clave1.equals(clave2)) {
      return true;
    }
    return false;
  }

  public boolean verificaCheck(char check) {
    if (check == '1') {
      return true;
    }
    return false;
  }

  public Cuenta buscaCuenta(String correo) {
    leerTabla();
    Cuenta cuentaEncontrada = null;
    for (Cuenta cuenta : dbCuentas) {
      if (cuenta.getCorreo().equals(correo)) {
        cuentaEncontrada = cuenta;
      }
    }
    return cuentaEncontrada;
  }

  public boolean registraCuenta(Cuenta cuenta) {
    FileWriter fw = null;
    PrintWriter pw = null;
    try {
      fw = new FileWriter(new File(miDir.getCanonicalPath() + "/Archivo.txt"));
      pw = new PrintWriter(fw);
      pw.println(cuenta.getCorreo().trim() + "," + cuenta.getClave().trim() + "," + 
                  cuenta.getNomHotel().trim() + "," + cuenta.getDirClerk().trim() + "," + cuenta.getCheck().trim());
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
    return false;
  }

//  public boolean verificaFecha(String fechax) {
//    try {
//      SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
//      Date fecha = formatoFecha.parse(fechax);
//    } catch (Exception e) {
//      return false;
//    }
//    return true;
//  }
}