package BlueBoxStorage.BackEnd.Modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "empleado_depostio")
public class EmpleadoSucursalM {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long idEmpleadoSucursal;

    @Getter
    @Setter
    private Long idUsuario;

    @Getter
    @Setter
    private Long idDeposito;
}
