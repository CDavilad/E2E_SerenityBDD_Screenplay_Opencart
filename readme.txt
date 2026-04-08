============================================================
 E2E PRUEBA FUNCIONAL - OPENCART - SERENITY BDD SCREENPLAY
============================================================

URL DEL SITIO: http://opencart.abstracta.us/
FRAMEWORK: Serenity BDD + Screenplay Pattern + Cucumber (es)
LENGUAJE: Java 17
BUILD TOOL: Gradle

------------------------------------------------------------
PRE-REQUISITOS
------------------------------------------------------------
1. Java 17 o superior instalado
   - Verificar: java -version

2. Google Chrome instalado (última versión estable)
   - ChromeDriver se descarga automáticamente por Serenity

3. Conexión a internet para resolver dependencias de Gradle

------------------------------------------------------------
PASOS DE EJECUCIÓN
------------------------------------------------------------

1. Clonar o descomprimir el proyecto en una carpeta local:
   cd E2E_SerenityBDD_Screenplay_Opencart

2. Dar permisos de ejecución al wrapper de Gradle (Linux/Mac):
   chmod +x gradlew

3. Ejecutar todos los tests (limpiar + evaluar + reporte):

   En Windows:
     gradlew.bat clean test aggregate

   En Linux/Mac:
     ./gradlew clean test aggregate

4. Ver el reporte HTML generado:
   Ruta: target/site/serenity/index.html

   Abrir en el navegador el archivo index.html localizado en:
   - Windows: target\site\serenity\index.html
   - Linux/Mac: target/site/serenity/index.html

------------------------------------------------------------
EJECUCIÓN CON PARÁMETROS OPCIONALES
------------------------------------------------------------

Para ejecutar en modo headless (sin ventana del navegador):
   gradlew.bat clean test aggregate -Dheadless.mode=true

Para ejecutar con un navegador específico:
   gradlew.bat clean test aggregate -Dwebdriver.driver=firefox

------------------------------------------------------------
ESTRUCTURA DEL PROYECTO
------------------------------------------------------------

src/
  test/
    java/
      opencart/
        hooks/          - Configuración del ciclo de vida Cucumber
        runners/        - CucumberRunner (suite de tests)
        ui/             - Page Objects (selectores de elementos)
          PaginaProducto.java
          PaginaCarrito.java
          PaginaCheckout.java
          PaginaConfirmacion.java
        tasks/          - Tareas Screenplay (acciones del actor)
          AgregarProductoAlCarrito.java
          VerCarrito.java
          SeleccionarGuestCheckout.java
          CompletarDatosFacturacion.java
          ConfirmarMetodoPago.java
          ConfirmarPedido.java
          EsperarCargaAjax.java
        questions/      - Preguntas Screenplay (aserciones)
          MensajeDeConfirmacion.java
        stepdefinitions/ - Definiciones de pasos Cucumber
          FlujoDCompraStepDefinitions.java
        util/           - Utilidades y datos de prueba
          AppConfig.java
          DatosCliente.java
          Productos.java
    resources/
      features/
        flujo_compra.feature  - Escenario en Gherkin (español)
      serenity.conf           - Configuración de Serenity
      logback-test.xml        - Configuración de logging

------------------------------------------------------------
ESCENARIO DE PRUEBA
------------------------------------------------------------

Flujo probado:
  1. Navegar a la tienda OpenCart
  2. Agregar MacBook al carrito (product_id=43)
  3. Agregar iPhone al carrito (product_id=40)
  4. Visualizar el carrito de compras
  5. Ir al Checkout y seleccionar "Guest Checkout"
  6. Completar datos de facturación (nombre, dirección, etc.)
  7. Seleccionar método de pago y aceptar términos
  8. Confirmar el pedido
  9. Verificar mensaje: "Your order has been placed!"

------------------------------------------------------------
NOTAS
------------------------------------------------------------

- El test usa datos de prueba fijos (no requiere cuenta registrada)
- La zona/estado se selecciona automáticamente (primera disponible)
  después de seleccionar "United States" como país
- Serenity genera screenshots de cada acción automáticamente
- Los reportes incluyen: HTML interactivo + JSON + XML
