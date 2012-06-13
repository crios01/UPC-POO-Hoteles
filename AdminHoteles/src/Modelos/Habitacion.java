package Modelos;

public class Habitacion extends TipoHabitacion {

  private int item;
  private String correo;
  private String nombre;

  // Constructor
  public Habitacion(int item, String correo, String nombre, String tipHabitacion, double precio) {
    super(tipHabitacion, precio);
    this.item = item;
    this.correo = correo;
    this.nombre = nombre;
  }

  // Getters
  public int getItem() {
    return item;
  }

  public String getCorreo() {
    return correo;
  }

  public String getNombre() {
    return nombre;
  }

  // Setters
  public void setItem(int item) {
    this.item = item;
  }

  public void setCorreo(String correo) {
    this.correo = correo;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
}