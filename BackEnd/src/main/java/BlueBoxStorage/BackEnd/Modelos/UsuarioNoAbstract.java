package BlueBoxStorage.BackEnd.Modelos;

import jakarta.persistence.Entity;

import java.util.Set;

@Entity(name = "usuarioNoAbs")
public class UsuarioNoAbstract extends UsuarioM{
    public UsuarioNoAbstract() {
    }

    public UsuarioNoAbstract(String nombreUsuario, String claveUsuario) {
        super(nombreUsuario, claveUsuario);
    }

    public UsuarioNoAbstract(String nombreUsuario, String claveUsuario, Set<RolM> autoridades) {
        super(nombreUsuario, claveUsuario, autoridades);
    }

    public UsuarioNoAbstract(Long idUsuario, String nombreUsuario, String claveUsuario, Set<RolM> autoridades) {
        super(idUsuario, nombreUsuario, claveUsuario, autoridades);
    }

    public UsuarioNoAbstract(Long idUsuario, String nombre, String direccion, String telefono, String nombreUsuario, String claveUsuario, Set<RolM> autoridades) {
        super(idUsuario, nombre, direccion, telefono, nombreUsuario, claveUsuario, autoridades);
    }
}
