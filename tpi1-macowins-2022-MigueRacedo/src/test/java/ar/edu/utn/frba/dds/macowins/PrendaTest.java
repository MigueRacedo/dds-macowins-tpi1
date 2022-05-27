package ar.edu.utn.frba.dds.macowins;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PrendaTest {

  @Test
  public void elTipoDeUnaCamisaNuevaEsCAMISA() {
    assertEquals(camisaNueva(200).getTipoPrenda().toString(), "CAMISA");
  }

  @Test
  public void elTipoDeUnSacoEnLiquidacionEsSACO() {
    assertEquals(sacoEnLiquidacion(200).getTipoPrenda().toString(), "SACO");
  }

  @Test
  public void elPrecioDeUnaCamisaNuevaEsSuPrecioBase() {
    assertEquals(camisaNueva(4000).precio(), 4000, 0);
    assertEquals(camisaNueva(5000).precio(), 5000, 0);
  }

  @Test
  public void elPrecioDeUnSacoEnLiquidacionEsSuLaMitadDeSuPrecioBase() {
    assertEquals(sacoEnLiquidacion(3000).precio(), 1500, 0);
    assertEquals(sacoEnLiquidacion(8000).precio(), 4000, 0);
  }

  @Test
  public void elPrecioDeUnPantalonEnPromocionEsSuPrecioBaseMenosSuDecuento() {
    assertEquals(pantalonEnPromocion(1500, 200).precio(), 1300, 0);
    assertEquals(pantalonEnPromocion(1500, 100).precio(), 1400, 0);
  }

  @Test
  public void elTipoDePrendaEsObligatorio() {
    RuntimeException exception = assertThrows(RuntimeException.class,() -> new Prenda(null,1500.0,nuevo));
    Assertions.assertTrue(exception.getMessage().contains("El tipo de prenda es obligatorio."));
  }

  private Prenda pantalonEnPromocion(double precioBase, int descuento) {
    Promocion promocion = new Promocion(descuento);
    return new Prenda(TipoPrenda.PANTALON,precioBase,promocion);
  }

  private Prenda camisaNueva(double precioBase) {
    return new Prenda(TipoPrenda.CAMISA,precioBase,nuevo);
  }

  private Prenda sacoEnLiquidacion(double precioBase) {
    return new Prenda(TipoPrenda.SACO,precioBase,liquidacion);
  }

  private final Nuevo nuevo = new Nuevo();
  private final Liquidacion liquidacion = new Liquidacion();
}
