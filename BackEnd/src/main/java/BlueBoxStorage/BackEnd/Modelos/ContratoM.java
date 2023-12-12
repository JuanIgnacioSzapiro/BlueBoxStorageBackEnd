package BlueBoxStorage.BackEnd.Modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
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
    private Date fechaInicio;

    @Column
    @Getter
    @Setter
    private Date fechaTerminacion;

    @Getter
    @Setter
    @Column(name = "idUsuario")
    private Long idUsuario;

    @Getter
    @Setter
    @Column(name = "idDeposito")
    private Long idDeposito;

    @Column
    @Getter
    @Setter
    private Boolean aprobado;
}
