package BlueBoxStorage.BackEnd.Modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "deposito")
public class DepositoM {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long idDeposito;

    @Column
    @Getter
    @Setter
    private Long volumen;

    @Column
    @Getter
    @Setter
    private Long numero;
}
