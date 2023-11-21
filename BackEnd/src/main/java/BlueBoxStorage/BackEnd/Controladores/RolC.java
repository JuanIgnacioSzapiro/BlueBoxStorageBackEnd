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

    @GetMapping("/roles")
    public List<RolM> get(){
        return servicio.get();
    }

    @PostMapping("/roles")
    public void post(@RequestBody RolM cuerpo){
        servicio.set(cuerpo);
    }

    @PutMapping("/roles/{id}")
    public void put(@PathVariable Long id, @RequestBody RolM cuerpo){
        servicio.update(id, cuerpo);
    }

    @DeleteMapping("/roles/{id}")
    public void delete(@PathVariable Long id){
        servicio.delete(id);
    }
}
