package BlueBoxStorage.BackEnd.Modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "cliente")
public class ClienteM extends UsuarioM{
    @Column (length = 20, unique = true)
    @Getter
    @Setter
    private String dni;

    @Column (length = 50, unique = true)
    @Getter
    @Setter
    private String mail;

    public ClienteM() {
        super();
        setAutoridades(new HashSet<>());
    }

    public ClienteM(String nombreUsuario, String claveUsuario, Set<RolM> autoridades) {
        super(nombreUsuario, claveUsuario, autoridades);
    }

    public ClienteM(Long idUsuario, String nombre, String direccion, String telefono, String nombreUsuario, String claveUsuario, Set<RolM> autoridades, String dni, String mail) {
        super(idUsuario, nombre, direccion, telefono, nombreUsuario, claveUsuario, autoridades);
        this.dni = dni;
        this.mail = mail;
    }
}
