package BlueBoxStorage.BackEnd.Modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "sucursal_zonas")
public class SucursalZonaM {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long idSucursalZona;

    @Getter
    @Setter
    private Long idSucursal;

    @Getter
    @Setter
    private Long idZona;
}
