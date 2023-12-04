package BlueBoxStorage.BackEnd.Modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "zona_depositos")
public class ZonaDepositoM {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long idSucursalZona;

    @Getter
    @Setter
    private Long idZona;

    @Getter
    @Setter
    private Long idDepostio;
}
