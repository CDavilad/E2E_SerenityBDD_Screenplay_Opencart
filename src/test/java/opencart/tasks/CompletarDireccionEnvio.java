package opencart.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import opencart.ui.PaginaCheckout;
import opencart.util.DatosCliente;

public class CompletarDireccionEnvio implements Task {

    private final DatosCliente datos;

    public CompletarDireccionEnvio(DatosCliente datos) {
        this.datos = datos;
    }

    public static CompletarDireccionEnvio con(DatosCliente datos) {
        return new CompletarDireccionEnvio(datos);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                EsperarCargaAjax.de(2000),
                net.serenitybdd.screenplay.actions.Enter.theValue(datos.getNombre()).into(PaginaCheckout.CAMPO_ENVIO_NOMBRE),
                net.serenitybdd.screenplay.actions.Enter.theValue(datos.getApellido()).into(PaginaCheckout.CAMPO_ENVIO_APELLIDO),
                net.serenitybdd.screenplay.actions.Enter.theValue(datos.getDireccion()).into(PaginaCheckout.CAMPO_ENVIO_DIRECCION),
                net.serenitybdd.screenplay.actions.Enter.theValue(datos.getCiudad()).into(PaginaCheckout.CAMPO_ENVIO_CIUDAD),
                net.serenitybdd.screenplay.actions.Enter.theValue(datos.getCodigoPostal()).into(PaginaCheckout.CAMPO_ENVIO_CODIGO_POSTAL),
                SelectFromOptions.byValue(String.valueOf(datos.getPaisId())).from(PaginaCheckout.SELECT_ENVIO_PAIS),
                EsperarCargaAjax.de(2000),
                SelectFromOptions.byIndex(1).from(PaginaCheckout.SELECT_ENVIO_ZONA),
                Click.on(PaginaCheckout.BTN_CONTINUAR_STEP3)
        );
    }
}
