package opencart.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import opencart.ui.PaginaCheckout;
import opencart.util.AppConfig;

public class SeleccionarGuestCheckout implements Task {

    public static SeleccionarGuestCheckout enCheckout() {
        return new SeleccionarGuestCheckout();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(AppConfig.checkoutUrl()),
                Click.on(PaginaCheckout.RADIO_GUEST_CHECKOUT),
                Click.on(PaginaCheckout.BTN_CONTINUAR_STEP1),
                EsperarCargaAjax.de(2000)
        );
    }
}
