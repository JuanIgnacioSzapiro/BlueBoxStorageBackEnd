package BlueBoxStorage.BackEnd.Controladores;

import BlueBoxStorage.BackEnd.Modelos.UsuarioM;
import BlueBoxStorage.BackEnd.Servicios.UsuarioS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioC {
    @Autowired
    UsuarioS servicio;

    @GetMapping("/listar_usuarios")
    public List<UsuarioM> get(){
        return servicio.obtenerTodos();
    }

    @PostMapping("")
    public ResponseEntity<?> login(@RequestBody UsuarioM usuarioBuscado){
        System.out.println(usuarioBuscado);
        UsuarioM usuarioEncontrado = servicio.encontrarXnombreUsuario(usuarioBuscado.getNombreUsuario());
        if(usuarioEncontrado.getClaveUsuario().equals(usuarioBuscado.getClaveUsuario())){
            return ResponseEntity.ok(usuarioEncontrado);
        }
        return (ResponseEntity<?>) ResponseEntity.internalServerError();
    }
}
