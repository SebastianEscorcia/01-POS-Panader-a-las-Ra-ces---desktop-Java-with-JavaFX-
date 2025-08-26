package controllers.usuario;

import BLL.usuario.UsuarioServices;
import DAL.models.Usuario;
import validators.UsuarioValidators;

import java.util.ArrayList;

public class UsuarioController {
    private final UsuarioServices services ;
    public  UsuarioController() {
        this.services = new UsuarioServices();
    }
    public void crearUsuario(Usuario usuario) {
        try {
            String mensajeError= UsuarioValidators.validarUsuario(usuario);
            if (mensajeError != null) {
                throw new Exception(mensajeError);
            }
            services.crearUsuario(usuario);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

    }
    public void actualizarUsuario(Usuario usuario) {
        try {
            services.editarUsuario(usuario);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
    public void eliminarUsuario(Usuario usuario) {
        try {
            services.eliminarUsuario(usuario);
        }  catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
    public ArrayList<Usuario> mostrarUsuarios () {
        try {
           return services.getUsuarios();
        }  catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        } finally {
            ArrayList<Usuario> usuarios = new ArrayList<>();
            return usuarios;
        }

    }

}
