package BlueBoxStorage.BackEnd.Controladores;

import BlueBoxStorage.BackEnd.Modelos.ZonaM;
import BlueBoxStorage.BackEnd.Servicios.ZonaS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ZonaC {
    @Autowired
    ZonaS servicio;

    @GetMapping("/listar_zonas")
    public List<ZonaM> get(){
        return servicio.get();
    }

    @PostMapping("/guardar_zona")
    public void post(@RequestBody ZonaM cuerpo){
        servicio.set(cuerpo);
    }

    @PutMapping("/editar_zona/{id}")
    public void put(@PathVariable Long id, @RequestBody ZonaM cuerpo){
        servicio.update(id, cuerpo);
    }

    @DeleteMapping("/borrar_zona/{id}")
    public void delete(@PathVariable Long id){
        servicio.delete(id);
    }
}
