package opencart.ui;

import net.serenitybdd.screenplay.targets.Target;

public class PaginaProducto {

    public static final Target BTN_AGREGAR_CARRITO = Target.the("botón agregar al carrito")
            .locatedBy("#button-cart");

    public static final Target CAMPO_CANTIDAD = Target.the("campo cantidad")
            .locatedBy("#input-quantity");
}
