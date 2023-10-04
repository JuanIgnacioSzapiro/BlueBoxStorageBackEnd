package BlueBoxStorage.BackEnd.Modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "empleado")
public class EmpleadoM extends UsuarioM{
    @Column (length = 20)
    @Getter
    @Setter
    private String codigo;

    @Column (length = 20)
    @Getter
    @Setter
    private String especialidad;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "empleado_deposito",
            joinColumns = {@JoinColumn(name = "idUsuario")},
            inverseJoinColumns = {@JoinColumn(name = "idDeposito")}
    )
    @Column (length = 20)
    @Getter
    @Setter
    private Set<DepositoM> depositos;

    public EmpleadoM() {
        super();
        setAutoridades(new HashSet<>());
    }

    public EmpleadoM(Long idUsuario, String nombreUsuario, String claveUsuario, Set<RolM> autoridades) {
        super(idUsuario, nombreUsuario, claveUsuario, autoridades);
    }

    public EmpleadoM(Long idUsuario, String nombre, String direccion, String telefono, String nombreUsuario, String claveUsuario, Set<RolM> autoridades, String codigo, String especialidad, Set<DepositoM> depositos) {
        super(idUsuario, nombre, direccion, telefono, nombreUsuario, claveUsuario, autoridades);
        this.codigo = codigo;
        this.especialidad = especialidad;
        this.depositos = depositos;
    }
}
