package opencart.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import opencart.ui.PaginaCheckout;
import opencart.util.DatosCliente;

public class CompletarDatosFacturacion implements Task {

    private final DatosCliente datos;

    public CompletarDatosFacturacion(DatosCliente datos) {
        this.datos = datos;
    }

    public static CompletarDatosFacturacion con(DatosCliente datos) {
        return new CompletarDatosFacturacion(datos);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(datos.getNombre()).into(PaginaCheckout.CAMPO_NOMBRE),
                Enter.theValue(datos.getApellido()).into(PaginaCheckout.CAMPO_APELLIDO),
                Enter.theValue(datos.getEmail()).into(PaginaCheckout.CAMPO_EMAIL),
                Enter.theValue(datos.getTelefono()).into(PaginaCheckout.CAMPO_TELEFONO),
                Enter.theValue(datos.getDireccion()).into(PaginaCheckout.CAMPO_DIRECCION),
                Enter.theValue(datos.getCiudad()).into(PaginaCheckout.CAMPO_CIUDAD),
                Enter.theValue(datos.getCodigoPostal()).into(PaginaCheckout.CAMPO_CODIGO_POSTAL),
                SelectFromOptions.byValue(String.valueOf(datos.getPaisId())).from(PaginaCheckout.SELECT_PAIS),
                EsperarCargaAjax.de(2000),
                SelectFromOptions.byIndex(1).from(PaginaCheckout.SELECT_ZONA),
                Click.on(PaginaCheckout.BTN_CONTINUAR_STEP2),
                EsperarCargaAjax.de(2000)
        );
    }
}
