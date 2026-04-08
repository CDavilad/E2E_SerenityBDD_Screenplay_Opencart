package opencart.ui;

import net.serenitybdd.screenplay.targets.Target;

public class PaginaCheckout {

    // Step 1: Checkout Options
    public static final Target RADIO_GUEST_CHECKOUT = Target.the("opción guest checkout")
            .locatedBy("//input[@name='account'][@value='guest']");

    public static final Target BTN_CONTINUAR_STEP1 = Target.the("botón continuar paso 1")
            .locatedBy("#button-account");

    // Step 2: Billing Details
    public static final Target CAMPO_NOMBRE = Target.the("campo nombre")
            .locatedBy("#input-payment-firstname");

    public static final Target CAMPO_APELLIDO = Target.the("campo apellido")
            .locatedBy("#input-payment-lastname");

    public static final Target CAMPO_EMAIL = Target.the("campo email de pago")
            .locatedBy("#input-payment-email");

    public static final Target CAMPO_TELEFONO = Target.the("campo teléfono")
            .locatedBy("#input-payment-telephone");

    public static final Target CAMPO_EMPRESA = Target.the("campo empresa")
            .locatedBy("#input-payment-company");

    public static final Target CAMPO_DIRECCION = Target.the("campo dirección")
            .locatedBy("#input-payment-address-1");

    public static final Target CAMPO_CIUDAD = Target.the("campo ciudad")
            .locatedBy("#input-payment-city");

    public static final Target CAMPO_CODIGO_POSTAL = Target.the("campo código postal")
            .locatedBy("#input-payment-postcode");

    public static final Target SELECT_PAIS = Target.the("selector de país")
            .locatedBy("#input-payment-country");

    public static final Target SELECT_ZONA = Target.the("selector de zona/estado")
            .locatedBy("#input-payment-zone");

    public static final Target BTN_CONTINUAR_STEP2 = Target.the("botón continuar paso 2")
            .locatedBy("#button-guest");

    // Step 3: Delivery Details
    public static final Target CAMPO_ENVIO_NOMBRE = Target.the("campo nombre de envío")
            .locatedBy("#input-shipping-firstname");

    public static final Target CAMPO_ENVIO_APELLIDO = Target.the("campo apellido de envío")
            .locatedBy("#input-shipping-lastname");

    public static final Target CAMPO_ENVIO_DIRECCION = Target.the("campo dirección de envío")
            .locatedBy("#input-shipping-address-1");

    public static final Target CAMPO_ENVIO_CIUDAD = Target.the("campo ciudad de envío")
            .locatedBy("#input-shipping-city");

    public static final Target CAMPO_ENVIO_CODIGO_POSTAL = Target.the("campo código postal de envío")
            .locatedBy("#input-shipping-postcode");

    public static final Target SELECT_ENVIO_PAIS = Target.the("selector de país de envío")
            .locatedBy("#input-shipping-country");

    public static final Target SELECT_ENVIO_ZONA = Target.the("selector de zona de envío")
            .locatedBy("#input-shipping-zone");

    public static final Target BTN_CONTINUAR_STEP3 = Target.the("botón continuar paso 3 (envío)")
            .locatedBy("#button-guest-shipping");

    // Step 4: Delivery Method
    public static final Target BTN_CONTINUAR_STEP4 = Target.the("botón continuar paso 4 (método envío)")
            .locatedBy("#button-shipping-method");

    // Step 5: Payment Method
    public static final Target CHECKBOX_TERMINOS = Target.the("checkbox términos y condiciones")
            .locatedBy("//input[@name='agree']");

    public static final Target BTN_CONTINUAR_STEP5 = Target.the("botón continuar paso 5 (pago)")
            .locatedBy("#button-payment-method");

    // Step 6: Confirm Order
    public static final Target BTN_CONFIRMAR_PEDIDO = Target.the("botón confirmar pedido")
            .locatedBy("#button-confirm");
}
