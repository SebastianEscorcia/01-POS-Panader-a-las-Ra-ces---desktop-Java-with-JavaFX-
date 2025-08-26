package DAL.models.Singleton;


import DAL.models.Usuario;

public class SesionUsuario {

    private static SesionUsuario instancia; // la única instancia
    private Usuario usuarioActivo;

    // Constructor privado: nadie más puede crear instancias
    private SesionUsuario() {}

    // Método para acceder a la instancia única
    public static SesionUsuario getInstancia() {
        if (instancia == null) {
            instancia = new SesionUsuario();
        }
        return instancia;
    }

    // Métodos para usar dentro de la app
    public Usuario getUsuarioActivo() {
        return usuarioActivo;
    }

    public void setUsuarioActivo(Usuario usuario) {
        this.usuarioActivo = usuario;
    }

    public void cerrarSesion() {
        usuarioActivo = null;
    }

    public boolean haySesionActiva() {
        return usuarioActivo != null;
    }
}
