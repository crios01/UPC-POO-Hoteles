package Modelos;

public class TipoHabitacion {

  private String tipHabitacion;
  private double precio;

  // Constructor
  public TipoHabitacion(String tipHabitacion, double precio) {
    this.tipHabitacion = tipHabitacion;
    this.precio = precio;
  }

  // Getters
  public String getTipHabitacion() {
    return tipHabitacion;
  }

  public double getPrecio() {
    return precio;
  }

  // Setters
  public void setTipHabitacion(String tipHabitacion) {
    this.tipHabitacion = tipHabitacion;
  }

  public void setPrecio(double precio) {
    this.precio = precio;
  }
}