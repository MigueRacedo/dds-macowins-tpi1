package ar.edu.utn.frba.dds.macowins;

import static java.util.Objects.requireNonNull;

public class Item {
  public Prenda prenda;
  public int cantidad;

  public Item(Prenda prenda, int cantidad){
    this.prenda = requireNonNull(prenda, "La prenda es obligatoria.");
    this.cantidad = requireNonNull(cantidad, "La cantidad es obligatoria.");
  }

  public double importe(){
    return this.prenda.precio() * cantidad;
  }
}
