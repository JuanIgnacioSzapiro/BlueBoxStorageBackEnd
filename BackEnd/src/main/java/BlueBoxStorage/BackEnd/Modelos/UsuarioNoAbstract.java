package BlueBoxStorage.BackEnd.Modelos;

import jakarta.persistence.Entity;

import java.util.Set;

@Entity(name = "usuarioNoAbs")
public class UsuarioNoAbstract extends UsuarioM{
    public UsuarioNoAbstract(String nombre, String direccion, String telefono, String nombreUsuario, String claveUsuario) {
        super(nombre, direccion, telefono, nombreUsuario, claveUsuario);
    }

    public UsuarioNoAbstract(String nombreUsuario, String claveUsuario) {
        super(nombreUsuario, claveUsuario);
    }

    public UsuarioNoAbstract() {
    }
}
