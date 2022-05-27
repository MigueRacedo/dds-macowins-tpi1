package ar.edu.utn.frba.dds.macowins;

import static java.util.Objects.requireNonNull;

public class Promocion extends Estado{
  int descuento;

  public Promocion(int descuento){
    this.descuento = requireNonNull(descuento, "El descuento es obligatorio.");
  }

  @Override
  public double cacular(double precioPrenda) {
    return precioPrenda - this.descuento;
  }
}
