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

    @Column
    @Getter
    @Setter
    private boolean administrador;

    @Column
    @Getter
    @Setter
    private boolean empleado;

    public EmpleadoM(String nombre, String direccion, String telefono, String nombreUsuario, String claveUsuario, String codigo, String especialidad, Set<DepositoM> depositos, boolean administrador, boolean empleado) {
        super(nombre, direccion, telefono, nombreUsuario, claveUsuario);
        this.codigo = codigo;
        this.especialidad = especialidad;
        this.depositos = depositos;
        this.administrador = administrador;
        this.empleado = empleado;
    }

    public EmpleadoM(String nombreUsuario, String claveUsuario, boolean administrador, boolean empleado) {
        super(nombreUsuario, claveUsuario);
        this.administrador = administrador;
        this.empleado = empleado;
    }

    public EmpleadoM() {
    }
}
