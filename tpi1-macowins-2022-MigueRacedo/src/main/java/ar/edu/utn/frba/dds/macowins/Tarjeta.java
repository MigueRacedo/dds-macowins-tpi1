package ar.edu.utn.frba.dds.macowins;

import static java.util.Objects.requireNonNull;

public class Tarjeta extends FormaDePago{
  int cuotas;
  double coeficiente;

  public Tarjeta(int cuotas, double coeficiente){
    this.cuotas = requireNonNull(cuotas, "las cuotas son obligatorias.");
    this.coeficiente = requireNonNull(coeficiente, "El coeficiente es obligatorio.");
  }

  @Override
  public double calcular(Double subTotal) {
    return cuotas * coeficiente + 0.01 * subTotal;
  }
}
