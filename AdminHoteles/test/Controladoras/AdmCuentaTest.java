package Controladoras;

import Modelos.Cuenta;
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
    System.out.println("El correo esta errado.");
  }

  @Test
  public void siPasoUnCorreoCorrectoMeDebeDarVerdad() {
    assertTrue(admCuentas.verificaCorreo("crios@ddperu.com.pe"));
  }

  @Test
  public void siComparoDosCadenasClavesDiferentesMeDebeDarError() {
    assertFalse(admCuentas.comparaClaves("master001", "Master001"));
    System.out.println("Las Claves no concuerdan.");
  }

  @Test
  public void siComparoDosCadenasClavesIgualesMeDebeDarVerdad() {
    assertTrue(admCuentas.comparaClaves("master001", "master001"));
    System.out.println("Las Claves son iguales.");
  }

  @Test
  public void siPasoElNombreDelHotelMeDebeDarSuDireccionWeb(){
    String cadenaGenerada = admCuentas.generaDirClerk("El Holandes Herrante");
    String cadenaComparar = "http://elholandesherrante.clerk.com";
    assertEquals(cadenaGenerada, cadenaComparar);
    System.out.println("La Dirección Web es:  " + cadenaGenerada);
  }
  
  @Test
  public void siNoPasoElCheckMeDebeDarError() {
    assertFalse(admCuentas.verificaCheck('0'));
    System.out.println("Debe Aceptar los Términos y Condiciones");
  }

  @Test
  public void siPasoElCheckMeDebeDarVerdad() {
    assertTrue(admCuentas.verificaCheck('1'));
    System.out.println("Check correcto.");
  }

  @Test
  public void siPasoUnaCuentaExistenteMeDebeDarError() {
    assertFalse(admCuentas.buscaCuenta("jpalacios@gmail.com"));
    System.out.println("Cuenta de correo ya existe.");
  }

  @Test
  public void siPasoUnaCuentaNoExistenteMeDebeDarVerdad() {
    assertTrue(admCuentas.buscaCuenta("mcorrea@celtik.com.ar"));
    System.out.println("Correcto, Cuenta no existe.");
  }

  @Test
  public void siRegistroUnaCuentaExistenteMeDebeDarError() {
    assertFalse(admCuentas.escribirCuenta(new Cuenta("jpalacios@gmail.com", "juan002", "Sheraton", "juanpalacios", "1")));
  }

  @Test
  public void siRegistroUnaCuentaNoExistenteMeDebeDarVerdad() {
    // Cada vez que se quiera correr el Test se debe cambiar de datos para que así sea un registro nuevo.
    assertTrue(admCuentas.escribirCuenta(new Cuenta("pcabrera@hotmail.com", "ana001", "El Olivar", "http://elolivar.clerk.com", "1")));
  }
}