package opencart.stepdefinitions;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import opencart.questions.MensajeDeConfirmacion;
import opencart.tasks.*;
import opencart.util.DatosCliente;
import opencart.util.Productos;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.containsString;

public class FlujoDCompraStepDefinitions {

    @Dado("que el comprador navega a la tienda OpenCart")
    public void queElCompradorNavegaALaTienda() {
        theActorCalled("Comprador");
    }

    @Cuando("agrega el producto {string} al carrito")
    public void agregaElProductoAlCarrito(String nombreProducto) {
        int productoId = Productos.obtenerIdPorNombre(nombreProducto);
        theActorInTheSpotlight().attemptsTo(
                AgregarProductoAlCarrito.conId(productoId, nombreProducto)
        );
    }

    @Y("visualiza el carrito de compras")
    public void visualizaElCarritoDeCompras() {
        theActorInTheSpotlight().attemptsTo(
                VerCarrito.deCompras()
        );
    }

    @Y("procede al checkout como invitado")
    public void procedeAlCheckoutComoInvitado() {
        theActorInTheSpotlight().attemptsTo(
                SeleccionarGuestCheckout.enCheckout()
        );
    }

    @Y("completa los datos de facturación con nombre {string} apellido {string} email {string} telefono {string} direccion {string} ciudad {string} codigo_postal {string}")
    public void completaLosDatosDeFacturacion(String nombre, String apellido, String email,
                                              String telefono, String direccion,
                                              String ciudad, String codigoPostal) {
        DatosCliente datos = new DatosCliente.Builder()
                .nombre(nombre)
                .apellido(apellido)
                .email(email)
                .telefono(telefono)
                .direccion(direccion)
                .ciudad(ciudad)
                .codigoPostal(codigoPostal)
                .build();

        theActorInTheSpotlight().attemptsTo(
                CompletarDatosFacturacion.con(datos)
        );
    }

    @Y("selecciona el método de envío disponible")
    public void seleccionaElMetodoDeEnvio() {
        theActorInTheSpotlight().attemptsTo(
                SeleccionarMetodoEnvio.porDefecto()
        );
    }

    @Y("confirma el método de pago aceptando los términos")
    public void confirmaElMetodoDePago() {
        theActorInTheSpotlight().attemptsTo(
                ConfirmarMetodoPago.aceptandoTerminos()
        );
    }

    @Y("confirma el pedido")
    public void confirmaElPedido() {
        theActorInTheSpotlight().attemptsTo(
                ConfirmarPedido.final_()
        );
    }

    @Entonces("el comprador ve el mensaje de confirmación {string}")
    public void elCompradorVeElMensajeDeConfirmacion(String mensajeEsperado) {
        theActorInTheSpotlight().should(
                seeThat(MensajeDeConfirmacion.delPedido(), containsString(mensajeEsperado))
        );
    }
}
