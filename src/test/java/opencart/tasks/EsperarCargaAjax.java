package opencart.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

/**
 * Tarea auxiliar para esperar que las peticiones AJAX finalicen.
 * Se usa principalmente después de seleccionar un país para que
 * carguen las zonas/estados dinámicamente.
 */
public class EsperarCargaAjax implements Task {

    private final long milisegundos;

    private EsperarCargaAjax(long milisegundos) {
        this.milisegundos = milisegundos;
    }

    public static EsperarCargaAjax de(long milisegundos) {
        return new EsperarCargaAjax(milisegundos);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
