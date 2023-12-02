package BlueBoxStorage.BackEnd.Modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "sucursalZonas")
public class SucursalZonasM {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long idSucursalZonas;

    @Getter
    @Setter
    @Column(name = "idSucursal")
    private Long idSucursal;

    @Getter
    @Setter
    @Column(name = "idZona")
    private Long idZona;
}
