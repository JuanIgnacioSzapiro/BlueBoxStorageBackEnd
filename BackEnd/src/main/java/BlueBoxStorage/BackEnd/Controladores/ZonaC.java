package BlueBoxStorage.BackEnd.Controladores;

import BlueBoxStorage.BackEnd.Modelos.SucursalZonaM;
import BlueBoxStorage.BackEnd.Modelos.ZonaM;
import BlueBoxStorage.BackEnd.Servicios.SucursalZonaS;
import BlueBoxStorage.BackEnd.Servicios.ZonaS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class ZonaC {
    @Autowired
    ZonaS servicio;

    @Autowired
    SucursalZonaS servicioSucursalZonaS;

    @GetMapping("/zonas")
    public List<ZonaM> get(){
        return servicio.get();
    }

    @PostMapping("/zonas/{id}")
    public void post(@PathVariable Long id, @RequestBody ZonaM cuerpo){
        servicio.set(cuerpo);
        SucursalZonaM sucursalZonaM = new SucursalZonaM();
        sucursalZonaM.setIdSucursal(id);
        sucursalZonaM.setIdZona(servicio.obtenerUltimoAgregado().getIdZona());
        servicioSucursalZonaS.set(sucursalZonaM);
    }

    @PutMapping("/zonas/{id}")
    public void put(@PathVariable Long id, @RequestBody ZonaM cuerpo){
        servicio.update(id, cuerpo);
    }

    @DeleteMapping("/zonas/{id}")
    public void delete(@PathVariable Long id){
        servicio.delete(id);
        servicioSucursalZonaS.borrarXIdZona(id);
    }

    @GetMapping("/zonas/{id}")
    public List<ZonaM> obtenerXsucursal(@PathVariable Long id){
        return servicio.obtenerXsucursal(id);
    }

}
