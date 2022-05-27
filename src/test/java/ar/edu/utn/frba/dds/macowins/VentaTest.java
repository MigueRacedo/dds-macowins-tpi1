package ar.edu.utn.frba.dds.macowins;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class VentaTest {
  Item item1;
  Item item2;
  Item item3;
  Venta ventaEfectivo;
  Venta ventaEfectivo2;
  Venta ventaTarjeta;
  LocalDateTime fecha = LocalDateTime.of(2022, 4,12,0,0,0);
  LocalDateTime fecha2 = LocalDateTime.of(2022, 5,12,0,0,0);

  @BeforeEach
  public void setUp() {
    Nuevo nuevo = new Nuevo();
    Liquidacion liquidacion = new Liquidacion();
    Promocion promocion = new Promocion(150);

    Efectivo efectivo = new Efectivo();
    Tarjeta tarjeta = new Tarjeta(6,2);

    Prenda pantalonEnPromocion = new Prenda(TipoPrenda.PANTALON,300.00,promocion);
    Prenda camisaNueva = new Prenda(TipoPrenda.CAMISA,300.00,nuevo);
    Prenda sacoEnLiquidacion = new Prenda(TipoPrenda.SACO,300.00,liquidacion);

    item1 = new Item(pantalonEnPromocion,2);
    item2 = new Item(camisaNueva,1);
    item3 = new Item(sacoEnLiquidacion,3);

    List<Item> items = Arrays.asList(item1,item2,item3);


    ventaEfectivo = new Venta(items,efectivo, fecha);
    ventaTarjeta = new Venta(items,tarjeta, fecha2);
    ventaEfectivo2 = new Venta(items,efectivo, fecha2);

    List<Venta> ventas = Arrays.asList(ventaEfectivo,ventaTarjeta,ventaEfectivo2);

    Caja.getInstance().limpiarVentas(); // Para que siempre tenga la misma cantidad a la hora de testear
    Caja.getInstance().agregarVariasVentas(ventas);
  }

  @Test
  public void losItemsEnUnaVentaSonObligatorias() {
    RuntimeException exception = assertThrows(RuntimeException.class,() -> new Venta(null,new Efectivo(),fecha));
    Assertions.assertTrue(exception.getMessage().contains("Los items son obligatorios."));
  }

  @Test
  public void elImporteDeUnItemEs300(){
    assertEquals(item1.importe(),300, 0);
  }

  @Test
  public void elImporteDeOtroItemEs300(){
    assertEquals(item2.importe(),300, 0);
  }

  @Test
  public void elImporteDeUnItemEs450(){
    assertEquals(item3.importe(),450, 0);
  }

  @Test
  public void elMesDeUnaVentaEsAbril(){
    assertEquals(ventaEfectivo.getFecha().getMonthValue(),4,0);
  }

  @Test
  public void elImporteDeUnaVentaConEfectivoEs1050(){
    assertEquals(ventaEfectivo.calcular(),1050,0);
  }

  @Test
  public void elImporteDeUnaVentaConTarjetaEs22punto5(){
    assertEquals(ventaTarjeta.calcular(),22.5,0);
  }

  @Test
  public void laCajaContiene3Ventas(){
    assertEquals(Caja.getInstance().getVentas().size(),3,0);
  }

  @Test
  public void laGananciaDelDiaDeMayoEs1075punto5(){
    assertEquals(Caja.getInstance().gananciaDelDia(fecha2),1072.5,0);
  }

}
