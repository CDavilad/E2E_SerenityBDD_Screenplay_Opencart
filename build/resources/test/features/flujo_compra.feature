# language: es
Característica: Flujo de compra en OpenCart como invitado
  Como comprador invitado
  Quiero agregar dos productos al carrito y completar la compra
  Para finalizar un pedido exitosamente

  Escenario: Comprar dos productos como invitado hasta la confirmación
    Dado que el comprador navega a la tienda OpenCart
    Cuando agrega el producto "MacBook" al carrito
    Y agrega el producto "iPhone" al carrito
    Y visualiza el carrito de compras
    Y procede al checkout como invitado
    Y completa los datos de facturación con nombre "John" apellido "Doe" email "guest@test.com" telefono "1234567890" direccion "123 Main Street" ciudad "Los Angeles" codigo_postal "90001"
    Y selecciona el método de envío disponible
    Y confirma el método de pago aceptando los términos
    Y confirma el pedido
    Entonces el comprador ve el mensaje de confirmación "Your order has been placed!"
