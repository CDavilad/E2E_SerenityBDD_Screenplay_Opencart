package opencart.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import opencart.ui.PaginaCheckout;

public class ConfirmarPedido implements Task {

    public static ConfirmarPedido final_() {
        return new ConfirmarPedido();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(PaginaCheckout.BTN_CONFIRMAR_PEDIDO)
        );
    }
}
