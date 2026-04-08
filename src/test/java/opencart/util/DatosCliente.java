package opencart.util;

public class DatosCliente {

    private final String nombre;
    private final String apellido;
    private final String email;
    private final String telefono;
    private final String direccion;
    private final String ciudad;
    private final String codigoPostal;
    private final String pais;
    private final int paisId;

    private DatosCliente(Builder builder) {
        this.nombre       = builder.nombre;
        this.apellido     = builder.apellido;
        this.email        = builder.email;
        this.telefono     = builder.telefono;
        this.direccion    = builder.direccion;
        this.ciudad       = builder.ciudad;
        this.codigoPostal = builder.codigoPostal;
        this.pais         = builder.pais;
        this.paisId       = builder.paisId;
    }

    public String getNombre()       { return nombre; }
    public String getApellido()     { return apellido; }
    public String getEmail()        { return email; }
    public String getTelefono()     { return telefono; }
    public String getDireccion()    { return direccion; }
    public String getCiudad()       { return ciudad; }
    public String getCodigoPostal() { return codigoPostal; }
    public String getPais()         { return pais; }
    public int    getPaisId()       { return paisId; }

    public static class Builder {
        private String nombre;
        private String apellido;
        private String email;
        private String telefono;
        private String direccion;
        private String ciudad;
        private String codigoPostal;
        private String pais       = "United States";
        private int    paisId     = 223;

        public Builder nombre(String nombre)             { this.nombre = nombre; return this; }
        public Builder apellido(String apellido)         { this.apellido = apellido; return this; }
        public Builder email(String email)               { this.email = email; return this; }
        public Builder telefono(String telefono)         { this.telefono = telefono; return this; }
        public Builder direccion(String direccion)       { this.direccion = direccion; return this; }
        public Builder ciudad(String ciudad)             { this.ciudad = ciudad; return this; }
        public Builder codigoPostal(String codigoPostal){ this.codigoPostal = codigoPostal; return this; }
        public Builder pais(String pais, int id)         { this.pais = pais; this.paisId = id; return this; }

        public DatosCliente build() { return new DatosCliente(this); }
    }
}
