package Controladoras;

import Modelos.*;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

public class AdmDefinicionTest {

  public AdmDefinicionTest() {
  }
  private AdmDefinicion admDef = new AdmDefinicion();

  @Test
  public void siPasoUnNumeroNoValidoMeDebeRetornarFalso() {
    assertFalse(admDef.verificaNumero(0));
  }

  @Test
  public void siPasoUnNumeroValidoMeDebeRetornarVerdad() {
    assertTrue(admDef.verificaNumero(35));
    System.out.println("Cantidad correcta ... !!!");
  }

  @Test
  public void siPasoTipoHabitacionVacioMeDebeDevolverSingle() {
    assertEquals(admDef.verificaTiposHabitaciones(null), "Single");
    System.out.println("Por defecto Tipo de Habitación:  " + admDef.verificaTiposHabitaciones(null));
  }

  @Test
  public void siEliminoUnaHabitacionElNumeroSeRecalcula() {
    datosPrueba datos = new datosPrueba();
    ArrayList<Habitacion> dbHabitacion = datos.llenarTablaHabitacion();
    int numeroActual = dbHabitacion.size();
    int numeroNuevo = admDef.borrarHabitacion(dbHabitacion, 20).size();
    assertEquals(numeroActual - 1, numeroNuevo);
    System.out.println("Correcto, Número Actual: " + numeroActual + " - Número Nuevo: " + numeroNuevo);
  }

  @Test
  public void siAgregoUnHabitacionElNumeroSeRecalcula() {
    datosPrueba datos = new datosPrueba();
    ArrayList<Habitacion> dbHabitacion = datos.llenarTablaHabitacion();
    Habitacion habitacion = new Habitacion(37, "mfernandez@hotmail.com", "137", "Single", 20.5);
    int numeroActual = dbHabitacion.size();
    int numeroNuevo = admDef.insertarHabitacion(dbHabitacion, habitacion).size();
    assertEquals(numeroActual + 1, numeroNuevo);
    System.out.println("Correcto, Número Actual: " + numeroActual + " - Número Nuevo: " + numeroNuevo);
  }

  @Test
  public void siModificoUnaHabitacionMeDebeDarVerdad() {
    datosPrueba datos = new datosPrueba();
    ArrayList<Habitacion> dbHabitacion = datos.llenarTablaHabitacion();
    Habitacion habActual = dbHabitacion.get(25);
    Habitacion habNueva = dbHabitacion.get(25);
    habNueva.setNombre("226");
    habNueva.setTipHabitacion("Single");

    ArrayList<Habitacion> dbDevuelta = admDef.modificarHabitacion(dbHabitacion, habNueva);
    Habitacion habDevuelta = dbDevuelta.get(25);

    assertEquals(habNueva, habDevuelta);
    System.out.println("El Registro se modifico correctamente.");
//    System.out.println(habNueva.getItem() + ", " + habNueva.getCorreo() + ", " + habNueva.getNombre() + ", " + habNueva.getTipHabitacion() + ", " + habNueva.getPrecio());
//    System.out.println(habDevuelta.getItem() + ", " + habDevuelta.getCorreo() + ", " + habDevuelta.getNombre() + ", " + habDevuelta.getTipHabitacion() + ", " + habDevuelta.getPrecio());
  }

  @Test
  public void siPasoUnPrecioNoValidoMeDebeRetornarFalso() {
    Precio precio = new Precio("mfernandez@hotmail.com", "Single", 0);
    assertFalse(admDef.verificarPrecio(precio.getPrecio()));
  }

  @Test
  public void siPasoUnPrecioValidoMeDebeRetornarVerdad() {
    Precio precio = new Precio("mfernandez@hotmail.com", "Single", 100.00);
    assertTrue(admDef.verificarPrecio(precio.getPrecio()));
    System.out.println("Precio Correcto.");
  }
}