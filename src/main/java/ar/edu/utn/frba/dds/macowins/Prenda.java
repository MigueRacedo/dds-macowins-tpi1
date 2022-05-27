package ar.edu.utn.frba.dds.macowins;

import static java.util.Objects.requireNonNull;

public class Prenda {
  private TipoPrenda tipoPrenda;
  private double precioBase;
  private Estado estado;

  public Prenda(TipoPrenda tipoPrenda, Double precioBase, Estado estado){
    this.tipoPrenda = requireNonNull(tipoPrenda, "El tipo de prenda es obligatorio.");
    this.precioBase = requireNonNull(precioBase, "El precio base es obligatorio.");
    this.estado = requireNonNull(estado, "El estado es obligatorio.");
  }

  public TipoPrenda getTipoPrenda() {
    return tipoPrenda;
  }

  public Double precio(){
    return this.estado.cacular(this.precioBase);
  }
}
