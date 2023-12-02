package BlueBoxStorage.BackEnd.Modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "zona_depositos")
public class ZonaDepositoM {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long zonaDeposito;

    @Getter
    @Setter
    @Column(name = "idZona")
    private char idZona;

    @Getter
    @Setter
    @Column(name = "idDeposito")
    private char idDeposito;
}
