package BlueBoxStorage.BackEnd.Modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity(name = "zona")
public class ZonaM {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long idZona;

    @Column
    @Getter
    @Setter
    private char letra;

    @Column(length = 20)
    @Getter
    @Setter
    private String tipo;
}
