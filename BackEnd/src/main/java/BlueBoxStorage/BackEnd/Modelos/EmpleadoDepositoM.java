package BlueBoxStorage.BackEnd.Modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "empleado_deposito")
public class EmpleadoDepositoM {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long idEmpleadoDeposito;

    @Getter
    @Setter
    @Column(name = "idUsuario")
    private Long idUsuario;

    @Getter
    @Setter
    @Column(name = "idDeposito")
    private Long idDeposito;
}
