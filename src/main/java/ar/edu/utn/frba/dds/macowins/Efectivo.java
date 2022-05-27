package ar.edu.utn.frba.dds.macowins;

public class Efectivo extends FormaDePago{
  @Override
  public double calcular(Double subTotal) {
    return subTotal;
  }
}
