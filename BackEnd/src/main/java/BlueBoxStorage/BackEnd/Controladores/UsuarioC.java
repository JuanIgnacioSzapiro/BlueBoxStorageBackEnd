package BlueBoxStorage.BackEnd.Controladores;

import BlueBoxStorage.BackEnd.Modelos.UsuarioNoAbstract;
import BlueBoxStorage.BackEnd.Servicios.ClienteS;
import BlueBoxStorage.BackEnd.Servicios.EmpleadoS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class UsuarioC {
    @Autowired
    ClienteS servicioC;

    @Autowired
    EmpleadoS servicioE;

    @Autowired
    UsuarioS servicioU;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UsuarioNoAbstract usuarioBuscado){
        if(servicioU.encontrarXnombre_usuario(usuarioBuscado.getNombreUsuario()).getClaveUsuario().equals(usuarioBuscado.getClaveUsuario())){
            return ResponseEntity.ok(servicioU.encontrarXnombre_usuario(usuarioBuscado.getNombreUsuario()));
        }
        return (ResponseEntity<?>) ResponseEntity.internalServerError();
    }

    @PostMapping("/usuario")
    public <T> T obtenerTipo(@RequestBody UsuarioNoAbstract cuerpo){
        String tipo = new String(servicioU.encontrarTipoXnombre(cuerpo.getNombreUsuario()));
        if(tipo.equals("empleado")){
            return (T) servicioE.encontrarXnombreUsuarioEmpleado(cuerpo.getNombreUsuario());
        }
        else if(tipo.equals("cliente")){
            return (T) servicioC.encontrarXnombreUsuarioEmpleado(cuerpo.getNombreUsuario());
        }
        return null;
    }
}
