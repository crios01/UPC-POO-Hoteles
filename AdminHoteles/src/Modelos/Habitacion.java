package Modelos;

public class Habitacion extends TipoHabitacion {

  private String correo;
  private String nombre;

  // Constructor
  public Habitacion(String correo, String nombre, String tipHabitacion) {
    super(tipHabitacion);
    this.correo = correo;
    this.nombre = nombre;
  }

  // Getters
  public String getCorreo() {
    return correo;
  }

  public String getNombre() {
    return nombre;
  }

  // Setters
  public void setCorreo(String correo) {
    this.correo = correo;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
}