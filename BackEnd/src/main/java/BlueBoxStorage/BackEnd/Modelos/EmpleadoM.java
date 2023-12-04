package BlueBoxStorage.BackEnd.Modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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

    @Column(length = 20, name = "administrabilidad")
    @Getter
    @Setter
    private boolean administrador;

    @Column(length = 20, name = "empleadbilidad")
    @Getter
    @Setter
    private boolean empleado;

    public boolean isAdministrador() {
        return administrador;
    }

    public boolean isEmpleado() {
        return empleado;
    }

    public EmpleadoM(String nombreUsuario, String claveUsuario, boolean administrador, boolean empleado) {
        super(nombreUsuario, claveUsuario);
        this.administrador = administrador;
        this.empleado = empleado;
    }

    public EmpleadoM() {
    }
}
