package opencart.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import opencart.util.AppConfig;

public class VerCarrito implements Task {

    public static VerCarrito deCompras() {
        return new VerCarrito();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(AppConfig.carritoUrl())
        );
    }
}
