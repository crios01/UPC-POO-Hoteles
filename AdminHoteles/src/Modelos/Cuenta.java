package Modelos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Cuenta extends Hotel {

  private String correo;
  private String clave;
  private String dirClerk;
  private boolean check;

  // Contructor
  public Cuenta(String correo, String clave, String nomHotel, String dirClerk, boolean check) {
    super(nomHotel);
    this.correo = correo;
    this.clave = clave;
    this.dirClerk = dirClerk;
    this.check = check;
  }

  // Getters
  public String getCorreo() {
    return correo;
  }

  public String getClave() {
    return clave;
  }

  public String getDirClerk() {
    return dirClerk;
  }

  public boolean getCheck() {
    return check;
  }
}