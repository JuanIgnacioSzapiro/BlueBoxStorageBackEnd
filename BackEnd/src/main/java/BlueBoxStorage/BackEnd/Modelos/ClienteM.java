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

    @Column
    @Getter
    @Setter
    private boolean cliente;

    @Column
    @Getter
    @Setter
    private boolean pendiente;

    public ClienteM(String nombre, String direccion, String telefono, String nombreUsuario, String claveUsuario, String dni, String mail, boolean cliente, boolean pendiente) {
        super(nombre, direccion, telefono, nombreUsuario, claveUsuario);
        this.dni = dni;
        this.mail = mail;
        this.cliente = cliente;
        this.pendiente = pendiente;
    }

    public ClienteM() {
    }
}
