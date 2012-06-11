package Modelos;

public class Precio extends TipoHabitacion {

  private String correo;

  public Precio(String correo, String tipHabitacion, double precio) {
    super(tipHabitacion, precio);
    this.correo = correo;
  }

  // Getters
  public String getCorreo() {
    return correo;
  }

  // Setters
  public void setCorreo(String correo) {
    this.correo = correo;
  }
}