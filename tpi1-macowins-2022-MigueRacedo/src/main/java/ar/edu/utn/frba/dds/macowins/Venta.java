package ar.edu.utn.frba.dds.macowins;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.Objects.requireNonNull;

public class Venta {
  private List<Item> items;
  private FormaDePago formaDePago;
  private LocalDateTime fecha;

  public Venta (List<Item> items, FormaDePago formaDePago, LocalDateTime fecha){
    this.items = requireNonNull(items, "Los items son obligatorios.");
    this.formaDePago = requireNonNull(formaDePago, "La forma de pago es obligatoria.");
    this.fecha = requireNonNull(fecha, "La fecha es obligatoria.");
  }

  public double calcular(){
    double subTotal = this.items.stream().mapToDouble(Item::importe).sum();
    return this.formaDePago.calcular(subTotal);
  }

  public LocalDateTime getFecha() {
    return this.fecha;
  }
}
