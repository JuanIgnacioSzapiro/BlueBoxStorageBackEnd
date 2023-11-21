package BlueBoxStorage.BackEnd.Controladores;

import BlueBoxStorage.BackEnd.Modelos.ContratoM;
import BlueBoxStorage.BackEnd.Servicios.ContratoS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ContratoC {
    @Autowired
    ContratoS servicio;

    @GetMapping("/contratos")
    public List<ContratoM> get(){
        return servicio.get();
    }

    @PostMapping("/contratos")
    public void post(@RequestBody ContratoM cuerpo){
        servicio.set(cuerpo);
    }

    @PutMapping("/contratos/{id}")
    public void put(@PathVariable Long id, @RequestBody ContratoM cuerpo){
        servicio.update(id, cuerpo);
    }

    @DeleteMapping("/contratos/{id}")
    public void delete(@PathVariable Long id){
        servicio.delete(id);
    }
}
