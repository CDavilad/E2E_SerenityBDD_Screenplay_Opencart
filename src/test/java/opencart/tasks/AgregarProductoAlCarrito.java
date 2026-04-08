package opencart.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import opencart.ui.PaginaProducto;
import opencart.util.AppConfig;

public class AgregarProductoAlCarrito implements Task {

    private final int productoId;
    private final String nombreProducto;

    public AgregarProductoAlCarrito(int productoId, String nombreProducto) {
        this.productoId    = productoId;
        this.nombreProducto = nombreProducto;
    }

    public static AgregarProductoAlCarrito conId(int productoId, String nombre) {
        return new AgregarProductoAlCarrito(productoId, nombre);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(AppConfig.productoUrl(productoId)),
                Click.on(PaginaProducto.BTN_AGREGAR_CARRITO)
        );
    }
}
