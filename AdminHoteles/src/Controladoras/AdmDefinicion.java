package Controladoras;

import Modelos.Habitacion;

public class AdmDefinicion {

  public boolean verificaNumero(int numero) {
    if (numero <= 0) {
      System.out.println("Debe ingresar un Número valido. Verifique !!!");
      return false;
    }
    return true;
  }

  public String verificaTiposHabitaciones(Habitacion habitacion) {
    if (habitacion.getTipHabitacion() != null || habitacion.getTipHabitacion().equals("")){
      habitacion.setTipHabitacion("Single");
    }
    return habitacion.getTipHabitacion();
  }

  public int recalculaNumHab(){
    
    return 0;
  }
}