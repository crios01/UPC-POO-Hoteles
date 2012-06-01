package Modelos;

public class Habitacion extends TipoHabitacion {

  private String nombre;

  // Constructor
  public Habitacion(String nombre, String tipHabitacion) {
    super(tipHabitacion);
    this.nombre = nombre;
  }

  // Getters
  public String getNombre() {
    return nombre;
  }

  // Setters
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
}