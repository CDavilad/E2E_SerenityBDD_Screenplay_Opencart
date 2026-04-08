# E2E Prueba Funcional — OpenCart · Serenity BDD Screenplay

Prueba E2E automatizada del flujo de compra como invitado en [OpenCart](http://opencart.abstracta.us/), implementada con el patrón **Screenplay** de Serenity BDD y escenarios escritos en español con Cucumber/Gherkin.

| Campo | Valor |
|---|---|
| Sitio bajo prueba | http://opencart.abstracta.us/ |
| Framework | Serenity BDD 5.3.3 + Cucumber 7.34.2 |
| Patrón | Screenplay (Actor → Tasks → Questions) |
| Lenguaje | Java 17 |
| Build tool | Gradle (wrapper incluido) |

---

## Escenario de prueba

```gherkin
Escenario: Comprar dos productos como invitado hasta la confirmación
  Dado que el comprador navega a la tienda OpenCart
  Cuando agrega el producto "MacBook" al carrito
  Y agrega el producto "iPhone" al carrito
  Y visualiza el carrito de compras
  Y procede al checkout como invitado
  Y completa los datos de facturación
  Y selecciona el método de envío disponible
  Y confirma el método de pago aceptando los términos
  Y confirma el pedido
  Entonces el comprador ve el mensaje de confirmación "Your order has been placed!"
```

---

## Pre-requisitos

1. **Java 17** o superior
   ```bash
   java -version
   ```
2. **Google Chrome** instalado (ChromeDriver se descarga automáticamente por Serenity)
3. **Conexión a internet** para resolver dependencias de Gradle

---

## Ejecución

### Clonar el repositorio

```bash
git clone <url-del-repo>
cd E2E_SerenityBDD_Screenplay_Opencart
```

### Ejecutar los tests

**Windows:**
```bat
gradlew.bat clean test aggregate
```

**Linux / Mac:**
```bash
chmod +x gradlew
./gradlew clean test aggregate
```

### Ver el reporte HTML

Una vez finalizada la ejecución, abrir en el navegador:

```
target/site/serenity/index.html
```

---

## Parámetros opcionales

```bash
# Modo headless (sin ventana del navegador)
gradlew.bat clean test aggregate -Dheadless.mode=true

# Usar Firefox en lugar de Chrome
gradlew.bat clean test aggregate -Dwebdriver.driver=firefox
```

---

## Estructura del proyecto

```
src/test/
├── java/opencart/
│   ├── hooks/               # Ciclo de vida Cucumber (@Before / @After)
│   ├── runners/             # CucumberRunner (suite JUnit Platform)
│   ├── ui/                  # Page Objects — selectores de elementos
│   │   ├── PaginaProducto.java
│   │   ├── PaginaCarrito.java
│   │   ├── PaginaCheckout.java
│   │   └── PaginaConfirmacion.java
│   ├── tasks/               # Tareas Screenplay — acciones del actor
│   │   ├── AgregarProductoAlCarrito.java
│   │   ├── VerCarrito.java
│   │   ├── SeleccionarGuestCheckout.java
│   │   ├── CompletarDatosFacturacion.java
│   │   ├── SeleccionarMetodoEnvio.java
│   │   ├── ConfirmarMetodoPago.java
│   │   ├── ConfirmarPedido.java
│   │   └── EsperarCargaAjax.java
│   ├── questions/           # Preguntas Screenplay — aserciones
│   │   └── MensajeDeConfirmacion.java
│   ├── stepdefinitions/     # Definiciones de pasos Cucumber
│   │   └── FlujoDCompraStepDefinitions.java
│   └── util/                # Utilidades y datos de prueba
│       ├── AppConfig.java
│       ├── DatosCliente.java
│       └── Productos.java
└── resources/
    ├── features/
    │   └── flujo_compra.feature   # Escenario en Gherkin (español)
    ├── serenity.conf              # Configuración de WebDriver y Serenity
    └── logback-test.xml           # Configuración de logging
```

---

## Notas

- El test usa datos de prueba fijos y **no requiere cuenta registrada** en el sitio.
- El país se establece en "United States" y la zona se selecciona automáticamente (primera disponible tras carga AJAX).
- Serenity captura **screenshots de cada acción** automáticamente.
- Los reportes generados incluyen: HTML interactivo, JSON y XML.

---

## Documentación adicional

- [`readme.txt`](readme.txt) — instrucciones de ejecución en formato plano
- [`conclusiones.md`](conclusiones.md) — hallazgos funcionales y técnicos (Markdown)
- [`conclusiones.txt`](conclusiones.txt) — hallazgos funcionales y técnicos (texto plano)