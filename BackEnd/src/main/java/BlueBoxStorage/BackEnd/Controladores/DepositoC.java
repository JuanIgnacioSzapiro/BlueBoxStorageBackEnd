package BlueBoxStorage.BackEnd.Controladores;

import BlueBoxStorage.BackEnd.Modelos.DepositoM;
import BlueBoxStorage.BackEnd.Modelos.ZonaDepositoM;
import BlueBoxStorage.BackEnd.Modelos.ZonaM;
import BlueBoxStorage.BackEnd.Servicios.DepositoS;
import BlueBoxStorage.BackEnd.Servicios.ZonaDepositoS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class DepositoC {
    @Autowired
    DepositoS servicio;

    @Autowired
    ZonaDepositoS servicioZonaDepositoS;

    @GetMapping("/depositos")
    public List<DepositoM> get(){
        return servicio.get();
    }

    @PostMapping("/depositos/{id}")
    public void post(@PathVariable Long id, @RequestBody DepositoM cuerpo){
        servicio.set(cuerpo);
        ZonaDepositoM zonaDepositoM = new ZonaDepositoM();
        zonaDepositoM.setIdZona(id);
        zonaDepositoM.setIdDepostio(servicio.obtenerUltimoAgregado().getIdDeposito());
        servicioZonaDepositoS.set(zonaDepositoM);
    }

    @PutMapping("/depositos/{id}")
    public void put(@PathVariable Long id, @RequestBody DepositoM cuerpo){
        servicio.update(id, cuerpo);
    }

    @DeleteMapping("/depositos/{id}")
    public void delete(@PathVariable Long id){
        servicio.delete(id);
        servicioZonaDepositoS.delete(id);
    }

    @GetMapping("/depositos/{id}")
    public List<DepositoM> obtenerXzona(@PathVariable Long id){
        return servicio.obtenerXzona(id);
    }

}
