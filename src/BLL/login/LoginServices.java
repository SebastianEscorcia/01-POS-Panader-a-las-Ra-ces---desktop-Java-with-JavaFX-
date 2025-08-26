package BLL.login;

import BLL.usuario.UsuarioServices;
import DAL.models.Usuario;

import java.util.ArrayList;

public class LoginServices {
    private Usuario usuario;
    private final UsuarioServices usuarioServices;
    public LoginServices() {
        this.usuario = new Usuario();
        this.usuarioServices = new UsuarioServices();
    }

    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public Usuario iniciarSesion(Usuario usuarioIngresado){
        try {
            ArrayList<Usuario> listaUsuarios = usuarioServices.getUsuarios();
            for(Usuario u : listaUsuarios){
                if(u.getNombreUsuario().equals(usuarioIngresado.getNombreUsuario()) && u.getPassword().equals(usuarioIngresado.getPassword())) {
                    System.out.println("Inicio de sesión exitosamente");
                    return u;

                }
            }
            throw new Exception("Credenciales inválidas");

        } catch (Exception e) {
            System.out.println("Error en inicio de sesión: " + e.getMessage());
            throw new RuntimeException(e);
        }

    }

    public Usuario encontrarUsuario (Usuario encontrarUsuario){
        try {
            for(Usuario u : usuarioServices.getUsuarios()){
                if(u.equals(encontrarUsuario)) {
                    return u;
                }
            }
            throw new Exception("Usuario no encontrado");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
