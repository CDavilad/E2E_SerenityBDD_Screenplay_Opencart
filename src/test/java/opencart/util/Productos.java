package opencart.util;

public class Productos {

    public static final int MACBOOK_ID      = 43;
    public static final String MACBOOK_NOMBRE = "MacBook";

    public static final int IPHONE_ID       = 40;
    public static final String IPHONE_NOMBRE  = "iPhone";

    // Mapeo de nombre de producto a su ID en OpenCart
    public static int obtenerIdPorNombre(String nombre) {
        switch (nombre) {
            case "MacBook":        return MACBOOK_ID;
            case "iPhone":         return IPHONE_ID;
            case "Apple Cinema 30\"": return 42;
            case "Canon EOS 5D":   return 30;
            default:
                throw new IllegalArgumentException("Producto no reconocido: " + nombre);
        }
    }
}
