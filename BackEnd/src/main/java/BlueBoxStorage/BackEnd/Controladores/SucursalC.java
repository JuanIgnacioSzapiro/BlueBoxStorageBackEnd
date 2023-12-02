package BlueBoxStorage.BackEnd.Controladores;

import BlueBoxStorage.BackEnd.Modelos.SucursalM;
import BlueBoxStorage.BackEnd.Modelos.ZonaM;
import BlueBoxStorage.BackEnd.Servicios.SucursalS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class SucursalC {
    @Autowired
    SucursalS servicio;

    @GetMapping("/sucursales")
    public List<SucursalM> get(){
        return servicio.get();
    }

    @PostMapping("/sucursales")
    public void post(@RequestBody SucursalM cuerpo){
        servicio.set(cuerpo);
    }

    @PutMapping("/sucursales/{id}")
    public void put(@PathVariable Long id, @RequestBody SucursalM cuerpo){
        servicio.update(id, cuerpo);
    }

    @DeleteMapping("/sucursales/{id}")
    public void delete(@PathVariable Long id){
        servicio.delete(id);
    }
}
