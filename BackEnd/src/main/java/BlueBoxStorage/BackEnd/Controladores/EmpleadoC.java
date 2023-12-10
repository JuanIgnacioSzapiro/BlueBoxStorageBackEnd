package BlueBoxStorage.BackEnd.Controladores;

import BlueBoxStorage.BackEnd.Modelos.EmpleadoM;
import BlueBoxStorage.BackEnd.Modelos.ZonaM;
import BlueBoxStorage.BackEnd.Servicios.EmpleadoS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class EmpleadoC {
    @Autowired
    EmpleadoS servicio;

    @GetMapping("/empleados")
    public List<EmpleadoM> get(){
        return servicio.get();
    }

    @PostMapping("/empleados")
    public void post(@RequestBody EmpleadoM cuerpo){
        servicio.set(cuerpo);
    }

    @PutMapping("/empleados/{id}")
    public void put(@PathVariable Long id, @RequestBody EmpleadoM cuerpo){
        servicio.update(id, cuerpo);
    }

    @DeleteMapping("/empleados/{id}")
    public void delete(@PathVariable Long id){
        servicio.delete(id);
    }


}
