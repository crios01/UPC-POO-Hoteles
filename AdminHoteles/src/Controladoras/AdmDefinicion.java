package Controladoras;

public class AdmDefinicion {
    public boolean verificaNumero(int numero){
    if (numero <= 0){
      System.out.println("Debe ingresar un Número valido. Verifique !!!");
      return false;
    }
    return true;
  }

}
