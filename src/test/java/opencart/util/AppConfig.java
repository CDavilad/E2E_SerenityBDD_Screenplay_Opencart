package opencart.util;

import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;

public class AppConfig {

    private static final EnvironmentVariables ENV =
            SystemEnvironmentVariables.createEnvironmentVariables();

    private AppConfig() {}

    public static String baseUrl() {
        return ENV.getProperty("webdriver.base.url", "http://opencart.abstracta.us");
    }

    public static String productoUrl(int productId) {
        return baseUrl() + "/index.php?route=product/product&product_id=" + productId;
    }

    public static String carritoUrl() {
        return baseUrl() + "/index.php?route=checkout/cart";
    }

    public static String checkoutUrl() {
        return baseUrl() + "/index.php?route=checkout/checkout";
    }
}
