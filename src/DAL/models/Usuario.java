package DAL.models;

public class Usuario {
    private String nombreUsuario;
    private String password;
    private Perfil perfil;

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }


    public Usuario() {
    }

    public Usuario(String nombreUsuario, String password, Perfil perfil) {
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.perfil = perfil;

    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Usuario other = (Usuario) obj;
        return this.nombreUsuario != null && this.nombreUsuario.equals(other.nombreUsuario);
    }

}
