package BlueBoxStorage.BackEnd.Servicios;

import BlueBoxStorage.BackEnd.Repositorios.EmpleadoSucursalR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoSucursalS {
    @Autowired
    private EmpleadoSucursalR repositorio;
}
