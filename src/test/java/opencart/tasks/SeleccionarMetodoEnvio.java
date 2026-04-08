package opencart.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import opencart.ui.PaginaCheckout;

public class SeleccionarMetodoEnvio implements Task {

    public static SeleccionarMetodoEnvio porDefecto() {
        return new SeleccionarMetodoEnvio();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                EsperarCargaAjax.de(2000),
                Click.on(PaginaCheckout.BTN_CONTINUAR_STEP4)
        );
    }
}
