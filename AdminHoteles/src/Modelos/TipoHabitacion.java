package Modelos;

public class TipoHabitacion {

  private String tipHabitacion;

  // Constructor
  public TipoHabitacion(String tipHabitacion) {
    this.tipHabitacion = tipHabitacion;
  }

  // Getters
  public String getDescripcion() {
    return tipHabitacion;
  }

  // Setters
  public void setDescripcion(String descripcion) {
    this.tipHabitacion = descripcion;
  }
}