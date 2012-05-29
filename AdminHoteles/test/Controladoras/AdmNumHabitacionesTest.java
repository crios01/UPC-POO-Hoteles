package Controladoras;

import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

public class AdmNumHabitacionesTest {

  public AdmNumHabitacionesTest() {
  }
  AdmNumHabitaciones admNumHabitaciones = new AdmNumHabitaciones();

  @Test
  public void siPasoUnNumeroMenorQueUnoMeDebeDarError() {
    assertFalse(admNumHabitaciones.verificaNumero(0));
  }

  @Test
  public void siPasoUnNumeroMayorQueUnoMeDebeDarVerdad() {
    assertTrue(admNumHabitaciones.verificaNumero(5));
    System.out.println("Correcto");
  }
}