# Conclusiones y Hallazgos — Prueba E2E OpenCart
**Serenity BDD + Screenplay Pattern**

| Campo | Valor |
|---|---|
| Sitio evaluado | http://opencart.abstracta.us/ |
| Tipo de prueba | Funcional E2E automatizada |
| Framework | Serenity BDD 5.3.3 + Cucumber 7.34.2 + Screenplay |
| Fecha | Abril 2026 |

---

## Hallazgos Funcionales

### 1. Flujo de compra como invitado (Guest Checkout)
- El flujo completo funciona sin registro previo de usuario.
- La opción **Guest Checkout** está disponible en el paso 1 del checkout; no está seleccionada por defecto (el valor por defecto es "Register Account").
- El carrito persiste entre páginas vía sesión de navegador.

### 2. Agregar productos al carrito
- Los productos se agregan correctamente desde la URL directa de cada producto (`index.php?route=product/product&product_id=N`).
- El botón "Add to Cart" tiene ID estable: `#button-cart`.
- El campo de cantidad tiene ID: `#input-quantity`.
- El sistema muestra un indicador en el header con el conteo de ítems y el total actualizado dinámicamente.

### 3. Producto con "Out of Stock" (MacBook)
- El MacBook (`product_id=43`) muestra "Availability: Out Of Stock" pero aun así permite agregarse al carrito.
- En la vista del carrito se marca con `***` indicando que no está disponible en la cantidad deseada.
- El sistema permite completar la compra igualmente; el pedido se procesa sin bloquear al usuario.
- > **Hallazgo:** Debería impedir la compra de productos sin stock o al menos alertar de forma más prominente al usuario.

### 4. Carga dinámica de zonas (AJAX)
- Al seleccionar el país en el formulario de facturación, las zonas/estados se cargan mediante una llamada AJAX.
- Es necesario esperar la respuesta antes de interactuar con el selector de zona (aproximadamente 1–2 segundos).
- Se implementó la tarea `EsperarCargaAjax` para manejar esta latencia.

### 5. Confirmación de pedido
- La página de confirmación navega a la URL: `/index.php?route=checkout/success`.
- El título de la página es: **"Your order has been placed!"**
- El mensaje aparece en el elemento `<h1>` dentro de `#content`.
- La confirmación ocurre de forma inmediata tras el clic en el botón "Confirm Order" (`#button-confirm`).

---

## Hallazgos Técnicos / de Automatización

### 6. Estabilidad de selectores
Los elementos clave tienen IDs estables y bien definidos, lo que facilita la automatización:

| Elemento | Selector |
|---|---|
| Botón agregar al carrito | `#button-cart` |
| Continuar (step 1 - cuenta) | `#button-account` |
| Continuar (step 2 - facturación) | `#button-guest` |
| Continuar (step 4 - envío) | `#button-shipping-method` |
| Continuar (step 5 - pago) | `#button-payment-method` |
| Confirmar pedido | `#button-confirm` |
| Campos de facturación | `#input-payment-firstname`, `#input-payment-lastname`, etc. |
| Radio Guest Checkout | `//input[@name='account'][@value='guest']` (sin ID, vía XPath) |

### 7. Patrón Screenplay
- El patrón Screenplay (actor → tasks → questions) permite separar claramente las responsabilidades de la prueba.
- Las tareas son reutilizables y expresan la intención del usuario de manera legible (lenguaje de negocio).
- Las preguntas encapsulan las aserciones, manteniendo los step definitions limpios y enfocados en el flujo.

### 8. Cucumber en español
- El feature file usa anotaciones en español (`@Dado`, `@Cuando`, `@Entonces`, `@Y`) para mayor legibilidad por el equipo.
- La directiva `# language: es` habilita el soporte de Gherkin en español nativo.

---

## Mejoras sugeridas al sitio

- Bloquear el proceso de checkout si hay productos sin stock.
- Agregar validación de email con formato incorrecto en el formulario de guest checkout.
- Mejorar el feedback visual cuando se agrega un producto al carrito (el toast de confirmación desaparece rápidamente).
- Implementar protección CSRF en el formulario de checkout.
- Añadir validación de longitud mínima en campos obligatorios como teléfono y dirección.

---

## Tiempo de ejecución estimado

- **Escenario completo (1 scenario):** ~30–45 segundos
- Incluye: apertura de browser, navegación, verificaciones y generación de reporte HTML.

---

## Versiones utilizadas

| Componente | Versión |
|---|---|
| Serenity BDD | 5.3.3 |
| Cucumber | 7.34.2 |
| JUnit Platform | 1.11.4 |
| Java | 17 |
| Google Chrome | versión compatible con ChromeDriver auto |
| Gradle Wrapper | 8.x |
