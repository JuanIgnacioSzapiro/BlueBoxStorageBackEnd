package BlueBoxStorage.BackEnd.Controladores;

import BlueBoxStorage.BackEnd.Modelos.RolM;
import BlueBoxStorage.BackEnd.Servicios.RolS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class RolC {
    @Autowired
    RolS servicio;

    @GetMapping("/listar_roles")
    public List<RolM> get(){
        return servicio.get();
    }

    @PostMapping("/guardar_roles")
    public void post(@RequestBody RolM cuerpo){
        servicio.set(cuerpo);
    }

    @PutMapping("/editar_rol/{id}")
    public void put(@PathVariable Long id, @RequestBody RolM cuerpo){
        servicio.update(id, cuerpo);
    }

    @DeleteMapping("/borrar_rol/{id}")
    public void delete(@PathVariable Long id){
        servicio.delete(id);
    }
}
