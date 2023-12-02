package BlueBoxStorage.BackEnd.Controladores;

import BlueBoxStorage.BackEnd.Modelos.ClienteM;
import BlueBoxStorage.BackEnd.Servicios.ClienteS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.query.JSqlParserUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class ClienteC {
    @Autowired
    ClienteS servicio;

    @GetMapping("/clientes")
    public List<ClienteM> get(){
        return servicio.get();
    }

    @PostMapping("/clientes")
    public void post(@RequestBody ClienteM cuerpo){
        servicio.set(cuerpo);
    }

    @PutMapping("/clientes/{id}")
    public void put(@PathVariable Long id, @RequestBody ClienteM cuerpo){
        servicio.update(id, cuerpo);
    }

    @DeleteMapping("/clientes/{id}")
    public void delete(@PathVariable Long id){
        servicio.delete(id);
    }
}
