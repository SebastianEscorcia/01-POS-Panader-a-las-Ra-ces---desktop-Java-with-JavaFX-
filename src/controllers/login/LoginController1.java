package controllers.login;

import BLL.login.LoginServices;
import DAL.models.Usuario;
import validators.LoginValidators;

public class LoginController1 {
    private final LoginServices loginServices;

    public LoginController1() {
        loginServices = new LoginServices();
    }

    public Usuario iniciarSesion(String username, String password) {
        try {
            Usuario usuario = new Usuario();
            usuario.setNombreUsuario(username);
            usuario.setPassword(password);
            String validarDatos = LoginValidators.validarDatosUsuario(usuario);

            if (validarDatos != null) {
                throw new IllegalArgumentException(validarDatos);
            }
          return   loginServices.iniciarSesion(usuario);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean encontrarUsuario(Usuario encontrarUsuario, String password, String username) {
        Usuario usuario = loginServices.encontrarUsuario(encontrarUsuario);
        return usuario.getPassword().equals(password) && usuario.getNombreUsuario().equals(username);

    }

}
