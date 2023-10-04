package BlueBoxStorage.BackEnd.Controladores;

import BlueBoxStorage.BackEnd.Modelos.SucursalM;
import BlueBoxStorage.BackEnd.Servicios.SucursalS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SucursalC {
    @Autowired
    SucursalS servicio;

    @GetMapping("/listar_sucursales")
    public List<SucursalM> get(){
        return servicio.get();
    }

    @PostMapping("/guardar_sucursal")
    public void post(@RequestBody SucursalM cuerpo){
        servicio.set(cuerpo);
    }

    @PutMapping("/editar_sucursal/{id}")
    public void put(@PathVariable Long id, @RequestBody SucursalM cuerpo){
        servicio.update(id, cuerpo);
    }

    @DeleteMapping("/borrar_sucursal/{id}")
    public void delete(@PathVariable Long id){
        servicio.delete(id);
    }
}
