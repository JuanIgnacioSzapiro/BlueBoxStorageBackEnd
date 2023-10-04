package BlueBoxStorage.BackEnd.Modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.text.DateFormat;

@Entity(name = "contrato")
public class ContratoM {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long idContrato;

    @Column
    @Getter
    @Setter
    private DateFormat fechaInicio;

    @Column
    @Getter
    @Setter
    private DateFormat fechaTerminacion;

    @Column
    @Getter
    @Setter
    private Long idCliente;

    @Column
    @Getter
    @Setter
    private Long idDeposito;

    @Column
    @Getter
    @Setter
    private Boolean aprobado;
}
