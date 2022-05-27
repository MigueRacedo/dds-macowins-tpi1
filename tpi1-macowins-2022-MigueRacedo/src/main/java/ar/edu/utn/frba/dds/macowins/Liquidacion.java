package ar.edu.utn.frba.dds.macowins;

public class Liquidacion extends Estado{

  @Override
  public double cacular(double precioPrenda) {
    return precioPrenda * 0.5;
  }
}
