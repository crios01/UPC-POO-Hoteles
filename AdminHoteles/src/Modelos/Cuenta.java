package Modelos;

public class Cuenta {

  private String correo;
  private String clave;
  private String nomHotel;
  private String dirClerk;
  private String check;

  // Contructor
  public Cuenta(String correo, String clave, String nomHotel, String dirClerk, String check) {
    this.correo = correo;
    this.clave = clave;
    this.nomHotel = nomHotel;
    this.dirClerk = dirClerk;
    this.check = check;  // 1 = con check   y   0 = sin check 
  }

  // Setters
  public void setCorreo(String correo) {
    this.correo = correo;
  }

  public void setClave(String clave) {
    this.clave = clave;
  }

  public void setNomHotel(String nomHotel) {
    this.nomHotel = nomHotel;
  }

  public void setDirClerk(String dirClerk) {
    this.dirClerk = dirClerk;
  }

  public void setCheck(String check) {
    this.check = check;
  }

  // Getters
  public String getClave() {
    return clave;
  }

  public String getCorreo() {
    return correo;
  }

  public String getDirClerk() {
    return dirClerk;
  }

  public String getNomHotel() {
    return nomHotel;
  }

  public String getCheck() {
    return check;
  }
}