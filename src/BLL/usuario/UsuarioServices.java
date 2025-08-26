package BLL.usuario;

import DAL.models.Perfil;
import DAL.models.Rol;
import DAL.models.Usuario;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.ArrayList;

public class UsuarioServices {
    private final ArrayList<Usuario> usuarios;

    public UsuarioServices() {
        usuarios = new ArrayList<>();
        cargarAdminDesdeConfig();
    }


    public void crearUsuario(Usuario usuario ) {
        try {
            boolean encontrado = buscarUsuario(usuario);
            if (encontrado) {
                throw new Exception("Este usuario ya existe");
            }else{

                usuarios.add(usuario);
            }
        } catch (Exception e) {
            System.out.println("No se pudo crear el peri" + e.getMessage());
            throw new RuntimeException(e);
        }
    }
    private void cargarAdminDesdeConfig() {
        try (InputStream input = new FileInputStream("src/resources/config/admin.properties")) {
            Properties prop = new Properties();
            prop.load(input);

            String username = prop.getProperty("username");
            String password = prop.getProperty("password");
            String rolStr = prop.getProperty("rol");

            Rol rol = Rol.valueOf(rolStr.toUpperCase());

            Perfil perfilAdmin = new Perfil("1", rol);
            Usuario admin = new Usuario(username, password, perfilAdmin);

            usuarios.add(admin);
            System.out.println("Usuario administrador cargado por configuración.");
        } catch (Exception e) {
            System.err.println("No se pudo cargar el usuario administrador: " + e.getMessage());
        }
    }

    public boolean buscarUsuario(Usuario usuario) {
        for (Usuario u : usuarios) {
            if (u.equals(usuario)) {
                System.out.println("Usuario encontrado" + usuario);
                return true;
            }
        }
        return false;
    }
    public boolean eliminarUsuario(Usuario usuario) {
        try {
            boolean encontrado = buscarUsuario(usuario);
            if (encontrado) {
                usuarios.remove(usuario);
                return true;
            } else{
                throw new Exception("Usuario no encontrado");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public boolean editarUsuario(Usuario usuario) {
        try {
            boolean encontrado = buscarUsuario(usuario);
            if (encontrado) {
                return true;
            } else {
                throw new Exception("Usuario no encontrado");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<Usuario> getUsuarios() {
        try  {
            if (usuarios.isEmpty()) {
                throw new Exception("Lista vacia");
            } else{
                return usuarios;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
