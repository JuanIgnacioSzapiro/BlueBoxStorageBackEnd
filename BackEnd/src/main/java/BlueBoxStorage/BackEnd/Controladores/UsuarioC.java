package BlueBoxStorage.BackEnd.Controladores;

import BlueBoxStorage.BackEnd.Modelos.UsuarioNoAbstract;
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
    public List<UsuarioNoAbstract> get(){
        return servicio.obtenerTodos();
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UsuarioNoAbstract usuarioBuscado){
        //System.out.println("\n\nusuarioBuscado.getNombreUsuario(): "+usuarioBuscado.getNombreUsuario()+"\nusuarioBuscado.getClaveUsuario(): "+usuarioBuscado.getClaveUsuario()+"\n\n");
        UsuarioNoAbstract usuarioEncontrado = servicio.encontrarXnombreUsuario(usuarioBuscado.getNombreUsuario());
        //System.out.println("\n\n"+servicio.encontrarXnombreUsuario(usuarioBuscado.getNombreUsuario())+"\n\n");
        if(usuarioEncontrado.getClaveUsuario().equals(usuarioBuscado.getClaveUsuario())){
            return ResponseEntity.ok(usuarioEncontrado);
        }
        return (ResponseEntity<?>) ResponseEntity.internalServerError();
    }
}
