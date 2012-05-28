package Modelos;

public class Habitacion {

  private String codCuenta;
  private String codHabitacion;
  private String Nomhabitacion;
  private String tipoHabitacion;
  private int numHabitacion;
  public String[][] arrayHabitaciones;

  public Habitacion(int pFilas, int pCampos) {
    arrayHabitaciones = new String[pFilas][pCampos];
  }

  public void defineHabitacion(int pFila, String pNombre, String pTipoHab) {
    arrayHabitaciones[pFila][0] = pNombre;
    if (pTipoHab.trim().length() > 0) {
      arrayHabitaciones[pFila][1] = pTipoHab;
    } else {
      arrayHabitaciones[pFila][1] = "Simple";
    }

  }

  public int getNumHabitacion() {
    return numHabitacion;
  }

  public void setNumHabitacion(int numHabitacion) {
    if (numHabitacion > 0) {
      this.numHabitacion = numHabitacion;
    } else {
      System.out.println("El número de habitaciones no puede ser menor o igual a cero");
    }

  }

  public String getCodCuenta() {
    return codCuenta;
  }

  public void setCodCuenta(String codCuenta) {
    this.codCuenta = codCuenta;
  }

  public String getCodHabitacion() {
    return codHabitacion;
  }

  public void setCodHabitacion(String codHabitacion) {
    this.codHabitacion = codHabitacion;
  }

  public String getNomhabitacion() {
    return Nomhabitacion;
  }

  public void setNomhabitacion(String nomhabitacion) {
    Nomhabitacion = nomhabitacion;
  }

  public String getTipoHabitacion() {
    return tipoHabitacion;
  }

  public void setTipoHabitacion(String tipoHabitacion) {
    this.tipoHabitacion = tipoHabitacion;
  }
}