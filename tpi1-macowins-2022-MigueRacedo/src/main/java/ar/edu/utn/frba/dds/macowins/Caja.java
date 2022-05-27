package ar.edu.utn.frba.dds.macowins;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.requireNonNull;

public class Caja {
  private static Caja instance = new Caja();
  private List<Venta> ventas = new ArrayList<>();

  public Caja() {
  }

  public static Caja getInstance() {return instance;}

  public List<Venta> getVentas() {
    return ventas;
  }

  public void agregarVenta(Venta unaVenta){
    this.ventas.add(unaVenta);
  }

  public void agregarVariasVentas(List<Venta> ventas){
    this.ventas.addAll(ventas);
  }

  public void limpiarVentas(){
    this.ventas.clear();
  }

  public double gananciaDelDia(LocalDateTime unDia){
    List<Venta> ventasDeDia = this.ventas.stream().filter(x -> x.getFecha().isEqual(unDia)).collect(Collectors.toList());
    return ventasDeDia.stream().mapToDouble(Venta::calcular).sum();
  }
}
