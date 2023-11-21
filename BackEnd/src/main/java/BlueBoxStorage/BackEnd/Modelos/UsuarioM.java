package BlueBoxStorage.BackEnd.Modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "usuario")
public abstract class UsuarioM {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long idUsuario;

    @Column (length = 100)
    @Getter
    @Setter
    private String nombre;

    @Column (length = 200)
    @Getter
    @Setter
    private String direccion;

    @Column (length = 50)
    @Getter
    @Setter
    private String telefono;

    @Column (length = 20)
    @Getter
    @Setter
    private String nombreUsuario;

    @Column (length = 200)
    @Getter
    @Setter
    private String claveUsuario;

    public UsuarioM(String nombre, String direccion, String telefono, String nombreUsuario, String claveUsuario) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.nombreUsuario = nombreUsuario;
        this.claveUsuario = claveUsuario;
    }

    public UsuarioM(String nombreUsuario, String claveUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.claveUsuario = claveUsuario;
    }

    public UsuarioM() {
    }
}
