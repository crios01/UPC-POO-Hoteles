package adminhoteles;

import Menus.*;

public class AdminHoteles {

  public static void main(String[] args) {
    MCuenta mCuenta = new MCuenta();
    MDefinicion mDefinicion = new MDefinicion();
    boolean opCuenta, opDefinicion;
    opCuenta = mCuenta.menuCuenta();
    if (opCuenta) {
      mDefinicion.setnCorreo(mCuenta.getnCorreo());
      opDefinicion = mDefinicion.menuDefinicion();
    }
  }
} // System.out.println();