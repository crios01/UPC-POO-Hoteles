package Controladoras;

import Modelos.Habitacion;
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
  public void ss() {
    
  }
}