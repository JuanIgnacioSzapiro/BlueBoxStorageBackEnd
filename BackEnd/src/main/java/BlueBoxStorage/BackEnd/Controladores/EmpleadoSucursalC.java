package BlueBoxStorage.BackEnd.Controladores;

import BlueBoxStorage.BackEnd.Servicios.EmpleadoSucursalS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class EmpleadoSucursalC {
    @Autowired
    EmpleadoSucursalS servicio;
}
