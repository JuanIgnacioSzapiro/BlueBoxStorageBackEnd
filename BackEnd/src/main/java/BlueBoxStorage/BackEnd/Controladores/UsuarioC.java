package BlueBoxStorage.BackEnd.Controladores;

import BlueBoxStorage.BackEnd.Modelos.UsuarioM;
import BlueBoxStorage.BackEnd.Servicios.UsuarioS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsuarioC {
    @Autowired
    UsuarioS servicio;

    @GetMapping("/listar_usuarios")
    public List<UsuarioM> get(){
        return servicio.get();
    }
}
