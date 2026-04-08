package opencart.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import opencart.ui.PaginaConfirmacion;

public class MensajeDeConfirmacion implements Question<String> {

    public static MensajeDeConfirmacion delPedido() {
        return new MensajeDeConfirmacion();
    }

    @Override
    public String answeredBy(Actor actor) {
        return PaginaConfirmacion.MENSAJE_CONFIRMACION
                .resolveFor(actor)
                .getText()
                .trim();
    }
}
