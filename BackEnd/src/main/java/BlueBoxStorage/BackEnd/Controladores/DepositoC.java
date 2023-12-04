package BlueBoxStorage.BackEnd.Controladores;

import BlueBoxStorage.BackEnd.Modelos.DepositoM;
import BlueBoxStorage.BackEnd.Modelos.ZonaM;
import BlueBoxStorage.BackEnd.Servicios.DepositoS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class DepositoC {
    @Autowired
    DepositoS servicio;

    @GetMapping("/depositos")
    public List<DepositoM> get(){
        return servicio.get();
    }

    @PostMapping("/depositos")
    public void post(@RequestBody DepositoM cuerpo){
        servicio.set(cuerpo);
    }

    @PutMapping("/depositos/{id}")
    public void put(@PathVariable Long id, @RequestBody DepositoM cuerpo){
        servicio.update(id, cuerpo);
    }

    @DeleteMapping("/depositos/{id}")
    public void delete(@PathVariable Long id){
        servicio.delete(id);
    }

}
