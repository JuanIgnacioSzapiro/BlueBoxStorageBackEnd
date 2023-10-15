package BlueBoxStorage.BackEnd.Controladores;

import BlueBoxStorage.BackEnd.Modelos.EmpleadoM;
import BlueBoxStorage.BackEnd.Servicios.EmpleadoS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class EmpleadoC {
    @Autowired
    EmpleadoS servicio;

    @GetMapping("/listar_empleados")
    public List<EmpleadoM> get(){
        return servicio.get();
    }

    @PostMapping("/guardar_empleado")
    public void post(@RequestBody EmpleadoM cuerpo){
        servicio.set(cuerpo);
    }

    @PutMapping("/editar_empleado/{id}")
    public void put(@PathVariable Long id, @RequestBody EmpleadoM cuerpo){
        servicio.update(id, cuerpo);
    }

    @DeleteMapping("/borrar_empleado/{id}")
    public void delete(@PathVariable Long id){
        servicio.delete(id);
    }
}
