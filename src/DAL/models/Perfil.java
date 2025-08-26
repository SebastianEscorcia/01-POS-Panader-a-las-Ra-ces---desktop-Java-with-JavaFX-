package DAL.models;

public class Perfil {
    private String idperfil;
    private Rol rol;

    public String getIdperfil() {
        return idperfil;
    }

    public void setIdperfil(String idperfil) {
        this.idperfil = idperfil;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
    public Perfil(String idperfil, Rol rol){
        this.idperfil = idperfil;
        this.rol = rol;
    }
}
