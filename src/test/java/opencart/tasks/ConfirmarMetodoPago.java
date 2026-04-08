package opencart.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import opencart.ui.PaginaCheckout;

public class ConfirmarMetodoPago implements Task {

    public static ConfirmarMetodoPago aceptandoTerminos() {
        return new ConfirmarMetodoPago();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                EsperarCargaAjax.de(2000),
                Click.on(PaginaCheckout.CHECKBOX_TERMINOS),
                Click.on(PaginaCheckout.BTN_CONTINUAR_STEP5),
                EsperarCargaAjax.de(2000)
        );
    }
}
