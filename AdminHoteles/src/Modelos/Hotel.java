package Modelos;

public class Hotel {

  private String correo;
  private String password1;
  private String password2;
  private String nombreHotel;
  private String webHotel;
  private boolean agreeHotel;
  private byte flagOK = 1;
  private int numHabitaciones;

  public boolean comparaPassword() {
    if (password2.equals(this.getPassword1())) {
      return true;
    } else {
      this.setFlagOK((byte) 0);
      return false;
    }
  }

  /**
   * @return the correo
   */
  public String getCorreo() {
    return correo;
  }

  /**
   * @param correo the correo to set
   */
  public void setCorreo(String correo) {
    int posArroba = correo.indexOf("@");
    int posPunto = correo.indexOf(".", posArroba + 1);
    int difPos = Math.abs(posArroba - posPunto);

    if (correo.length() <= 0) {
      this.setFlagOK((byte) 0);
      System.out.println("Debe ingresar correo electrónico");
    } else {
      if ((difPos <= 1) | (posPunto == (correo.length() - 1))) {
        this.correo = "";
        this.setFlagOK((byte) 0);
        System.out.println("Debe ingresar correo electrónico válido");
      } else {
        this.correo = correo;
      }
    }

  }

  /**
   * @return the password1
   */
  public String getPassword1() {
    return password1;
  }

  /**
   * @param password1 the password1 to set
   */
  public void setPassword1(String password1) {
    if (password1.length() >= 6) {
      this.password1 = password1;
    } else {
      this.password1 = "";
      this.setFlagOK((byte) 0);
      System.out.println("La clave debe tener por lo menos 6 caracteres");
    }

  }

  /**
   * @return the password2
   */
  public String getPassword2() {
    return password2;
  }

  /**
   * @param password2 the password2 to set
   */
  public void setPassword2(String password2) {
    if (password2.length() >= 6) {
      this.password2 = password2;
    } else {
      this.password2 = "";
      this.setFlagOK((byte) 0);
      System.out.println("La clave de validación debe tener por lo menos 6 caracteres");
    }

  }

  /**
   * @return the nombreHotel
   */
  public String getNombreHotel() {
    return nombreHotel;
  }

  /**
   * @param nombreHotel the nombreHotel to set
   */
  public void setNombreHotel(String nombreHotel) {
    if (nombreHotel.length() > 0) {
      this.nombreHotel = nombreHotel;
    } else {
      this.nombreHotel = "";
      this.setFlagOK((byte) 0);
      System.out.println("Debe ingresar nombre del Hotel");
    }

  }

  /**
   * @return the webHotel
   */
  public String getWebHotel() {
    return webHotel;
  }

  /**
   * @param webHotel the webHotel to set
   */
  public void setWebHotel(String webHotel) {
    if (webHotel.length() > 0) {
      this.webHotel = "http://www." + webHotel + ".clerk.im";
    } else {
      this.webHotel = "";
      this.setFlagOK((byte) 0);
      System.out.println("Ingrese la dirección web del Hotel");
    }

  }

  /**
   * @return the agreeHotel
   */
  public boolean isAgreeHotel() {
    return agreeHotel;
  }

  /**
   * @param arrayRegistro1 the agreeHotel to set
   */
  public void setAgreeHotel(boolean agreeHotel) {
    this.agreeHotel = agreeHotel;
    if (agreeHotel == false) {
      this.setFlagOK((byte) 0);
      System.out.println("Debe estar de acuerdo con los términos y condiciones");
    }
  }

  /**
   * @return the flagOK
   */
  public byte getFlagOK() {
    return flagOK;
  }

  /**
   * @param flagOK the flagOK to set
   */
  public void setFlagOK(byte flagOK) {
    this.flagOK = flagOK;
  }

  /**
   * @return the numHabitaciones
   */
  public int getNumHabitaciones() {
    return numHabitaciones;
  }

  /**
   * @param numHabitaciones the numHabitaciones to set
   */
  public void setNumHabitaciones(int numHabitaciones) {
    if (numHabitaciones > 0) {
      this.numHabitaciones = numHabitaciones;
    } else {
      this.setFlagOK((byte) 0);
      System.out.println("Debe ingresar un número de habitaciones válido");
    }
  }
}