package validators;

import DAL.models.Usuario;

public class LoginValidators {

    public static String validarDatosUsuario(Usuario usuario){
        if(!validarNombreUsuario(usuario.getNombreUsuario()))
            return "El nombre de usuario debe ser entre 10 y 30 caracteres ";
        if(!validarPassword(usuario.getPassword()))
            return "La contraseña debe ser mayor a 8 caracteres";
        return null;
    }
    public static boolean validarPassword(String password){
        return password != null && password.length() >= 8;
    }
    public static boolean validarNombreUsuario(String nombreUsuario){
        return nombreUsuario != null && nombreUsuario.length() >= 10 && nombreUsuario.length() <= 20;
    }
}
