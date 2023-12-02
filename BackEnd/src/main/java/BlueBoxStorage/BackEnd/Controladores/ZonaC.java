package BlueBoxStorage.BackEnd.Controladores;

import BlueBoxStorage.BackEnd.Modelos.ZonaM;
import BlueBoxStorage.BackEnd.Servicios.ZonaS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class ZonaC {
    @Autowired
    ZonaS servicio;

    @GetMapping("/zonas")
    public List<ZonaM> get(){
        return servicio.get();
    }

    @PostMapping("/zonas")
    public void post(@RequestBody ZonaM cuerpo){
        servicio.set(cuerpo);
    }

    @PutMapping("/zonas/{id}")
    public void put(@PathVariable Long id, @RequestBody ZonaM cuerpo){
        servicio.update(id, cuerpo);
    }

    @DeleteMapping("/zonas/{id}")
    public void delete(@PathVariable Long id){
        servicio.delete(id);
    }

    @GetMapping("/zonas/{id}")
    public List<ZonaM> obtenerZonas(@PathVariable Long id){
        return servicio.encontrarZonasXIdSucursal(id);
    }
}
