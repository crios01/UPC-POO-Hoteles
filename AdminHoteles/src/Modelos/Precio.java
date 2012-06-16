package Modelos;

public class Precio extends TipoHabitacion {

  private int item;
  private String correo;
  private String moneda1;
  private double precio1;
  private String moneda2;
  private double precio2;
  private String moneda3;
  private double precio3;

  // Contructor
  public Precio(int item, String correo, String tipHabitacion, String moneda1, double precio1, String moneda2, double precio2, String moneda3, double precio3) {
    super(tipHabitacion);
    this.item = item;
    this.correo = correo;
    this.moneda1 = moneda1;
    this.precio1 = precio1;
    this.moneda2 = moneda2;
    this.precio2 = precio2;
    this.moneda3 = moneda3;
    this.precio3 = precio3;
  }

  // Getters
  public int getItem() {
    return item;
  }

  public String getCorreo() {
    return correo;
  }

  public String getMoneda1() {
    return moneda1;
  }

  public String getMoneda2() {
    return moneda2;
  }

  public String getMoneda3() {
    return moneda3;
  }

  public double getPrecio1() {
    return precio1;
  }

  public double getPrecio2() {
    return precio2;
  }

  public double getPrecio3() {
    return precio3;
  }

  //Setters
  public void setPrecio1(double precio1) {
    this.precio1 = precio1;
  }

  public void setPrecio2(double precio2) {
    this.precio2 = precio2;
  }

  public void setPrecio3(double precio3) {
    this.precio3 = precio3;
  }
}