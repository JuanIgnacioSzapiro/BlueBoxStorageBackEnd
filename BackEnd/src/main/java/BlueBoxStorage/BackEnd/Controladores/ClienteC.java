package BlueBoxStorage.BackEnd.Controladores;

import BlueBoxStorage.BackEnd.Modelos.ClienteM;
import BlueBoxStorage.BackEnd.Servicios.ClienteS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ClienteC {
    @Autowired
    ClienteS servicio;

    @GetMapping("/listar_clientes")
    public List<ClienteM> get(){
        return servicio.get();
    }

    @PostMapping("/guardar_cliente")
    public void post(@RequestBody ClienteM cuerpo){
        servicio.set(cuerpo);
    }

    @PutMapping("/editar_cliente/{id}")
    public void put(@PathVariable Long id, @RequestBody ClienteM cuerpo){
        servicio.update(id, cuerpo);
    }

    @DeleteMapping("/borrar_cliente/{id}")
    public void delete(@PathVariable Long id){
        servicio.delete(id);
    }
}
