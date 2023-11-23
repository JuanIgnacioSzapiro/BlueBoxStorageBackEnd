package BlueBoxStorage.BackEnd.Controladores;

import BlueBoxStorage.BackEnd.Modelos.ClienteM;
import BlueBoxStorage.BackEnd.Modelos.EmpleadoM;
import BlueBoxStorage.BackEnd.Modelos.UsuarioNoAbstract;
import BlueBoxStorage.BackEnd.Servicios.ClienteS;
import BlueBoxStorage.BackEnd.Servicios.EmpleadoS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioC {

    @Autowired
    EmpleadoS servicioE;
    @Autowired
    ClienteS servicioC;

    @GetMapping("/usuarios")
    public List<UsuarioNoAbstract> get(){
        UsuarioNoAbstract usuarioNoAbstract = new UsuarioNoAbstract();
        List<UsuarioNoAbstract> totalUsuario = new ArrayList<>();
        List<ClienteM> totalClientes = new ArrayList<>();
        List<EmpleadoM> totalEmpleados = new ArrayList<>();
        totalClientes.addAll(servicioC.get());
        totalEmpleados.addAll(servicioE.get());
        totalClientes.forEach(cliente->{
            usuarioNoAbstract.setIdUsuario(cliente.getIdUsuario());
            usuarioNoAbstract.setClaveUsuario(cliente.getClaveUsuario());
            usuarioNoAbstract.setNombreUsuario(cliente.getNombreUsuario());
            usuarioNoAbstract.setNombre(cliente.getNombre());
            usuarioNoAbstract.setDireccion(cliente.getDireccion());
            usuarioNoAbstract.setTelefono(cliente.getTelefono());
            totalUsuario.add(usuarioNoAbstract);
        });
        totalEmpleados.forEach(empleado->{
            usuarioNoAbstract.setIdUsuario(empleado.getIdUsuario());
            usuarioNoAbstract.setClaveUsuario(empleado.getClaveUsuario());
            usuarioNoAbstract.setNombreUsuario(empleado.getNombreUsuario());
            usuarioNoAbstract.setNombre(empleado.getNombre());
            usuarioNoAbstract.setDireccion(empleado.getDireccion());
            usuarioNoAbstract.setTelefono(empleado.getTelefono());
            totalUsuario.add(usuarioNoAbstract);
        });
        return totalUsuario;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UsuarioNoAbstract usuarioBuscado){
        if(servicioE.encontrarXnombreUsuarioEmpleado(usuarioBuscado.getNombreUsuario()).getClaveUsuario().equals(usuarioBuscado.getClaveUsuario())){
            return ResponseEntity.ok(servicioE.encontrarXnombreUsuarioEmpleado(usuarioBuscado.getNombreUsuario()));
        }
        else if(servicioC.encontrarXnombreUsuarioCliente(usuarioBuscado.getNombreUsuario()).getClaveUsuario().equals(usuarioBuscado.getClaveUsuario())) {
            return ResponseEntity.ok(servicioC.encontrarXnombreUsuarioCliente(usuarioBuscado.getNombreUsuario()));
        }
        return (ResponseEntity<?>) ResponseEntity.internalServerError();
    }
}
