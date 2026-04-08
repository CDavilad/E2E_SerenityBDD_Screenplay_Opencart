package opencart.ui;

import net.serenitybdd.screenplay.targets.Target;

public class PaginaCarrito {

    public static final Target LINK_CHECKOUT = Target.the("enlace checkout")
            .locatedBy("//a[contains(@href,'checkout/checkout')]");

    public static final Target TABLA_PRODUCTOS = Target.the("tabla de productos en el carrito")
            .locatedBy("#content table");
}
