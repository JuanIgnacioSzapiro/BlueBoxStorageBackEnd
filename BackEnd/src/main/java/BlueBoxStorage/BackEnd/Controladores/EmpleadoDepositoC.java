package BlueBoxStorage.BackEnd.Controladores;

import BlueBoxStorage.BackEnd.Modelos.EmpleadoDepositoM;
import BlueBoxStorage.BackEnd.Modelos.EmpleadoM;
import BlueBoxStorage.BackEnd.Servicios.EmpleadoDepositoS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class EmpleadoDepositoC {
    @Autowired
    EmpleadoDepositoS servicio;

    @GetMapping("/empleados_depositos/{id}")
    public List<EmpleadoDepositoM> get(@PathVariable Long id){
        return servicio.get(id);
    }

    @PostMapping("/empleados_depositos")
    public void post(@RequestBody EmpleadoDepositoM empleadoDepositoM){
        servicio.set(empleadoDepositoM);
    }

    @DeleteMapping("/empleados_depositos/{id}")
    public void delete(@PathVariable Long id){
        servicio.delete(id);
    }
}
