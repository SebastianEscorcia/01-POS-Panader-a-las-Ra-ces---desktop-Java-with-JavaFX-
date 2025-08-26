package validators;

import DAL.models.Usuario;

public class UsuarioValidators {
    public static String validarUsuario(Usuario usuario) {
        if (!validarPassword(usuario.getPassword()))
            return "Por favor ingrese una password o verifica que sea mayor a 8 caracteres";
        if (!validarNombreUsuario(usuario.getNombreUsuario()))
            return "Por favor ingrese un nombre de usuario o verifica que esté entre 10 y 20 caracteres";
        if(!validaRol(usuario))
            return "Por favor ingrese el rol del nuevo usuario";
        return null ;
    }

    public static boolean validaRol(Usuario usuario) {
        return usuario.getPerfil().getRol() != null;
    }

    public static boolean validarNombreUsuario(String nombreUsuario) {
        return nombreUsuario != null && nombreUsuario.length() >= 10 && nombreUsuario.length() <= 20;
    }

    public static boolean validarPassword(String password) {
        return password != null && password.length() >= 8;
    }
}
