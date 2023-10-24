package BlueBoxStorage.BackEnd.Modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

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

    @Column (length = 20, unique = true)
    @Getter
    @Setter
    private String nombreUsuario;

    @Column (length = 200)
    @Getter
    @Setter
    private String claveUsuario;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "usuario_rol",
            joinColumns = {@JoinColumn(name = "idUsuario")},
            inverseJoinColumns = {@JoinColumn(name = "idRol")}
    )
    @Column (length = 20)
    @Getter
    @Setter
    private Set<RolM> autoridades;

    public UsuarioM() {
        super();
        autoridades = new HashSet<>();
    }

    public UsuarioM(String nombreUsuario, String claveUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.claveUsuario = claveUsuario;
    }

    public UsuarioM(Long idUsuario, String nombreUsuario, String claveUsuario, Set<RolM> autoridades) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.claveUsuario = claveUsuario;
        this.autoridades = autoridades;
    }

    public UsuarioM(Long idUsuario, String nombre, String direccion, String telefono, String nombreUsuario, String claveUsuario, Set<RolM> autoridades) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.nombreUsuario = nombreUsuario;
        this.claveUsuario = claveUsuario;
        this.autoridades = autoridades;
    }
}
