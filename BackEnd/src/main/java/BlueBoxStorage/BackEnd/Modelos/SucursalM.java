package BlueBoxStorage.BackEnd.Modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity(name = "sucursal")
public class SucursalM {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long idSucursal;

    @Column (length = 100)
    @Getter
    @Setter
    private String direccion;

    @Column (length = 50)
    @Getter
    @Setter
    private String telefono;
}
