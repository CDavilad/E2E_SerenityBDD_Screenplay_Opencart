package opencart.ui;

import net.serenitybdd.screenplay.targets.Target;

public class PaginaConfirmacion {

    public static final Target MENSAJE_CONFIRMACION = Target.the("mensaje de confirmación del pedido")
            .locatedBy("#content h1");
}
