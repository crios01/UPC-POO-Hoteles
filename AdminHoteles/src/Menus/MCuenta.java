package Menus;

import Controladoras.*;
import Modelos.*;
import java.io.*;
import java.util.ArrayList;

public class MCuenta {

  private String nCorreo;

  public String getnCorreo() {
    return nCorreo;
  }

  public boolean menuCuenta() {
    boolean log = false;
    try {
      AdmCuenta admCuenta = new AdmCuenta();
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      String correo = null, clave1 = null, clave2 = null, nomHotel = null, dirClerk = null, opcion = null;
      boolean check = false;
      clear();
      System.out.println("====================");
      System.out.println("INFORMACIÓN PERSONAL");
      System.out.println("====================");
      // Correo Electrónico
      while (true) {
        System.out.println("Correo electrónico: ");
        correo = in.readLine();
        if (correo.trim().equals("0")) {
          return false;
        }
        if (admCuenta.verificaCadena(correo, "Correo") && admCuenta.verificaCorreo(correo)) {
          if (admCuenta.buscarCuenta(correo)) {
            break;
          } else {
            System.out.println("Correo electrónico ya existe. Verifique !!!");
          }
        }
      }
      // Contraseña
      while (true) {
        System.out.println("Escoje tu contraseña: ");
        clave1 = in.readLine();
        System.out.println("Repite tu contraseña: ");
        clave2 = in.readLine();
        if (admCuenta.verificaCadena(clave1, "Contraseña") && admCuenta.verificaCadena(clave2, "Contraseña")
                && admCuenta.comparaClaves(clave1, clave2)) {
          break;
        }
      }
      // Nombre de Hotel y dirección WEB
      while (true) {
        System.out.println("Nombre de Hotel: ");
        nomHotel = in.readLine();
        if (!admCuenta.buscaHotel(nomHotel)) {
          ArrayList<Hotel> lista = admCuenta.listaHoteles(nomHotel, 1);
          System.out.println("");
          System.out.println("Lista de Sugerencias");
          System.out.println("====================");
          for (Hotel hotel : lista) {
            System.out.println(hotel.getNomHotel());
          }
          System.out.println("");
          dirClerk = admCuenta.generaDirClerk(nomHotel);
          System.out.println("Dirección Web: " + dirClerk);
          break;
        } else {
          System.out.println("Nombre de Hotel no existe. Verifique !!!");
        }
      }
      // Terminos y condiciones
      while (!check) {
        System.out.println("He leído y acepto los Términos y Condiciones: (S)i / (N)o ");
        opcion = in.readLine().toUpperCase();
        if (opcion.equals("S") || opcion.equals("N")) {
          check = admCuenta.verificaCheck(opcion);
        }
      }
      // Confirmar la escritura de datos
      while (!opcion.equals("S") && !opcion.equals("N")) {
        System.out.println("Desea grabar los datos (S)i / (N)o ? ");
        opcion = in.readLine().toUpperCase();
      }
      // Escribir datos
      if (opcion.equals("S")) {
        Cuenta cuenta = new Cuenta(correo, clave1, nomHotel, dirClerk, check);
        if (admCuenta.escribirCuenta(cuenta)) {
          System.out.println("");
          System.out.println("Preceso finalizado. Su cuenta se ha creado satisfactoriamente.");
          System.out.println("Le llegara un mensaje a su correo el cual deberá ser confirmado");
          System.out.println("en las siguientes 24 horas de recibido.");
          System.out.println("Usted cuenta con un plan gratuito hasta que se cambie a uno de paga.");
          System.out.println("");
          nCorreo = correo;
          log = true;
        }
      } else {
        System.out.println("");
        System.out.println("Registro de datos Cancelado.");
      }
    } catch (Exception e) {
      e.printStackTrace(); // Escribe la misma línea del texto de error, además del número exacto de línea de código.
    }
    return log;
  }

  public void clear() {
    for (int i = 0; i < 200; i++) {
      System.out.println();
    }
  }
}
