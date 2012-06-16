package Controladoras;

import Modelos.Cuenta;
import Modelos.Hotel;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

public class AdmCuentaTest {

  public AdmCuentaTest() {
  }
  AdmCuenta admCuentas = new AdmCuenta();

  @Test
  public void siPasoCampoCorreoVacioMeDebeDarError() {
    assertFalse(admCuentas.verificaCadena(null, "Correo Electrónico"));
    assertFalse(admCuentas.verificaCadena(null, "Contraseña"));
    assertFalse(admCuentas.verificaCadena(null, "Nombre de Hotel"));
  }

  @Test
  public void siPasoCadenaNoVaciaMeDebeDarVerdad() {
    assertTrue(admCuentas.verificaCadena("verdad@verdad.com", "Correo"));
    assertTrue(admCuentas.verificaCadena("Verdad001", "Clave"));
    assertTrue(admCuentas.verificaCadena("La Verdad", "Hotel"));
    System.out.println("Correcto. El campo no esta vacío");
  }

  @Test
  public void siPasoUnCorreoErradoMeDebeDarError() {
    assertFalse(admCuentas.verificaCorreo("jaime@mail.com."));
  }

  @Test
  public void siPasoUnCorreoCorrectoMeDebeDarVerdad() {
    assertTrue(admCuentas.verificaCorreo("crios@ddperu.com.pe"));
  }

  @Test
  public void siComparoDosCadenasClavesDiferentesMeDebeDarError() {
    assertFalse(admCuentas.comparaClaves("master001", "Master001"));
  }

  @Test
  public void siComparoDosCadenasClavesIgualesMeDebeDarVerdad() {
    assertTrue(admCuentas.comparaClaves("master001", "master001"));
    System.out.println("Las Claves son iguales.");
  }

  @Test
  public void siPasoElNombreDelHotelMeDebeDarSuDireccionWeb() {
    String cadenaGenerada = admCuentas.generaDirClerk("El Holandes Errante");
    String cadenaComparar = "http://elholandeserrante.clerk.im";
    assertEquals(cadenaGenerada, cadenaComparar);
    System.out.println("La Dirección Web es:  " + cadenaGenerada);
  }

  @Test
  public void siNoPasoElCheckMeDebeDarError() {
    assertFalse(admCuentas.verificaCheck("0"));
  }

  @Test
  public void siPasoElCheckMeDebeDarVerdad() {
    assertTrue(admCuentas.verificaCheck("1"));
    System.out.println("Check correcto.");
  }

  @Test
  public void siPasoUnaCadenaNombreHotelMeDebeRetornarUnaListaDeSugerencias() {
    ArrayList<Hotel> lista = new ArrayList<Hotel>();
    String nomRetornado = "", nomEsperado = "San Blas", nomAsignado = "San";
    lista = admCuentas.listaHoteles(nomAsignado, 1);
    for (Hotel hotel : lista) {
      nomRetornado = hotel.getNomHotel().trim();
      System.out.println(hotel.getNomHotel());
    }
    // El esperado es el último de la lista.
    assertEquals(nomEsperado, nomRetornado);
  }

  @Test
  public void siPasoUnaCuentaExistenteMeDebeDarError() {
    assertFalse(admCuentas.buscarCuenta("jpalacios@gmail.com"));
    System.out.println("Cuenta de correo ya existe.");
  }

  @Test
  public void siPasoUnaCuentaNoExistenteMeDebeDarVerdad() {
    assertTrue(admCuentas.buscarCuenta("mcorrea@celtik.com.ar"));
    System.out.println("Correcto, Cuenta no existe.");
  }

  @Test
  public void siRegistroUnaCuentaExistenteMeDebeDarError() {
    assertFalse(admCuentas.escribirCuenta(new Cuenta("jpalacios@gmail.com", "juan002", "Sheraton", "juanpalacios", true)));
  }

  @Test
  public void siRegistroUnaCuentaNoExistenteMeDebeDarVerdad() {
    // Cada vez que se quiera correr el Test se debe cambiar de datos para que así sea un registro nuevo.
    assertTrue(admCuentas.escribirCuenta(new Cuenta("pcabrera@hotmail.com", "ana001", "El Olivar", "http://elolivar.clerk.com", true)));
  }
}