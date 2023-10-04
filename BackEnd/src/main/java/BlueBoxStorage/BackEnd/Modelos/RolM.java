package BlueBoxStorage.BackEnd.Modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "rol")
public class RolM {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Integer idRol;

    @Column(length = 50)
    @Getter
    @Setter
    private String autoridad;

    public RolM() {
        super();
    }

    public RolM(String autoridad) {
        this.autoridad = autoridad;
    }

    public RolM(Integer idRol, String autoridad) {
        this.idRol = idRol;
        this.autoridad = autoridad;
    }
}
